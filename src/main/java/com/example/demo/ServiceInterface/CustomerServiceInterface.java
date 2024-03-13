package com.example.demo.ServiceInterface;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;

@Service 
public interface CustomerServiceInterface
{
	 public Customer saveCustomer(Customer customer);
	 public Customer getCustomerById(Long id);
}
