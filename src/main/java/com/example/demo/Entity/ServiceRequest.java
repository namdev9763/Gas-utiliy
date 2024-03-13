package com.example.demo.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ServiceRequest 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String details;
    private LocalDateTime submittedDateTime;
    private LocalDateTime resolvedDateTime;
    private RequestStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

	public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceRequest(Long id, String type, String details, LocalDateTime submittedDateTime,
			LocalDateTime resolvedDateTime, RequestStatus status, Customer customer) {
		super();
		this.id = id;
		this.type = type;
		this.details = details;
		this.submittedDateTime = submittedDateTime;
		this.resolvedDateTime = resolvedDateTime;
		this.status = status;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getSubmittedDateTime() {
		return submittedDateTime;
	}

	public void setSubmittedDateTime(LocalDateTime submittedDateTime) {
		this.submittedDateTime = submittedDateTime;
	}

	public LocalDateTime getResolvedDateTime() {
		return resolvedDateTime;
	}

	public void setResolvedDateTime(LocalDateTime resolvedDateTime) {
		this.resolvedDateTime = resolvedDateTime;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", type=" + type + ", details=" + details + ", submittedDateTime="
				+ submittedDateTime + ", resolvedDateTime=" + resolvedDateTime + ", status=" + status + ", customer="
				+ customer + "]";
	}
    
}
