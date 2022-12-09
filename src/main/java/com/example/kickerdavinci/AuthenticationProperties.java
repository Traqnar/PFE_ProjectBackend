package com.example.kickerdavinci;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class AuthenticationProperties {

  private String secret = "s";
}