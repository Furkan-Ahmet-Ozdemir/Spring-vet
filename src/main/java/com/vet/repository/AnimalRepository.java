package com.vet.repository;

import com.vet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Integer > {
    public Long countById(Integer id);

    @Query(value = "select * from animal join users  where name like %:keyword% or where users.name like %:keyword%", nativeQuery = true)
    List<Animal> findByKeyword(@Param("keyword") String keyword);

}
//    @Query(value = "select * from animal join user a where name like %:keyword% or where user.firstName like %:keyword%", nativeQuery = true)
//    List<Animal> findByKeyword(@Param("keyword") String keyword);
//select * from animal join user on(animal.user_id=user.id) where name
//select * from animal inner join users (animal.user_id=user.id) where animal.name like %:keyword% or users.firstName like %:keyword%