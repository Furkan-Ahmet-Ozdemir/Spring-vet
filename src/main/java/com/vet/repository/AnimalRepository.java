package com.vet.repository;

import com.vet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal,Integer > {
    public Long countById(Integer id);
}
