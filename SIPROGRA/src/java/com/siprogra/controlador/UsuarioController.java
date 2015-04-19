/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siprogra.controlador;

import com.siprogra.services.LoginWS_Service;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author elkin
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/webServicesGesProGra/loginWS.wsdl")
    private LoginWS_Service service;

    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }
    
    public void inicioSesion() {
        
    }
    
    public void cerrarSesion() {
        
    }

    private boolean iniciarSesion(java.lang.String usuario, java.lang.String password) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.siprogra.services.LoginWS port = service.getLoginWSPort();
        return port.iniciarSesion(usuario, password);
    }
    
}
