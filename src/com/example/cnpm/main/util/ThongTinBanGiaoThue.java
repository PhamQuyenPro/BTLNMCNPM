package com.example.cnpm.main.util;

import java.util.Vector;

public class ThongTinBanGiaoThue {
	
	private int stt;
	private	String maLoai;
	private int soLuong;
	private String trangThai_Truoc;
	private String trangThai_Sau;
	private int maBanGiao;
	private int maHoatDong;
	
	public ThongTinBanGiaoThue() {
		  
	  }
	
	public String getMaLoai() {
		return maLoai;
	}
	public ThongTinBanGiaoThue(int stt, String maLoai, int soLuong, String trangThaiTruoc, String trangThaiSau, int maBanGiao,
			int maHoatDong) {
		
		this.stt = stt;
		this.maLoai = maLoai;
		this.soLuong = soLuong;
		this.setTrangThai_Truoc(trangThaiTruoc);
		if (!trangThaiSau.isBlank()) this.setTrangThai_Sau(trangThaiSau);
		this.maBanGiao = maBanGiao;
		this.maHoatDong = maHoatDong;
	}
	
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getMaBanGiao() {
		return maBanGiao;
	}
	public void setMaBanGiao(int maBanGiao) {
		this.maBanGiao = maBanGiao;
	}
	public int getMaHoatDong() {
		return maHoatDong;
	}
	public void setMaHoatDong(int maHoatDong) {
		this.maHoatDong = maHoatDong;
	}

	public String getTrangThai_Truoc() {
		return trangThai_Truoc;
	}

	public void setTrangThai_Truoc(String trangThai_Truoc) {
		this.trangThai_Truoc = trangThai_Truoc;
	}

	public String getTrangThai_Sau() {
		return trangThai_Sau;
	}

	public void setTrangThai_Sau(String trangThai_Sau) {
		this.trangThai_Sau = trangThai_Sau;
	}
}
