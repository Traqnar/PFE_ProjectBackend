package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Services.SetService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetController {

  private final SetService setService;

  public SetController(SetService setService) {
    this.setService = setService;
  }
}
