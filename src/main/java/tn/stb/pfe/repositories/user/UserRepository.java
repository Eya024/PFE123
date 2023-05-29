package tn.stb.pfe.repositories.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import tn.stb.pfe.models.user.User;

@Repository
public interface UserRepository extends CommonUserRepository<User> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
  
    Boolean existsByEmail(String email);

}
