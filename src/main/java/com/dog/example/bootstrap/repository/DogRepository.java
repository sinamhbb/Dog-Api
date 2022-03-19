package com.dog.example.bootstrap.repository;


import com.dog.example.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d.id, d.breed FROM Dog d WHERE d.id=:id")
    public String findBreedById(Long id);

    @Query("SELECT d.id, d.breed FROM Dog d")
    public List<String> findAllBreed();

    @Query("SELECT d.id, d.name FROM Dog d")
    public List<String> findAllName();

}
