package org.mfoyou.agent.utils.json;

import org.mfoyou.agent.utils.common.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONMaker {

    static Logger logger = Logger.getLogger(JSONMaker.class);

    public static String addListItem(String json, String key, Object object) {
        if (json == null || json.equals("")) {
            json = "{}";
        }
        JSONObject jObject = JSON.parseObject(json);
        JSONArray jArray = jObject.getJSONArray(key);
        if (jArray == null) {
            jArray = new JSONArray();
        }
        jArray.add(object);
        jObject.put(key, jArray);
        return jObject.toJSONString();
    }
    public static JSONObject addItem(Object srcObj, String key, Object object) {
        JSONObject jObject = (JSONObject) JSON.toJSON(srcObj);
        jObject.put(key, object);
        return jObject;
    }

    public static JSONObject AttachSubJsonString(Object object, String srcKey) {
        JSONObject jObject = (JSONObject) JSON.toJSON(object);
        String string = (String) jObject.get(srcKey);
        try {
            if (string != null && (!string.equals(""))) {
                JSONObject subObject = JSON.parseObject(string);
                jObject.putAll(subObject);
            }
        } catch (Exception e) {
            logger.error(string, e);
            e.printStackTrace();
        }
        return jObject;
    }

    public static JSONObject mergeJson(Object object1, Object object2) {
        if (object1 == null && object2 == null)
            return null;
        JSONObject jObject = (JSONObject) JSON.toJSON(object1);
        if (object2 != null)
            jObject.putAll((JSONObject) JSON.toJSON(object2));
        return jObject;
    }

    public static JSONObject mergeJson(Object object1, String json) {
        JSONObject jObject = (JSONObject) JSON.toJSON(object1);
        jObject.putAll((JSONObject) JSON.parseObject(json));
        return jObject;
    }

    public static JSONObject mergeJson(Object object1, Object object2, String[] keys) {
        if (object1 == null && object2 == null)
            return null;
        if (keys == null) {
            return mergeJson(object1, object2);
        }

        JSONObject jObject = (JSONObject) JSON.toJSON(object1);
        if (object2 == null) {
            return jObject;
        }
        JSONObject jObject2 = (JSONObject) JSON.toJSON(object2);
        for (String key : keys) {
            jObject.put(key, jObject2.get(key));
        }
        return jObject;
    }

    public static JSONObject mergeJson(String json1, String json2) {
        JSONObject jObject = (JSONObject) JSON.parseObject(json1);
        jObject.putAll((JSONObject) JSON.parseObject(json2));
        return jObject;
    }

    public static JSONObject mergeFilterJson(String keys[], Object... json) {
        if (json == null || json.length == 0)
            return null;

        JSONObject jObject = (JSONObject) JSON.toJSON(json[0]);
        for (int i = 1; i < json.length; i++) {
            if(json[i] == null){
                logger.error("mergeFilterJson attach null object " + jObject.toJSONString());
                continue;
            }
            jObject.putAll((JSONObject) JSON.toJSON(json[i]));
        }
        JSONObject ret = new JSONObject();
        for (String key : keys) {
            ret.put(key, jObject.get(key));
        }
        return ret;
    }

}
