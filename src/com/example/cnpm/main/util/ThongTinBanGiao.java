package com.example.cnpm.main.util;

public class ThongTinBanGiao {	
	
	private int stt;
	private String maLoai;
	private int soLuong;
	private String trangthai_truoc;
	private String trangthai_sau;
	private int maBanGiao;
	private int maHoatDong;


	public ThongTinBanGiao(int stt, String maLoai, int soLuong, String trangthai_truoc, String trangthai_sau,
			int maBanGiao, int maHoatDong) {
		super();
		this.stt = stt;
		this.maLoai = maLoai;
		this.soLuong = soLuong;
		this.trangthai_truoc = trangthai_truoc;
		this.trangthai_sau = trangthai_sau;
		this.maBanGiao = maBanGiao;
		this.maHoatDong = maHoatDong;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getMaLoai() {
		return maLoai;
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

	public String getTrangthai_truoc() {
		return trangthai_truoc;
	}

	public void setTrangthai_truoc(String trangthai_truoc) {
		this.trangthai_truoc = trangthai_truoc;
	}

	public String getTrangthai_sau() {
		return trangthai_sau;
	}

	public void setTrangthai_sau(String trangthai_sau) {
		this.trangthai_sau = trangthai_sau;
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
	
}
