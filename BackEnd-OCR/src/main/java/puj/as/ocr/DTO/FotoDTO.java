package puj.as.ocr.DTO;

import java.io.Serializable;

import puj.as.ocr.entities.Foto;

public class FotoDTO {

    private String idFoto;
    private Serializable datos;

    public FotoDTO(Foto foto) {
        this.idFoto = foto.getIdFoto();
        this.datos = foto.getDatos();
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public Serializable getDatos() {
        return datos;
    }

    public void setDatos(Serializable datos) {
        this.datos = datos;
    }
    
    
}
