package puj.as.ocr.DTO;

import java.util.ArrayList;
import java.util.List;

import puj.as.ocr.entities.Carro;
import puj.as.ocr.entities.Foto;

public class CarroDTO {
    private static final long serialVersionUID = 1L;

    private String idCarro;
    private String placa;
    private String tipo;
    private Boolean esRentado;
    private Double precio;
    private List<FotoDTO> fotoList;
    private LocalizacionDTO idLocalizacion;
    private UsuarioDTO idPropietario;

    public CarroDTO(String idCarro, String placa, String tipo, Boolean esRentado, Double precio, List<FotoDTO> fotoList,
            LocalizacionDTO idLocalizacion, UsuarioDTO idPropietario) {
        this.idCarro = idCarro;
        this.placa = placa;
        this.tipo = tipo;
        this.esRentado = esRentado;
        this.precio = precio;
        this.fotoList = fotoList;
        this.idLocalizacion = idLocalizacion;
        this.idPropietario = idPropietario;
    }

    public CarroDTO(Carro carro) {
        this.idCarro = carro.getIdCarro();
        this.placa = carro.getPlaca();
        this.tipo = carro.getTipo();
        this.esRentado = carro.getEsRentado();
        this.precio = carro.getPrecio();
        this.fotoList = new ArrayList<FotoDTO>();
        for (Foto foto : carro.getFotoList()) {
            this.fotoList.add(new FotoDTO(foto));
        }
        this.idLocalizacion = new LocalizacionDTO(carro.getIdLocalizacion());
        this.idPropietario = new UsuarioDTO(carro.getIdPropietario(), false);
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

    public List<FotoDTO> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<FotoDTO> fotoList) {
        this.fotoList = fotoList;
    }

    public LocalizacionDTO getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(LocalizacionDTO idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public UsuarioDTO getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(UsuarioDTO idPropietario) {
        this.idPropietario = idPropietario;
    }

}
