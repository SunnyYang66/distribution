package org.mfoyou.agent.utils.map;

import java.awt.Point;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.Logger;


public class MapObjectTrans {

    static Logger logger = Logger.getLogger(Logger.class);

    public static Map<String, String> objectToMap(Object object) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get(object) != null) {
                        String type = field.getType().getName();
                        Object value = field.get(object);
                        if (Date.class.getName().equals(type)) {
                            value = DateUtils.datetimeFormat.format(value);
                        }
                        map.put(field.getName(), value.toString());
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
    public static Map<String, String> objectToMapV2(Object object) {
    	
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = object.getClass().getDeclaredFields();
        Field[] fields2 = object.getClass().getSuperclass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get(object) != null) {
                        String type = field.getType().getName();
                        Object value = field.get(object);
                        if (Date.class.getName().equals(type)) {
                            value = DateUtils.datetimeFormat.format(value);
                        }
                        map.put(field.getName(), value.toString());
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        if (fields2 != null) {
            for (Field field : fields2) {
                try {
                    field.setAccessible(true);
                    if (field.get(object) != null) {
                        String type = field.getType().getName();
                        Object value = field.get(object);
                        if (Date.class.getName().equals(type)) {
                            value = DateUtils.datetimeFormat.format(value);
                        }
                        map.put(field.getName(), value.toString());
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
    public static Map<String, Object> objectToMapObject(Object object) {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                try {

                    field.setAccessible(true);
                    if (field.get(object) != null) {
                        Object value = field.get(object);
                        map.put(field.getName(), value);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    public static <T> T mapToObject_Sql(Map<String, Object> map, Class<T> beanClass) {
        if (map == null)
            return null;

        T obj = null;
        try {
            obj = beanClass.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                Object value = map.get(field.getName());
                if (value == null)
                    continue;
                field.setAccessible(true);
                String fieldTypeName = field.getType().getName();
                if (fieldTypeName.equals(String.class.getName())) {
                    field.set(obj, value);
                } else if (fieldTypeName.equals(Integer.class.getName())) {
                    field.set(obj, (int) (value));
                } else if (fieldTypeName.equals(Long.class.getName())) {
                    field.set(obj, (long) (value));
                } else if (fieldTypeName.equals(Double.class.getName())) {
                    field.set(obj, (double) (value));
                } else if (fieldTypeName.equals(Float.class.getName())) {
                    field.set(obj, (float) (value));
                } else if (fieldTypeName.equals(Date.class.getName())) {
                    field.set(obj, (value));
                }

            }
        } catch (Exception e) {
            logger.error("", e);
            e.printStackTrace();
        }

        return obj;
    }

    public static <T> T mapToObject(Map<String, String> map, Class<T> beanClass) {
        if (map == null)
            return null;

        T obj = null;
        try {
            obj = beanClass.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                String value = map.get(field.getName());
                if (value == null)
                    continue;
                field.setAccessible(true);
                String fieldTypeName = field.getType().getName();
                if (fieldTypeName.equals(String.class.getName())) {
                    field.set(obj, value);
                } else if (fieldTypeName.equals(Integer.class.getName())) {
                    field.set(obj, Integer.parseInt(value));
                } else if (fieldTypeName.equals(Long.class.getName())) {
                    field.set(obj, Long.parseLong(value));
                } else if (fieldTypeName.equals(Double.class.getName())) {
                    field.set(obj, Double.parseDouble(value));
                } else if (fieldTypeName.equals(Float.class.getName())) {
                    field.set(obj, Float.parseFloat(value));
                } else if (fieldTypeName.equals(Date.class.getName())) {
                    field.set(obj, DateUtils.datetimeFormat.parse(value));
                }

            }
        } catch (Exception e) {
            logger.error("", e);
            e.printStackTrace();
        }

        return obj;
    }

    public static Object mapToObject1(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }

        return obj;
    }

    public static Map<String, Object> objectToMap1(Object obj) throws Exception {
        if (obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }

    public static Object mapToObject2(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    public static Map<String, Object> objectToMap2(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    @SuppressWarnings("unchecked")
    public static <M, T> Map<M, T> ListToMap(List<T> list, Class<T> beanClass, String fieldName) {

        Field field = null;
        Map<M, T> retMap = new HashMap<>();
        try {
            field = beanClass.getDeclaredField(fieldName);

        } catch (Exception e) {
            //logger.error("", e);
        }
        try {
            if (field == null) {
                field = beanClass.getSuperclass().getDeclaredField(fieldName);
            }
        } catch (Exception e) {
            logger.error("", e);
            return retMap;
        }
        field.setAccessible(true);

        for (T t : list) {
            try {
                retMap.put((M) field.get(t), t);
            } catch (Exception e) {
                logger.error("", e);
            }
        }

        return retMap;
    }

    @SuppressWarnings("unchecked")
	public static <M, T> List<M> getListItem(List<T> list, Class<T> beanClass, String fieldName) {
        Field field = null;
        List<M> retMap = new ArrayList<>();
        try {
            field = beanClass.getDeclaredField(fieldName);

        } catch (Exception e) {
            logger.error("", e);
        }
        try {
            if (field == null) {
                field = beanClass.getSuperclass().getDeclaredField(fieldName);
            }
        } catch (Exception e) {
            logger.error("", e);
            return retMap;
        }
        field.setAccessible(true);

        for (T t : list) {
            try {
                retMap.add((M) field.get(t));
            } catch (Exception e) {
                logger.error("", e);
            }
        }

        return retMap;
    }

    public static void main(String args[]) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1, 1));
        list.add(new Point(2, 2));

        Map<Integer, Point> m1 = ListToMap(list, Point.class, "x");
        Map<String, Point> m2 = ListToMap(list, Point.class, "x");
        System.out.println(m1.get(1));
        System.out.println(m2.get(1L));

    }

}
