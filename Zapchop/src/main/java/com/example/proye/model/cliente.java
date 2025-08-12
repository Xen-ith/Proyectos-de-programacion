package com.example.proye.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "identificacion", nullable = false, unique = true)
    private int identificacion;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "telefono", nullable = false)
    private long telefono;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;
    

    public cliente() {
    }

    public cliente(String nombre, String contraseña, int identificacion, String direccion, long telefono, String correo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "cliente [id=" + id + ", nombre=" + nombre + ", contraseña=" + contraseña + ", identificacion="
                + identificacion + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + "]";
    }


    
    
    
    
    
    
}
