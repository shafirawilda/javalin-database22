package id.dojoseigan.Model;

import com.google.gson.Gson;
import id.dojoseigan.PgConnection;
import id.dojoseigan.helper.DBUtils;
import id.dojoseigan.helper.Res;
import org.sql2o.Sql2o;

import java.util.List;

public class FilmCategory {
    private Integer film_id;
    private Integer category_id;
    private java.sql.Timestamp last_update;
    private Film film;

    public void setFilm(Film film) {
        this.film = film;
    }

    public Integer getFilm() {
        return film_id;
    }

    static Sql2o sql2o = PgConnection.getSql2o();
    static Gson gson = new Gson();

    public static Res<List<FilmCategory>> listFilmCategories(){
        Res<List<FilmCategory>> res = new DBUtils<FilmCategory>().list(
                """
                SELECT fc.film_id, fc.category_id, fc.last_update FROM film_category fc
                JOIN film f ON f.film_id = fc.film_id
                """,
                FilmCategory.class
        );
        return res;
    }
};
