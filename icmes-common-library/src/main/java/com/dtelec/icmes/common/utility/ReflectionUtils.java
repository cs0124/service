package com.dtelec.icmes.common.utility;

import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withAnnotation;
import static org.reflections.ReflectionUtils.withModifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

public class ReflectionUtils {
    
	private static Pattern pattern = Pattern.compile("\\.([^\\.]+)$", Pattern.CASE_INSENSITIVE);
	
	public static <T> Set<Class<? extends T>> getAllSubClass(Class<T> type, String packagePath) {
		FilterBuilder filter = new FilterBuilder().includePackage(packagePath);
		ConfigurationBuilder builder = new ConfigurationBuilder()
				.setUrls(ClasspathHelper.forClass(type))
				.addUrls(ClasspathHelper.forPackage(packagePath))
	            .setScanners(new SubTypesScanner())
	            .filterInputsBy((path) -> {
	    		    Matcher matcher = pattern.matcher(path);
	    		    if (matcher.find()) {
	    		    	String ext = matcher.group(1).toLowerCase();
	    		    	if ("class".equals(ext)) {
	    		    		return filter.apply(path);
	    		    	}
	    		    }
	    		    return false;
	    		});
		
		Reflections reflections = new Reflections(builder);
		Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
		
		return classes;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> Set<Class<? extends T>> getAllAnnotationClass(Class<T> type, String packagePath, Class<? extends Annotation> annotation) {
		FilterBuilder filter = new FilterBuilder().includePackage(packagePath);
		ConfigurationBuilder builder = new ConfigurationBuilder()
				.setUrls(ClasspathHelper.forClass(type))
				.addUrls(ClasspathHelper.forPackage(packagePath))
	            .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner())
	            .filterInputsBy((path) -> {
	    		    Matcher matcher = pattern.matcher(path);
	    		    if (matcher.find()) {
	    		    	String ext = matcher.group(1).toLowerCase();
	    		    	if ("class".equals(ext)) {
	    		    		return filter.apply(path);
	    		    	}
	    		    }
	    		    return false;
	    		});
		
		Reflections reflections = new Reflections(builder);
		Set<Class<? extends T>> classes = new HashSet<Class<? extends T>>();
		reflections.getTypesAnnotatedWith(annotation).forEach((cls) -> {
            classes.add((Class<? extends T>)cls);
		});
		
		return classes;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> List<Method> getAllAnnotationMethodFromClass(Class<T> type, String packagePath, Class<? extends Annotation> annotation) {
		List<Method> allMethods = new ArrayList<Method>();
		Set<Class<? extends T>> classes = getAllSubClass(type, packagePath);
		for (Class<?> cls : classes) {
			Set<Method> methods = getAllMethods(cls, withModifier(Modifier.PUBLIC), withAnnotation(annotation));
			for (Method func : methods) {
				allMethods.add(func);
			}
        }
		
		return allMethods;
	}
	
	
	public static <T> Type[] fetchTypeArgumentsOfGenericClassByInstance(T instance) {
		Type[] types = null;
		
		if (instance != null) {
			Type superClass = instance.getClass().getGenericSuperclass();
			if (superClass instanceof ParameterizedType) {
				types = ((ParameterizedType)superClass).getActualTypeArguments();
			}
			else {
				types = new Type[] {Object.class};
			}
		}
		if (types == null)
			types = new Type[0];
		
		return types;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T asClassInstance(Object obj, Class<T> tClass) {
	    return tClass.isInstance(obj) ? (T)obj : null;
	}
	
}
