package tn.stb.pfe.services.impl;


import org.springframework.stereotype.Service;
import tn.stb.pfe.models.Work;
import tn.stb.pfe.models.user.Role;
import tn.stb.pfe.models.user.User;
import tn.stb.pfe.models.user.customer.CorporateCustomer;
import tn.stb.pfe.models.user.customer.Customer;
import tn.stb.pfe.models.user.customer.RetailCustomer;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.repositories.RoleRepository;
import tn.stb.pfe.repositories.user.UserRepository;
import tn.stb.pfe.repositories.user.customer.CorporateCustomerRepository;
import tn.stb.pfe.repositories.user.customer.CustomerRepository;
import tn.stb.pfe.repositories.user.customer.RetailCustomerRepository;
import tn.stb.pfe.repositories.user.provider.ProviderRepository;
import tn.stb.pfe.services.UserService;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import tn.stb.pfe.exception.UserNotFoundException;


@Service
public class UserServiceImpl implements UserService {

    private final ProviderRepository providerRepository;
    private final CustomerRepository customerRepository;
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final RetailCustomerRepository retailCustomerRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    //private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(ProviderRepository providerRepository, CustomerRepository customerRepository, CorporateCustomerRepository corporateCustomerRepository, RetailCustomerRepository retailCustomerRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.providerRepository = providerRepository;
        this.customerRepository = customerRepository;
        this.corporateCustomerRepository = corporateCustomerRepository;
        this.retailCustomerRepository = retailCustomerRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean userExists(String userName) {
        return userRepository.findByUserName(userName).isPresent();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerRepository.getOne(customerId);
    }

    @Override
    public Provider getProviderById(int providerId) {
        return providerRepository.findById(providerId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public RetailCustomer getRetailCustomerById(int retailCustomerId) {
        return retailCustomerRepository.findById(retailCustomerId).orElseThrow(UserNotFoundException::new);

    }

    @Override
    public CorporateCustomer getCorporateCustomerById(int corporateCustomerId) {
        return corporateCustomerRepository.findById(corporateCustomerId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<RetailCustomer> getAllRetailCustomers() {
        return retailCustomerRepository.findAll();
    }


    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getUsersByRoleName(String roleName) {
        return userRepository.findByRoleName(roleName);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<Provider> getProvidersWithRetailWorks() {
        return providerRepository.findAllWithRetailWorks();
    }

    @Override
    public List<Provider> getProvidersWithCorporateWorks() {
        return providerRepository.findAllWithCorporateWorks();
    }

    @Override
    public List<Provider> getProvidersByWork(Work work) {
        return providerRepository.findByWorks(work);
    }

    @Override
    public Collection<Role> getRolesForRetailCustomer() {
        HashSet<Role> roles = new HashSet();
        roles.add(roleRepository.findByName("ROLE_CUSTOMER_RETAIL"));
        roles.add(roleRepository.findByName("ROLE_CUSTOMER"));
        return roles;
    }


    @Override
    public Collection<Role> getRoleForCorporateCustomers() {
        HashSet<Role> roles = new HashSet();
        roles.add(roleRepository.findByName("ROLE_CUSTOMER_CORPORATE"));
        roles.add(roleRepository.findByName("ROLE_CUSTOMER"));
        return roles;
    }

    @Override
    public Collection<Role> getRolesForProvider() {
        HashSet<Role> roles = new HashSet();
        roles.add(roleRepository.findByName("ROLE_PROVIDER"));
        return roles;
    }


}

