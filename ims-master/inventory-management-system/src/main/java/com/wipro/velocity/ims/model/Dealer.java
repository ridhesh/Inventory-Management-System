package com.wipro.velocity.ims.model;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="dealer")
public class Dealer {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
   
    @Column(unique = true)
    private String email;
   
    @Column(name="first_name")
    private String fname;
   
    @Column(name="last_name")
    private String lname;
   
    @Column(name="password")
    private String password;
   
     @Column(name="dob")
     private Date dob;
    
    @Column(name="phone")
    private String phoneNo;
   
    /*
    one-to-one relationship,  between Dealer and address entities.
    Implementing With a Foreign Key in JPA
 
    @OneToOne annotation on the related entity field, Address.
    */
    @OneToOne(mappedBy="dealer",cascade =  CascadeType.ALL)
    private Address address;

	public Dealer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();  // encrypt password in database field
        String normalString = password;
        String encodedString = encoder.encodeToString(
        normalString.getBytes(StandardCharsets.UTF_8) );
        this.password = encodedString;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}  
}
