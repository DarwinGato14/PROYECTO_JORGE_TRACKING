/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Pallet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioPallet {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public boolean crear(Pallet pallet) {
        boolean valido = false;
        try {

            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(pallet);
            em.getTransaction().commit();
            valido = true;
        } catch (Exception e) {
            System.out.println("Error al insertar pallet " + e.getMessage());
            valido = false;
        } finally {
            em.close();
        }
        return valido;
    }

    public boolean eliminar(Pallet pallet) {
        boolean valido = false;
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(pallet));
            em.getTransaction().commit();
            valido = true;
        } catch (Exception e) {
            System.out.println("Error al eliminar  pallet" + e.getMessage());
            valido = false;
        } finally {
            em.close();
        }
        return valido;
    }

    public boolean modificar(Pallet pallet) {
        boolean valido = false;
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(pallet);
            em.getTransaction().commit();
            valido = true;
        } catch (Exception e) {
            System.out.println("Error al insertar pallet " + e.getMessage());
                valido = false;
        } finally {
            em.close();
        }
        return valido;
    }

    public List<Pallet> findAll() {


        List<Pallet> listaPallets = new ArrayList<Pallet>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Pallet.findAll", Pallet.class);
            listaPallets = (List<Pallet>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la consulta de pallets ALL");
        } finally {
            em.close();
        }

        return listaPallets;
    }
}
