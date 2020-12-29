package com.example.cnpm.main.util;

public class ThueNhaVanHoa {
	private int cmnd;
	private int phi;
	private int maHoatDong;
	
	public ThueNhaVanHoa() {
		
	}

	public ThueNhaVanHoa(int cmnd, int phi, int maHoatDong) {
		super();
		this.setCmnd(cmnd);
		this.setPhi(phi);
		this.setMaHoatDong(maHoatDong);
	}

	public int getCmnd() {
		return cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	public int getPhi() {
		return phi;
	}

	public void setPhi(int phi) {
		this.phi = phi;
	}

	public int getMaHoatDong() {
		return maHoatDong;
	}

	public void setMaHoatDong(int maHoatDong) {
		this.maHoatDong = maHoatDong;
	}
}
