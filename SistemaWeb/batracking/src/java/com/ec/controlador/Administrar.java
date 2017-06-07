/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Producto;
import com.ec.servicio.ServicioProducto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author gato
 */
public class Administrar {

//servicios 
    ServicioProducto servicioProducto = new ServicioProducto();
    //crear un factura nueva
    private Producto productoDAO = new Producto();
    private ListModelList<Producto> listaProductosModel;
    private List<Producto> listaProductosDAODatos = new ArrayList<Producto>();
    private Set<Producto> registrosSeleccionados = new HashSet<Producto>();

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) throws Exception {
        Selectors.wireComponents(view, this, false);

    }

    public Administrar() {
        cargarInformacionProductos();
        getProductos();
    }

    private void getProductos() {
        setListaProductosModel(new ListModelList<Producto>(getListaProductosDAODatos()));
        ((ListModelList<Producto>) listaProductosModel).setMultiple(true);
    }

    @Command
    @NotifyChange("listaProductosModel")
    public void seleccionarRegistros() {

        registrosSeleccionados = ((ListModelList<Producto>) getListaProductosModel()).getSelection();

    }

    private void cargarInformacionProductos() {
        listaProductosDAODatos = servicioProducto.findAll();
    }

    @Command
    @NotifyChange({"listaRutas"})
    public void doRutas() {
        Executions.sendRedirect("/administrar/rutas.zul");
    }

    public Producto getProductoDAO() {
        return productoDAO;
    }

    public void setProductoDAO(Producto productoDAO) {
        this.productoDAO = productoDAO;
    }

    public ListModelList<Producto> getListaProductosModel() {
        return listaProductosModel;
    }

    public void setListaProductosModel(ListModelList<Producto> listaProductosModel) {
        this.listaProductosModel = listaProductosModel;
    }

    public List<Producto> getListaProductosDAODatos() {
        return listaProductosDAODatos;
    }

    public void setListaProductosDAODatos(List<Producto> listaProductosDAODatos) {
        this.listaProductosDAODatos = listaProductosDAODatos;
    }

    public Set<Producto> getRegistrosSeleccionados() {
        return registrosSeleccionados;
    }

    public void setRegistrosSeleccionados(Set<Producto> registrosSeleccionados) {
        this.registrosSeleccionados = registrosSeleccionados;
    }
}