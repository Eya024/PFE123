package tn.stb.pfe.repositories.user.provider;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.stb.pfe.models.Work;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.repositories.user.CommonUserRepository;
import java.util.List;

@Repository
public interface ProviderRepository extends CommonUserRepository<Provider> {

    List<Provider> findByWorks(Work work);

    @Query("select distinct p from Provider p inner join p.works w where w.targetCustomer = 'retail'")
    List<Provider> findAllWithRetailWorks();

    @Query("select distinct p from Provider p inner join p.works w where w.targetCustomer = 'corporate'")
    List<Provider> findAllWithCorporateWorks();
}
