package com.vidwel.learn.springbootwebsocket.config;

import com.vidwel.learn.springbootwebsocket.model.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 5000)
    public void sendAdhocMessages() {
        template.convertAndSend("/topic/user", new ResponseDTO("Send Scheduler /topic/user", new Date(), true));
    }
    @Scheduled(fixedDelay = 5000)
    public void sendNews() {
        template.convertAndSend("/topic/news", new ResponseDTO("Send Scheduler /topic/news", new Date(), true));
    }
}
