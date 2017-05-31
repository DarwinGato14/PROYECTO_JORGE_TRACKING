/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.rest;

import com.ec.entidad.Pallet;
import com.ec.servicio.ServicioPallet;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Darwin Morocho
 */
@Path(value = "Parada")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class RestPallet {

    ServicioPallet servicioPallet = new ServicioPallet();

    @POST
    // http://localhost:8080/ProjectWeb/api/Clientes
    public String registrarParada(@FormParam("event_id") String valor1,
            @FormParam("imei") String valor2) {
        Pallet pallet = new Pallet();
        //la logica de insertar
        boolean validar = false;
        //System.out.println("Ingresa al servicio");

        try {
            // cargarRutas();
        } catch (Exception e) {
            System.out.println("ocurrio un error " + e.getMessage());
        }


        if (servicioPallet.crear(pallet)) {
            return "true";
        } else {
            return "false";
        }

    }
}
