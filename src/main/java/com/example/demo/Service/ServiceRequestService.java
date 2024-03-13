package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.RequestStatus;
import com.example.demo.Entity.ServiceRequest;
import com.example.demo.Repositry.ServiceRequestRepository;
import com.example.demo.ServiceInterface.ServiceRequestInterface;

@Service
public class ServiceRequestService implements ServiceRequestInterface 
{
	 @Autowired
	    private ServiceRequestRepository serviceRequestRepository;

	    public ServiceRequest submitServiceRequest(ServiceRequest serviceRequest) {
	        serviceRequest.setSubmittedDateTime(LocalDateTime.now());
	        serviceRequest.setStatus(RequestStatus.SUBMITTED);
	        return serviceRequestRepository.save(serviceRequest);
	    }
	    
	    public ServiceRequest getServiceRequestById(Long id) {
	        return serviceRequestRepository.findById(id).orElse(null);
	    }
	    public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest) {
	        return serviceRequestRepository.save(serviceRequest);
	    }
	    public List<ServiceRequest> getServiceRequestsByCustomer(Customer customer) {
	        return serviceRequestRepository.findByCustomer(customer);
	    }
}
