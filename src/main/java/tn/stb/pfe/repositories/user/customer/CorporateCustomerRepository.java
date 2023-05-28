package tn.stb.pfe.repositories.user.customer;

import org.springframework.stereotype.Repository;
import tn.stb.pfe.models.user.customer.CorporateCustomer;
import tn.stb.pfe.repositories.user.CommonUserRepository;

@Repository
public interface CorporateCustomerRepository extends CommonUserRepository<CorporateCustomer> {
}
