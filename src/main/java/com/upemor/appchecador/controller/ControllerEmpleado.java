/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.controller;

import com.upemor.appchecador.persistence.entity.Checador;
import com.upemor.appchecador.persistence.entity.Empleado;
import com.upemor.appchecador.persistence.repository.RepositoryChecador;
import com.upemor.appchecador.persistence.repository.RepositoryEmpleado;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbeni
 */
@Component
public class ControllerEmpleado {
    
    @Autowired @Getter RepositoryEmpleado repository;
    
    private boolean validate(Empleado obj) throws Exception{
        if(obj.getNombre().isEmpty()){ throw new Exception("El nombre proporcionado no es válido");}
        if(obj.getEmail().isEmpty()){ throw new Exception("Es necesario proporcionar un email");}
        if(obj.getApellidos().isEmpty()){ throw new Exception("El apellido proporcionado no es válido");}
        return true;
    }
    
    public Empleado save(Empleado obj) throws Exception{
        try{
            if(validate(obj)){
                if(obj.getId()==0){
                    return repository.save(obj);
                }
                Empleado emp= repository.findById(obj.getId()).orElse(null);
                    emp.setNombre(obj.getNombre());
                    emp.setEmail(obj.getEmail());
                    emp.setApellidos(obj.getApellidos());
                    return repository.save(emp);
            }
            return null;
        }catch(Exception ex){ 
            throw ex;
        }
    }  
}
