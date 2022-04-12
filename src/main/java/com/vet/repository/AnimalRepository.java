package com.vet.repository;

import com.vet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Integer > {
    public Long countById(Integer id);

    @Query(value = "select a.* from animals a inner join users u on u.id=a.user_id where a.name like %:keyword% or u.first_name like %:keyword%", nativeQuery = true)
    List<Animal> findByKeyword(@Param("keyword") String keyword);
}

