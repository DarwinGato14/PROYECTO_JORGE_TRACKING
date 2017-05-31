/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "pallet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pallet.findAll", query = "SELECT p FROM Pallet p"),
    @NamedQuery(name = "Pallet.findByIdPallet", query = "SELECT p FROM Pallet p WHERE p.idPallet = :idPallet"),
    @NamedQuery(name = "Pallet.findByPallCodigo", query = "SELECT p FROM Pallet p WHERE p.pallCodigo = :pallCodigo"),
    @NamedQuery(name = "Pallet.findByPallDescripcion", query = "SELECT p FROM Pallet p WHERE p.pallDescripcion = :pallDescripcion")})
public class Pallet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pallet")
    private Integer idPallet;
    @Size(max = 100)
    @Column(name = "pall_codigo")
    private String pallCodigo;
    @Size(max = 150)
    @Column(name = "pall_descripcion")
    private String pallDescripcion;
    @OneToMany(mappedBy = "idPallet")
    private Collection<FotografiaPallet> fotografiaPalletCollection;
    @OneToMany(mappedBy = "idPallet")
    private Collection<Producto> productoCollection;

    public Pallet() {
    }

    public Pallet(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public Integer getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public String getPallCodigo() {
        return pallCodigo;
    }

    public void setPallCodigo(String pallCodigo) {
        this.pallCodigo = pallCodigo;
    }

    public String getPallDescripcion() {
        return pallDescripcion;
    }

    public void setPallDescripcion(String pallDescripcion) {
        this.pallDescripcion = pallDescripcion;
    }

    @XmlTransient
    public Collection<FotografiaPallet> getFotografiaPalletCollection() {
        return fotografiaPalletCollection;
    }

    public void setFotografiaPalletCollection(Collection<FotografiaPallet> fotografiaPalletCollection) {
        this.fotografiaPalletCollection = fotografiaPalletCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPallet != null ? idPallet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pallet)) {
            return false;
        }
        Pallet other = (Pallet) object;
        if ((this.idPallet == null && other.idPallet != null) || (this.idPallet != null && !this.idPallet.equals(other.idPallet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Pallet[ idPallet=" + idPallet + " ]";
    }
    
}
