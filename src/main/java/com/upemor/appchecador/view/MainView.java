/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upemor.appchecador.view;

import com.upemor.appchecador.MainUI;
import com.upemor.appchecador.view.utils.Element;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author dbeni
 */

@PreserveOnRefresh
public class MainView extends Panel{
    private MainUI ui;
    private VerticalLayout content;
    private MenuBar menuBar;
    public MainView(){
        init();
        
    }
    private void init(){
        ui = Element.getUI();
            menuBar = new MenuBar();
        
            menuBar.setWidth("100%");
            menuBar.setHtmlContentAllowed(true);
            MenuBar.MenuItem menuOp1 = menuBar.addItem("Empleados", VaadinIcons.USER_CARD, command->{setContent(ui.getViewFactory().getEmpleadoDlg());});
            MenuBar.MenuItem menuOp2 = menuBar.addItem("Checador", VaadinIcons.USER_CHECK, command->{setContent(ui.getViewFactory().getChecadorDlg());});
                    
        content = new VerticalLayout();
            Element.cfgLayoutComponent(content,true,false);
            
        
        VerticalLayout main = new VerticalLayout();
            Element.cfgLayoutComponent(main,true,true);
            main.setSizeFull();
            main.addComponent(menuBar); 
            main.addComponent(content);
            main.setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);
        this.setContent(main);
        this.setCaptionAsHtml(true);
    }
    
    public void setContent(Panel panel){
        content.removeAllComponents();
        content.addComponent(panel);
    }
     
}