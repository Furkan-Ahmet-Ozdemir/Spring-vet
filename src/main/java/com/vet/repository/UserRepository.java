package com.vet.repository;

import com.vet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Long countById(Integer id);


}
