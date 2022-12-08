package com.example.kickerdavinci.Controllers;

import com.example.kickerdavinci.Models.Division;
import com.example.kickerdavinci.Models.model.NoIdDivision;
import com.example.kickerdavinci.Services.DivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DivisionController {

  private final DivisionService divisionService;

  public DivisionController(DivisionService divisionService) {
    this.divisionService = divisionService;
  }

  @PostMapping("/division")
  public ResponseEntity<Void> createOne(@RequestBody NoIdDivision division) {
    if (division.getName() == null || division.getName().equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!divisionService.createOne(division)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/division/{name}")
  public ResponseEntity<Division> getOne(@PathVariable String name) {
    if (name == null || name.equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    Division division = divisionService.getOne(name);
    if (division == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(division, HttpStatus.OK);
  }

  @GetMapping("/divisions")
  public ResponseEntity<Iterable<Division>> getAllDivisions() {
    return new ResponseEntity<>(divisionService.getAll(), HttpStatus.OK);
  }

  @DeleteMapping("/division/{name}")
  public ResponseEntity<Void> deleteByName(@PathVariable String name) {
    if (name == null || name.equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!divisionService.deleteByName(name)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/division/{name}")
  public ResponseEntity<Void> updateDivision(@RequestBody NoIdDivision division,
      @PathVariable String name) {
    if (division.getName() == null || division.getName().equals("")) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (!divisionService.existsName(name)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    if (!divisionService.update(division.toDivision(), name)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(HttpStatus.OK);

  }
}
