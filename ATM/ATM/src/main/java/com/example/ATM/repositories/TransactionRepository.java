package com.example.ATM.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ATM.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
	@Query("SELECT COUNT(DISTINCT t.customerId) FROM Transaction t WHERE t.timestamp >= :fromTime")
    Long countUniqueCustomersLast24Hours(LocalDateTime fromTime);

    @Query("SELECT t.type, COUNT(t) FROM Transaction t GROUP BY t.type")
    List<Object[]> countTransactionsByType();
}
