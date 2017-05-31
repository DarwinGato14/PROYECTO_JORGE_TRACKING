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
@Table(name = "cliente_final")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteFinal.findAll", query = "SELECT c FROM ClienteFinal c"),
    @NamedQuery(name = "ClienteFinal.findByIdCliente", query = "SELECT c FROM ClienteFinal c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "ClienteFinal.findByCliMarca", query = "SELECT c FROM ClienteFinal c WHERE c.cliMarca = :cliMarca"),
    @NamedQuery(name = "ClienteFinal.findByCliModelo", query = "SELECT c FROM ClienteFinal c WHERE c.cliModelo = :cliModelo"),
    @NamedQuery(name = "ClienteFinal.findByCliObservacion", query = "SELECT c FROM ClienteFinal c WHERE c.cliObservacion = :cliObservacion"),
    @NamedQuery(name = "ClienteFinal.findByCliPropietario", query = "SELECT c FROM ClienteFinal c WHERE c.cliPropietario = :cliPropietario"),
    @NamedQuery(name = "ClienteFinal.findByCliContacto", query = "SELECT c FROM ClienteFinal c WHERE c.cliContacto = :cliContacto")})
public class ClienteFinal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 30)
    @Column(name = "cli_marca")
    private String cliMarca;
    @Size(max = 30)
    @Column(name = "cli_modelo")
    private String cliModelo;
    @Size(max = 150)
    @Column(name = "cli_observacion")
    private String cliObservacion;
    @Size(max = 50)
    @Column(name = "cli_propietario")
    private String cliPropietario;
    @Size(max = 25)
    @Column(name = "cli_contacto")
    private String cliContacto;
    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id_seguimiento")
    @ManyToOne
    private Seguimiento idSeguimiento;

    public ClienteFinal() {
    }

    public ClienteFinal(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliMarca() {
        return cliMarca;
    }

    public void setCliMarca(String cliMarca) {
        this.cliMarca = cliMarca;
    }

    public String getCliModelo() {
        return cliModelo;
    }

    public void setCliModelo(String cliModelo) {
        this.cliModelo = cliModelo;
    }

    public String getCliObservacion() {
        return cliObservacion;
    }

    public void setCliObservacion(String cliObservacion) {
        this.cliObservacion = cliObservacion;
    }

    public String getCliPropietario() {
        return cliPropietario;
    }

    public void setCliPropietario(String cliPropietario) {
        this.cliPropietario = cliPropietario;
    }

    public String getCliContacto() {
        return cliContacto;
    }

    public void setCliContacto(String cliContacto) {
        this.cliContacto = cliContacto;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteFinal)) {
            return false;
        }
        ClienteFinal other = (ClienteFinal) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.ClienteFinal[ idCliente=" + idCliente + " ]";
    }
    
}
