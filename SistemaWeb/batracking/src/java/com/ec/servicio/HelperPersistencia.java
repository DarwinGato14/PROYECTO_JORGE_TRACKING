/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class HelperPersistencia {

    public static EntityManager getEMF() {
        EntityManager emf = (EntityManager) Persistence.createEntityManagerFactory("batrackingPU").createEntityManager();

//        entityManager.getTransaction().begin();
//java.sql.Connection connection = entityManager.unwrap(java.sql.Connection.class);
        return emf;
    }
}
