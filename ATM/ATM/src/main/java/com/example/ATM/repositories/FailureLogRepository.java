package com.example.ATM.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ATM.models.FailureLog;

public interface FailureLogRepository extends JpaRepository<FailureLog, Long>{
	List<FailureLog> findAllByOrderByTimestampDesc();
}
