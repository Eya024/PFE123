package tn.stb.pfe.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.stb.pfe.models.user.User;
import java.util.List;
import java.util.Optional;

@Repository
@NoRepositoryBean
public interface CommonUserRepository<T extends User> extends JpaRepository<T, Integer> {

    Optional<T> findByUsername(String username);

    @Query("select t from #{#entityName} t inner join t.roles r where r.name in :roleName")
    List<T> findByRoleName(@Param("roleName") String roleName);
}
