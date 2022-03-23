package com.vet.service;

import com.vet.exception.AnimalNotFoundException;
import com.vet.model.Animal;
import com.vet.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository repo;

    public List<Animal> listAll(){
        return (List<Animal>) repo.findAll();
    }

    public void save(Animal animal) {
        repo.save(animal);
        return ;
    }

    public Animal get(Integer id) throws AnimalNotFoundException {
        Optional<Animal> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new AnimalNotFoundException("Couldn find any Animal with ID "+ id);
    }

    public void delete(Integer id) throws AnimalNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count==0){
            throw new AnimalNotFoundException("Couldn find any Animal with ID "+ id);
        }
        repo.deleteById(id);
    }

}
