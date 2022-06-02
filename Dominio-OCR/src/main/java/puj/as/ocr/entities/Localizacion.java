/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name = "LOCALIZACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacion.findAll", query = "SELECT l FROM Localizacion l"),
    @NamedQuery(name = "Localizacion.findByIdLocalizacion", query = "SELECT l FROM Localizacion l WHERE l.idLocalizacion = :idLocalizacion"),
    @NamedQuery(name = "Localizacion.findByCiudad", query = "SELECT l FROM Localizacion l WHERE l.ciudad = :ciudad"),
    @NamedQuery(name = "Localizacion.findByDireccion", query = "SELECT l FROM Localizacion l WHERE l.direccion = :direccion")})
public class Localizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LOCALIZACION")
    private String idLocalizacion;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(mappedBy = "idLocalizacion")
    private List<Carro> carroList;

    public Localizacion() {
    }

    public Localizacion(String idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(String idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Carro> getCarroList() {
        return carroList;
    }

    public void setCarroList(List<Carro> carroList) {
        this.carroList = carroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalizacion != null ? idLocalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.idLocalizacion == null && other.idLocalizacion != null) || (this.idLocalizacion != null && !this.idLocalizacion.equals(other.idLocalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "puj.as.ocr.entities.Localizacion[ idLocalizacion=" + idLocalizacion + " ]";
    }
    
}
