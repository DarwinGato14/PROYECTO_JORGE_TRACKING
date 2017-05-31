/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "alerta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a"),
    @NamedQuery(name = "Alerta.findByIdAlerta", query = "SELECT a FROM Alerta a WHERE a.idAlerta = :idAlerta"),
    @NamedQuery(name = "Alerta.findByAlertNombre", query = "SELECT a FROM Alerta a WHERE a.alertNombre = :alertNombre"),
    @NamedQuery(name = "Alerta.findByAlertDesde", query = "SELECT a FROM Alerta a WHERE a.alertDesde = :alertDesde"),
    @NamedQuery(name = "Alerta.findByAlertsHasta", query = "SELECT a FROM Alerta a WHERE a.alertsHasta = :alertsHasta"),
    @NamedQuery(name = "Alerta.findByAlertSemaforo", query = "SELECT a FROM Alerta a WHERE a.alertSemaforo = :alertSemaforo")})
public class Alerta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alerta")
    private Integer idAlerta;
    @Size(max = 50)
    @Column(name = "alert_nombre")
    private String alertNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "alert_desde")
    private BigDecimal alertDesde;
    @Column(name = "alerts_hasta")
    private BigDecimal alertsHasta;
    @Size(max = 100)
    @Column(name = "alert_semaforo")
    private String alertSemaforo;
    @OneToMany(mappedBy = "idAlerta")
    private Collection<Seguimiento> seguimientoCollection;

    public Alerta() {
    }

    public Alerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getAlertNombre() {
        return alertNombre;
    }

    public void setAlertNombre(String alertNombre) {
        this.alertNombre = alertNombre;
    }

    public BigDecimal getAlertDesde() {
        return alertDesde;
    }

    public void setAlertDesde(BigDecimal alertDesde) {
        this.alertDesde = alertDesde;
    }

    public BigDecimal getAlertsHasta() {
        return alertsHasta;
    }

    public void setAlertsHasta(BigDecimal alertsHasta) {
        this.alertsHasta = alertsHasta;
    }

    public String getAlertSemaforo() {
        return alertSemaforo;
    }

    public void setAlertSemaforo(String alertSemaforo) {
        this.alertSemaforo = alertSemaforo;
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
        hash += (idAlerta != null ? idAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.idAlerta == null && other.idAlerta != null) || (this.idAlerta != null && !this.idAlerta.equals(other.idAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Alerta[ idAlerta=" + idAlerta + " ]";
    }
    
}
