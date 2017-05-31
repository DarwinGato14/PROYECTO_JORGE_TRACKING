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
@Table(name = "tipo_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByIdTipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByTusuNombre", query = "SELECT t FROM TipoUsuario t WHERE t.tusuNombre = :tusuNombre"),
    @NamedQuery(name = "TipoUsuario.findByTusAbreviatura", query = "SELECT t FROM TipoUsuario t WHERE t.tusAbreviatura = :tusAbreviatura"),
    @NamedQuery(name = "TipoUsuario.findByTusuAcceso", query = "SELECT t FROM TipoUsuario t WHERE t.tusuAcceso = :tusuAcceso")})
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_usuario")
    private Integer idTipoUsuario;
    @Size(max = 50)
    @Column(name = "tusu_nombre")
    private String tusuNombre;
    @Size(max = 10)
    @Column(name = "tus_abreviatura")
    private String tusAbreviatura;
    @Column(name = "tusu_acceso")
    private Integer tusuAcceso;
    @OneToMany(mappedBy = "idTipoUsuario")
    private Collection<Usuario> usuarioCollection;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTusuNombre() {
        return tusuNombre;
    }

    public void setTusuNombre(String tusuNombre) {
        this.tusuNombre = tusuNombre;
    }

    public String getTusAbreviatura() {
        return tusAbreviatura;
    }

    public void setTusAbreviatura(String tusAbreviatura) {
        this.tusAbreviatura = tusAbreviatura;
    }

    public Integer getTusuAcceso() {
        return tusuAcceso;
    }

    public void setTusuAcceso(Integer tusuAcceso) {
        this.tusuAcceso = tusuAcceso;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.TipoUsuario[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
