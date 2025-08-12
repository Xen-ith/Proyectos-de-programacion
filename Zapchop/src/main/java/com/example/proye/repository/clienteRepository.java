package com.example.proye.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proye.model.cliente;



@Repository
public interface clienteRepository extends JpaRepository<cliente, Long> {
}