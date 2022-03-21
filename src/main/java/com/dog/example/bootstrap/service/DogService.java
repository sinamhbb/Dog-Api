package com.dog.example.bootstrap.service;

import com.dog.example.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();
    List<String> retrieveDogBreeds();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();

}
