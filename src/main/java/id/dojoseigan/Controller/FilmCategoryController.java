package id.dojoseigan.Controller;

import com.google.gson.Gson;
import id.dojoseigan.Model.Film;
import id.dojoseigan.Model.FilmCategory;
import id.dojoseigan.helper.Res;
import io.javalin.http.Handler;

import java.util.List;

public class FilmCategoryController {
    static Gson gson = new Gson();

    public static Handler listFilmCategory = ctx -> {
        Res<List<FilmCategory>> list = FilmCategory.listFilmCategories();

        List<FilmCategory> ListFilmCategory = list.getData();
        for(FilmCategory filmCategory : ListFilmCategory){
            Film film = Film.getFilmById(filmCategory.getFilm())
                    .getData();
            filmCategory.setFilm(film);
        }
        ctx.json(gson.toJson(list));
    };
}
