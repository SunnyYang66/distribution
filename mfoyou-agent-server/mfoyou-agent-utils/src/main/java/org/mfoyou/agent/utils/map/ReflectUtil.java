package org.mfoyou.agent.utils.map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.mfoyou.agent.utils.common.UDate;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class ReflectUtil {

	private static final Logger LOGGER = Logger.getLogger(ReflectUtil.class);
	
	public static Boolean checkField(Object object,String[] fileds){
		Class<?> sC = object.getClass();
		Class<?> sSC = object.getClass().getSuperclass();
		for(String filedstring : fileds){
			Field desField = getField(sC,filedstring);
			if (desField == null && sSC != null) {
				desField = getField(sSC,filedstring);
			}
			if(desField == null)return false;
			try {
				desField.setAccessible(true);
				if(desField.get(object) == null){
					LOGGER.error(" "+filedstring+" not fund");
					return false;
				}
			} catch (Exception e) {
				LOGGER.error(JSON.toJSON(object), e);
				return false;
			}
		}
		return true;		
	}

	public static Boolean ObjectCopy(Object src, Object des) {

		try {
			Class<?> sC = src.getClass();
			Class<?> sSC = src.getClass().getSuperclass();
			Class<?> dC = des.getClass();
			Class<?> sDC = des.getClass().getSuperclass();
			Field[] fields = sC.getDeclaredFields();
			for (Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())) { // 璺宠繃闈欐�佸瓧娈�
					continue;
				}
				String fieldName = field.getName();
				field.setAccessible(true);
				Field desFields = getField(dC,fieldName);
				if (desFields == null && sDC != null) {
					desFields = getField(sDC,fieldName);
				}
				if (desFields != null) {
					desFields.setAccessible(true);
					desFields.set(des, field.get(src));
				}
			}
			if (sSC != null) {
				fields = sSC.getDeclaredFields();
				for (Field field : fields) {
					if (Modifier.isStatic(field.getModifiers())) { // 璺宠繃闈欐�佸瓧娈�
						continue;
					}
					String fieldName = field.getName();
					field.setAccessible(true);
					Field desFields = getField(dC,fieldName);
					if (desFields == null && sDC != null) {
						desFields = getField(sDC,fieldName);
					}
					if (desFields != null) {
						desFields.setAccessible(true);
						desFields.set(des, field.get(src));
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("", e);
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public static Boolean ObjectCopyNotNull(Object src, Object des) {

        try {
            Class<?> sC = src.getClass();
            Class<?> sSC = src.getClass().getSuperclass();
            Class<?> dC = des.getClass();
            Class<?> sDC = des.getClass().getSuperclass();
            Field[] fields = sC.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) { // 璺宠繃闈欐�佸瓧娈�
                    continue;
                }
                if(field.get(src)== null){
                    continue;
                }
                String fieldName = field.getName();
                field.setAccessible(true);
                Field desFields = getField(dC,fieldName);
                if (desFields == null && sDC != null) {
                    desFields = getField(sDC,fieldName);
                }
                if (desFields != null) {
                    desFields.setAccessible(true);
                    desFields.set(des, field.get(src));
                }
            }
            if (sSC != null) {
                fields = sSC.getDeclaredFields();
                for (Field field : fields) {
                    if (Modifier.isStatic(field.getModifiers())) { // 璺宠繃闈欐�佸瓧娈�
                        continue;
                    }
                    if(field.get(src)== null){
                        continue;
                    }
                    String fieldName = field.getName();
                    field.setAccessible(true);
                    Field desFields = getField(dC,fieldName);
                    if (desFields == null && sDC != null) {
                        desFields = getField(sDC,fieldName);
                    }
                    if (desFields != null) {
                        desFields.setAccessible(true);
                        desFields.set(des, field.get(src));
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("", e);
            e.printStackTrace();
            return false;
        }

        return true;
    }
	private static Field getField(Class<?> cs,String name){
		try {
			return cs.getDeclaredField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			return null;
		}
	}

	/**
	 * 鎶婁竴涓璞＄殑瀹炰緥瀛楁瀛楁鍚嶅拰鍊兼斁鍒癿ap閲�
	 *
	 * @param object
	 * @param dateFormat
	 *            鍙互涓簄ull.濡傛灉瀹炰緥瀛楁鏈塂ate鍨嬶紝鍙互鎸囧畾鏀惧叆map鐨勬牸寮�,姣斿yyyy-MM-dd
	 *            HH:mm:ss銆�
	 * @param includeFields
	 *            鍙互涓簄ull.鎸囧畾瑕佸寘鍚繘map鐨勫瓧娈靛悕锛屼负null浼氬寘鍚墍鏈夊疄渚嬪瓧娈点��
	 * @return
	 */
	public static Map<String, Object> fildsToMap(Object object, String dateFormat, Set<String> includeFields) {
		if (object == null) {
			return Collections.emptyMap();
		}

		Map<String, Object> map = Maps.newHashMap();

		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())) { // 璺宠繃闈欐�佸瓧娈�
					continue;
				}
				String fieldName = field.getName();
				if (includeFields != null && !includeFields.contains(fieldName)) {
					continue;
				}

				field.setAccessible(true);
				if (field.getType().equals(Date.class)) {
					if (StringUtils.isNotBlank(dateFormat)) {
						map.put(fieldName, UDate.formatDate((Date) field.get(object), dateFormat));
					} else {
						map.put(fieldName, ((Date) field.get(object)).getTime());
					}
				} else {
					map.put(fieldName, field.get(object));
				}
			}
		} catch (Exception e) {
			LOGGER.error(String.format("瀵硅薄杞琺ap鍑洪敊,fildsToMap(object=%s, dateFormat=%s, includeFields=%s)", object,
					dateFormat, includeFields), e);
		}

		return map;
	}

	/**
	 * 鎶婁竴涓璞＄殑瀹炰緥瀛楁瀛楁鍚嶅拰鍊兼斁鍒癿ap閲�,processor鐗堟湰锛屾洿鍔犵伒娲�
	 *
	 * @param object
	 * @param processor
	 *            field澶勭悊鍣�;(澶氱粍鍚堬紝灏戠户鎵�;鎻愬彇鍙樺寲鐐�)
	 * @return
	 */
	public static Map<String, Object> fildsToMap(Object object, IFieldProcessor processor) {
		if (object == null) {
			return Collections.emptyMap();
		}
		processor = processor == null ? DEFAULT_FIELD_PROCESSOR : processor;

		Map<String, Object> resultMap = Maps.newHashMap();

		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				Class<?> filedType = field.getType();

				field.setAccessible(true);
				Object fildeValue = field.get(object);

				Object reslut = processor.processField(fieldName, filedType, fildeValue);
				if (reslut == null) {
					resultMap.put(fieldName, reslut);
				}
			}

			processor.postProcess(resultMap);
		} catch (Exception e) {
			LOGGER.error(String.format("瀵硅薄杞琺ap鍑洪敊,fildsToMap(object=%s, processor=%s)", object, processor), e);
		}

		return resultMap;
	}

	private static final IFieldProcessor DEFAULT_FIELD_PROCESSOR = new GeneralFieldProccessor("yyyy-MM-dd", null);

	public static class GeneralFieldProccessor implements IFieldProcessor {

		protected String dateFormat;
		protected Set<String> includeFields;

		public GeneralFieldProccessor(String dateFormat, Set<String> includeFields) {
			this.dateFormat = dateFormat;
			this.includeFields = includeFields;
		}

		@Override
		public Object processField(String fieldName, Class<?> filedType, Object fildeValue) {
			if (includeFields != null && !includeFields.isEmpty() && !includeFields.contains(fieldName)) {
				return null;
			}

			if (Date.class.equals(filedType)) {
				if (StringUtils.isNotBlank(dateFormat)) {
					return UDate.formatDate((Date) fildeValue, dateFormat);
				} else {
					return ((Date) fildeValue).getTime();
				}
			}

			return null;
		}

		@Override
		public void postProcess(Map<String, Object> resultMap) {
			// nothing to do
		}

		@Override
		public String toString() {
			return "GeneralFieldProccessor{" + "dateFormat='" + dateFormat + '\'' + ", includeFields=" + includeFields
					+ '}';
		}
	}

	public interface IFieldProcessor {

		Object processField(String fieldName, Class<?> filedType, Object fildeValue);

		void postProcess(Map<String, Object> resultMap);
	}
}
