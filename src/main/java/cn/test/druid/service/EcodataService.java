//package cn.test.druid.service;
//import cn.test.druid.mapper.EcodataMapper;
//import cn.test.druid.model.Ecodata;
//import com.alibaba.fastjson.JSONObject;
//import org.elasticsearch.action.index.IndexRequestBuilder;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @Auther jxy
// * @Date 2020-04-30
// */
//@Service
//public class EcodataService {
//    @Autowired
//    private EcodataMapper ecodataMapper;
//
//    public Ecodata get(Long datanumId) {
//        Ecodata ecodata = ecodataMapper.get(datanumId);
//        String s = JSONObject.toJSONString(ecodata);
//        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("myindex1", "article", "4").setSource(s, XContentType.JSON);
//        indexRequestBuilder.get();
//    }
//}
