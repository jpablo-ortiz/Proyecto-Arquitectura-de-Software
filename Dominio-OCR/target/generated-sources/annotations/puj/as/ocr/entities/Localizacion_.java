package puj.as.ocr.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import puj.as.ocr.entities.Carro;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-06-01T18:33:14")
@StaticMetamodel(Localizacion.class)
public class Localizacion_ { 

    public static volatile SingularAttribute<Localizacion, String> idLocalizacion;
    public static volatile SingularAttribute<Localizacion, String> ciudad;
    public static volatile ListAttribute<Localizacion, Carro> carroList;
    public static volatile SingularAttribute<Localizacion, String> direccion;

}