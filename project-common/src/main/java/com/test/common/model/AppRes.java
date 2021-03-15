package com.test.common.model;


import lombok.Data;

import java.util.List;


@Data
public class AppRes {

    private String replyName;

    private List<String> serviceList;

    private Integer status = 200;
    
    private String message;
}
