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
@Table(name = "fabricante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f"),
    @NamedQuery(name = "Fabricante.findByIdFabricante", query = "SELECT f FROM Fabricante f WHERE f.idFabricante = :idFabricante"),
    @NamedQuery(name = "Fabricante.findByFabNombre", query = "SELECT f FROM Fabricante f WHERE f.fabNombre = :fabNombre"),
    @NamedQuery(name = "Fabricante.findByFabDescripcion", query = "SELECT f FROM Fabricante f WHERE f.fabDescripcion = :fabDescripcion"),
    @NamedQuery(name = "Fabricante.findByFabContacto", query = "SELECT f FROM Fabricante f WHERE f.fabContacto = :fabContacto"),
    @NamedQuery(name = "Fabricante.findByFabPaginaWeb", query = "SELECT f FROM Fabricante f WHERE f.fabPaginaWeb = :fabPaginaWeb"),
    @NamedQuery(name = "Fabricante.findByFabEmail", query = "SELECT f FROM Fabricante f WHERE f.fabEmail = :fabEmail"),
    @NamedQuery(name = "Fabricante.findByFabRazonSocial", query = "SELECT f FROM Fabricante f WHERE f.fabRazonSocial = :fabRazonSocial")})
public class Fabricante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fabricante")
    private Integer idFabricante;
    @Size(max = 100)
    @Column(name = "fab_nombre")
    private String fabNombre;
    @Size(max = 100)
    @Column(name = "fab_descripcion")
    private String fabDescripcion;
    @Size(max = 25)
    @Column(name = "fab_contacto")
    private String fabContacto;
    @Size(max = 100)
    @Column(name = "fab_pagina_web")
    private String fabPaginaWeb;
    @Size(max = 100)
    @Column(name = "fab_email")
    private String fabEmail;
    @Size(max = 100)
    @Column(name = "fab_razon_social")
    private String fabRazonSocial;
    @OneToMany(mappedBy = "idFabricante")
    private Collection<Producto> productoCollection;

    public Fabricante() {
    }

    public Fabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getFabNombre() {
        return fabNombre;
    }

    public void setFabNombre(String fabNombre) {
        this.fabNombre = fabNombre;
    }

    public String getFabDescripcion() {
        return fabDescripcion;
    }

    public void setFabDescripcion(String fabDescripcion) {
        this.fabDescripcion = fabDescripcion;
    }

    public String getFabContacto() {
        return fabContacto;
    }

    public void setFabContacto(String fabContacto) {
        this.fabContacto = fabContacto;
    }

    public String getFabPaginaWeb() {
        return fabPaginaWeb;
    }

    public void setFabPaginaWeb(String fabPaginaWeb) {
        this.fabPaginaWeb = fabPaginaWeb;
    }

    public String getFabEmail() {
        return fabEmail;
    }

    public void setFabEmail(String fabEmail) {
        this.fabEmail = fabEmail;
    }

    public String getFabRazonSocial() {
        return fabRazonSocial;
    }

    public void setFabRazonSocial(String fabRazonSocial) {
        this.fabRazonSocial = fabRazonSocial;
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
        hash += (idFabricante != null ? idFabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.idFabricante == null && other.idFabricante != null) || (this.idFabricante != null && !this.idFabricante.equals(other.idFabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Fabricante[ idFabricante=" + idFabricante + " ]";
    }
    
}
