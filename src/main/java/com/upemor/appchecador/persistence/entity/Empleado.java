
package com.upemor.appchecador.persistence.entity;

/**
 *
 * @author dbeni
 */


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="empleado")
public class Empleado implements Serializable{
    /** **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellidos;
    @Column(nullable=false)
    private String email;
    @OneToMany(mappedBy="empleado")
    List<Checador> checadorList;
    
    @Override
    public String toString(){
        return id+"/"+apellidos;
         }
}
