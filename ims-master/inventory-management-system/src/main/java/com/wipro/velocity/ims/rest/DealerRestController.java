package com.wipro.velocity.ims.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.ims.exception.ResourceNotFoundException;
import com.wipro.velocity.ims.model.Address;
import com.wipro.velocity.ims.model.Dealer;
import com.wipro.velocity.ims.model.DealerAddress;
import com.wipro.velocity.ims.repository.UserRepository;
//import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class DealerRestController {

	@Autowired
	private UserRepository urepo;

	@PostMapping("/dealer")
	public Boolean loginDealer(@Validated @RequestBody Dealer dealer) throws ResourceNotFoundException
	{
		Boolean a=false;;
		String email=dealer.getEmail();
		String password=dealer.getPassword();
		//System.out.println(email+password);
		Dealer d = urepo.findByEmail(email);//.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: "));
		//    System.out.println(d.getEmail() +d.getPassword() );

		if(email.equals(d.getEmail()) && password.equals(d.getPassword()))
		{
			//    System.out.println(d.getEmail() +d.getPassword() );
			a=true;

		}
		return a;
	}
	
	//Open Postman and make POST request - http://localhost:8085/ims/api/dealers
    //Under body tab --> raw --> Text --> Json and type the json data to be saved
        
    @PostMapping("/dealers")
    public DealerAddress createDealer(@Validated @RequestBody DealerAddress dealer) throws ResourceNotFoundException{

 

        /*if(urepo.findByEmail(dealer.getEmail())!=null)
        {            
            new ResourceNotFoundException("User Already Exists");
        }*/
        System.out.println("Hello "+ dealer.getEmail()+" " +dealer.getPassword());
        Dealer d=new Dealer();
        d.setEmail(dealer.getEmail());
        d.setFname(dealer.getFname());
        d.setLname(dealer.getLname());
        d.setPassword(dealer.getPassword());
        System.out.println("Hello "+ dealer.getEmail()+" " +dealer.getPassword());
        d.setDob(dealer.getDob());
        d.setPhoneNo(dealer.getPhoneNo());
        
        Address a=new Address();
        a.setStreet(dealer.getStreet());
        a.setCity(dealer.getCity());
        a.setPincode(dealer.getPincode());
        
                
        d.setAddress(a);
        a.setDealer(d);
    //    lservice.saveDealer(dealer);
         urepo.save(d);
         return dealer;
    }
    
    @GetMapping("/dealers")
    public List<DealerAddress> getAllCustomers() {
         return  urepo.fetchDealerInnerJoin();
    }
    
    
}
