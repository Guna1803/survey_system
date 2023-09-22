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

public class signup_controller {

    @FXML
    private Button backbutton;

    @FXML
    private PasswordField cpword;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private PasswordField pword;

    @FXML
    private Button sbutton;

    @FXML
    private TextField uname;

    @FXML
    private Label msg;

    @FXML
    void gosignup(ActionEvent event) {
        if((pword.getText().equals(cpword.getText())) && fname.getText()!=null && lname.getText()!=null && uname.getText()!=null){
            DB_file connectnow = new DB_file();
            Connection connectDB = connectnow.getConnection();

            String verifylogin = "INSERT INTO user (firstname,lastname,username,password) VALUES('" + fname.getText() + "','" + lname.getText() + "','"  + uname.getText() + "','" + pword.getText() + "');";
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(verifylogin);
                msg.setText("NEW USER REGISTER SUCCESSFULLY..!!");
            } catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }

        else if(!pword.getText().equals((cpword.getText()))){
            msg.setText("PASSWORD MISS MATCH..!!");
        }

        else if(pword.getText()==null || cpword.getText()==null || fname.getText()==null || lname.getText()==null || uname.getText()==null){
            msg.setText("SOME FIELDS ARE MISSING..!!");
        }
    }

    @FXML
    void goback(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(login_page.class.getResource("login.fxml"));
        Stage window = (Stage)backbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),1530 , 790));
    }

}
