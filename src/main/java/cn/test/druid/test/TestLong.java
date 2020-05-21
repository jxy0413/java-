package cn.test.druid.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-04-27
 */
public class TestLong {
    @Test
    public void test(){
        JSONArray jsonArray =new JSONArray();
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","已使用");
        jsonObject.put("value",1);
        JSONObject jsonObject1= new JSONObject();
        jsonObject1.put("name","未使用");
        jsonObject1.put("value",7-3);
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        System.out.println(jsonArray);
    }
}
