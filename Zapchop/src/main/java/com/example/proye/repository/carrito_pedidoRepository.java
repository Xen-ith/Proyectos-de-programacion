package com.example.proye.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proye.model.carrito_pedido;


public interface carrito_pedidoRepository extends JpaRepository<carrito_pedido, Long>{
    List<carrito_pedido> findByClienteId(Long id);

    public Optional<carrito_pedido> findById(Integer pedidoId);
}
