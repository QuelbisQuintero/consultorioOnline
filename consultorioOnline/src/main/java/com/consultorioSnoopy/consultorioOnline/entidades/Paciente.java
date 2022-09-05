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
@Entity(name="pacientes")
public class Paciente {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre_completo", length = 45, nullable = false, unique = false)
    private String nombreCompleto;
    
    @Column(name="tipo_documento", length = 5, nullable = false, unique = false)
    private String tipoDocumento;
    
    @Column(name="numero_documento", nullable = false, unique = true)
    private int numeroDocumento;
    
    @Column(name="clave",  length = 45, nullable = false, unique = false)
    private String clave;
    
    @Column(name="habilitado", nullable=true, unique = false, columnDefinition = "TINYINT")
    private boolean habilitado; //vale como habeas data
    
    public Paciente() {
    }

    public Paciente(int id, String nombreCompleto, String tipoDocumento, int numeroDocumento, String clave) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.clave = clave;
    }

    public Paciente(String nombreCompleto, String tipoDocumento, int numeroDocumento, String clave) {
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.clave = clave;
        habilitado=true;
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

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", clave=" + clave + ", habilitado=" + habilitado + '}';
    }
      
   
}
