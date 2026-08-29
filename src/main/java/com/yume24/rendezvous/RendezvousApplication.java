package com.yume24.rendezvous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RendezvousApplication {

    static void main(String[] args) {
        SpringApplication.run(RendezvousApplication.class, args);
    }

}
