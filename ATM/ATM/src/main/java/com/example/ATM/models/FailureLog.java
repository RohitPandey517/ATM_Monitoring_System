package com.example.ATM.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class FailureLog {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull(message = "Timestamp cannot be null")
	    private LocalDateTime timestamp;

	    @NotNull(message = "Description cannot be null")
	    @Size(max = 255, message = "Description must be within 255 characters")
	    private String description;

	    @NotNull(message = "ATM ID cannot be null")
	    private Long atmId;
	    
	    public FailureLog() {
	    	
	    }
		public FailureLog(Long id, LocalDateTime timestamp, String description, Long atmId) {
			super();
			this.id = id;
			this.timestamp = timestamp;
			this.description = description;
			this.atmId = atmId;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Long getAtmId() {
			return atmId;
		}
		public void setAtmId(Long atmId) {
			this.atmId = atmId;
		}
	    
	    
}
