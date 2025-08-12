package com.example.proye.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proye.model.pedido;


@Repository
public interface pedidoRepository  extends JpaRepository<pedido, Long>{

    
}
