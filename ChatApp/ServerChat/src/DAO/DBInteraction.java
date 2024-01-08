package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

    static Connection con ;
    static Statement st;
    public static void connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/webdev";
            con = DriverManager.getConnection(url, "springstudent","springstudent" );
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect()
    {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int Maj(String sql)
    {
        int nb=0;
        try {
            nb = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nb;
    }

    public static ResultSet Select(String sql)
    {
        ResultSet resultSet=null;
        try {
            resultSet = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}

