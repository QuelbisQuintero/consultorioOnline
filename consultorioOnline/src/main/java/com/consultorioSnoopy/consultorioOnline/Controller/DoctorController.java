/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Controller;

import com.consultorioSnoopy.consultorioOnline.Service.DoctorService;
import com.consultorioSnoopy.consultorioOnline.entidades.Doctor;
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
 * doctores           /doctores
 * doctor             /doctor
 * doctorForm         /doctor/form
 * doctorFormId       /doctor/form/{id}
 * doctorDes          /doctor/des/{id}
 * 
 */

@Controller
public class DoctorController {
        @Autowired
        private DoctorService dService;
        
        @GetMapping ("/doctores")  // 
        public String listaDoctores(Model model, @RequestParam(value="fnombre", required=false) String criterio){
            if(criterio==null){
                model.addAttribute("doctores", dService.listaDoctores());
            }else{
                model.addAttribute("doctores", dService.listaDoctoresNombre(criterio));
                model.addAttribute("fnombre", criterio);
            }
            return "doctores";
        }
        
        @GetMapping("/doctor")
        public String doctor(Model model, @PathVariable int id){
            model.addAttribute("doctor", dService.consultaDoctorId(id) );
            return "pasiente";
        }
        
        @GetMapping("/doctor/form")
        public String formNewDoctor(Model model){
            model.addAttribute("doctor", new Doctor() );
            return "doctorForm";
        }
        
        @GetMapping("/doctor/form/{id}")
        public String formNewdoctor(Model model, @PathVariable int id){
            model.addAttribute("doctor", dService.consultaDoctorId(id) );
            return "doctorForm";
        }   
        
        @PostMapping("/doctores")
        public String guardarPaciente(@ModelAttribute Doctor d){
            dService.crearEditarDoctor(d);
            return "redirect:/doctores";
        }
        
        @GetMapping("/doctor/des/{id}")
        public String deshabilitarPaciente(@PathVariable int id){
            Doctor d = dService.consultaDoctorId(id);
            if (d.isHabilitado()){
                dService.deshabilitarDoctor(d);
            }else{
                dService.habilitarDoctor(d);
            }
            return "redirect:/doctores";
        }

}
