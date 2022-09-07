/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consultorioSnoopy.consultorioOnline.reposiorios;

import com.consultorioSnoopy.consultorioOnline.entidades.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yonathanp
 */
@Repository
public interface IPacientesRepo extends JpaRepository<Paciente, Integer>{
    public Paciente findBynumeroDocumento(int criterio);
    public List<Paciente> findBynombreCompletoContaining(String criterio);
}
