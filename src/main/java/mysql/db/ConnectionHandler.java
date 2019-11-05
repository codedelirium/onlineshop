package mysql.db;

import mysql.config.SystemConfig;

import java.sql.*;
import java.util.Properties;

public class ConnectionHandler {
    private static String DB_DRIVER;
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PWD;

    private static Connection conn;

    static{
        Properties sysProps= SystemConfig.getDefaultProperties();
        DB_DRIVER=sysProps.getProperty("db_driver");
        DB_URL=sysProps.getProperty("db_url");
        DB_USER=sysProps.getProperty("db_user");
        DB_PWD=sysProps.getProperty("db_pwd");
    }

    public static Connection getConnection() throws SQLException {
        if(conn==null){
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new SQLException("驱动不存在！",e);
            }

            //2、建立与数据库的连接通道
            conn = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
            System.out.println("连接成功！");
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();//关闭连接（资源关闭）
            } catch (SQLException e) {
            }
        }
    }
    /**
     * 关闭资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt){
        close(null,stmt,null);
    }
    /**
     * 关闭资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt){
        close(rs,stmt,null);
    }
    /**
     * 关闭资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }

        if(conn!=null){
            try {
                conn.close();//关闭连接（资源关闭）
            } catch (SQLException e) {
            }
        }
    }

//	public static void main(String[] args) {
//		try {
//			Connection conn=ConnectionHandler.getConnection();
//			System.out.println(conn);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
