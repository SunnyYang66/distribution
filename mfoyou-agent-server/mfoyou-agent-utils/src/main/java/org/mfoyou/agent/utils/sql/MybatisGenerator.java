package org.mfoyou.agent.utils.sql;

import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisGenerator {
    private static Logger logger = Logger.getLogger(MybatisGenerator.class);

    public static <T> void setLimit(T example, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null)
            pageIndex = 1;
        if (pageSize == null)
            pageSize = 100;
        else
            pageSize = Math.min(100, pageSize);
        try {
            Field fieldLimitStart = example.getClass().getDeclaredField("limitStart");
            fieldLimitStart.setAccessible(true);
            fieldLimitStart.set(example, (pageIndex - 1) * pageSize);
            Field fieldLimitEnd = example.getClass().getDeclaredField("limitEnd");
            fieldLimitEnd.setAccessible(true);
            fieldLimitEnd.set(example, pageSize);
        } catch (Exception e) {
            logger.error(example.toString(), e);
            e.printStackTrace();
        }
    }
    
    

    public static <D, E> void makeExample(D dataObject, E exampleObject) {
        if (dataObject == null)
            return;
        Method[] dMethods = dataObject.getClass().getDeclaredMethods();
        Method[] eMethods = exampleObject.getClass().getDeclaredMethods();
        Map<String, Method> map = new HashMap<>();
        for (Method method : eMethods) {
            map.put(method.getName(), method);
        }
        for (Method method : dMethods) {
            String name = method.getName();
            if (name.startsWith("get")) {
                try {
                    Object value = method.invoke(dataObject);
                    if (value != null) {//反射  到example
                        Method eMethod = map.get("and" + name.substring(3) + "EqualTo");
                        if (eMethod != null) {
                            eMethod.invoke(exampleObject, value);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }

    }
    


    public static String makeIn(List<?> list) {
        String string = "(" + list.get(0);

        for (int i = 1; i < list.size(); i++) {
            string += "," + list.get(i);

        }
        string += ")";
        logger.info(string);
        return string;
    }

    public static <Entity, Example, Mapper> ArrayListObject<Entity> getList(Entity mfoyouWorkerInvitation, Integer pageId, Integer pageSize, Class<Example> classExample,
                                                                            Mapper mapper) throws Exception {
        Example example = classExample.newInstance();
        MybatisGenerator.setLimit(example, pageId, pageSize);
        MybatisGenerator.makeExample(mfoyouWorkerInvitation, classExample.getMethod("or").invoke(example));

        Integer count = (Integer) mapper.getClass().getMethod("countByExample", classExample).invoke(mapper, example);
        @SuppressWarnings("unchecked")
		List<Entity> list = (List<Entity>) mapper.getClass().getMethod("selectByExample", classExample).invoke(mapper, example);

        return ArrayListObject.bliudArrayList(list, pageId, pageSize, count);

    }
    public static <T> T getOneValue(List<T> list){
    	if(list==null|| list.size()==0){
    		return null;
    	}
    	return list.get(0);
    }

}
