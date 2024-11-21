package com.wipro.velocity.ims.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.velocity.ims.model.Dealer;
import com.wipro.velocity.ims.model.DealerAddress;

public interface UserRepository extends CrudRepository<Dealer, Long> {

	// Fetch record/object based on email - non Id field
	
	/*Optional is a container object which may or may not contain a non-null value.
	If a value is present, isPresent() returns true. If no value is present, the object is considered empty and isPresent() returns false.
	*/
    public Dealer findByEmail(String email);
    
  //Custom queries using jpql in crud repo
    @Query("SELECT new com.wipro.velocity.ims.model.DealerAddress(d.id,d.email,d.fname,d.lname,"
            + "d.password,d.dob,d.phoneNo,a.street,a.city,a.pincode) "
            + "FROM Dealer d INNER JOIN d.address a")
    List<DealerAddress> fetchDealerInnerJoin();
}
