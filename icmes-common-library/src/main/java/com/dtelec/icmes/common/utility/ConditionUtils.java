package com.dtelec.icmes.common.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

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
	
	
	public List<String> getValueStringArray(String key, boolean removeEmpty) {
		List<String> result = null;
		if (key != null) {
			key = key.toLowerCase();
			List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				result = new ArrayList<>();
				for (String val : values) {
					if (removeEmpty == true) {
						String valStr = StringUtils.trimToNull(val);
						if (valStr == null) {
							continue;	
						}
					}
					result.add(val);
				}
			}
		}
		
		return result;
	}
	
	public List<Integer> getValueIntegerArray(String key, boolean removeEmpty) {
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
					if (removeEmpty == true && valInt == null) {
						continue;
					}
					result.add(valInt);
				}
			}
		}
		
		return result;
	}
	
	public List<Long> getValueLongArray(String key, boolean removeEmpty) {
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
					if (removeEmpty == true && valLong == null) {
						continue;
					}
					result.add(valLong);
				}
			}
		}
		
		return result;
	}
	
	public List<Boolean> getValueBooleanArray(String key, boolean removeEmpty) {
		List<Boolean> result = null;
		if (key != null) {
			key = key.toLowerCase();
		    List<String> values = this.paramMapping.get(key);
			if (values != null && values.isEmpty() == false) {
				result = new ArrayList<>();
				for (String val : values) {
					val = StringUtils.trimToNull(val);
					Boolean valBool = null;
					if ("1".equalsIgnoreCase(val) || "true".equalsIgnoreCase(val)) {
						valBool = true;
					}
					else if ("0".equalsIgnoreCase(val) || "false".equalsIgnoreCase(val)) {
						valBool = false;
					}
					
					if (removeEmpty == true && valBool == null) {
						continue;
					}
					result.add(valBool);
				}
			}
		}
		
		return result;
	}
	
}
