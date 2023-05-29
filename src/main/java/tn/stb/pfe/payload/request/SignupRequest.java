package tn.stb.pfe.payload.request;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String firstName;

    private String lastName;

    private String mobile;

    private String street;

    private String city;

    private String postcode;

  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName() {
      return this.firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return this.lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getMobile() {
      return this.mobile;
    }

    public void setMobile(String mobile) {
      this.mobile = mobile;
    }

    public String getStreet() {
      return this.street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getCity() {
      return this.city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getPostCode() {
      return this.postcode;
    }

    public void setPostCode(String postcode) {
      this.postcode = postcode;
    }

    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
