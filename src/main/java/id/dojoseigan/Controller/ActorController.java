package id.dojoseigan.Controller;

import com.google.gson.Gson;
import id.dojoseigan.Model.Actor;

import io.javalin.http.Handler;
import org.sql2o.Sql2o;

public class ActorController {
    static public Gson gson = new Gson();
    public static Handler listActorApi = ctx -> ctx.json(Actor.listActor());
    public static Handler ActorDetail = ctx -> {
        String actor_id = ctx.pathParam("actor_id");
        ctx.json(Actor.listActorDetail(actor_id));
    };
    public static Handler delActor = ctx -> {
        String actor_id = ctx.pathParam("actor_id");
        ctx.json(Actor.delActor(actor_id));
    };




}

