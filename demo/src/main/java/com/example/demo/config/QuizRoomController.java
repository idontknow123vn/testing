package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;

@CrossOrigin("*")
@RestController
public class QuizRoomController {
	@Autowired
	private Map<String, Integer> roomIdVsPlayerCount = new ConcurrentHashMap<>();
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	private static final int MAX_ALLOWED_PLAYERS = 2;
	
	@MessageMapping("/room/{idroom}/join")
	@SendTo("/topic/{idroom}")
	public void join() {
		
	}
	
    @EventListener
    public void handleSubscribe(SessionConnectedEvent event) {
    	StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = accessor.getDestination();
        String roomId = destination.split("/")[2];
        if (roomIdVsPlayerCount.getOrDefault(roomId, 0) >= MAX_ALLOWED_PLAYERS) {
            // Start the game for this room
            startGame(roomId);
            return;
        }

        // If not at maximum, subscribe user and increment player count
        roomIdVsPlayerCount.put(roomId, roomIdVsPlayerCount.getOrDefault(roomId, 0) + 1);
        
    }
    
    private void startGame(String roomId) {
    
        simpMessagingTemplate.convertAndSend("/topic/" + roomId, "The game is starting!");
    }
}
