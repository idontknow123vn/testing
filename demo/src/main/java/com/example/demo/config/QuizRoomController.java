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

@CrossOrigin("*")
@RestController
public class QuizRoomController {

	private Map<String, QuizRoom> roomIdVsPlayerCount = new ConcurrentHashMap<>();
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private quizz_service service;
	
	@MessageMapping("/app/{idroom}/submit")
	public void submit(SimpMessageHeaderAccessor accessor) {
		
	}
	
	@PostMapping("/createRoom")
	public ResponseEntity<Object> createRoom(@RequestBody QuizRoom room) {
		String _room = room.getName();
		roomIdVsPlayerCount.put(_room, room);
		return new ResponseEntity<Object>(roomIdVsPlayerCount, HttpStatus.OK);
	}
	
	@GetMapping("/rooms")
	public ResponseEntity<Object> getListRoom(){
		Map<String, QuizRoom> filtered = roomIdVsPlayerCount.entrySet()
				.stream()
				.filter(e -> (e.getValue().getPlayersPoints().size() < e.getValue().getNumber()))
				.collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
		return new ResponseEntity<Object>(filtered, HttpStatus.OK);
	}
	
    @EventListener
    public void handleSubscribe(SessionSubscribeEvent event) {
    	StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();
        String roomId = destination.split("/")[2];
        if (roomIdVsPlayerCount.getOrDefault(roomId, null).getPlayersPoints().size() 
        		>= roomIdVsPlayerCount.getOrDefault(roomId, null).getNumber()) {
            // Start the game for this room
            startGame(roomId);
            return;
        }

        // If not at maximum, subscribe user and increment player count
//        roomIdVsPlayerCount.getOrDefault(roomId, null).getPlayersPoints().put(user, 0.0);
        
        simpMessagingTemplate.convertAndSend("/topic/" + roomId, "user connected!");
    }
    
    private void startGame(String roomId) {
 
        simpMessagingTemplate.convertAndSend("/topic/" + roomId, service.generateQuizz());
    }
}
