package com.vidwel.learn.springbootwebsocket.controller;

import com.vidwel.learn.springbootwebsocket.model.dto.RequestDTO;
import com.vidwel.learn.springbootwebsocket.model.dto.ResponseDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class WebSocketController {

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public ResponseDTO test(RequestDTO requestDTO) {
        System.out.println("requestDTO: " + requestDTO);
        return new ResponseDTO(requestDTO.getName(), new Date(), true);
    }
}
