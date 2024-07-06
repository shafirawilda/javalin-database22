package id.dojoseigan.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dojoseigan.Model.Actor;

import id.dojoseigan.helper.Res;
import io.javalin.http.Handler;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorController {
    static public Gson gson = new Gson();
//    public static Handler listActorApi = ctx -> ctx.json(Actor.listActor());
    public static Handler ActorDetail = ctx -> {
        String actor_id = ctx.pathParam("actor_id");
        ctx.json(Actor.listActorDetail(actor_id));
    };
    public static Handler delActor = ctx -> {
        String actor_id = ctx.pathParam("actor_id");
        ctx.json(Actor.delActor(actor_id));
    };

    public static Handler listActorApi = ctx ->{
        Map<String, String> paramList = new HashMap<>();

        String page = ctx.pathParam("page");
        String firstname = ctx.queryParam("firstname");
        String lastname = ctx.queryParam("lastname");

        paramList.put("first_name", firstname);
        paramList.put("last_name", lastname);

        Res<List<Actor>> res = Actor.listActor(paramList,Integer.valueOf(page));

        ctx.json(gson.toJson(res));
    };

//    public static Handler postActor = ctx -> {
//        Map<String, Object> payload = gson.fromJson(ctx.body(), new TypeToken<Map<String, Object>>(){});
//        Object firstname = payload.get("first_name");
//        Object lastname = payload.get("last_name");
//        Actor actor = new Actor(-1, firstname.toString(), lastname.toString());
//        System.out.println(actor);
//    };







}

