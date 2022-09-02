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
@Entity(name="paciente")
public class Paciente {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre_completo", length = 45, nullable = true)
    private String nombre_completo;
    
    @Column(name="tipo_documento", length = 5, nullable = true)
    private String tipo_documento;
    
    @Column(name="numero_documento", nullable = true)
    private String numero_documento;
    
    @Column(name="clave",  length = 45, nullable = true)
    private String clave;
    
    @Column(name="habilitado", nullable=true)
    private boolean habilitado; //vale como habeas data
    
    public Paciente() {
    }

    public Paciente(String nombre_completo, String tipo_documento, String numero_documento, String clave) {
        this.nombre_completo = nombre_completo;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.clave = clave;
        habilitado=true;
    }

    public int getId() {
        return id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
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
        return "Paciente{" + "id=" + id + ", nombre_completo=" + nombre_completo + ", tipo_documento=" + tipo_documento + ", numero_documento=" + numero_documento + ", clave=" + clave + ", habilitado=" + habilitado + '}';
    }
    
}
