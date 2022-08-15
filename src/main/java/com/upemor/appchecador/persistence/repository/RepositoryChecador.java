/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.persistence.repository;

import com.upemor.appchecador.persistence.entity.Checador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dbeni
 */
@Transactional
public interface RepositoryChecador  extends JpaRepository<Checador,Long>{

    public List<Checador> getByMotivoLikeOrFechaLikeOrderByFechaAscHoraAsc(String string, String string0);
    
    
}
