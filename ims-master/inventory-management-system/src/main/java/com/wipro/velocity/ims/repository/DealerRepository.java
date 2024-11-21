package com.wipro.velocity.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.velocity.ims.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

	/*
     * This interface DealerRepository has save(),findAll(),findById(),deleteById(),count()
    etc.. inbuilt methods of JpaRepository for various database operations.
    This interface will be implemented by class automatically
    */
}
