package tn.stb.pfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.stb.pfe.models.user.User;
import tn.stb.pfe.models.user.customer.Customer;
import tn.stb.pfe.models.user.provider.Provider;
import tn.stb.pfe.services.UserService;


@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // create provider user with role
    @ResponseBody
    @PostMapping("/add-provider")
    public void addProvider (@RequestBody Provider user) {
        userService.saveUserProvider(user);
    }

    // create customer user
    @ResponseBody
    @PostMapping("/add-customer")
    public void addProvider(@RequestBody Customer user) {
        userService.saveUserCustomer(user);
    }


    @ResponseBody
    @GetMapping("/all-providers")
    public List<Provider> showAllProviders() {
        return userService.getAllProviders();
    }

    @ResponseBody
    @GetMapping("/all-customers")
    public List<Customer> showAllCustomers() {
        return userService.getAllCustomers();
    }


    @ResponseBody
    @GetMapping("/all-users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
}
