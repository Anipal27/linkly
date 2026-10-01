package com.MyOrg.Linkly.repository;

import com.MyOrg.Linkly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findByFirstname(String firstname);
    List<User> findByFirstnameAndLastname(String firstname, String lastname);
    List<User> findByFirstnameContainingAndLastnameContaining(String firstname, String lastname);
}
