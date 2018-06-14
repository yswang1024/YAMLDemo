package com.example.yamldemo.controller;

import com.example.yamldemo.dataobject.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    private ServerInfo serverInfo;


    @GetMapping("/get")
    public String getServerInfo(){
        return serverInfo.toString();
    }

}
