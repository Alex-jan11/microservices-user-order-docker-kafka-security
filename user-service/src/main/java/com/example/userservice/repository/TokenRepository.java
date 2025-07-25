// repository/TokenRepository.java
package com.example.userservice.repository;

import com.example.userservice.model.Token;
import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    List<Token> findAllByUser(User user);

    Optional<Token> findByToken(String token);
}
