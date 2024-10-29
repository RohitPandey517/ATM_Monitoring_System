package com.example.ATM.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ATM.models.FailureLog;
import com.example.ATM.models.MediaLog;
import com.example.ATM.repositories.FailureLogRepository;
import com.example.ATM.repositories.MediaLogRepository;
import com.example.ATM.repositories.TransactionRepository;
import com.example.ATM.models.Transaction;

@Service
public class AtmService {

	@Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private FailureLogRepository failureLogRepository;
    @Autowired
    private MediaLogRepository mediaLogRepository;

    public Long getCustomerCountLast24Hours() {
        return transactionRepository.countUniqueCustomersLast24Hours(LocalDateTime.now().minusHours(24));
    }

    public List<Object[]> getTransactionBreakdown() {
        return transactionRepository.countTransactionsByType();
    }

    public List<FailureLog> getFailureLogs() {
        return failureLogRepository.findAllByOrderByTimestampDesc();
    }

    public List<MediaLog> getMediaLogs(LocalDateTime startTime, LocalDateTime endTime) {
        return mediaLogRepository.findByTimestampBetween(startTime, endTime);
    }
    
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public FailureLog saveFailureLog(FailureLog failureLog) {
        return failureLogRepository.save(failureLog);
    }

    public MediaLog saveMediaLog(MediaLog mediaLog) {
        return mediaLogRepository.save(mediaLog);
    }
}
