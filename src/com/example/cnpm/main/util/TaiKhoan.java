package com.example.cnpm.main.util;

public class TaiKhoan {
	private String tentk;
	private String mk;
	private int cmnd;
	
	public TaiKhoan() {
		
	}
	
	public TaiKhoan(String tentk, String mk, int cmnd) {
		super();
		this.tentk = tentk;
		this.mk = mk;
		this.cmnd = cmnd;
	}
	public String getTentk() {
		return tentk;
	}
	public void setTentk(String tentk) {
		this.tentk = tentk;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public int getCmnd() {
		return cmnd;
	}
	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
}
