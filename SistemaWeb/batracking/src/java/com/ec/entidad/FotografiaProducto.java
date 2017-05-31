/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "fotografia_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotografiaProducto.findAll", query = "SELECT f FROM FotografiaProducto f"),
    @NamedQuery(name = "FotografiaProducto.findByIdFotoProducto", query = "SELECT f FROM FotografiaProducto f WHERE f.idFotoProducto = :idFotoProducto"),
    @NamedQuery(name = "FotografiaProducto.findByFprodNombre", query = "SELECT f FROM FotografiaProducto f WHERE f.fprodNombre = :fprodNombre"),
    @NamedQuery(name = "FotografiaProducto.findByFprodPath", query = "SELECT f FROM FotografiaProducto f WHERE f.fprodPath = :fprodPath")})
public class FotografiaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foto_producto")
    private Integer idFotoProducto;
    @Size(max = 100)
    @Column(name = "fprod_nombre")
    private String fprodNombre;
    @Size(max = 150)
    @Column(name = "fprod_path")
    private String fprodPath;
    @Lob
    @Column(name = "fprod_real")
    private byte[] fprodReal;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;

    public FotografiaProducto() {
    }

    public FotografiaProducto(Integer idFotoProducto) {
        this.idFotoProducto = idFotoProducto;
    }

    public Integer getIdFotoProducto() {
        return idFotoProducto;
    }

    public void setIdFotoProducto(Integer idFotoProducto) {
        this.idFotoProducto = idFotoProducto;
    }

    public String getFprodNombre() {
        return fprodNombre;
    }

    public void setFprodNombre(String fprodNombre) {
        this.fprodNombre = fprodNombre;
    }

    public String getFprodPath() {
        return fprodPath;
    }

    public void setFprodPath(String fprodPath) {
        this.fprodPath = fprodPath;
    }

    public byte[] getFprodReal() {
        return fprodReal;
    }

    public void setFprodReal(byte[] fprodReal) {
        this.fprodReal = fprodReal;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotoProducto != null ? idFotoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotografiaProducto)) {
            return false;
        }
        FotografiaProducto other = (FotografiaProducto) object;
        if ((this.idFotoProducto == null && other.idFotoProducto != null) || (this.idFotoProducto != null && !this.idFotoProducto.equals(other.idFotoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.FotografiaProducto[ idFotoProducto=" + idFotoProducto + " ]";
    }
    
}
