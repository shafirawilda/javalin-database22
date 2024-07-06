package id.dojoseigan.Model;

import com.google.gson.Gson;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.SQLDataException;
import java.sql.Timestamp;
import java.util.List;

import static id.dojoseigan.PgConnection.getSql2o;

public class Actor {
    private long actor_id;
    private String first_name;
    private String last_name;
    private Timestamp last_update;

    static Gson gson = new Gson();
    public static Sql2o sql2o = getSql2o();


    public static String listActor(){
        try(Connection con = sql2o.open()){
            List<Actor> actors = con.createQuery("SELECT * FROM actor").executeAndFetch(Actor.class);

            return gson.toJson(actors);
        }catch (Sql2oException sql2oException){
            return sql2oException.toString();
        }
    }

    public static String listActorDetail(String actor_id){
        try(Connection con = sql2o.open()){
            List<Actor> actors = con.createQuery("SELECT * FROM actor WHERE actor_id = " + actor_id).
                    executeAndFetch(Actor.class);

            return gson.toJson(actors);
        }
    }

    public static String delActor(String actor_id){
        try(Connection con = sql2o.open()){
            con.createQuery("DELETE FROM actor WHERE actor_id = " + Integer.parseInt(actor_id)).
                    executeUpdate();

            return ("Berhasil");
        }catch (Sql2oException sql2oException){
            return sql2oException.toString();
        }
    }
}
