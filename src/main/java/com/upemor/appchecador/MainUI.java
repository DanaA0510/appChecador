package com.upemor.appchecador;
        
import com.upemor.appchecador.controller.ControllerChecador;
import com.upemor.appchecador.controller.ControllerEmpleado;
import com.upemor.appchecador.view.ViewFactory;
import com.upemor.appchecador.view.utils.Element;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/*
* 
*@author dbeni 
*/

@SpringUI
@PreserveOnRefresh
@Viewport("width=device-width, initial-scale=1")
//@Theme("mainTheme")
public class MainUI  extends UI{
    @Getter ViewFactory viewFactory; 
    
    @Getter @Autowired ControllerEmpleado controllerEmpleado;
    @Getter @Autowired ControllerChecador controllerChecador;
    
    @Override
    protected void init(VaadinRequest request){
        this.setSizeFull();
        this.getUI().getPage().setTitle(Element.getSystemName());
        /**Aqui si la instancia actual de la ui tiene usuario logeado o una se sesión**/
        /*facilitar el acceso a la main view*/
        viewFactory = new ViewFactory();
        setContent(viewFactory.getMainView());
    }
}