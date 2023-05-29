package tn.stb.pfe.repositories.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.stb.pfe.models.user.Role;
import tn.stb.pfe.models.user.RoleStatus;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleStatus name);
}
