package com.dog.example.bootstrap.service;

import java.util.List;

public interface DogService {

    List<String> retrieveDogBreeds();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();

}
