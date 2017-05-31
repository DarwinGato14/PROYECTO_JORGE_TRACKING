/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsuNombre", query = "SELECT u FROM Usuario u WHERE u.usuNombre = :usuNombre"),
    @NamedQuery(name = "Usuario.findByUsuApellido", query = "SELECT u FROM Usuario u WHERE u.usuApellido = :usuApellido"),
    @NamedQuery(name = "Usuario.findByUsuLogin", query = "SELECT u FROM Usuario u WHERE u.usuLogin = :usuLogin"),
    @NamedQuery(name = "Usuario.findByUsuPassword", query = "SELECT u FROM Usuario u WHERE u.usuPassword = :usuPassword"),
    @NamedQuery(name = "Usuario.findByUsuCorreo", query = "SELECT u FROM Usuario u WHERE u.usuCorreo = :usuCorreo"),
    @NamedQuery(name = "Usuario.findByUsuNivel", query = "SELECT u FROM Usuario u WHERE u.usuNivel = :usuNivel"),
    @NamedQuery(name = "Usuario.findByUsuRol", query = "SELECT u FROM Usuario u WHERE u.usuRol = :usuRol"),
    @NamedQuery(name = "Usuario.findByUsuMovil", query = "SELECT u FROM Usuario u WHERE u.usuMovil = :usuMovil"),
    @NamedQuery(name = "Usuario.findByUsuFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaCreacion = :usuFechaCreacion"),
    @NamedQuery(name = "Usuario.findByUsuFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaModificacion = :usuFechaModificacion"),
    @NamedQuery(name = "Usuario.findByUsuFechaEliminacion", query = "SELECT u FROM Usuario u WHERE u.usuFechaEliminacion = :usuFechaEliminacion"),
    @NamedQuery(name = "Usuario.findByUsuActivo", query = "SELECT u FROM Usuario u WHERE u.usuActivo = :usuActivo"),
    @NamedQuery(name = "Usuario.findByUsuEliminado", query = "SELECT u FROM Usuario u WHERE u.usuEliminado = :usuEliminado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 100)
    @Column(name = "usu_nombre")
    private String usuNombre;
    @Size(max = 100)
    @Column(name = "usu_apellido")
    private String usuApellido;
    @Size(max = 40)
    @Column(name = "usu_login")
    private String usuLogin;
    @Size(max = 40)
    @Column(name = "usu_password")
    private String usuPassword;
    @Size(max = 100)
    @Column(name = "usu_correo")
    private String usuCorreo;
    @Column(name = "usu_nivel")
    private Integer usuNivel;
    @Lob
    @Column(name = "usu_fotografia")
    private byte[] usuFotografia;
    @Size(max = 50)
    @Column(name = "usu_rol")
    private String usuRol;
    @Size(max = 100)
    @Column(name = "usu_movil")
    private String usuMovil;
    @Column(name = "usu_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date usuFechaCreacion;
    @Column(name = "usu_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date usuFechaModificacion;
    @Column(name = "usu_fecha_eliminacion")
    @Temporal(TemporalType.DATE)
    private Date usuFechaEliminacion;
    @Column(name = "usu_activo")
    private Integer usuActivo;
    @Column(name = "usu_eliminado")
    private Integer usuEliminado;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne
    private TipoUsuario idTipoUsuario;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Seguimiento> seguimientoCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public Integer getUsuNivel() {
        return usuNivel;
    }

    public void setUsuNivel(Integer usuNivel) {
        this.usuNivel = usuNivel;
    }

    public byte[] getUsuFotografia() {
        return usuFotografia;
    }

    public void setUsuFotografia(byte[] usuFotografia) {
        this.usuFotografia = usuFotografia;
    }

    public String getUsuRol() {
        return usuRol;
    }

    public void setUsuRol(String usuRol) {
        this.usuRol = usuRol;
    }

    public String getUsuMovil() {
        return usuMovil;
    }

    public void setUsuMovil(String usuMovil) {
        this.usuMovil = usuMovil;
    }

    public Date getUsuFechaCreacion() {
        return usuFechaCreacion;
    }

    public void setUsuFechaCreacion(Date usuFechaCreacion) {
        this.usuFechaCreacion = usuFechaCreacion;
    }

    public Date getUsuFechaModificacion() {
        return usuFechaModificacion;
    }

    public void setUsuFechaModificacion(Date usuFechaModificacion) {
        this.usuFechaModificacion = usuFechaModificacion;
    }

    public Date getUsuFechaEliminacion() {
        return usuFechaEliminacion;
    }

    public void setUsuFechaEliminacion(Date usuFechaEliminacion) {
        this.usuFechaEliminacion = usuFechaEliminacion;
    }

    public Integer getUsuActivo() {
        return usuActivo;
    }

    public void setUsuActivo(Integer usuActivo) {
        this.usuActivo = usuActivo;
    }

    public Integer getUsuEliminado() {
        return usuEliminado;
    }

    public void setUsuEliminado(Integer usuEliminado) {
        this.usuEliminado = usuEliminado;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
