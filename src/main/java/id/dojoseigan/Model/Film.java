package id.dojoseigan.Model;

import id.dojoseigan.helper.DBUtils;
import id.dojoseigan.helper.Res;

public class Film {

    private Integer film_id;
    private String title;
    private String description;

    public static Res<Film> getFilmById(Integer filmId){
        Res data = new DBUtils().get(
                """
                        SELECT film_id, title, description
                        FROM film
                        WHERE film_id = :p1;
                        """,
                filmId,
                Film.class
        );
        return data;
    }
}
