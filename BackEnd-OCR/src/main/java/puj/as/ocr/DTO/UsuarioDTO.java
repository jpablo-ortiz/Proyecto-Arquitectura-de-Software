package puj.as.ocr.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import puj.as.ocr.entities.Carro;
import puj.as.ocr.entities.Usuario;

public class UsuarioDTO {
    private String idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private Boolean customer;
    private Date fechaCreacionCuenta;
    private String correo;
    private List<CarroDTO> carroList;

    public UsuarioDTO(Usuario idPropietario, boolean ingresarCarros) {
        this.idUsuario = idPropietario.getIdUsuario();
        this.username = idPropietario.getUsername();
        this.password = idPropietario.getPassword();
        this.nombre = idPropietario.getNombre();
        this.apellidos = idPropietario.getApellidos();
        this.customer = idPropietario.getCustomer();
        this.fechaCreacionCuenta = idPropietario.getFechaCreacionCuenta();
        this.correo = idPropietario.getCorreo();
        this.carroList = new ArrayList<CarroDTO>();
        if (ingresarCarros) {
            for (Carro carro : idPropietario.getCarroList()) {
                this.carroList.add(new CarroDTO(carro));
            }
        }
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getCustomer() {
        return customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    public Date getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public void setFechaCreacionCuenta(Date fechaCreacionCuenta) {
        this.fechaCreacionCuenta = fechaCreacionCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<CarroDTO> getCarroList() {
        return carroList;
    }

    public void setCarroList(List<CarroDTO> carroList) {
        this.carroList = carroList;
    }
    
    
}
