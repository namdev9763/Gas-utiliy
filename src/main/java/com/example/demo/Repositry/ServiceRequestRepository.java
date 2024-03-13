package com.example.demo.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> 
{
	 List<ServiceRequest> findByCustomer(Customer customer);
}
