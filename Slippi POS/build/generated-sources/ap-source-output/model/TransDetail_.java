package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Login;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T23:09:23")
@StaticMetamodel(TransDetail.class)
public class TransDetail_ { 

    public static volatile SingularAttribute<TransDetail, String> date;
    public static volatile SingularAttribute<TransDetail, Integer> no;
    public static volatile SingularAttribute<TransDetail, String> total;
    public static volatile SingularAttribute<TransDetail, String> transid;
    public static volatile SingularAttribute<TransDetail, String> time;
    public static volatile SingularAttribute<TransDetail, Login> id;

}