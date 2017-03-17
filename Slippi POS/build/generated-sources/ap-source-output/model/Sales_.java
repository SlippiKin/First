package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Login;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T23:09:23")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, Integer> no;
    public static volatile SingularAttribute<Sales, Integer> quantity;
    public static volatile SingularAttribute<Sales, String> transid;
    public static volatile SingularAttribute<Sales, Login> id;
    public static volatile SingularAttribute<Sales, String> barcode;

}