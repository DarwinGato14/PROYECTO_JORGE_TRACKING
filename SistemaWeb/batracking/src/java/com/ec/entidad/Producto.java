/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByProdCodigo", query = "SELECT p FROM Producto p WHERE p.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "Producto.findByProdEspecificaciones", query = "SELECT p FROM Producto p WHERE p.prodEspecificaciones = :prodEspecificaciones"),
    @NamedQuery(name = "Producto.findByProdEstadoBateria", query = "SELECT p FROM Producto p WHERE p.prodEstadoBateria = :prodEstadoBateria"),
    @NamedQuery(name = "Producto.findByProdFechaProduccion", query = "SELECT p FROM Producto p WHERE p.prodFechaProduccion = :prodFechaProduccion"),
    @NamedQuery(name = "Producto.findByProdFechaVenta", query = "SELECT p FROM Producto p WHERE p.prodFechaVenta = :prodFechaVenta"),
    @NamedQuery(name = "Producto.findByProdFechaMantenimiento", query = "SELECT p FROM Producto p WHERE p.prodFechaMantenimiento = :prodFechaMantenimiento"),
    @NamedQuery(name = "Producto.findByProdFechaRepone", query = "SELECT p FROM Producto p WHERE p.prodFechaRepone = :prodFechaRepone")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Size(max = 100)
    @Column(name = "prod_codigo")
    private String prodCodigo;
    @Size(max = 150)
    @Column(name = "prod_especificaciones")
    private String prodEspecificaciones;
    @Size(max = 40)
    @Column(name = "prod_estado_bateria")
    private String prodEstadoBateria;
    @Column(name = "prod_fecha_produccion")
    @Temporal(TemporalType.DATE)
    private Date prodFechaProduccion;
    @Column(name = "prod_fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date prodFechaVenta;
    @Column(name = "prod_fecha_mantenimiento")
    @Temporal(TemporalType.DATE)
    private Date prodFechaMantenimiento;
    @Column(name = "prod_fecha_repone")
    @Temporal(TemporalType.DATE)
    private Date prodFechaRepone;
    @OneToMany(mappedBy = "idProducto")
    private Collection<FotografiaProducto> fotografiaProductoCollection;
    @JoinColumn(name = "id_pallet", referencedColumnName = "id_pallet")
    @ManyToOne
    private Pallet idPallet;
    @JoinColumn(name = "id_fabricante", referencedColumnName = "id_fabricante")
    @ManyToOne
    private Fabricante idFabricante;
    @OneToMany(mappedBy = "idProducto")
    private Collection<Seguimiento> seguimientoCollection;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(String prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public String getProdEspecificaciones() {
        return prodEspecificaciones;
    }

    public void setProdEspecificaciones(String prodEspecificaciones) {
        this.prodEspecificaciones = prodEspecificaciones;
    }

    public String getProdEstadoBateria() {
        return prodEstadoBateria;
    }

    public void setProdEstadoBateria(String prodEstadoBateria) {
        this.prodEstadoBateria = prodEstadoBateria;
    }

    public Date getProdFechaProduccion() {
        return prodFechaProduccion;
    }

    public void setProdFechaProduccion(Date prodFechaProduccion) {
        this.prodFechaProduccion = prodFechaProduccion;
    }

    public Date getProdFechaVenta() {
        return prodFechaVenta;
    }

    public void setProdFechaVenta(Date prodFechaVenta) {
        this.prodFechaVenta = prodFechaVenta;
    }

    public Date getProdFechaMantenimiento() {
        return prodFechaMantenimiento;
    }

    public void setProdFechaMantenimiento(Date prodFechaMantenimiento) {
        this.prodFechaMantenimiento = prodFechaMantenimiento;
    }

    public Date getProdFechaRepone() {
        return prodFechaRepone;
    }

    public void setProdFechaRepone(Date prodFechaRepone) {
        this.prodFechaRepone = prodFechaRepone;
    }

    @XmlTransient
    public Collection<FotografiaProducto> getFotografiaProductoCollection() {
        return fotografiaProductoCollection;
    }

    public void setFotografiaProductoCollection(Collection<FotografiaProducto> fotografiaProductoCollection) {
        this.fotografiaProductoCollection = fotografiaProductoCollection;
    }

    public Pallet getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Pallet idPallet) {
        this.idPallet = idPallet;
    }

    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
    }

    @XmlTransient
    public Collection<Seguimiento> getSeguimientoCollection() {
        return seguimientoCollection;
    }

    public void setSeguimientoCollection(Collection<Seguimiento> seguimientoCollection) {
        this.seguimientoCollection = seguimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
