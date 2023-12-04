package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;

@Controller
public class QuizRoomController {
	private ConcurrentHashMap<Integer, QuizRoom> list = new ConcurrentHashMap<>();
	
	@MessageMapping("/join")
    @SendTo("/topic/room/{idroom}")
    public QuizRoom join(@DestinationVariable int idroom, @RequestBody user_dto dto) {
        // handle joining a room
		QuizRoom find_room = list.get(idroom);
		find_room.getPlayers().put(dto, 0);
        return find_room;
    }
	@MessageMapping("/leave")
    @SendTo("/topic/room/{idroom}")
    public QuizRoom leave(@DestinationVariable int idroom, @RequestBody user_dto dto) {
        // handle joining a room
		QuizRoom find_room = list.get(idroom);
		find_room.getPlayers().remove(dto);
        return find_room;
    }
	@MessageMapping("/start")
    @SendTo("/topic/room/{idroom}")
    public List<quizz_dto> startQuizz(@DestinationVariable int idroom) {
        // handle joining a room
    	QuizRoom find_room = list.get(idroom);
		
        return find_room.getQuestions();
    }
    @MessageMapping("/end")
    @SendTo("/topic/room/{idroom}")
    public QuizRoom end(@DestinationVariable int idroom) {
        // handle joining a room
    	QuizRoom find_room = list.get(idroom);
		list.remove(idroom);
        return find_room;
    }
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        String username = event.getUser().getName();
//
//        // find the room for the user
//        QuizRoom room = findRoomForUser(username);
//
//        if (room != null) {
//            // find the player for the user
//            Player player = findPlayerForUser(username);
//
//            if (player != null) {
//                // remove the player from the room
//                room.removePlayer(player);
//
//                // if the room is empty, remove it
//                if (room.getPlayers().isEmpty()) {
//                    removeRoom(room);
//                }
//            }
//        }
//    }
}
