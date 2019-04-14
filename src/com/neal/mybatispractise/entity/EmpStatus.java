package com.neal.mybatispractise.entity;

public enum EmpStatus {
	LOGIN(100, "LOGIN"), LOGOUT(200, "LOGOUT"), REMOVED(300, "INVALID");

	private Integer code;
	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private EmpStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public static EmpStatus getEmpStatusByCode(Integer code){
		switch (code) {
		case 100:
			return LOGIN;
		case 200:
			return LOGOUT;
		case 300:
			return REMOVED;
		default:
			return null;
		}
	}

}
