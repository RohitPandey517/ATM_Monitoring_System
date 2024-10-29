package com.example.ATM.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ATM.models.FailureLog;
import com.example.ATM.models.MediaLog;
import com.example.ATM.models.Transaction;
import com.example.ATM.services.AtmService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/atm")
public class AtmController {
	
	@Autowired
    private AtmService atmService;

    @GetMapping("/customers/last24hours")
    public ResponseEntity<Long> getCustomerCountLast24Hours() {
        Long count = atmService.getCustomerCountLast24Hours();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/transactions/breakdown")
    public ResponseEntity<List<Object[]>> getTransactionBreakdown() {
    	List<Object[]> breakdown = atmService.getTransactionBreakdown();
        return ResponseEntity.ok(breakdown);
    }

    @GetMapping("/failures")
    public ResponseEntity<List<FailureLog>> getFailureLogs() {
        List<FailureLog> failures = atmService.getFailureLogs();
        return ResponseEntity.ok(failures);
    }

    @GetMapping("/camera/media")
    public ResponseEntity<List<MediaLog>> downloadMedia(
            @RequestParam String startTime,
            @RequestParam String endTime) {
        List<MediaLog> mediaLogs = atmService.getMediaLogs(
                LocalDateTime.parse(startTime),
                LocalDateTime.parse(endTime)
        );
        return ResponseEntity.ok(mediaLogs);
    }
    
    @PostMapping("/transaction")
    public ResponseEntity<Transaction> addTransaction(@RequestBody @Valid Transaction transaction) {
        Transaction savedTransaction = atmService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @PostMapping("/failure")
    public ResponseEntity<FailureLog> addFailureLog(@RequestBody @Valid FailureLog failureLog) {
        FailureLog savedFailureLog = atmService.saveFailureLog(failureLog);
        return ResponseEntity.ok(savedFailureLog);
    }

    @PostMapping("/media")
    public ResponseEntity<MediaLog> addMediaLog(@RequestBody @Valid MediaLog mediaLog) {
        MediaLog savedMediaLog = atmService.saveMediaLog(mediaLog);
        return ResponseEntity.ok(savedMediaLog);
    }
}
