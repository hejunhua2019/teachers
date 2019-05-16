package cn.com.yajiaotong.wface.util;

import java.lang.reflect.Field;
/**
 * 分页帮助类
 * @author yigh
 *
 */
public class ReflectHelper {
	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				e.getStackTrace();
			}
		}
		return null;
	}
    
	public static Object getValueByFieldName(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,IllegalArgumentException, IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		Object value = null;
		if (field != null) {
			if (field.isAccessible()) {
				value = field.get(obj);
			} else {
				field.setAccessible(true);
				value = field.get(obj);
				field.setAccessible(false);
			}
		}
		return value;
	}
    
	public static void setValueByFieldName(Object obj, String fieldName,Object value
			) throws SecurityException, NoSuchFieldException,IllegalArgumentException, IllegalAccessException {
		Field field=null;
		try {
			field = obj.getClass().getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			field = obj.getClass().getSuperclass().getDeclaredField(fieldName);
		} 
		if (field.isAccessible()) {
			field.set(obj, value);
		} else {
			field.setAccessible(true);
			field.set(obj, value);
			field.setAccessible(false);
		}
		
	}
//	public static void setValueByFieldName(Object obj, String fieldName,Object value
//			) throws SecurityException, NoSuchFieldException,IllegalArgumentException, IllegalAccessException {
//		Field field = obj.getClass().getDeclaredField(fieldName);
//		if (field.isAccessible()) {
//			field.set(obj, value);
//		} else {
//			field.setAccessible(true);
//			field.set(obj, value);
//			field.setAccessible(false);
//		}
//	}
}   