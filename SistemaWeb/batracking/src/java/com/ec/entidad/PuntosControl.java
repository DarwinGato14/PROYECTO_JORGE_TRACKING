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
@Table(name = "puntos_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntosControl.findAll", query = "SELECT p FROM PuntosControl p"),
    @NamedQuery(name = "PuntosControl.findByIdControl", query = "SELECT p FROM PuntosControl p WHERE p.idControl = :idControl"),
    @NamedQuery(name = "PuntosControl.findByConLugar", query = "SELECT p FROM PuntosControl p WHERE p.conLugar = :conLugar"),
    @NamedQuery(name = "PuntosControl.findByConLongitud", query = "SELECT p FROM PuntosControl p WHERE p.conLongitud = :conLongitud"),
    @NamedQuery(name = "PuntosControl.findByConLatitud", query = "SELECT p FROM PuntosControl p WHERE p.conLatitud = :conLatitud"),
    @NamedQuery(name = "PuntosControl.findByConDescripcion", query = "SELECT p FROM PuntosControl p WHERE p.conDescripcion = :conDescripcion")})
public class PuntosControl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_control")
    private Integer idControl;
    @Size(max = 100)
    @Column(name = "con_lugar")
    private String conLugar;
    @Size(max = 100)
    @Column(name = "con_longitud")
    private String conLongitud;
    @Size(max = 100)
    @Column(name = "con_latitud")
    private String conLatitud;
    @Size(max = 100)
    @Column(name = "con_descripcion")
    private String conDescripcion;
    @OneToMany(mappedBy = "idControl")
    private Collection<FotografiaControl> fotografiaControlCollection;
    @OneToMany(mappedBy = "idControl")
    private Collection<Seguimiento> seguimientoCollection;

    public PuntosControl() {
    }

    public PuntosControl(Integer idControl) {
        this.idControl = idControl;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
    }

    public String getConLugar() {
        return conLugar;
    }

    public void setConLugar(String conLugar) {
        this.conLugar = conLugar;
    }

    public String getConLongitud() {
        return conLongitud;
    }

    public void setConLongitud(String conLongitud) {
        this.conLongitud = conLongitud;
    }

    public String getConLatitud() {
        return conLatitud;
    }

    public void setConLatitud(String conLatitud) {
        this.conLatitud = conLatitud;
    }

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    @XmlTransient
    public Collection<FotografiaControl> getFotografiaControlCollection() {
        return fotografiaControlCollection;
    }

    public void setFotografiaControlCollection(Collection<FotografiaControl> fotografiaControlCollection) {
        this.fotografiaControlCollection = fotografiaControlCollection;
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
        hash += (idControl != null ? idControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntosControl)) {
            return false;
        }
        PuntosControl other = (PuntosControl) object;
        if ((this.idControl == null && other.idControl != null) || (this.idControl != null && !this.idControl.equals(other.idControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.PuntosControl[ idControl=" + idControl + " ]";
    }
    
}
