package com.easycore.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

public class MyBeanUtils {

	// 设置bean中所有String型属性值null->""并trim空格
	public static void setStringProps(Object mybean, Class<?> beanClazz) {
		Field[] fs = beanClazz.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true);
			if (f.getType().toString().contains("String")) {
				try {
					if (null == f.get(mybean))
						f.set(mybean, "");
					else
						f.set(mybean, f.get(mybean).toString().trim());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 设置bean中所有String型属性值trim空格
	public static void setStringPropsTrim(Object mybean, Class<?> beanClazz) {
		Field[] fs = beanClazz.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true);
			if (f.getType().toString().contains("String")) {
				try {
					Object val = f.get(mybean);
					if (null != val) {
						String res = val.toString().trim();
						f.set(mybean, res);
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 获取bean中所有null值字段名
	public static List<String> getNullProps(Object mybean, Class<?> beanClazz) {
		List<String> props = new ArrayList<String>();
		Field[] fs = beanClazz.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true);
			try {
				if (null == f.get(mybean))
					props.add(f.getName());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return props;
	}

	// 追加拷贝字段属性(源bean中null值字段不拷贝到目标bean)
	public static void copyPropsSkipNull(Object source, Object target,
			Class<?> beanClazz) {
		List<String> props = getNullProps(source, beanClazz);
		String[] nullprops = props.toArray(new String[props.size()]);
		BeanUtils.copyProperties(source, target, nullprops);
	}

}
