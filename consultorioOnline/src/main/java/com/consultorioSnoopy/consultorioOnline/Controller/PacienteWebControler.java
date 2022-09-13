/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Controller;

import com.consultorioSnoopy.consultorioOnline.Service.PacienteService;
import com.consultorioSnoopy.consultorioOnline.entidades.Paciente;
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
public class PacienteWebControler {
    
    @Autowired
    private PacienteService pServisce;
    
    
    @GetMapping("api/pacientes")
    public ResponseEntity<List<Paciente>> consultaPacientes(){
        List<Paciente> pasientes= pServisce.listaPacientes();
        return new ResponseEntity<> (pasientes, HttpStatus.OK);
    }
    
    @GetMapping("api/paciente")
    public ResponseEntity<Paciente> PacienteById(){
        Paciente paciente= pServisce.consultaPacienteId(47);
        return new ResponseEntity<> (paciente, HttpStatus.OK);
    }
    
}
