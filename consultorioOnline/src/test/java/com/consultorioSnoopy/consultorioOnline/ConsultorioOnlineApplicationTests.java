package com.consultorioSnoopy.consultorioOnline;

import com.consultorioSnoopy.consultorioOnline.Service.PacienteService;
import com.consultorioSnoopy.consultorioOnline.entidades.Paciente;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsultorioOnlineApplicationTests {
    
        @Autowired
        private PacienteService ps; 
        
	//@Test
	void verificarguardado() {
            Paciente p= new Paciente("Pepe pinta", "c.c.", 12, "clave");
            Assertions.assertTrue(ps.crearEditarPaciente(p).getId()>0, "Error al guardar en la BD");
	}
        //@Test
        void verificarbuscarNumeroIdentificacionHabilitar(){
            Paciente p = ps.consultaPacientesIdentificacion(56789);
            Assertions.assertTrue(ps.habilitarPaciente(p),"No se logro habilitar"); 
        }
        //@Test
        void verificardeshabilitar(){
            Paciente p = ps.consultaPacientesIdentificacion(1234);
            Assertions.assertTrue(!ps.deshabilitarPaciente(p),"No se logro deshabilitar");            
        }
        //@Test
        void verificarmodificar(){
            Paciente p = ps.consultaPacientesIdentificacion(1234);
            p.setClave("cocoliso");      
            p.setNumeroDocumento(99);
            System.out.println(p);
            System.out.println(ps.crearEditarPaciente(p));
        }
        //@Test
        void verificarListaPacientes(){
            System.out.println(ps.listaPacientes());
        }
        
        //@Test
        void verificarListaPacientesNombre(){
            System.out.println(ps.listaPacientesNombre("pepe"));
        }
        

}
