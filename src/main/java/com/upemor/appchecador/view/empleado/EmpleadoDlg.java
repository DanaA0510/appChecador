/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view.empleado;

import com.upemor.appchecador.persistence.entity.Empleado;
import com.upemor.appchecador.utils.Utils;
import com.upemor.appchecador.view.utils.TemplateDlg;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author dbeni
 */
public class EmpleadoDlg extends TemplateDlg<Empleado>{

    public EmpleadoDlg() {
        init();
    }
    
    
    
    private void init(){
        searchField.setPlaceholder("Proporciona el nombre del usuario");
        
        grid.addColumn(Empleado::getId).setCaption("Id");
        grid.addColumn(Empleado::getNombre).setCaption("Nombre(s)");
        grid.addColumn(Empleado::getApellidos).setCaption("Apellido(s)");
        grid.addColumn(Empleado::getEmail).setCaption("Email(s)");
       
        setCaption("Empleados");
        updateDlg();
    }
    
    @Override
    protected void buttonSearchEvent(){
        try{
            List<Empleado> list = ui.getControllerEmpleado().getRepository().getByNombreLikeOrApellidosLikeOrderByApellidosAscNombreAsc("%"+searchField.getValue()+"%","%"+searchField.getValue()+"%");
            grid.setItems(list);
            grid.recalculateColumnWidths();
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
        }
    }

    @Override
    protected void buttonAddEvent(){
        ui.addWindow(new EmpleadoWinDlg());
    }

    @Override
    protected void eventEditButtonGrid(Empleado obj){
        ui.addWindow(new EmpleadoWinDlg(obj.getId()));
    }

    @Override
    protected void eventDeleteButtonGrid(Empleado obj) {
        ui.getControllerEmpleado().getRepository().delete(obj);
    }
   
    
}
