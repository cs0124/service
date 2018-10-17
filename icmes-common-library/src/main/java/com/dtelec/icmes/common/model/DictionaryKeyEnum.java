package com.dtelec.icmes.common.model;

/**
 * 整个微服务系统的全部字典KeyCode枚举
 * 
 * @author hlxu
 *
 */
public enum DictionaryKeyEnum {
	
	POWER_CUT_COMMIT("停电申请确认");
	
	private final String keyDesc;

	private DictionaryKeyEnum(String keyDesc) {
		this.keyDesc = keyDesc;
	}

	public static DictionaryKeyEnum getEnumByKey(String keyCode) {
		for (DictionaryKeyEnum item : DictionaryKeyEnum.values()) {
			if (item.name().equals(keyCode)) {
				return item;
			}
		}

		return null;
	}

	public String getKeyDesc() {
		return keyDesc;
	}
	
	public String getKeyCode() {
		return this.name();
	}
}
