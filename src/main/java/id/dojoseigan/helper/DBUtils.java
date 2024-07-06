package id.dojoseigan.helper;

import id.dojoseigan.PgConnection;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class DBUtils<T> {
    static private Sql2o sql2o = PgConnection.getSql2o();

    public Res<List<T>> list(String query, Class<T> mapper) {
        try (Connection con = sql2o.open()) {
            List<T> list = con.createQuery(query).executeAndFetch(mapper);
            return new Res<List<T>>("Berhasil Mendapatkan Data.", list);
        }
        catch (Sql2oException sql2oException) {
            sql2oException.printStackTrace();
            return new Res(sql2oException.toString(),null );
        } catch (Exception e){
            e.printStackTrace();
            return new Res(e.toString(), null);
        }
    }

    public Res<T> get(String query,Object param, Class<T> mapper) {
        try (Connection con = sql2o.open()) {
            T data = con.createQuery(query).withParams(param).executeAndFetchFirst(mapper);
            return new Res<T>("Berhasil Mendapatkan data", data);
        } catch (Sql2oException sql2oException) {
            return new Res(sql2oException.toString(),null);
        } catch (Exception e){
            return new Res(e.toString(), null);
        }
    }
}
