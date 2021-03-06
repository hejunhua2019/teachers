package cn.com.yajiaotong.wface.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Logger logger = Logger.getLogger(ConnectionFactory.class);
	private static String driver;//="com.mysql.jdbc.Driver";
	private static String url;//="jdbc:mysql://localhost:3308/cooperation";
	private static String userName;//="root";
	private static String password;//="admin";
	

	public static Connection getConnection(String driver,String url,String userName,String password){
		Connection con = null;
		try {
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			logger.error("初始化数据库异常:"+e.getMessage());
			e.printStackTrace();
		}
		return con;
	}
        public static Connection getConnection(String db){

                Connection con = null;
                String u ="";
                if(url.lastIndexOf("/")+1 == url.length()){
                        u = url+db;
                }else{
                        u = url+"/"+db;
                }
         u+="?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
         try {
             con = DriverManager.getConnection(u,userName,password);
         if(con!=null){
             logger.info("["+db+"]数据库连接成功");
             System.out.println("["+db+"]数据库连接成功");
         }else{
             logger.info("["+db+"]数据库连接失败");
             System.out.println("["+db+"]数据库连接失败");
         }
     } catch (SQLException e) {
         logger.error("数据库连接异常:"+e.getMessage());
             e.printStackTrace();
     }
     return con;
        }

	public static void close(Connection con){
		try {
			if(con != null){
				con.close();
			}
		} catch (SQLException e) {
			logger.error("数据库关闭异常:"+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
//		String url = "jdbc:oracle:thin:@219.239.91.89:1521:ORCL";
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String uName = "search";
//		String pwd = "search";
//		Connection con = getConnection(driver,url,uName,pwd);
//		if(con!=null){
//			System.out.println("连接成功:"+url);
//			close(con);
//		}
        System.out.println(0x000000FF & 256);
	}
}
