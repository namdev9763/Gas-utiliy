package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Repositry.CustomerRepository;
import com.example.demo.ServiceInterface.CustomerServiceInterface;

@Service
public class CustomerService implements CustomerServiceInterface
{
	@Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) 
    {
        return customerRepository.findById(id).orElse(null);
    }

}
