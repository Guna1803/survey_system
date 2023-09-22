package com.example.survey_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login_controller {

    @FXML
    private Button loginbutton;

    public static String str;

    public String getname(){
        String name=str;
        return name;
    }

    @FXML
    private PasswordField password;

    @FXML
    private Button signupbutton;

    @FXML
    private TextField username;

    @FXML
    private Label altmsg;

    private static String ename;

    @FXML
    void login(ActionEvent event) throws IOException {
        str = username.getText();
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "SELECT count(1) FROM user WHERE username = '"+username.getText()+"' and password = '"+password.getText()+"';";
        try {
            ename=username.getText();
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            while (queryResult.next())
            {
                if(queryResult.getInt(1)==1){
                    FXMLLoader fxmlLoader = new FXMLLoader(login_page.class.getResource("mainpage.fxml"));
                    Stage window = (Stage) loginbutton.getScene().getWindow();
                    window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
                }
            }
        } catch (Exception e)
        {
            altmsg.setText("INVALID USERNAME OR PASSWORD..!");
            e.printStackTrace();
            e.getCause();
        }

    }


    @FXML
    void signup(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(login_page.class.getResource("signup.fxml"));
        Stage window = (Stage)signupbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),1530 , 790));

    }

}
