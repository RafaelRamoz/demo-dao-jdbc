package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    
    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties prop = propLoad();
                String url = prop.getProperty("dburl");
                conn = DriverManager.getConnection(url, prop);

            }catch(SQLException e){
                throw new dbException("Error: " + e.getMessage());
            }
        }
        return conn;
    }

    public static Properties propLoad(){
        try(FileInputStream fs = new FileInputStream("C:\\Users\\Ramoszz\\Desktop\\Estudos\\Estudos Atualizado\\Java\\Demo DAO JDBC\\Demo DAO JDBC\\src\\db\\db.properties")){
            Properties prop = new Properties();
            prop.load(fs);
            return prop;

        }catch(IOException e){
            throw new dbException("Error: " + e.getMessage());
        }
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e ){
                throw new dbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){
        if(st!=null){
            try{
                st.close();
            }catch(SQLException e ){
                throw new dbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                throw new db.dbException(e.getMessage());
            }
        }
    }


}
