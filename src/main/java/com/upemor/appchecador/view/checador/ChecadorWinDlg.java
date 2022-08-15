/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view.checador;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.jarektoro.responsivelayout.ResponsiveRow;
import com.upemor.appchecador.persistence.entity.Checador;
import com.upemor.appchecador.persistence.entity.Empleado;
import com.upemor.appchecador.utils.Utils;
import com.upemor.appchecador.view.utils.Element;
import com.upemor.appchecador.view.utils.TemplateModalWin;
import com.vaadin.shared.Position;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author dbeni
 */
public class ChecadorWinDlg extends TemplateModalWin<Long> {

    private ComboBox<Empleado> idEmpleado;
    private DateField fecha;
    private TextField hora;
    private ComboBox<Integer> kiosko;
    private ComboBox<String> motivo;

    public ChecadorWinDlg() {
        id = 0l;
        init();
        setCaption("Nuevo Checador");
    }

    public ChecadorWinDlg(Long id) {
        init();
        loadData(id);
        setCaption("Editar Checador");
    }

    private void init() {

        idEmpleado = new ComboBox<>("Ingresa Id empleado");
        idEmpleado.setItems(ui.getControllerEmpleado().getRepository().findAll());
        Element.cfgComponent(idEmpleado);

        fecha = new DateField("Fecha");
        fecha.setDateFormat("yyyy-MM-dd");
        fecha.setPlaceholder("yyyy-mm-dd");
        fecha.setValue(LocalDate.now());
        Element.cfgComponent(fecha);

        hora = new TextField("Hora");
        hora.setValue(LocalTime.now().toString());
        Element.cfgComponent(hora);

        kiosko = new ComboBox<>("Kiosko");
        List<Integer> num = Arrays.asList(3, 1, 4);
        kiosko.setItems(num);
        Element.cfgComponent(kiosko);
        
        motivo = new ComboBox<>("Motivo");
        List<String> mots = Arrays.asList("Entrada", "Salida");
        motivo.setItems(mots);
        Element.cfgComponent(motivo);
        

        ResponsiveLayout content = new ResponsiveLayout();
        Element.cfgLayoutComponent(content);
        ResponsiveRow row1 = content.addRow().withAlignment(Alignment.TOP_CENTER);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(idEmpleado);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(fecha);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(hora);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(kiosko);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(motivo);
        contentLayout.addComponent(content);

        setWidth("50%");
    }

    @Override
    protected void loadData(Long id) {
        try {
            Checador obj = ui.getControllerChecador().getRepository().findById(id).orElse(null);
            this.id = obj.getId();
            idEmpleado.setValue(obj.getEmpleado());
            fecha.setValue(obj.getFecha());
            hora.setValue(obj.getHora());
            kiosko.setValue(obj.getKiosko());
            
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(), ex.toString());
            Element.makeNotification("Error: " + ex.getMessage(), Notification.Type.WARNING_MESSAGE, Position.TOP_CENTER).show(ui.getPage());
        }
    }

    @Override
    protected void buttonAcceptEvent() {
        try {
            
                Checador obj = new Checador();
                obj.setId(id);
               
                obj.setEmpleado(idEmpleado.getValue());
                obj.setFecha(LocalDate.now());
                
                obj.setKiosko(kiosko.getValue());
                obj.setMotivo(motivo.getValue());
                
                obj.setHora(hora.getValue());
                
                obj = ui.getControllerChecador().save(obj);
                if (obj != null) {
                    Element.makeNotification("Datos guardados correctamemnte", Notification.Type.HUMANIZED_MESSAGE, Position.TOP_CENTER).show(ui.getPage());
                    close();
                }
           
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(), ex.toString());
            Element.makeNotification("Error: " + ex.getMessage(), Notification.Type.WARNING_MESSAGE, Position.TOP_CENTER).show(ui.getPage());
        }
    }

    @Override
    protected void buttonCancelEvent() {
        close();
    }

    @Override
    protected void buttonDeleteEvent() {
    }
}
