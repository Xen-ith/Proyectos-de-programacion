package com.example.proye.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_pedido")
public class carrito_pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_calzado", nullable = false)
    private calzado calzado;

    @Column(name = "color1")
    private String color1;

    @Column(name = "color2")
    private String color2;

    @Column(name = "cordon")
    private String cordon;

    @Column(name = "talla")
    private int talla;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public calzado getCalzado() {
        return calzado;
    }

    public void setCalzado(calzado calzado) {
        this.calzado = calzado;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getCordon() {
        return cordon;
    }

    public void setCordon(String cordon) {
        this.cordon = cordon;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("pedido{");
        sb.append("id=").append(id);
        sb.append(", calzado=").append(calzado);
        sb.append(", color1=").append(color1);
        sb.append(", color2=").append(color2);
        sb.append(", cordon=").append(cordon);
        sb.append(", talla=").append(talla);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }












}
