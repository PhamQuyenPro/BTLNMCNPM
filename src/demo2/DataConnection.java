/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author M4800
 */

public class DataConnection {
                
    private static final String hostname = "localhost";
    private static final String username = "root";
    private static final String password = "";
    private static final String dbName = "mysql_db";
    private static final String connectionUrl = "jdbc:mysql://" + hostname + ":3306/" + dbName;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            if (conn != null){
                System.out.println("Kết nối thành công");
                return conn;
            }
        }catch(Exception e){
            System.out.println("Lỗi kết nối đến database: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args){
        Connection conn = DataConnection.getConnection();
        String sql = "select * from login";
        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String user = rs.getString("USER_NAME");
                String passw = rs.getString("PASSWORD");
                
                System.out.println("Id:" + id + ", username: " + user + ", password: " + passw);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
