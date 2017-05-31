/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s"),
    @NamedQuery(name = "Seguimiento.findByIdSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.idSeguimiento = :idSeguimiento"),
    @NamedQuery(name = "Seguimiento.findBySegFechaLlegada", query = "SELECT s FROM Seguimiento s WHERE s.segFechaLlegada = :segFechaLlegada"),
    @NamedQuery(name = "Seguimiento.findBySegFechaPartida", query = "SELECT s FROM Seguimiento s WHERE s.segFechaPartida = :segFechaPartida"),
    @NamedQuery(name = "Seguimiento.findBySegResponsableRecibe", query = "SELECT s FROM Seguimiento s WHERE s.segResponsableRecibe = :segResponsableRecibe"),
    @NamedQuery(name = "Seguimiento.findBySegResponsableDespacho", query = "SELECT s FROM Seguimiento s WHERE s.segResponsableDespacho = :segResponsableDespacho"),
    @NamedQuery(name = "Seguimiento.findBySegTiempoEstimado", query = "SELECT s FROM Seguimiento s WHERE s.segTiempoEstimado = :segTiempoEstimado"),
    @NamedQuery(name = "Seguimiento.findBySegTiempoEmpleado", query = "SELECT s FROM Seguimiento s WHERE s.segTiempoEmpleado = :segTiempoEmpleado"),
    @NamedQuery(name = "Seguimiento.findBySegUltimo", query = "SELECT s FROM Seguimiento s WHERE s.segUltimo = :segUltimo"),
    @NamedQuery(name = "Seguimiento.findBySegLongitud", query = "SELECT s FROM Seguimiento s WHERE s.segLongitud = :segLongitud"),
    @NamedQuery(name = "Seguimiento.findBySegLatitud", query = "SELECT s FROM Seguimiento s WHERE s.segLatitud = :segLatitud")})
public class Seguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seguimiento")
    private Integer idSeguimiento;
    @Column(name = "seg_fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date segFechaLlegada;
    @Column(name = "seg_fecha_partida")
    @Temporal(TemporalType.DATE)
    private Date segFechaPartida;
    @Size(max = 100)
    @Column(name = "seg_responsable_recibe")
    private String segResponsableRecibe;
    @Size(max = 100)
    @Column(name = "seg_responsable_despacho")
    private String segResponsableDespacho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "seg_tiempo_estimado")
    private BigDecimal segTiempoEstimado;
    @Column(name = "seg_tiempo_empleado")
    private BigDecimal segTiempoEmpleado;
    @Size(max = 5)
    @Column(name = "seg_ultimo")
    private String segUltimo;
    @Size(max = 100)
    @Column(name = "seg_longitud")
    private String segLongitud;
    @Size(max = 100)
    @Column(name = "seg_latitud")
    private String segLatitud;
    @OneToMany(mappedBy = "idSeguimiento")
    private Collection<ClienteFinal> clienteFinalCollection;
    @OneToMany(mappedBy = "idSeguimiento")
    private Collection<ComentarioSeguimiento> comentarioSeguimientoCollection;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "id_alerta", referencedColumnName = "id_alerta")
    @ManyToOne
    private Alerta idAlerta;
    @JoinColumn(name = "id_control", referencedColumnName = "id_control")
    @ManyToOne
    private PuntosControl idControl;
    @OneToMany(mappedBy = "idSeguimiento")
    private Collection<FotografiasSeguimiento> fotografiasSeguimientoCollection;

    public Seguimiento() {
    }

    public Seguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Date getSegFechaLlegada() {
        return segFechaLlegada;
    }

    public void setSegFechaLlegada(Date segFechaLlegada) {
        this.segFechaLlegada = segFechaLlegada;
    }

    public Date getSegFechaPartida() {
        return segFechaPartida;
    }

    public void setSegFechaPartida(Date segFechaPartida) {
        this.segFechaPartida = segFechaPartida;
    }

    public String getSegResponsableRecibe() {
        return segResponsableRecibe;
    }

    public void setSegResponsableRecibe(String segResponsableRecibe) {
        this.segResponsableRecibe = segResponsableRecibe;
    }

    public String getSegResponsableDespacho() {
        return segResponsableDespacho;
    }

    public void setSegResponsableDespacho(String segResponsableDespacho) {
        this.segResponsableDespacho = segResponsableDespacho;
    }

    public BigDecimal getSegTiempoEstimado() {
        return segTiempoEstimado;
    }

    public void setSegTiempoEstimado(BigDecimal segTiempoEstimado) {
        this.segTiempoEstimado = segTiempoEstimado;
    }

    public BigDecimal getSegTiempoEmpleado() {
        return segTiempoEmpleado;
    }

    public void setSegTiempoEmpleado(BigDecimal segTiempoEmpleado) {
        this.segTiempoEmpleado = segTiempoEmpleado;
    }

    public String getSegUltimo() {
        return segUltimo;
    }

    public void setSegUltimo(String segUltimo) {
        this.segUltimo = segUltimo;
    }

    public String getSegLongitud() {
        return segLongitud;
    }

    public void setSegLongitud(String segLongitud) {
        this.segLongitud = segLongitud;
    }

    public String getSegLatitud() {
        return segLatitud;
    }

    public void setSegLatitud(String segLatitud) {
        this.segLatitud = segLatitud;
    }

    @XmlTransient
    public Collection<ClienteFinal> getClienteFinalCollection() {
        return clienteFinalCollection;
    }

    public void setClienteFinalCollection(Collection<ClienteFinal> clienteFinalCollection) {
        this.clienteFinalCollection = clienteFinalCollection;
    }

    @XmlTransient
    public Collection<ComentarioSeguimiento> getComentarioSeguimientoCollection() {
        return comentarioSeguimientoCollection;
    }

    public void setComentarioSeguimientoCollection(Collection<ComentarioSeguimiento> comentarioSeguimientoCollection) {
        this.comentarioSeguimientoCollection = comentarioSeguimientoCollection;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Alerta getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Alerta idAlerta) {
        this.idAlerta = idAlerta;
    }

    public PuntosControl getIdControl() {
        return idControl;
    }

    public void setIdControl(PuntosControl idControl) {
        this.idControl = idControl;
    }

    @XmlTransient
    public Collection<FotografiasSeguimiento> getFotografiasSeguimientoCollection() {
        return fotografiasSeguimientoCollection;
    }

    public void setFotografiasSeguimientoCollection(Collection<FotografiasSeguimiento> fotografiasSeguimientoCollection) {
        this.fotografiasSeguimientoCollection = fotografiasSeguimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguimiento != null ? idSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.idSeguimiento == null && other.idSeguimiento != null) || (this.idSeguimiento != null && !this.idSeguimiento.equals(other.idSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidad.Seguimiento[ idSeguimiento=" + idSeguimiento + " ]";
    }
    
}
