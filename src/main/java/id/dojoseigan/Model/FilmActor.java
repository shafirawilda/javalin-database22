package id.dojoseigan.Model;

import id.dojoseigan.helper.DBUtils;
import id.dojoseigan.helper.Res;

import java.util.List;

public class FilmActor {
    private Integer actor_id;
    private Integer film_id;
    private Integer last_update;
    private Actor actor;

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public Integer getFilm() {
        return film_id;
    }

    public static Res<List<FilmActor>> listFilmActor(){
        Res<List<FilmActor>> res = new DBUtils<FilmActor>().list(
                """
                SELECT fa.actor_id, fa.film_id, fa.last_update FROM film_actor fa
                JOIN film f ON f.film_id = fa.film_id
                """,
                FilmActor.class
        );
        return res;
    }
}
