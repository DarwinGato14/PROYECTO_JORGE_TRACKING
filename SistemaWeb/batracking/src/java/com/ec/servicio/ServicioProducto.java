/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.servicio;

import com.ec.entidad.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioProducto {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public boolean crear(Producto producto) {
        boolean valido = false;
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            valido = true;
        } catch (Exception e) {
            System.out.println("Error al insertar producto " + e.getMessage());
            valido = false;
        } finally {
            em.close();
        }
        return valido;
    }

    public boolean eliminar(Producto producto) {
        boolean valido = false;
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.remove(em.merge(producto));
            em.getTransaction().commit();
            valido = true;
        } catch (Exception e) {
            System.out.println("Error al eliminar  producto" + e.getMessage());
            valido = false;
        } finally {
            em.close();
        }
        return valido;
    }

    public boolean modificar(Producto producto) {
        boolean valido = false;
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            valido = true;
        } catch (Exception e) {
            System.out.println("Error al insertar producto " + e.getMessage());
            valido = false;
        } finally {
            em.close();
        }
        return valido;
    }

    public List<Producto> findAll() {


        List<Producto> listaProductos = new ArrayList<Producto>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Producto.findAll", Producto.class);
            listaProductos = (List<Producto>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la consulta de productos ALL");
        } finally {
            em.close();
        }

        return listaProductos;
    }
}
