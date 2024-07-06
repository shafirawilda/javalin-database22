package id.dojoseigan;

import org.sql2o.Sql2o;

public class PgConnection {
    static private final Sql2o sql2o;

    static {
        sql2o = new Sql2o("jdbc:postgresql://localhost:5432/dvdrental", "shafira2", "ddeunghunie123");
    }

    public static Sql2o getSql2o() {
        return sql2o;
    }
}
