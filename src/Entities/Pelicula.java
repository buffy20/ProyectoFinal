/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videoteca;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lou
 */
@Entity
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findByIdPelicula", query = "SELECT p FROM Pelicula p WHERE p.idPelicula = :idPelicula"),
    @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Pelicula.findByProductora", query = "SELECT p FROM Pelicula p WHERE p.productora = :productora"),
    @NamedQuery(name = "Pelicula.findByFechaEstreno", query = "SELECT p FROM Pelicula p WHERE p.fechaEstreno = :fechaEstreno"),
    @NamedQuery(name = "Pelicula.findByNacionalidad", query = "SELECT p FROM Pelicula p WHERE p.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Pelicula.findByDuracion", query = "SELECT p FROM Pelicula p WHERE p.duracion = :duracion"),
    @NamedQuery(name = "Pelicula.findByRecaudacion", query = "SELECT p FROM Pelicula p WHERE p.recaudacion = :recaudacion"),
    @NamedQuery(name = "Pelicula.findByOscars", query = "SELECT p FROM Pelicula p WHERE p.oscars = :oscars"),
    @NamedQuery(name = "Pelicula.findByRutaImagen", query = "SELECT p FROM Pelicula p WHERE p.rutaImagen = :rutaImagen"),
    @NamedQuery(name = "Pelicula.findByValoracion", query = "SELECT p FROM Pelicula p WHERE p.valoracion = :valoracion")})
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPelicula")
    private Integer idPelicula;
    @Basic(optional = false)
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Productora")
    private String productora;
    @Column(name = "FechaEstreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;
    @Column(name = "Nacionalidad")
    private String nacionalidad;
    @Column(name = "Duracion")
    private Short duracion;
    @Column(name = "Recaudacion")
    private BigInteger recaudacion;
    @Column(name = "Oscars")
    private Boolean oscars;
    @Column(name = "RutaImagen")
    private String rutaImagen;
    @Column(name = "Valoracion")
    private Integer valoracion;
    @JoinColumn(name = "IdActor", referencedColumnName = "IdActor")
    @ManyToOne
    private Actor idActor;
    @JoinColumn(name = "IdGenero", referencedColumnName = "IdGenero")
    @ManyToOne
    private Genero idGenero;
    @JoinColumn(name = "IdDirector", referencedColumnName = "IdDirector")
    @ManyToOne
    private Director idDirector;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Pelicula(Integer idPelicula, String titulo) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public BigInteger getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(BigInteger recaudacion) {
        this.recaudacion = recaudacion;
    }

    public Boolean getOscars() {
        return oscars;
    }

    public void setOscars(Boolean oscars) {
        this.oscars = oscars;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Actor getIdActor() {
        return idActor;
    }

    public void setIdActor(Actor idActor) {
        this.idActor = idActor;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Director getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Director idDirector) {
        this.idDirector = idDirector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPelicula != null ? idPelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idPelicula == null && other.idPelicula != null) || (this.idPelicula != null && !this.idPelicula.equals(other.idPelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videoteca.Pelicula[ idPelicula=" + idPelicula + " ]";
    }
    
}
