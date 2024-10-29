package com.example.ATM.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class MediaLog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message = "timestamp can't be Null")
    private LocalDateTime timestamp;
	
	@NotNull(message = "mediaPath can't be Null")
    private String mediaPath;
	
	@NotNull (message = "Atm Id can't be Null")
    private Long atmId;
    
    public MediaLog() {
    	
    }
	public MediaLog(Long id, LocalDateTime timestamp, String mediaPath, Long atmId) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.mediaPath = mediaPath;
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
	public String getMediaPath() {
		return mediaPath;
	}
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	public Long getAtmId() {
		return atmId;
	}
	public void setAtmId(Long atmId) {
		this.atmId = atmId;
	}
    
    
}
