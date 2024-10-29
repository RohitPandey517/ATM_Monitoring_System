package com.example.ATM.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Transaction {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull(message = "Transaction type cannot be null")
	    @Size(min = 1, max = 50, message = "Transaction type must be between 1 and 50 characters")
	    private String type;
	    
	    @NotNull(message = "Timestamp cannot be null")
	    private LocalDateTime timestamp;
	    
	    @NotNull(message = "Customer ID cannot be null")
	    private Long customerId;
	    
	    @NotNull(message = "ATM ID cannot be null")
	    private Long atmId;
	    
	    public Transaction() {
	    	
	    }
	    
		public Transaction(Long id, String type, LocalDateTime timestamp, Long customerId, Long atmId) {
			super();
			this.id = id;
			this.type = type;
			this.timestamp = timestamp;
			this.customerId = customerId;
			this.atmId = atmId;
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
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public Long getAtmId() {
			return atmId;
		}
		public void setAtmId(Long atmId) {
			this.atmId = atmId;
		}
	    
	    
	    
}
