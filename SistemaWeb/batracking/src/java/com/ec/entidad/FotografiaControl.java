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
@Table(name = "fotografia_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotografiaControl.findAll", query = "SELECT f FROM FotografiaControl f"),
    @NamedQuery(name = "FotografiaControl.findByIdFotoControl", query = "SELECT f FROM FotografiaControl f WHERE f.idFotoControl = :idFotoControl"),
    @NamedQuery(name = "FotografiaControl.findByFcontNombre", query = "SELECT f FROM FotografiaControl f WHERE f.fcontNombre = :fcontNombre"),
    @NamedQuery(name = "FotografiaControl.findByFcontPath", query = "SELECT f FROM FotografiaControl f WHERE f.fcontPath = :fcontPath")})
public class FotografiaControl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foto_control")
    private Integer idFotoControl;
    @Size(max = 50)
    @Column(name = "fcont_nombre")
    private String fcontNombre;
    @Size(max = 150)
    @Column(name = "fcont_path")
    private String fcontPath;
    @Lob
    @Column(name = "fcont_real")
    private byte[] fcontReal;
    @JoinColumn(name = "id_control", referencedColumnName = "id_control")
    @ManyToOne
    private PuntosControl idControl;

    public FotografiaControl() {
    }

    public FotografiaControl(Integer idFotoControl) {
        this.idFotoControl = idFotoControl;
    }

    public Integer getIdFotoControl() {
        return idFotoControl;
    }

    public void setIdFotoControl(Integer idFotoControl) {
        this.idFotoControl = idFotoControl;
    }

    public String getFcontNombre() {
        return fcontNombre;
    }

    public void setFcontNombre(String fcontNombre) {
        this.fcontNombre = fcontNombre;
    }

    public String getFcontPath() {
        return fcontPath;
    }

    public void setFcontPath(String fcontPath) {
        this.fcontPath = fcontPath;
    }

    public byte[] getFcontReal() {
        return fcontReal;
    }

    public void setFcontReal(byte[] fcontReal) {
        this.fcontReal = fcontReal;
    }

    public PuntosControl getIdControl() {
        return idControl;
    }

    public void setIdControl(PuntosControl idControl) {
        this.idControl = idControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotoControl != null ? idFotoControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotografiaControl)) {
            return false;
        }
        FotografiaControl other = (FotografiaControl) object;
        if ((this.idFotoControl == null && other.idFotoControl != null) || (this.idFotoControl != null && !this.idFotoControl.equals(other.idFotoControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.FotografiaControl[ idFotoControl=" + idFotoControl + " ]";
    }
    
}
