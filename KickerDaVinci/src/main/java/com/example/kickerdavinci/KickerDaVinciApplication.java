package com.example.kickerdavinci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class KickerDaVinciApplication {

  public static void main(String[] args) {
    SpringApplication.run(KickerDaVinciApplication.class, args);
  }

}
