package com.example.cnpm.main.util;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class NguoiDangKi {
     private String name;
     private String address;
     private String phoneNumber;
     private String CMND;
     private Date TimeUse;
     private String gioitinh;
     //private Date TimeEnd;
     //private int Phi;
     //private String bienban;
     //private String mucdich;
     //private String mathue;

    public NguoiDangKi() {
    }

    public NguoiDangKi(String name, String address, String phoneNumber, String CMND, Date TimeUse,  String gioitinh) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.CMND = CMND;
        this.TimeUse = TimeUse;
        this.gioitinh = gioitinh;
     //   this.TimeEnd = TimeEnd;
      //  this.Phi = Phi;
       // this.bienban = bienban;
       // this.mucdich = mucdich;
       // this.mathue = mathue;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getTimeUse() {
        return TimeUse;
    }

    public void setTimeUse(Date TimeUse) {
        this.TimeUse = TimeUse;
    }

   /* public Date getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(Date TimeEnd) {
        this.TimeEnd = TimeEnd;
    }

   

    public int getPhi() {
        return Phi;
    }

    public void setPhi(int Phi) {
        this.Phi = Phi;
    }

    public String getBienban() {
        return bienban;
    }

    public void setBienban(String bienban) {
        this.bienban = bienban;
    }

    public String getMucdich() {
        return mucdich;
    }

    public void setMucdich(String mucdich) {
        this.mucdich = mucdich;
    }

    public String getMathue() {
        return mathue;
    }

    public void setMathue(String mathue) {
        this.mathue = mathue;
    }
    */ 
}
