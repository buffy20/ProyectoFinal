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
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findByIdActor", query = "SELECT a FROM Actor a WHERE a.idActor = :idActor"),
    @NamedQuery(name = "Actor.findByNombre", query = "SELECT a FROM Actor a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actor.findByApellidos", query = "SELECT a FROM Actor a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Actor.findByNacionalidad", query = "SELECT a FROM Actor a WHERE a.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Actor.findByA\u00f1oNacimiento", query = "SELECT a FROM Actor a WHERE a.a\u00f1oNacimiento = :a\u00f1oNacimiento"),
    @NamedQuery(name = "Actor.findByOscar", query = "SELECT a FROM Actor a WHERE a.oscar = :oscar")})
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdActor")
    private Integer idActor;
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
    @OneToMany(mappedBy = "idActor")
    private Collection<Pelicula> peliculaCollection;

    public Actor() {
    }

    public Actor(Integer idActor) {
        this.idActor = idActor;
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
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
        hash += (idActor != null ? idActor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.idActor == null && other.idActor != null) || (this.idActor != null && !this.idActor.equals(other.idActor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "videoteca.Actor[ idActor=" + idActor + " ]";
    }
    
}
