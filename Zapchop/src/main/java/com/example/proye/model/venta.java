package com.example.proye.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private pedido pedido;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    

    public venta() {
    }

    public venta(pedido pedido, LocalDate fecha){
        this.pedido = pedido;
        this.fecha = fecha;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public pedido getPedido() {
        return pedido;
    }

    public void setPedido(pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("venta{");
        sb.append("id=").append(id);
        sb.append(", pedido=").append(pedido);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }

    

    
}