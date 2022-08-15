/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.persistence.repository;

import com.upemor.appchecador.persistence.entity.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dbeni
 */
public interface RepositoryEmpleado extends JpaRepository<Empleado,Long>{

    public List<Empleado> getByNombreLikeOrApellidosLikeOrderByApellidosAscNombreAsc(String name, String lastname);
    
}
