package com.citi.argentina.ip.gpservice.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MergeObject {

	private static Map<Class, PropertyDescriptor[]> descriptorsMap = new HashMap<>();

	public static <T> T mergetwoObjects(Object updatedObject, Object originalObject) throws Exception {

		Class originalClass = originalObject.getClass();
		Class updatedClass = updatedObject.getClass();
		/*if ( !originalClass.equals(updatedClass)) {
throw new Exception();
}*/
		PropertyDescriptor[] descriptors = descriptorsMap.get(originalClass);
		if (descriptors == null) {
			descriptors = PropertyUtils.getPropertyDescriptors(originalClass);
			descriptorsMap.put(originalClass, descriptors);
		}
		for (PropertyDescriptor descriptor : descriptors) {
			if (PropertyUtils.isReadable(originalObject, descriptor.getName()) && PropertyUtils.isWriteable(originalObject, descriptor.getName())) {
				Method readMethod = descriptor.getReadMethod();
				Object value = null;
				try {
					value = readMethod.invoke(updatedObject);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (value != null) {
					Method writeMethod = descriptor.getWriteMethod();
					try {
						writeMethod.invoke(originalObject, value);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return (T) originalObject;
	}
}