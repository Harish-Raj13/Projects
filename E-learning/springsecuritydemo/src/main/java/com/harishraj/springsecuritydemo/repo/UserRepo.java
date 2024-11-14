package com.harishraj.springsecuritydemo.repo;

import com.harishraj.springsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
