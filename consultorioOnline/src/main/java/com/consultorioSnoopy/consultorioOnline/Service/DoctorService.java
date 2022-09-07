/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.Service;

import com.consultorioSnoopy.consultorioOnline.entidades.Doctor;
import com.consultorioSnoopy.consultorioOnline.reposiorios.IDoctoresRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yonathanp
 */
@Service
public class DoctorService {

    @Autowired
    private IDoctoresRepo repo;

    public Doctor crearEditarDoctor(Doctor d) {
        return repo.save(d);
    }

    public Doctor consultaDoctorId(int n) {
        return repo.findById(n).get();
    }

    public Doctor consultaDoctorIdentificacion(int n) {
        return repo.findByNumeroDocumentoIs(n);
    }

    public boolean deshabilitarDoctor(Doctor d) {
        d.setHabilitado(false);
        return crearEditarDoctor(d).isHabilitado();
    }

    public boolean habilitarDoctor(Doctor d) {
        d.setHabilitado(true);
        return crearEditarDoctor(d).isHabilitado();
    }

    public List<Doctor> listaDoctoresNombre(String criterio) {
        return repo.findByNombreCompletoContaining(criterio);
    }

    public List<Doctor> listaDoctores() {
        return repo.findAll();
    }

}
