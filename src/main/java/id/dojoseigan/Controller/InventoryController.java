package id.dojoseigan.Controller;

import com.google.gson.Gson;
import id.dojoseigan.Model.Film;
import id.dojoseigan.Model.Inventory;
import id.dojoseigan.helper.Res;
import io.javalin.http.Handler;

import java.util.List;


public class InventoryController {
    static Gson gson = new Gson();

    public static Handler listInventory = ctx -> {
        Res<List<Inventory>> list = Inventory.listInventory();
//        List<Inventory> listInventory = list.getData();
//        System.out.println(listInventory);
//        for (Inventory inventory: listInventory){
//            Film film = Film.getFilmById(inventory.getFilm_id())
//                    .getData();
//            inventory.setFilm(film);
//        }
        ctx.json(gson.toJson(list));
    };
}
