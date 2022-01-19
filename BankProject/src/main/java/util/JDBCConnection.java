package util;

//Imports from java.sql -> JDBC
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {


    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            //Make new connection
            Properties props = new Properties();
            try {
                props.load(JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));
                String endpoint = props.getProperty("endpoint");
                String url = "jdbc:postgresql://" + endpoint + "/postgres";
                String username = props.getProperty("username");
                String password = props.getProperty("password");
                con = DriverManager.getConnection(url, username, password);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }


    /*
    THIS IS FOR TESTING PURPOSES ONLY!!!!!!!!!!!!!!
    NOT NEEDED TO ACTUALLY USE JDBC
     */
    public static void main(String[] args) {

        Connection conn1 = getConnection();
        Connection conn2 = getConnection();

        System.out.println(conn1);
        System.out.println(conn2);

    }
}