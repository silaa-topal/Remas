package com.company.remasbackend.repository;

import com.company.remasbackend.model.Reciept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecieptRepository extends JpaRepository<Reciept, Long> {

}
