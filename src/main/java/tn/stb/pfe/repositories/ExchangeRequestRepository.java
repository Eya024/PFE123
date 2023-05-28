package tn.stb.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.stb.pfe.models.ExchangeRequest;

@Repository
public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Integer> {
}
