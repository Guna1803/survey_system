package com.example.survey_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class mainpage_controller {

    @FXML
    private RadioButton b1;

    @FXML
    private RadioButton b2;

    @FXML
    private RadioButton b3;

    @FXML
    private RadioButton b4;

    @FXML
    private Button submitform;

    @FXML
    private ToggleGroup toggle;

    @FXML
    private Label erms;

    @FXML
    private Button repbut;

    @FXML
    public TextField setname;


    public String usname;

    public String  setname (){
        mainpage_controller mc = new mainpage_controller();
        usname=mc.setname();
        return "";
    }

    String str;
    @FXML
    void butsubmit(ActionEvent event) {
        if(b1.isSelected()){
            str = "GOA";
        }

        else if(b2.isSelected()){
            str = "THAILAND";
        }

        else if(b3.isSelected()){
            str = "SINGAPORE";
        }
        else if(b4.isSelected()){
            str = "MALDHIVES";
        }

        if(str!=null){
            DB_file connectnow = new DB_file();
            Connection connectDB = connectnow.getConnection();
            login_controller ak = new login_controller();
            usname = ak.getname();
            String verifylogin = "update user set Willingness ='"+str+"' where username='"+usname+"';";
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(verifylogin);
                erms.setText("THANKS FOR YOUR ANSWER..!!");
            } catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
    }

    @FXML
    void showrep(ActionEvent event) throws IOException {

    }

}
