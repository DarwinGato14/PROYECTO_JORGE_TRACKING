/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import java.util.HashMap;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

/**
 *
 * @author gato
 */
public class MenuOpciones extends SelectorComposer<Component> {

    @Wire("#btnMenu")
    Button btnMenu;
    @Wire("#btnAdministracion")
    Button btnAdministracion;
    @Wire("#btnGenerarCod")
    Button btnGenerarCod;
    @Wire("#btnSeguimiento")
    Button btnSeguimiento;
    @Wire("#btnReportes")
    Button btnReportes;
    UserCredential credential = new UserCredential();
    private String acceso = "";

    public MenuOpciones() {
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
        credential = cre;
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

//
//        if (credential.getUsuarioSistema().getUsuNivelAcceso() == 1) {
//
//
//            btnAdministrar.setVisible(Boolean.TRUE);
//
//            btnCotizar.setVisible(Boolean.TRUE);
//
//            btnCompaginado.setVisible(Boolean.TRUE);
//
//            btnGiganto.setVisible(Boolean.TRUE);
//
//            btnDigital.setVisible(Boolean.TRUE);
//
//            btnUsuarios.setVisible(Boolean.TRUE);
//
//        } else {
//            btnAdministrar.setVisible(Boolean.FALSE);
//
//            btnCotizar.setVisible(Boolean.FALSE);
//
//            btnCompaginado.setVisible(Boolean.FALSE);
//
//            btnGiganto.setVisible(Boolean.FALSE);
//
//            btnDigital.setVisible(Boolean.FALSE);
//
//            btnUsuarios.setVisible(Boolean.FALSE);
//        }
    }

    @Listen("onClick = #btnMenu")
    public void doFacturar() {
        Executions.sendRedirect("/administrar/menu.zul");
    }

    @Listen("onClick = #btnAdministracion")
    public void btnSinFactura() {
        Executions.sendRedirect("/administrar/administracion.zul");
    }

    @Listen("onClick = #btnGenerarCod")
    public void doAdministrarVenta() {
        Executions.sendRedirect("/administrar/generarcodigos.zul");
    }

    @Listen("onClick = #btnSeguimiento")
    public void doConsultas() {
        Executions.sendRedirect("/administrar/seguimiento.zul");
    }

    @Listen("onClick = #btnReportes")
    public void doReportes() {
        Executions.sendRedirect("/administrar/reportes.zul");
    }


    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }
}
