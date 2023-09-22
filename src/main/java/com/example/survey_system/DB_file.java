package com.example.survey_system;
import java.sql.Connection;
import java.sql.DriverManager;
public class DB_file {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "user";
        String databaseUser = "root";
        String databasePassword = "guna@2004";
        String url = "jdbc:mysql://localhost/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
