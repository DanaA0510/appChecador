/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view;

import com.upemor.appchecador.view.checador.ChecadorDlg;
import com.upemor.appchecador.view.empleado.EmpleadoDlg;

/**
 *
 * @author dbeni
 */
public class ViewFactory {

    private MainView mainView;
    private EmpleadoDlg empleadoDlg;
    private ChecadorDlg checadorDlg;
    
    public MainView getMainView() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    public EmpleadoDlg getEmpleadoDlg() {
        if (empleadoDlg == null) {
            empleadoDlg = new EmpleadoDlg();
        }
        return empleadoDlg;
    }

    public ChecadorDlg getChecadorDlg() {
        if (checadorDlg == null) {
            checadorDlg = new ChecadorDlg();
        }
        return checadorDlg;
    }

    
    
    
    
}
