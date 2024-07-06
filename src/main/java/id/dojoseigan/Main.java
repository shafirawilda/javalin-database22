package id.dojoseigan;

import id.dojoseigan.Controller.ActorController;
import id.dojoseigan.Controller.FilmCategoryController;
import id.dojoseigan.Controller.InventoryController;
import io.javalin.Javalin;
import io.javalin.http.Handler;

//import static id.dojoseigan.Model.Actor.insertActor;
import static id.dojoseigan.Model.Actor.sql2o;
import static javax.swing.UIManager.get;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        var app = Javalin.create(/*config*/)
                .start(7070);

        app
                .get("/actor/<page>", ActorController.listActorApi)
                .get("/{actor_id}", ActorController.ActorDetail)
                .delete("/{actor_id}", ActorController.delActor)
                .get("/film-category", FilmCategoryController.listFilmCategory)
                .get("/inventory", InventoryController.listInventory);
    }
}