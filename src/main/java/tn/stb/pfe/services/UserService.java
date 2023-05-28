package tn.stb.pfe.services;

import tn.stb.pfe.models.Work;
import tn.stb.pfe.models.user.Role;
import tn.stb.pfe.models.user.User;
import tn.stb.pfe.models.user.customer.CorporateCustomer;
import tn.stb.pfe.models.user.customer.Customer;
import tn.stb.pfe.models.user.customer.RetailCustomer;
import tn.stb.pfe.models.user.provider.Provider;

import java.util.Collection;
import java.util.List;

public interface UserService {
    boolean userExists(String userName);

    User getUserById(int userId);

    User getUserByUsername(String userName);

    List<User> getUsersByRoleName(String roleName);

    List<User> getAllUsers();

    void deleteUserById(int userId);

   // void updateUserPassword(ChangePasswordForm passwordChangeForm);

    /*
     * Provider
     * */
    Provider getProviderById(int providerId);

    List<Provider> getProvidersWithRetailWorks();

    List<Provider> getProvidersWithCorporateWorks();

    List<Provider> getProvidersByWork(Work work);

    List<Provider> getAllProviders();

   /* void saveNewProvider(UserForm userForm);

    void updateProviderProfile(UserForm updateData);*/

    Collection<Role> getRolesForProvider();

    /*
     * Customer
     * */
    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    /*
     * RetailCustomer
     * */
    RetailCustomer getRetailCustomerById(int retailCustomerId);

   // void saveNewRetailCustomer(UserForm userForm);

  //  void updateRetailCustomerProfile(UserForm updateData);

    Collection<Role> getRolesForRetailCustomer();

    /*
     * CorporateCustomer
     * */
    CorporateCustomer getCorporateCustomerById(int corporateCustomerId);

    List<RetailCustomer> getAllRetailCustomers();

  //  void saveNewCorporateCustomer(UserForm userForm);

   // void updateCorporateCustomerProfile(UserForm updateData);

    Collection<Role> getRoleForCorporateCustomers();


    User saveUserProvider(Provider user);

    User saveUserCustomer(Customer user);


}

