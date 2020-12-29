package com.example.cnpm.main.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import com.example.cnpm.main.util.*;


import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class DBContext {
        
    public static ArrayList<NguoiDangKi> selectQuery(){
        String dbURL = "jdbc:mysql://localhost/cnpm";
        String username = "root";
        String password = "";
        ArrayList<NguoiDangKi> list = new ArrayList<>();
        String sql = "select hoten,diachi,sdt,diachi,cmnd,ngaysinh,gioitinh from tt_canhan";
  //       String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DKsudung;user=sa;password=123456";
        try {
           Connection connection =   DriverManager.getConnection(dbURL,username,password);
          Statement  statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                NguoiDangKi n = new NguoiDangKi();
                n.setName(rs.getString("hoten"));
                n.setAddress(rs.getString("diachi"));
                n.setPhoneNumber(rs.getString("sdt"));
                n.setCMND(rs.getString("cmnd"));
                n.setTimeUse(rs.getDate("ngaysinh"));
                n.setGioitinh(rs.getString("gioitinh"));
            //    n.setTimeEnd(rs.getDate(6));
              //  n.setPhi(rs.getInt(7));
             // n.setMucdich(rs.getString(8));
              //  n.setBienban(rs.getString(9));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
   
 public  boolean addNewMem(NguoiDangKi n){
  
      PreparedStatement statement ;
      String dbURL = "jdbc:mysql://localhost/cnpm";
      String username = "root";
      String password = "";
     //String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DKsudung;user=sa;password=123456";
     try {
        Connection connection = DriverManager.getConnection(dbURL,username,password);
         String sql = "INSERT INTO tt_canhan(cmnd,hoten,ngaysinh,gioitinh,sdt,diachi) VALUES(?,?,?,?,?,?)";
          statement=connection.prepareStatement(sql);
          statement.setString(2,n.getName());
          statement.setString(6, n.getAddress());
          statement.setString(5, n.getPhoneNumber());
          statement.setString(1, n.getCMND());
          statement.setTimestamp(3, new Timestamp(n.getTimeUse().getTime()));
          statement.setString(4, n.getGioitinh());
   //      statement.setTimestamp(6, new Timestamp(n.getTimeEnd().getTime()));
    //      statement.setInt(7, n.getPhi());
    //      statement.setString(8, n.getMucdich());
    //      statement.setString(9, n.getBienban());
          statement.executeUpdate();
          return true;
     } catch (Exception e) {
         e.printStackTrace();
     }
   return false;
 }
 public boolean updateMem(NguoiDangKi n) {
	 PreparedStatement statement;
     String dbURL = "jdbc:mysql://localhost/cnpm";
     String username = "root";
     String password = "";
    //String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DKsudung;user=sa;password=123456";
    try {
       Connection connection = DriverManager.getConnection(dbURL,username,password);
       String  sql = "update tt_canhan set hoten=?,ngaysinh=?,gioitinh=?,sdt=?,diachi=? where cmnd=?";
       statement = connection.prepareCall(sql);
       statement=connection.prepareStatement(sql);
       statement.setString(1,n.getName());
       statement.setString(5, n.getAddress());
       statement.setString(4, n.getPhoneNumber());
       statement.setString(6, n.getCMND());
       statement.setTimestamp(2, new Timestamp(n.getTimeUse().getTime()));
       statement.setString(3, n.getGioitinh());
       statement.execute();
       return true;
    }
       catch (Exception e) {
           e.printStackTrace();
       }
    return false;
 }
   
 
   public  static void delete(String cmnd){
  
      PreparedStatement statement ;
      String dbURL = "jdbc:mysql://localhost/cnpm";
      String username = "root";
      String password = "";
  //   String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DKsudung;user=sa;password=123456";
     try {
    	 Connection connection = DriverManager.getConnection(dbURL,username,password);
         String sql = "delete from tt_canhan where cmnd= ?";
         statement=connection.prepareCall(sql);
          statement.setString(1,cmnd);
           statement.executeUpdate();  
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
    public static ArrayList<NguoiDangKi> findByname(String HoTen){
        
        ArrayList<NguoiDangKi> list = new ArrayList<>();
        String dbURL = "jdbc:mysql://localhost/cnpm";
        String username = "root";
        String password = "";
        String sql = "SELECT * FROM tt_canhan where hoten like ?";
    //     String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DKsudung;user=sa;password=123456";
        try {
        	 Connection connection = DriverManager.getConnection(dbURL,username,password);
          PreparedStatement statement = connection.prepareCall(sql);
          statement.setString(1, "%"+HoTen+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                NguoiDangKi n = new NguoiDangKi(
                rs.getString("hoten"),
                rs.getString("diachi"),
                rs.getString("sdt"),
                rs.getString("cmnd"),
                rs.getDate("ngaysinh"),
                rs.getString("gioitinh"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
 