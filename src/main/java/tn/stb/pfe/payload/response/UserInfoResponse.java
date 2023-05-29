package tn.stb.pfe.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Integer id;

	private String username;

	private String email;
  
	private String firstName;
  
	private String lastName;
  
	private String mobile;
  
	private String street;
  
	private String city;
  
	private String postcode;
	
	private List<String> roles;

	public UserInfoResponse(Integer id, String username, String email, String firstName, String lastName, String mobile, String street, String city, String postcode, List<String> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.street = street;
		this.city = city;
		this.postcode = postcode;
		this.roles = roles;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postcode;
	}
	
	public List<String> getRoles() {
		return roles;
	}
}
