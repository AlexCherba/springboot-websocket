package com.vidwel.learn.springbootwebsocket.controller;

import com.vidwel.learn.springbootwebsocket.model.dto.RequestDTO;
import com.vidwel.learn.springbootwebsocket.model.dto.ResponseDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class WebSocketController {

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public ResponseDTO test(RequestDTO requestDTO) {
        System.out.println("requestDTO: " + requestDTO);
        return new ResponseDTO(requestDTO.getName(), new Date(), true);
    }
    @MessageMapping("/friends.get_all")
    @SendTo("/friend/get")
    public List getFriends(String authId) {
        System.out.println("authId: " + authId);
        return new ArrayList<String>(){{this.add(authId);}};
    }
}
