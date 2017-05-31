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
@Table(name = "fotografias_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotografiasSeguimiento.findAll", query = "SELECT f FROM FotografiasSeguimiento f"),
    @NamedQuery(name = "FotografiasSeguimiento.findByIdFotografiaSeg", query = "SELECT f FROM FotografiasSeguimiento f WHERE f.idFotografiaSeg = :idFotografiaSeg"),
    @NamedQuery(name = "FotografiasSeguimiento.findByFsegNombre", query = "SELECT f FROM FotografiasSeguimiento f WHERE f.fsegNombre = :fsegNombre"),
    @NamedQuery(name = "FotografiasSeguimiento.findByFsegPath", query = "SELECT f FROM FotografiasSeguimiento f WHERE f.fsegPath = :fsegPath")})
public class FotografiasSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fotografia_seg")
    private Integer idFotografiaSeg;
    @Size(max = 50)
    @Column(name = "fseg_nombre")
    private String fsegNombre;
    @Size(max = 150)
    @Column(name = "fseg_path")
    private String fsegPath;
    @Lob
    @Column(name = "fseg_real")
    private byte[] fsegReal;
    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id_seguimiento")
    @ManyToOne
    private Seguimiento idSeguimiento;

    public FotografiasSeguimiento() {
    }

    public FotografiasSeguimiento(Integer idFotografiaSeg) {
        this.idFotografiaSeg = idFotografiaSeg;
    }

    public Integer getIdFotografiaSeg() {
        return idFotografiaSeg;
    }

    public void setIdFotografiaSeg(Integer idFotografiaSeg) {
        this.idFotografiaSeg = idFotografiaSeg;
    }

    public String getFsegNombre() {
        return fsegNombre;
    }

    public void setFsegNombre(String fsegNombre) {
        this.fsegNombre = fsegNombre;
    }

    public String getFsegPath() {
        return fsegPath;
    }

    public void setFsegPath(String fsegPath) {
        this.fsegPath = fsegPath;
    }

    public byte[] getFsegReal() {
        return fsegReal;
    }

    public void setFsegReal(byte[] fsegReal) {
        this.fsegReal = fsegReal;
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
        hash += (idFotografiaSeg != null ? idFotografiaSeg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotografiasSeguimiento)) {
            return false;
        }
        FotografiasSeguimiento other = (FotografiasSeguimiento) object;
        if ((this.idFotografiaSeg == null && other.idFotografiaSeg != null) || (this.idFotografiaSeg != null && !this.idFotografiaSeg.equals(other.idFotografiaSeg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.FotografiasSeguimiento[ idFotografiaSeg=" + idFotografiaSeg + " ]";
    }
    
}
