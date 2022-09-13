/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Controller;

import com.consultorioSnoopy.consultorioOnline.Service.PacienteService;
import com.consultorioSnoopy.consultorioOnline.entidades.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author yonathanp
 * 
 * index.html           /
 * pacientes            /pacientes
 * paciente             /paciente
 * pacienteForm         /paciente/form
 * pacienteFormId       /paciente/form/{id}
 * pacienteDes          /paciente/des/{id}
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
        
    @GetMapping("/paciente")
    public String Paciente(Model model, @RequestParam(value="id", required=true) int id){
        model.addAttribute("paciente", pServisce.consultaPacienteId(id));
        return "paciente";
    }
    
    @GetMapping("/paciente/form")
    public String formNewPaciente(Model model){
        model.addAttribute("paciente", new Paciente() );
        return "pacienteForm";
    }
    
    @GetMapping("/paciente/form/{id}")
    public String formNewPaciente(Model model, @PathVariable int id){
        model.addAttribute("paciente", pServisce.consultaPacienteId(id) );
        return "pacienteForm";
    }
    
    @PostMapping("/pacientes")
    public String guardarPaciente(@ModelAttribute Paciente p){
        pServisce.crearEditarPaciente(p);
        return "redirect:/pasientes";
    }
    
    @GetMapping("/paciente/des/{id}")
    public String deshabilitarPaciente(@PathVariable int id){
        Paciente p = pServisce.consultaPacienteId(id);
        if (p.isHabilitado()){
            pServisce.deshabilitarPaciente(p);
        }else{
            pServisce.habilitarPaciente(p);
        }
        return "redirect:/pasientes";
    }
    
}
