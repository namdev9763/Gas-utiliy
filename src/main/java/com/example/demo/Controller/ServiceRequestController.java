package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.ServiceRequest;
import com.example.demo.ServiceInterface.ServiceRequestInterface;

@RestController
@RequestMapping("/api/servicerequests")
public class ServiceRequestController
{
	 @Autowired
	 private ServiceRequestInterface serviceRequestInterface;

	    @PostMapping
	    public ResponseEntity<ServiceRequest> submitServiceRequest(@RequestBody ServiceRequest serviceRequest)
	    {
	        ServiceRequest submittedRequest = serviceRequestInterface.submitServiceRequest(serviceRequest);
	        return new ResponseEntity<>(submittedRequest, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable Long id, @RequestBody ServiceRequest updatedRequest) {
	        ServiceRequest existingRequest = serviceRequestInterface.getServiceRequestById(id);
	        if (existingRequest == null)
	        {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        existingRequest.setType(updatedRequest.getType());
	        existingRequest.setDetails(updatedRequest.getDetails());
	        existingRequest.setResolvedDateTime(updatedRequest.getResolvedDateTime());
	        existingRequest.setStatus(updatedRequest.getStatus());
	        ServiceRequest updatedServiceRequest = serviceRequestInterface.updateServiceRequest(existingRequest);
	        return new ResponseEntity<>(updatedServiceRequest, HttpStatus.OK);
	    }

	    @GetMapping("/customer/{customerId}")
	    public ResponseEntity<List<ServiceRequest>> getServiceRequestsByCustomer(@PathVariable Long customerId) {
	        Customer customer = new Customer();
	        customer.setId(customerId);
	        List<ServiceRequest> serviceRequests = serviceRequestInterface.getServiceRequestsByCustomer(customer);
	        return new ResponseEntity<>(serviceRequests, HttpStatus.OK);
	    }

}
