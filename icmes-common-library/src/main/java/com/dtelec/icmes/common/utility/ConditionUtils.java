package com.dtelec.icmes.common.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * ConditionUtils 用于分析 URL 查询字符
 * @author HLXu
 * @version 1.0
 */
public class ConditionUtils {

	/**
	 * URL 查询的正则表达式
	 */
	private static Pattern regex_params = Pattern.compile("[\\&]{0,1}\\s*([^\\=]+)\\s*\\=\\s*([^\\=\\&]*)", Pattern.CASE_INSENSITIVE & Pattern.MULTILINE);
	private Map<String, List<String>> paramMapping;	
	
	public ConditionUtils(String condition) {
		paramMapping = new HashMap<>();
		Matcher matcher = regex_params.matcher(condition);
		
		while (matcher.find()) {
			String key = matcher.group(1).toLowerCase();
			String val = matcher.group(2);
			
			List<String> values = null;
			if (paramMapping.containsKey(key)) {
				values = paramMapping.get(key);
			}
			else {
				values = new ArrayList<>();
				paramMapping.put(key, values);
			}
			
			values.add(val);
		}
	}
	
	public String getValueString(String key, String defVal) {
		String result = defVal;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				result = values.get(0);
			}
		}
		
		return result;
	}
	
	public Integer getValueInteger(String key, Integer defVal) {
		Integer result = defVal;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				try {
					result = Integer.valueOf(values.get(0));	
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public Long getValueLong(String key, Long defVal) {
		Long result = defVal;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				try {
					result = Long.valueOf(values.get(0));	
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public Boolean getValueBoolean(String key, Boolean defVal) {
		Boolean result = defVal;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				try {
					String valStr = values.get(0);
					if ("1".equalsIgnoreCase(valStr) || "true".equalsIgnoreCase(valStr)) {
						result = true;
					}
					else if ("0".equalsIgnoreCase(valStr) || "false".equalsIgnoreCase(valStr)) {
						result = false;
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	
	public List<String> getValueStringArray(String key) {
		List<String> result = null;
		if (key != null) {
			key = key.toLowerCase();
		    result = this.paramMapping.get(key);
		}
		
		return result;
	}
	
	public List<Integer> getValueIntegerArray(String key) {
		List<Integer> result = null;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				result = new ArrayList<>();
				for (String val : values) {
					Integer valInt = null;
					try {
						valInt = Integer.valueOf(val);	
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					result.add(valInt);
				}
			}
		}
		
		return result;
	}
	
	public List<Long> getValueLongArray(String key) {
		List<Long> result = null;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				result = new ArrayList<>();
				for (String val : values) {
					Long valLong = null;
					try {
						valLong = Long.valueOf(val);	
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					result.add(valLong);
				}
			}
		}
		
		return result;
	}
	
	public List<Boolean> getValueBooleanArray(String key) {
		List<Boolean> result = null;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				result = new ArrayList<>();
				for (String val : values) {
					Boolean valInt = null;
					if ("1".equalsIgnoreCase(val) || "true".equalsIgnoreCase(val)) {
						valInt = true;
					}
					else if ("0".equalsIgnoreCase(val) || "false".equalsIgnoreCase(val)) {
						valInt = false;
					}
					result.add(valInt);
				}
			}
		}
		
		return result;
	}
	
}
