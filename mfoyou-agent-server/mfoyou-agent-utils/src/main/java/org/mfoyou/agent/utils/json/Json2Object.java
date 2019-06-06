package org.mfoyou.agent.utils.json;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.utils.common.MfoyouMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Json2Object {

    private static Logger logger = LoggerFactory.getLogger(Json2Object.class);

    public static MfoyouMap json2MfoyouMap(String json) {
        logger.info(json);
        return MfoyouMap.fromHashMap(json2Map(json));
    }

    public static Map<String, String> json2Map(String json) {
        logger.info(json);
        JSONObject object = JSON.parseObject(json);
        Map<String, String> map = new HashMap<>();
        for (String key : object.keySet()) {
            if(object.getString(key) != null)map.put(key, object.getString(key));
        }
        return map;
    }
    public static JSONObject json2JsonObject(String json) {
        logger.info(json);
        JSONObject object = JSON.parseObject(json);
        return object;
    }

    public static <T> T json2Object(String json, Class<T> beanClass) {
        logger.info(json);
        T objet = null;
        try {
            objet = JSON.parseObject(json, beanClass);
        } catch (Exception e) {
            logger.error(json, e);
            e.printStackTrace();
        }
        return objet;

    }

    public static <T> List<T> json2Arrary(String json, Class<T> beanClass) {
        logger.info(json);
        List<T> objet = null;
        try {
            objet = JSON.parseArray(json, beanClass);
        } catch (Exception e) {
            logger.error(json, e);
            e.printStackTrace();
        }
        return objet;

    }

    public static <T> T jsonToObject(String json, Class<T> beanClass) {
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            T obj = beanClass.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                String key = field.getName();
                if (!jsonObject.containsKey(key))
                    continue;
                field.setAccessible(true);
                String fieldTypeName = field.getType().getName();
                if (fieldTypeName.equals(String.class.getName())) {
                    field.set(obj, jsonObject.getString(key));
                } else if (fieldTypeName.equals(Integer.class.getName())) {
                    field.set(obj, jsonObject.getInteger(key));
                } else if (fieldTypeName.equals(Long.class.getName())) {
                    field.set(obj, jsonObject.getLong(key));
                } else if (fieldTypeName.equals(Double.class.getName())) {
                    field.set(obj, jsonObject.getDouble(key));
                } else if (fieldTypeName.equals(Float.class.getName())) {
                    field.set(obj, jsonObject.getFloat(key));
                } else if (fieldTypeName.equals(Date.class.getName())) {
                    field.set(obj, jsonObject.getDate(key));
                }
            }
            return obj;
        } catch (Exception e) {
            logger.error(json, e);
        }
        return null;
    }

}
