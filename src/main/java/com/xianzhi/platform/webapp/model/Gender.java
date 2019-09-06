package com.xianzhi.platform.webapp.model;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
	M ("M", 1, "男"),
	F ("F", 2, "女"),
	U ("U", 0, "未知");
	
	private static Map<String, Gender> code2Enum = new HashMap<>();
	private static Map<String, Gender> name2Enum = new HashMap<>();
	private static Map<Integer, Gender> weixinId2Enum = new HashMap<>();
	
	static {
		for (Gender value : Gender.values()) {
			code2Enum.put(value.getCode(), value);
			name2Enum.put(value.getName(), value);
			weixinId2Enum.put(value.getWeixinId(), value);
		}
	}
	
	private final String code;
	private final String name;
	private final int weixinId;
	
	private Gender(String code, int weixinId, String name) {
		this.code = code;
		this.weixinId = weixinId;
		this.name = name;
	}

    public static Gender getByName(String genderName) {
		return name2Enum.get(genderName);
    }

    public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}

	public int getWeixinId() {
		return weixinId;
	}

	public static Gender getByCode(String code) {
		return code2Enum.get(code);
	}
	
	public static Gender getByWeixinId(int weixinId) {
		return weixinId2Enum.get(weixinId);
	}
}
