package puj.as.ocr.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import puj.as.ocr.entities.Foto;
import puj.as.ocr.entities.Localizacion;
import puj.as.ocr.entities.Usuario;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-06-01T18:33:14")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile SingularAttribute<Carro, String> tipo;
    public static volatile SingularAttribute<Carro, Double> precio;
    public static volatile SingularAttribute<Carro, String> idCarro;
    public static volatile SingularAttribute<Carro, Boolean> esRentado;
    public static volatile SingularAttribute<Carro, Localizacion> idLocalizacion;
    public static volatile SingularAttribute<Carro, Usuario> idPropietario;
    public static volatile ListAttribute<Carro, Foto> fotoList;
    public static volatile SingularAttribute<Carro, String> placa;

}