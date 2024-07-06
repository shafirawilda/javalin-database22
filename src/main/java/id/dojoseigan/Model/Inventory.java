package id.dojoseigan.Model;

import id.dojoseigan.PgConnection;
import id.dojoseigan.helper.DBUtils;
import id.dojoseigan.helper.Res;
import org.sql2o.Sql2o;

import java.util.List;

public class Inventory {
    private Integer inventory_id;
    private Integer film_id;
    private Integer store_id;
    private java.sql.Timestamp last_update;
    private Film film;

    static Sql2o sql2o = PgConnection.getSql2o();

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    static public <T> Res<List<Inventory>> listInventory(){
        Res<List<Inventory>> res = new DBUtils<Inventory>().list(
                """
                SELECT i.inventory_id, i.film_id, i.store_id FROM inventory i
                JOIN film f ON f.film_id = i.film_id;
                """,
                Inventory.class
        );
        return res;
    }
}
