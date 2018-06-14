package com.example.yamldemo.dataobject;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "server-production")
@Data
public class ServerInfo {

    //服务器 IP
    private String ip;

    //服务器端口号
    private String port;

}
