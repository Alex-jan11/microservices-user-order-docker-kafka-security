// repository/UserRepository.java
package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    // căutare parțială (ex: pentru search)
    @Query("SELECT u FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :usernamePart, '%'))")
    List<User> searchByUsernameFragment(@Param("usernamePart") String usernamePart);
}

