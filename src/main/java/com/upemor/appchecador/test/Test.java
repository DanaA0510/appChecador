/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.test;

import com.upemor.appchecador.controller.ControllerChecador;
import com.upemor.appchecador.controller.ControllerEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbeni
 */
@Component
public class Test implements ApplicationRunner{
    
    @Autowired private ControllerEmpleado controllerEmpleado;
    @Autowired private ControllerChecador controllerChecador;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Empleado empleado= new Empleado();
//        empleado.setNombre("Dana Emmanuel");
//        empleado.setApellidos("Benítez Reyes");
//        empleado.setEmail("debr@mail.com");
//// System.out.println(empleado);
//        controllerEmpleado.save(empleado);
//       
////        Checador checador= new Checador();
////        checador.setEmpleado(empleado);
////        checador.setFecha(LocalDate.now());
////        checador.setHora(LocalDateTime.now().toLocalTime());
////       checador.setMotivo("Entrada");
////        checador.setKiosko(10);
////        //controllerChecador.save(checador);
////        //System.out.println("Prueba");
//        
//        Empleado empleado2= new Empleado();
//        empleado2.setNombre("Alejandra");
//        empleado2.setApellidos("Flores Arvizu");
//        empleado2.setEmail("flaa@mail.com");
//      // System.out.println(empleado);
//        controllerEmpleado.save(empleado2);        
//        Empleado empleado3= new Empleado();
//        empleado3.setNombre("Angel Maximiliano");
//        empleado3.setApellidos("Mora Gonzalez");
//        empleado3.setEmail("mgam@mail.com");
//      // System.out.println(empleado);
//       controllerEmpleado.save(empleado3);                
//        Empleado empleado4= new Empleado();
//        empleado4.setNombre("Bristol Sullivan");
//        empleado4.setApellidos("Garcia Perez");
//        empleado4.setEmail("gpbs@mail.com");
//      // System.out.println(empleado);
//        controllerEmpleado.save(empleado4);        
//        
    }
}
