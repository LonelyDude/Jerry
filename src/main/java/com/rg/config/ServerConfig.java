package com.rg.config;

import com.rg.http.HttpServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.io.IOException;
import java.net.ServerSocket;

@Configuration
@Import({ContextConfig.class, ThreadPoolConfig.class})
public class ServerConfig {

    @Value("${port}")
    private int port;

    @Bean(destroyMethod = "close")
    public ServerSocket serverSocket() throws IOException {
        return new ServerSocket(port);
    }

    @Bean(initMethod = "init")
    public HttpServer server(){
        return new HttpServer();
    }

}