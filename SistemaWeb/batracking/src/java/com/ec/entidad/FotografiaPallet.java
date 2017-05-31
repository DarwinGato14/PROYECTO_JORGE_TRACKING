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
@Table(name = "fotografia_pallet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotografiaPallet.findAll", query = "SELECT f FROM FotografiaPallet f"),
    @NamedQuery(name = "FotografiaPallet.findByIdFotoPallet", query = "SELECT f FROM FotografiaPallet f WHERE f.idFotoPallet = :idFotoPallet"),
    @NamedQuery(name = "FotografiaPallet.findByFpallNombre", query = "SELECT f FROM FotografiaPallet f WHERE f.fpallNombre = :fpallNombre"),
    @NamedQuery(name = "FotografiaPallet.findByFpallPath", query = "SELECT f FROM FotografiaPallet f WHERE f.fpallPath = :fpallPath")})
public class FotografiaPallet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foto_pallet")
    private Integer idFotoPallet;
    @Size(max = 50)
    @Column(name = "fpall_nombre")
    private String fpallNombre;
    @Size(max = 150)
    @Column(name = "fpall_path")
    private String fpallPath;
    @Lob
    @Column(name = "fpall_real")
    private byte[] fpallReal;
    @JoinColumn(name = "id_pallet", referencedColumnName = "id_pallet")
    @ManyToOne
    private Pallet idPallet;

    public FotografiaPallet() {
    }

    public FotografiaPallet(Integer idFotoPallet) {
        this.idFotoPallet = idFotoPallet;
    }

    public Integer getIdFotoPallet() {
        return idFotoPallet;
    }

    public void setIdFotoPallet(Integer idFotoPallet) {
        this.idFotoPallet = idFotoPallet;
    }

    public String getFpallNombre() {
        return fpallNombre;
    }

    public void setFpallNombre(String fpallNombre) {
        this.fpallNombre = fpallNombre;
    }

    public String getFpallPath() {
        return fpallPath;
    }

    public void setFpallPath(String fpallPath) {
        this.fpallPath = fpallPath;
    }

    public byte[] getFpallReal() {
        return fpallReal;
    }

    public void setFpallReal(byte[] fpallReal) {
        this.fpallReal = fpallReal;
    }

    public Pallet getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Pallet idPallet) {
        this.idPallet = idPallet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFotoPallet != null ? idFotoPallet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotografiaPallet)) {
            return false;
        }
        FotografiaPallet other = (FotografiaPallet) object;
        if ((this.idFotoPallet == null && other.idFotoPallet != null) || (this.idFotoPallet != null && !this.idFotoPallet.equals(other.idFotoPallet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.FotografiaPallet[ idFotoPallet=" + idFotoPallet + " ]";
    }
    
}
