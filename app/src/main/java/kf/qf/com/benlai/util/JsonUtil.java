package kf.qf.com.benlai.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import kf.qf.com.benlai.entity.CityEntity;
import kf.qf.com.benlai.entity.HotCityEntity;


/**
 * Created by yzy on 2016/3/7/0007.
 */
public class JsonUtil {
    //解析热门城市
    public static List<HotCityEntity> parseHotCity(String json){

        try {
            JSONObject object = new JSONObject(json);
            JSONArray hotlist = object.getJSONObject("data").getJSONArray("hotlist");
            TypeToken<List<HotCityEntity>> tt = new TypeToken<List<HotCityEntity>>(){};
            List<HotCityEntity> list_hotcity = new Gson().fromJson(hotlist.toString(), tt.getType());
            return list_hotcity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //解析普通城市
    public static List<CityEntity> parseCity(String json){
        try {
            JSONObject object = new JSONObject(json);
            JSONArray list = object.getJSONObject("data").getJSONArray("list");
            TypeToken<List<CityEntity>> tt = new TypeToken<List<CityEntity>>(){};
            List<CityEntity> list_citys = new Gson().fromJson(list.toString(), tt.getType());
            return list_citys;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
