/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view.checador;

import com.upemor.appchecador.persistence.entity.Checador;
import com.upemor.appchecador.utils.Utils;
import com.upemor.appchecador.view.utils.TemplateDlg;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author dbeni
 */
public class ChecadorDlg extends TemplateDlg<Checador>{

    public ChecadorDlg() {
        init();
    }
    
    private void init(){
        searchField.setPlaceholder("Proporciona el nombre del usuario");
        
        grid.addColumn(Checador::getId).setCaption("Id");
        grid.addColumn(Checador::getEmpleado).setCaption("Empleado");
        grid.addColumn(Checador::getFecha).setCaption("Fecha");
        grid.addColumn(Checador::getHora).setCaption("Hora");
        grid.addColumn(Checador::getKiosko).setCaption("Kiosko");
        grid.addColumn(Checador::getMotivo).setCaption("Motivo");
       
        setCaption("Checador");
        updateDlg();
    }
    
    @Override
    protected void buttonSearchEvent(){
        try{
            List<Checador> list = ui.getControllerChecador().getRepository().getByMotivoLikeOrFechaLikeOrderByFechaAscHoraAsc("%"+searchField.getValue()+"%","%"+searchField.getValue()+"%");
            grid.setItems(list);
            grid.recalculateColumnWidths();
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
        }
    }

    @Override
    protected void buttonAddEvent(){
        ui.addWindow(new ChecadorWinDlg());
    }

    @Override
    protected void eventEditButtonGrid(Checador obj){
        ui.addWindow(new ChecadorWinDlg(obj.getId()));
    }

    @Override
    protected void eventDeleteButtonGrid(Checador obj) {
        ui.getControllerChecador().getRepository().delete(obj);
    }
   
}
