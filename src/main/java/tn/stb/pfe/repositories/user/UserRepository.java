package tn.stb.pfe.repositories.user;

import org.springframework.stereotype.Repository;

import tn.stb.pfe.models.user.User;

@Repository
public interface UserRepository extends CommonUserRepository<User> {
}
