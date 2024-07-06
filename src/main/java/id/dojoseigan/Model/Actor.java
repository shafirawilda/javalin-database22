package id.dojoseigan.Model;

import com.google.gson.Gson;
import id.dojoseigan.helper.DBUtils;
import id.dojoseigan.helper.Res;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.SQLDataException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static id.dojoseigan.PgConnection.getSql2o;

public class Actor {
    private long actor_id;
    private String first_name;
    private String last_name;
    private Timestamp last_update;

    static Gson gson = new Gson();
    public static Sql2o sql2o = getSql2o();

    public static Res<List<Actor>> listActor(Map<String, String> params, Integer page){
        String sql = "SELECT actor_id, first_name, last_name, last_update" +
                "FROM actor WHERE TRUE ";

        String where = "";
        if(params.get("first_name") != null && params.get("first_name") != ""){
            where += "AND first_name ILIKE '%" + params.get("first_name") + "%'";
        }

        if(params.get("last_name") != null && params.get("last_name") != ""){
            where += "AND last_name ILIKE '%" + params.get("last_name") + "%'";
        }

        Res data = new DBUtils().list(
                sql + where + " ORDER BY actor_id LIMIT 10 ",
                Actor.class
        );
        return data;
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
