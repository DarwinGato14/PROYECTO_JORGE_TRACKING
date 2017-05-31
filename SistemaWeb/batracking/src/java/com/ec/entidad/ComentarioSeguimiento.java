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
@Table(name = "comentario_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComentarioSeguimiento.findAll", query = "SELECT c FROM ComentarioSeguimiento c"),
    @NamedQuery(name = "ComentarioSeguimiento.findByIdObservacionSeg", query = "SELECT c FROM ComentarioSeguimiento c WHERE c.idObservacionSeg = :idObservacionSeg"),
    @NamedQuery(name = "ComentarioSeguimiento.findByOsegDescripcion", query = "SELECT c FROM ComentarioSeguimiento c WHERE c.osegDescripcion = :osegDescripcion")})
public class ComentarioSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_observacion_seg")
    private Integer idObservacionSeg;
    @Size(max = 150)
    @Column(name = "oseg_descripcion")
    private String osegDescripcion;
    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id_seguimiento")
    @ManyToOne
    private Seguimiento idSeguimiento;

    public ComentarioSeguimiento() {
    }

    public ComentarioSeguimiento(Integer idObservacionSeg) {
        this.idObservacionSeg = idObservacionSeg;
    }

    public Integer getIdObservacionSeg() {
        return idObservacionSeg;
    }

    public void setIdObservacionSeg(Integer idObservacionSeg) {
        this.idObservacionSeg = idObservacionSeg;
    }

    public String getOsegDescripcion() {
        return osegDescripcion;
    }

    public void setOsegDescripcion(String osegDescripcion) {
        this.osegDescripcion = osegDescripcion;
    }

    public Seguimiento getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Seguimiento idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObservacionSeg != null ? idObservacionSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioSeguimiento)) {
            return false;
        }
        ComentarioSeguimiento other = (ComentarioSeguimiento) object;
        if ((this.idObservacionSeg == null && other.idObservacionSeg != null) || (this.idObservacionSeg != null && !this.idObservacionSeg.equals(other.idObservacionSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.ComentarioSeguimiento[ idObservacionSeg=" + idObservacionSeg + " ]";
    }
    
}
