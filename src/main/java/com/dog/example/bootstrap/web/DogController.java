package com.dog.example.bootstrap.web;

import com.dog.example.bootstrap.entity.Dog;
import com.dog.example.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogList = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogList,HttpStatus.OK);
    }

    @GetMapping("/dog-breeds")
    public ResponseEntity<List<String>> getAllBreeds() {
        List<String> dogBreeds = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(dogBreeds, HttpStatus.OK);
    }

    @GetMapping("dog-breed")
    public ResponseEntity<List<String>> getBreedById(@RequestParam(value = "id") Long id) {

        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<List<String>>(Collections.singletonList(breed),HttpStatus.OK);
    }

    @GetMapping("/dog-names")
    public ResponseEntity<List<String>> getAllNames() {
        List<String> dogNames = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(dogNames, HttpStatus.OK);
    }

}
