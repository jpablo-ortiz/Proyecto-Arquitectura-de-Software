package puj.as.ocr.DTO;

import puj.as.ocr.entities.Localizacion;

public class LocalizacionDTO {

    private String idLocalizacion;
    private String ciudad;
    private String direccion;

    public LocalizacionDTO(Localizacion idLocalizacion) {
        this.idLocalizacion = idLocalizacion.getIdLocalizacion();
        this.ciudad = idLocalizacion.getCiudad();
        this.direccion = idLocalizacion.getDireccion();
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
    
    
}
