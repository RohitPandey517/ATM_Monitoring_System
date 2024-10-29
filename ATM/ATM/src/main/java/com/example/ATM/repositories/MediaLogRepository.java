package com.example.ATM.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ATM.models.MediaLog;

public interface MediaLogRepository extends JpaRepository<MediaLog,Long> {
	List<MediaLog> findByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);
}
