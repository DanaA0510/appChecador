/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view.empleado;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.jarektoro.responsivelayout.ResponsiveRow;
import com.upemor.appchecador.persistence.entity.Empleado;
import com.upemor.appchecador.utils.Utils;
import com.upemor.appchecador.view.utils.Element;
import com.upemor.appchecador.view.utils.TemplateModalWin;
import com.vaadin.shared.Position;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import java.util.logging.Logger;
/**
 *
 * @author dbeni
 */
public class EmpleadoWinDlg extends TemplateModalWin<Long> {

    private TextField name;
    private TextField lastName;
    private TextField email;
    

    public EmpleadoWinDlg() {
        id = 0l;
        init();
        setCaption("Nuevo Empleado");
    }

    public EmpleadoWinDlg(Long id) {
        init();
        loadData(id);
        setCaption("Editar Empleado");
    }

    private void init() {

        name = new TextField("Nombre");
        Element.cfgComponent(name);
        lastName = new TextField("Apellidos");
        Element.cfgComponent(lastName);
        email = new TextField("Email");
        Element.cfgComponent(email);
        
        ResponsiveLayout content = new ResponsiveLayout();
        Element.cfgLayoutComponent(content);
        ResponsiveRow row1 = content.addRow().withAlignment(Alignment.TOP_CENTER);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(name);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(lastName);
        row1.addColumn().withDisplayRules(12, 12, 12, 12).withComponent(email);
        contentLayout.addComponent(content);

        setWidth("50%");
    }

    @Override
    protected void loadData(Long id) {
        try {
            Empleado obj = ui.getControllerEmpleado().getRepository().findById(id).orElse(null);
            this.id = obj.getId();
            name.setValue(obj.getNombre());
            lastName.setValue(obj.getApellidos());
            email.setValue(obj.getEmail());

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(), ex.toString());
            Element.makeNotification("Error: " + ex.getMessage(), Notification.Type.WARNING_MESSAGE, Position.TOP_CENTER).show(ui.getPage());
        }
    }

    @Override
    protected void buttonAcceptEvent() {
        try {
            if (Utils.verifyEmailPattern(email.getValue())) {
                Empleado obj = new Empleado();
                obj.setId(id);
                obj.setNombre(name.getValue());
                obj.setApellidos(lastName.getValue());
                obj.setEmail(email.getValue());
               
                obj = ui.getControllerEmpleado().save(obj);
                if (obj != null) {
                    Element.makeNotification("Datos guardados correctamemnte", Notification.Type.HUMANIZED_MESSAGE, Position.TOP_CENTER).show(ui.getPage());
                    close();
                }
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