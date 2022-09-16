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
public class PacienteController {
    
    
    @Autowired
    private PacienteService pService;
    
    
    @GetMapping("/")
    public String cargarIndex(){
        return "index";
    }
    
    @GetMapping("/pacientes")
    public String listaPacientes(Model model, @RequestParam(value="criterio", required=false) String criterio ){
        if (criterio==null){
            model.addAttribute("pacientes", pService.listaPacientes());          
        }else{
            model.addAttribute("pacientes", pService.listaPacientesNombre(criterio)); 
            model.addAttribute("creiterio", criterio);
        }
        return "pacientes";
    }
        
    @GetMapping("/paciente")
    public String Paciente(Model model, @RequestParam(value="id", required=true) int id){
        model.addAttribute("paciente", pService.consultaPacienteId(id));
        return "paciente";
    }
    
    @GetMapping("/paciente/form")
    public String formNewPaciente(Model model){
        model.addAttribute("paciente", new Paciente() );
        return "pacienteForm";
    }
    
    @GetMapping("/paciente/form/{id}")
    public String formNewPaciente(Model model, @PathVariable int id){
        model.addAttribute("paciente", pService.consultaPacienteId(id) );
        return "pacienteForm";
    }
    
    @PostMapping("/pacientes")
    public String guardarPaciente(@ModelAttribute Paciente p){
        pService.crearEditarPaciente(p);
        return "redirect:/pasientes";
    }
    
    @GetMapping("/paciente/des/{id}")
    public String deshabilitarPaciente(@PathVariable int id){
        Paciente p = pService.consultaPacienteId(id);
        if (p.isHabilitado()){
            pService.deshabilitarPaciente(p);
        }else{
            pService.habilitarPaciente(p);
        }
        return "redirect:/pasientes";
    }
    
}
