package org.mfoyou.agent.utils.common;

import java.util.ArrayList;
import java.util.List;

import org.mfoyou.agent.utils.exp.ArgsNullException;
import org.mfoyou.agent.utils.exp.DataNullException;
import org.mfoyou.agent.utils.exp.DataRangErrorException;


public class ObjectUtil {
    private static Logger logger = Logger.getLogger(ObjectUtil.class);
	
	public static<T> List<T> arrary2List(T[] ts){
		if(ts==null){
			return null;
		}
		List<T> list=new ArrayList<>();
		for(T t:ts){
			list.add(t);
		}
		return list;
	}
	
	public static void checkInputValue(Object ...objects){
	    int index = 0;
	    for(Object ob:objects){
	        if(ob == null){
	            logger.error("checkInputValue 数组第"+index+"个参数为空，请确认");
	           throw new ArgsNullException(); 
	        }
	        index++;
	    }
	}
	
	public static void checkDataValue(Object ...objects){
	    int index = 0;
        for(Object ob:objects){
            if(ob == null){
                logger.error("checkDataValue 数组第"+index+"个参数为空，请确认");
               throw new DataNullException(); 
            }
            index++;
        }
    }
	public static void checkDataRange(Integer object,Integer minValue,Integer maxValue){
	    checkDataValue(object);
	    if(object < minValue) throw new DataRangErrorException(); 
	    if(object > maxValue) throw new DataRangErrorException(); 
    }

}
