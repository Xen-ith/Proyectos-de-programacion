package com.example.proye.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "calzados")
public class calzado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "precio", nullable = false)
    private long precio;

    @Column(name = "stock", nullable = false)
    private int stock;

    public calzado() {
    }

    public calzado(String modelo, long precio, int stock) {
        this.modelo = modelo;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("calzado{");
        sb.append("id=").append(id);
        sb.append(", modelo=").append(modelo);
        sb.append(", precio=").append(precio);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }

    

}
    