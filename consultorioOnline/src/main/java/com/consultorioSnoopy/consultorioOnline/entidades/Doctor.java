/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yonathanp
 */
@Entity(name="doctores")
public class Doctor {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre_completo", length = 80, nullable = false, unique = false)
    private String nombreCompleto;
    
    @Column(name="tipo_documento", length = 5, nullable = false, unique = false)
    private String tipoDocumento;
    
    @Column(name="numero_documento", nullable = false, unique = true)
    private int numeroDocumento;
    
    @Column(name="clave",  length = 20, nullable = false, unique = false)
    private String clave;
    
    @Column(name="telefono", nullable = true, unique = false)
    private int telefono;
    
    @Column(name="habilitado", nullable=false, unique = false, columnDefinition = "TINYINT")
    private boolean habilitado;

    public Doctor(int id, String nombreCompleto, String tipoDocumento, int numeroDocumento, String clave, int telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.clave = clave;
        this.telefono = telefono;
    }

    public Doctor(String nombreCompleto, String tipoDocumento, int numeroDocumento, String clave, int telefono) {
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.clave = clave;
        this.telefono = telefono;
        habilitado=true;
    }

    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
    
}
