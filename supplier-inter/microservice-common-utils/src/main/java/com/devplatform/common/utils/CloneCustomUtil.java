package com.devplatform.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.devplatform.common.annotation.AuthCustom;

public class CloneCustomUtil {

	public static Object clone(Class<?> a, Object source) {
		try {
			Object res = a.newInstance();
			Method[] sourceMethods = source.getClass().getDeclaredMethods();
			Field[] fe = a.getDeclaredFields();// getFields();
			for (Field field : fe) {
				if (Modifier.isFinal(field.getModifiers())) {
					continue;
				}
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				String srcFieldName = "";
				AuthCustom authCustom = field.getAnnotation(AuthCustom.class);  
				if(authCustom != null){  
					srcFieldName = authCustom.filed();
				}else{
					srcFieldName = field.getName();
				}
				String targetFieldName = field.getName();
				Class<?> fieldType = field.getType();
				for (Method method: sourceMethods){
					String mname = method.getName();
					String gm = getMethodName(srcFieldName);
					String sm = setMethodName(targetFieldName);
					if(mname.equals(gm)){
						Object o = method.invoke(source);
						Method m = a.getDeclaredMethod(sm, fieldType);
						m.invoke(res, o);
					}
				}
				
			}
			return res;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return null;

	}
    public static String getMethodName(String fieldName){
    	String gm = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
    	return gm; 
    }
    public static String setMethodName(String fieldName){
    	String gm = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
    	return gm; 
    }
}
