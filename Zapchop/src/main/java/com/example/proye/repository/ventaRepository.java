package com.example.proye.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proye.model.venta;

@Repository
public interface ventaRepository extends JpaRepository<venta, Integer>{
    
}
