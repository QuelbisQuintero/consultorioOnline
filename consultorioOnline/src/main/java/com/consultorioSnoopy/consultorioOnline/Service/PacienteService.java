/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Service;

import com.consultorioSnoopy.consultorioOnline.entidades.Paciente;
import com.consultorioSnoopy.consultorioOnline.reposiorios.IPacientesRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yonathanp
 */
@Service
public class PacienteService {
    
    @Autowired
    private IPacientesRepo repo; 
    
    public Paciente crearEditarPaciente(Paciente p){
        return repo.save(p);      
    }
    
    public Paciente consultaPacientesIdentificacion(int n){
        return repo.findBynumeroDocumento(n);
    }
    
/*    
    public List<Paciente> consultaPacientesNombre(String n){
        return repo.findBynombre_completoContaining(n);
    } 
  */  
    public Paciente consultaPacienteId(int n){
        return repo.findById(n).get();
    }
    
    public boolean deshabilitarPaciente(Paciente p){
        p.setHabilitado(false);
        return crearEditarPaciente(p).isHabilitado();
    }
    
    public boolean habilitarPaciente(Paciente p){
        p.setHabilitado(true);
        return crearEditarPaciente(p).isHabilitado();
    }
    
    public List<Paciente> listaPacientesNombre (String criterio){
        return repo.findBynombreCompletoContaining(criterio);
    }
    
    public List<Paciente> listaPacientes (){
        return repo.findAll();
    }
    
    
}
