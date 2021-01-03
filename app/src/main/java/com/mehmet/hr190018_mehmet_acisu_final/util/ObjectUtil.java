package com.mehmet.hr190018_mehmet_acisu_final.util;

import com.google.gson.Gson;
import com.mehmet.hr190018_mehmet_acisu_final.model.FutbolcuModel;

public class ObjectUtil {

    public  static String futbolcuToJsonString(FutbolcuModel futbolcuModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(futbolcuModel);
    }

    public  static FutbolcuModel jsonStringToFutbolcu(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,FutbolcuModel.class);
    }
}
