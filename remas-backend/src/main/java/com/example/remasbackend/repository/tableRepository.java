package com.example.remasbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.remasbackend.model.table;

@Repository
public interface tableRepository extends JpaRepository<table, Long> {
}
