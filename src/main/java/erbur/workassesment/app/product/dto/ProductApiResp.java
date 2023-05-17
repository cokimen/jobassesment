package erbur.workassesment.app.product.dto;

import java.io.Serializable;
import java.util.HashMap;


public class ProductApiResp implements Serializable {


    public static ProductApiResp ProductApiRespBuilder(Integer status, Object bodyJson){
        return new ProductApiResp(status, bodyJson);
    }


    private ProductApiResp(Integer status, Object bodyJson){
        this.keyJson.put("status", status);
        this.keyJson.put("data", bodyJson);
    }

    private HashMap<String, Object> keyJson = new HashMap<>();

    public HashMap<String, Object> getBodyJson(){
         return keyJson;
    }
}
