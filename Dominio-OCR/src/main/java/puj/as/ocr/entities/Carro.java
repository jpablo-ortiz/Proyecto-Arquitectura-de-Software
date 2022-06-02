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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CARRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findByIdCarro", query = "SELECT c FROM Carro c WHERE c.idCarro = :idCarro"),
    @NamedQuery(name = "Carro.findByPlaca", query = "SELECT c FROM Carro c WHERE c.placa = :placa"),
    @NamedQuery(name = "Carro.findByTipo", query = "SELECT c FROM Carro c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Carro.findByEsRentado", query = "SELECT c FROM Carro c WHERE c.esRentado = :esRentado"),
    @NamedQuery(name = "Carro.findByPrecio", query = "SELECT c FROM Carro c WHERE c.precio = :precio")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CARRO")
    private String idCarro;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "ES_RENTADO")
    private Boolean esRentado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;
    @OneToMany(mappedBy = "idCarro")
    private List<Foto> fotoList;
    @JoinColumn(name = "ID_LOCALIZACION", referencedColumnName = "ID_LOCALIZACION")
    @ManyToOne
    private Localizacion idLocalizacion;
    @JoinColumn(name = "ID_PROPIETARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idPropietario;

    public Carro() {
    }

    public Carro(String idCarro) {
        this.idCarro = idCarro;
    }

    public String getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEsRentado() {
        return esRentado;
    }

    public void setEsRentado(Boolean esRentado) {
        this.esRentado = esRentado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    public Localizacion getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Localizacion idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public Usuario getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Usuario idPropietario) {
        this.idPropietario = idPropietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarro != null ? idCarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idCarro == null && other.idCarro != null) || (this.idCarro != null && !this.idCarro.equals(other.idCarro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "puj.as.ocr.entities.Carro[ idCarro=" + idCarro + " ]";
    }
    
}
