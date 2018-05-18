package com.vidwel.learn.springbootwebsocket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO {
    private String name;
    private Date date = new Date();
    private boolean status;
}
