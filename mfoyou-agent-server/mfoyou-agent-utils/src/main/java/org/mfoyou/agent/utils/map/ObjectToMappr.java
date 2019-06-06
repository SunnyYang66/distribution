package org.mfoyou.agent.utils.map;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMappr {
	
	public static  DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Map<String, Object> toMap() {
		return ObjectToMap(this);
	}

	public static Map<String, Object> ObjectToMap(Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(object == null)return map;
		Field[] fields = object.getClass().getDeclaredFields();
		if (fields != null) {
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					map.put(field.getName(), field.get(object));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	public static Map<String, Object> ObjectToMapM(Object object) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(object == null)return map;
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    String type = field.getType().getName();
                    Object value = field.get(object);
                    if((Date.class.getName().equals(type)) && (value != null)){
                        map.put(field.getName(), ((Date)value).getTime()); 
                    }
                    else{
                        map.put(field.getName(), field.get(object)); 
                    }
                    
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


	public static Map<String, String> ObjectToMaps(Object object) {
		Map<String, String> map = new HashMap<String, String>();
		if(object == null)return map;
		Field[] fields = object.getClass().getDeclaredFields();
		if (fields != null) {
			for (Field field : fields) {
				try {
					
					field.setAccessible(true);
					if (field.get(object) != null) {
						String type = field.getType().getName();
						Object value = field.get(object);
						if(Date.class.getName().equals(type)){
							value = format.format(value);
						}
						map.put(field.getName(),value.toString());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return map;
	}
}
