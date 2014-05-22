/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package videoteca;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lou
 */
@Entity
@Table(name = "director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
    @NamedQuery(name = "Director.findByIdDirector", query = "SELECT d FROM Director d WHERE d.idDirector = :idDirector"),
    @NamedQuery(name = "Director.findByNombre", query = "SELECT d FROM Director d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Director.findByApellidos", query = "SELECT d FROM Director d WHERE d.apellidos = :apellidos"),
    @NamedQuery(name = "Director.findByNacionalidad", query = "SELECT d FROM Director d WHERE d.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Director.findByA\u00f1oNacimiento", query = "SELECT d FROM Director d WHERE d.a\u00f1oNacimiento = :a\u00f1oNacimiento"),
    @NamedQuery(name = "Director.findByOscar", query = "SELECT d FROM Director d WHERE d.oscar = :oscar")})
public class Director implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDirector")
    private Integer idDirector;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Nacionalidad")
    private String nacionalidad;
    @Column(name = "A\u00f1oNacimiento")
    @Temporal(TemporalType.DATE)
    private Date añoNacimiento;
    @Column(name = "Oscar")
    private Boolean oscar;
    @OneToMany(mappedBy = "idDirector")
    private Collection<Pelicula> peliculaCollection;

    public Director() {
    }

    public Director(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(Date añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public Boolean getOscar() {
        return oscar;
    }

    public void setOscar(Boolean oscar) {
        this.oscar = oscar;
    }

    @XmlTransient
    public Collection<Pelicula> getPeliculaCollection() {
        return peliculaCollection;
    }

    public void setPeliculaCollection(Collection<Pelicula> peliculaCollection) {
        this.peliculaCollection = peliculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDirector != null ? idDirector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.idDirector == null && other.idDirector != null) || (this.idDirector != null && !this.idDirector.equals(other.idDirector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videoteca.Director[ idDirector=" + idDirector + " ]";
    }
    
}
