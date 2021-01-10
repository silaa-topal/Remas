package com.example.remasbackend.repository;

import com.example.remasbackend.model.receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface receiptRepository extends JpaRepository<receipt, Long> {
}
