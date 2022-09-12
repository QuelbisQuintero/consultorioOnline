/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Controller;

import com.consultorioSnoopy.consultorioOnline.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author yonathanp
 * 
 * index.html           /
 * listaPacientes       /pacientes
 * PacienteById         /pacientes/id
 * 
 * 
 */


@Controller
public class PacienteControler {
    
    
    @Autowired
    private PacienteService pServisce;
    
    
    @GetMapping("/")
    public String cargarIndex(){
        return "index";
    }
    
    @GetMapping("/pacientes")
    public String listaPacientes(Model model, @RequestParam(value="criterio", required=false) String criterio ){
        if (criterio==null){
            model.addAttribute("pacientes", pServisce.listaPacientes());          
        }else{
            model.addAttribute("pacientes", pServisce.listaPacientesNombre(criterio)); 
            model.addAttribute("creiterio", criterio);
        }
        return "pacientes";
    }
    
    
    @GetMapping("/pacientes/id")
    public String PacienteById(Model model, @RequestParam(value="id", required=true) int id){
        model.addAttribute("paciente", pServisce.consultaPacienteId(id));
        return "PacienteById";
    }
    
}
