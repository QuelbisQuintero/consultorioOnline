/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Controller;

import com.consultorioSnoopy.consultorioOnline.Service.DoctorService;
import com.consultorioSnoopy.consultorioOnline.entidades.Doctor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yonathanp
 */


@RestController
public class DoctorWebController {
    
    @Autowired
    private DoctorService dService;
    
    
    @GetMapping("api/doctores")
    public ResponseEntity<List<Doctor>> consultaDoctores(){
        List<Doctor> doctores= dService.listaDoctores();
        return new ResponseEntity<> (doctores, HttpStatus.OK);
    }
    
    @GetMapping("api/doctor")
    public ResponseEntity<Doctor> PacienteById(){
        Doctor paciente= dService.consultaDoctorId(0);
        return new ResponseEntity<> (paciente, HttpStatus.OK);
    }
    
}
