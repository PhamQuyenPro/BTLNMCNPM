package com.example.cnpm.main.util;

import java.util.Vector;

public class HoatDong extends Vector<String>
{
  private int stt;
  private String tenHd = "";
  private String TgBatDau= "";
  private String TgKetThuc = "";
  private String mucDich = "";
  
  public HoatDong() {
	  super();
  }
  
  
  public HoatDong(int stt, String tenHd, String tgBatDau, String tgKetThuc, String mucDich)
  {
    super();
    
    this.stt = stt;
    if(tenHd != null)
    this.tenHd = tenHd;
    if(tgBatDau != null)
    TgBatDau = tgBatDau;
    if(tgKetThuc != null)
    TgKetThuc = tgKetThuc;
    if(mucDich != null)
    this.mucDich = mucDich;
    initVector();
  }
  
  private void initVector()
  {
    clear();
    add(Integer.toString(stt));
    add(tenHd);
    add(TgKetThuc);
    add(TgBatDau);
    add(mucDich);
  }
  
  public int getStt()
  {
    return stt;
  }
  public void setStt(int stt)
  {
    this.stt = stt;
    initVector();
  }
  public String getTenHd()
  {
    return tenHd;
  }
  public void setTenHd(String tenHd)
  {
    this.tenHd = tenHd;
    initVector();
  }
  public String getTg_BatDau()
  {
    return TgBatDau;
  }
  public void setTg_BatDau(String tgBatDau)
  {
    TgBatDau = tgBatDau;
    initVector();
  }
  public String getTg_KetThuc()
  {
    return TgKetThuc;
  }
  public void setTg_KetThuc(String tgKetThuc)
  {
    TgKetThuc = tgKetThuc;
    initVector();
  }

  public String getMucDich()
  {
    return mucDich;
  }
  public void setMucDich(String mucDich)
  {
    this.mucDich = mucDich;
    initVector();
  }
  
  
}
