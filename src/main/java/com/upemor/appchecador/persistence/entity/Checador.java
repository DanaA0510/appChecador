package com.upemor.appchecador.persistence.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="checador")
public class Checador implements Serializable{
    /** **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable=false)
    private LocalDate fecha;
    
    @Column(nullable=false)
    private String hora;
    
    @Column(nullable=true)
    private String motivo;
    
    
    @Column(nullable=false)
    private int kiosko;
    
    @ManyToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;
    
    
    @Override
    public String toString(){
        return id+""+empleado.toString();
         }
}
