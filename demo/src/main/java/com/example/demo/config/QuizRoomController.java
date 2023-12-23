package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;
import com.example.demo.service.quizz_service;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class QuizRoomController {

	private Map<String, QuizRoom> roomIdVsPlayerCount = new ConcurrentHashMap<>();
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private quizz_service service;
	
	@PostMapping("/createRoom")
	public ResponseEntity<Object> createRoom(@RequestBody QuizRoom room) {
		String _room = room.getName();
		if (!roomIdVsPlayerCount.containsKey(_room)) roomIdVsPlayerCount.put(_room, room);
		else {
			return new ResponseEntity<>("Phòng bạn nhập đã tồn tại", HttpStatus.ALREADY_REPORTED);
		}
		return new ResponseEntity<Object>(room, HttpStatus.OK);
	}
	
	@GetMapping("/rooms")
	public ResponseEntity<Object> getListRoom(){
		Map<String, QuizRoom> filtered = roomIdVsPlayerCount.entrySet()
				.stream()
				.filter(e -> (e.getValue().getPlayersPoints().size() < e.getValue().getNumber()))
				.collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		return new ResponseEntity<Object>(filtered, HttpStatus.OK);
	}
	
	@MessageMapping("/{nameroom}/join")
	public void joinRoom(@DestinationVariable String nameroom,
			@Payload String user, SimpMessageHeaderAccessor headerAccessor){
		headerAccessor.getSessionAttributes().put("nameroom", nameroom);
		headerAccessor.getSessionAttributes().put("user", user);
		QuizRoom room = roomIdVsPlayerCount.getOrDefault(nameroom, null);
		room.addUser(user);
		simpMessagingTemplate.convertAndSend("/room/" + nameroom, room);
	}
	
	@MessageMapping("/{nameroom}/submitpoint")
	public void submitPoint(@DestinationVariable String nameroom, SubmitInfo info){
		QuizRoom room = roomIdVsPlayerCount.getOrDefault(nameroom, null);
		room.getPlayersPoints().put(info.name, info.points);
		room.setNumberSubmitted(room.getNumberSubmitted() + 1);
		if (room.getNumberSubmitted() == room.getNumber()) {
			simpMessagingTemplate.convertAndSend("/result/" + nameroom, room.getPlayersPoints());
		}
	}
	
	@MessageMapping("/{nameroom}/leave")
	public void leaveRoom(@DestinationVariable String nameroom, String user){
		QuizRoom room = roomIdVsPlayerCount.getOrDefault(nameroom, null);
		room.getPlayersPoints().remove(user);
	}
	
	@SendTo("/rooms/{nameroom}")
	public List<String> sendListPlayer(@DestinationVariable String nameroom){
		QuizRoom room = roomIdVsPlayerCount.getOrDefault(nameroom, null);
		List<String> userList = new ArrayList<>(room.getPlayersPoints().keySet());
		return userList;
	}
	
	@SendTo("/questions/{nameroom}")
	public List<quizz_dto> generateQuizz(@DestinationVariable String nameroom){
		return service.generateQuizz();
	}
	
	@SendTo("/result/{nameroom}")
	public Map<String, Double> getListResult(@DestinationVariable String nameroom){
		QuizRoom room = roomIdVsPlayerCount.getOrDefault(nameroom, null);
		return room.getPlayersPoints();
	}
	
//    @EventListener
//    public void handleSubscribe(SessionSubscribeEvent event) {
//    	StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
//        String destination = accessor.getDestination();
//        String roomId = destination.split("/")[2];
//        if (roomIdVsPlayerCount.getOrDefault(roomId, null).getPlayersPoints().size() 
//        		>= roomIdVsPlayerCount.getOrDefault(roomId, null).getNumber()) {
//            // Start the game for this room
//            startGame(roomId);
//            return;
//        }
//        
//        simpMessagingTemplate.convertAndSend("/room/" + roomId, "user connected!");
//    }
    
//    private void startGame(String roomId) {
// 
//        simpMessagingTemplate.convertAndSend("/questions/" + roomId, service.generateQuizz());
//    }
//    
//    private void sendResult(String roomId) {
//    	simpMessagingTemplate.convertAndSend("/result/" + roomId, "result sent");
//    }
}
