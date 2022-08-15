/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.controller;


import com.upemor.appchecador.persistence.entity.Checador;
import com.upemor.appchecador.persistence.repository.RepositoryChecador;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbeni
 */
/**
 *Clase controladora  entidad= Checador
 *Atributos:
 *  repositorio checador
 * 
 * Métodos:
 *  validate()-> boleean  valida entrada de datos de la entidad
 *  
 *  save()-> Usuario valida si se guarda o edita la entidad en la base de datos
 * 
 **/
@Component
public class ControllerChecador {
    @Autowired @Getter private RepositoryChecador repository;
    
    private boolean validate(Checador obj) throws Exception{
        if(obj.getFecha().toString().isEmpty()){ throw new Exception("La fecha proporcionada no es válida");}
        if(obj.getKiosko()<0){ throw new Exception("Es necesario proporcionar un numero de Kiosko");}
        if(obj.getMotivo().isEmpty()){ throw new Exception("El motivo proporcionado no es válido");}  
        if(obj.getEmpleado().toString().isEmpty()){ throw new Exception("El empleado no es valido proporcionado no es válido");}
        return true;
    }
    
    public Checador save(Checador obj) throws Exception{
        try{
            if(validate(obj)){
                if(obj.getId()==0){
                    return repository.save(obj);
                }
                Checador check= repository.findById(obj.getId()).orElse(null);
                    check.setEmpleado(obj.getEmpleado());
                    check.setFecha(obj.getFecha());
                    check.setMotivo(obj.getMotivo());
                    check.setKiosko(obj.getKiosko());
                    
                    return repository.save(check);
                   
            }
            return null;
        }catch(Exception ex){ 
            throw ex;
        }
    }
   
}
