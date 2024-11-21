package com.wipro.velocity.ims.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.velocity.ims.model.Dealer;
import com.wipro.velocity.ims.repository.DealerRepository;
import com.wipro.velocity.ims.repository.UserRepository;

/*
Spring @Service annotation can be applied only to classes.
It is used to mark the class as a service provider.
It is used with classes that provide some business functionalities.
Spring context will autodetect these classes when 
annotation-based configuration and classpath scanning is used.
*/

/*
@Transactional annotation provides broad support for transaction 
management and allows developers to concentrate on business logic 
rather than worrying about data integrity in the event of system 
failures.
*/

@Service
@Transactional
public class DealerService {
	
	/*
    @Autowired annotation is used for dependency injection.
	In spring boot application, all loaded beans are eligible 
	for auto wiring to another bean.
	The annotation @Autowired in spring boot is used to 
	auto-wire a bean into another bean.
	*/
	@Autowired
	private DealerRepository drepo;
	
	@Autowired
	private UserRepository urepo;
	
	public void saveDealer(Dealer dealer)
	{
		drepo.save(dealer);		//invokes save() method of JpaRepository
		
	}
	
	public Dealer findByEmail(String email)
	{
		return urepo.findByEmail(email);
	}
	
	
}
