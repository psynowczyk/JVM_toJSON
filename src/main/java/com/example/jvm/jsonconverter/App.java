package com.example.jvm.jsonconverter;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class App {
	
	public static String toJSON(Object obj, Boolean format) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder builder = new StringBuilder();
		Field[] flds = obj.getClass().getDeclaredFields();
		builder.append("{");
        for (int x = 0; x < flds.length; x++) {
        	if (format) builder.append("\n\t");
        	
        	// append field name
        	builder.append('"').append(flds[x].getName()).append('"').append(": ");
        	
        	// append ArrayList
        	if (flds[x].getType().toString().equals("class java.util.ArrayList")) {
        		Object array = flds[x].get(obj);
        		builder.append(appendArray(array, "ArrayList", true));
        	}
        	else if (flds[x].getType().toString().equals("class [Ljava.lang.String;")) {
        		Object array = flds[x].get(obj);
        		builder.append(appendArray(array, "String", true));
        	}
        	else if (flds[x].getType().toString().equals("class [Ljava.lang.Integer;")) {
        		Object array = flds[x].get(obj);
        		builder.append(appendArray(array, "Integer", true));
        	}
        	else {
	        	builder.append('"').append(flds[x].get(obj)).append('"');
        	}
        	if (x != flds.length-1) builder.append(",");
        }
        if (format) builder.append("\n");
        builder.append("}");
		return builder.toString();
	}
	
	public static String appendArray(Object array, String type, Boolean format) {
		StringBuilder builder = new StringBuilder();
    	builder.append("[");
    	int length = 0;
    	if (type == "ArrayList") length = ((ArrayList) array).size();
    	else if (type == "String") length = ((String[]) array).length;
    	else if (type == "Integer") length = ((Integer[]) array).length;
    	for (int x = 0; x < length; x++) {
    		if (format) builder.append("\n\t\t");
    		builder.append('"');
    		if (type == "ArrayList") builder.append(((ArrayList) array).get(x).toString());
        	else if (type == "String") builder.append(((String[]) array)[x]);
        	else if (type == "Integer") builder.append(((Integer[]) array)[x].toString());
    		builder.append('"');
    		if (x != length-1) builder.append(",");
    	}
    	if (format) builder.append("\n\t");
    	builder.append("]");
    	return builder.toString();
	}
	
    public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException {
    	
    	Class<?> cls;
    	try {
	    	cls = Class.forName("com.example.jvm.jsonconverter.Person");
			Object obj = cls.newInstance();
			
			// usage (object, format: true/false)
			String json = toJSON(obj, true);
			
			System.out.println(json);
    	}
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (InstantiationException e) { e.printStackTrace(); }
    }
}
