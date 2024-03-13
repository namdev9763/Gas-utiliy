package com.example.demo.ServiceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.ServiceRequest;

@Service
public interface ServiceRequestInterface 
{
	 public ServiceRequest submitServiceRequest(ServiceRequest serviceRequest);
	 public ServiceRequest getServiceRequestById(Long id);
	 public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest);
	 public List<ServiceRequest> getServiceRequestsByCustomer(Customer customer);
}
