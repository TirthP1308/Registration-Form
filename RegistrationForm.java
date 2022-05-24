package com.example.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import java.util.regex.Pattern;

public class RegistrationForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane pane1 = new GridPane();
        pane1.setHgap(5);
        pane1.setVgap(2);
        pane1.setAlignment(Pos.CENTER);

        Label fn = new Label("First Name");
        TextField fntf = new TextField();
        fntf.setPromptText("Enter Your First Name");
        pane1.add(fn, 1, 1);
        pane1.add(fntf, 2, 1);

        Label mn = new Label("Middle Name");
        TextField mntf = new TextField();
        mntf.setPromptText("Enter Your Middle Name");
        pane1.add(mn, 1, 2);
        pane1.add(mntf, 2, 2);

        Label ln = new Label("Last Name");
        TextField lntf = new TextField();
        lntf.setPromptText("Enter Your Last Name");
        pane1.add(ln, 1, 3);
        pane1.add(lntf, 2, 3);

        Label ea = new Label("Email Address");
        TextField eatf = new TextField();
        eatf.setPromptText("Enter Your Email Address");
        pane1.add(ea, 1, 5);
        pane1.add(eatf, 2, 5);

        Label mno = new Label("Mobile Number");
        TextField mnotf = new TextField();
        mnotf.setPromptText("Enter Your Mobile Number");
        pane1.add(mno, 1, 7);
        pane1.add(mnotf, 2, 7);

        Label dob = new Label("Date of Birth");
        pane1.add(dob, 1, 9);

        Label date = new Label("Date");
        String[] Dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ComboBox CBDate = new ComboBox(FXCollections.observableArrayList(Dates));
        pane1.add(date,1,10);
        pane1.add(CBDate,2,10);

        Label month = new Label("Month");
        String[] Months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        ComboBox CBMonth = new ComboBox(FXCollections.observableArrayList(Months));
        pane1.add(month,1,11);
        pane1.add(CBMonth,2,11);

        Label year = new Label("Year");
        String[] Years = {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
        ComboBox CBYear = new ComboBox(FXCollections.observableArrayList(Years));
        pane1.add(year,1,12);
        pane1.add(CBYear,2,12);

        Label gender = new Label("Gender");
        RadioButton m = new RadioButton("Male");
        RadioButton f = new RadioButton("Female");
        RadioButton o = new RadioButton("Others");
        ToggleGroup group = new ToggleGroup();
        m.setToggleGroup(group);
        f.setToggleGroup(group);
        o.setToggleGroup(group);
        pane1.add(gender,1,14);
        pane1.add(m,2,14);
        pane1.add(f,2,15);
        pane1.add(o,2,16);

        Label Lang = new Label("Language Known");
        CheckBox Hindi = new CheckBox("Hindi");
        CheckBox Guj = new CheckBox("Gujarati");
        CheckBox Eng = new CheckBox("English");
        CheckBox Other = new CheckBox("Others");
        pane1.add(Hindi,2,18);
        pane1.add(Guj,2,19);
        pane1.add(Eng,2,20);
        pane1.add(Other,2,21);

        Button cancel = new Button("Cancel");
        Button submit = new Button("Submit");
        pane1.add(submit,3,25);
        pane1.add(cancel,1,25);

        //Create second scene
        GridPane pane2 = new GridPane();
        Scene scene2 = new Scene(pane2,800,300);
        Label wp = new Label();

        submit.setOnAction(e->{
            //name validation
            String fml="[A-Za-z\\s]+";
            Pattern p=Pattern.compile(fml);
            boolean a=p.matcher(fntf.getText()).matches();
            if(!a){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name Error");
                alert.setHeaderText(null);
                alert.setContentText("First name must be character and not be null");
                alert.showAndWait();
            }
            boolean b=p.matcher(mntf.getText()).matches();
            if(!b){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name Error");
                alert.setHeaderText(null);
                alert.setContentText("Middle name must be character and not be null");
                alert.showAndWait();
            }
            boolean c=p.matcher(lntf.getText()).matches();
            if(!c){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name Error");
                alert.setHeaderText(null);
                alert.setContentText("Last name must be character and not be null");
                alert.showAndWait();
            }

            //validation for email
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern emailPattern = Pattern.compile(emailRegex);
            boolean emailChecker = emailPattern.matcher(eatf.getText()).matches();
            if(!emailChecker){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Email Address");
                alert.showAndWait();
            }

            //Validation for mobile number
            String numberRegex = "[6-9][0-9]{9}";
            Pattern numberPattern = Pattern.compile(numberRegex);
            boolean numberChecker = numberPattern.matcher(mnotf.getText()).matches();
            if(!numberChecker){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Number Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Mobile Number with limit in 10 digits");
                alert.showAndWait();
            }

            //validation for ComboBox
            boolean D = CBDate.getSelectionModel().isEmpty();
            if(D){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DOB Warning");
                alert.setHeaderText(null);
                alert.setContentText("Select the Day");
                alert.showAndWait();
            }
            boolean M = CBMonth.getSelectionModel().isEmpty();
            if(M){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DOB Warning");
                alert.setHeaderText(null);
                alert.setContentText("Select the Month");
                alert.showAndWait();
            }
            boolean Y = CBYear.getSelectionModel().isEmpty();
            if(Y) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("DOB Warning");
                alert.setHeaderText(null);
                alert.setContentText("Select the Year");
                alert.showAndWait();
            }

            //Validation for RadioButton
            boolean mf = ((m.isSelected() | f.isSelected()));
            if(!mf){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Select one of the gender");
                alert.showAndWait();
            }

            //Validation for CheckBox
            boolean hge =  (Hindi.isSelected() | Guj.isSelected() | Eng.isSelected() );
            if(!hge) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Select one of the language");
                alert.showAndWait();
            }

            if(a && b && c && emailChecker && numberChecker && !D && !M && !Y && mf && hge){
                primaryStage.setScene(scene2);
                wp.setText(" Welcome "+fntf.getText()+" "+lntf.getText()+" ! ");
                pane2.setAlignment(Pos.CENTER);
                pane2.setStyle("-fx-font:50px CENTER");
                pane2.add(wp,1,1);
            }
        });

        cancel.setOnAction(e->{
            fntf.clear();
            mntf.clear();
            lntf.clear();
            eatf.clear();
            mnotf.clear();
            CBDate.getSelectionModel().clearSelection();
            CBMonth.getSelectionModel().clearSelection();
            CBYear.getSelectionModel().clearSelection();
            m.setSelected(false);
            f.setSelected(false);
            o.setSelected(false);
            Hindi.setSelected(false);
            Guj.setSelected(false);
            Eng.setSelected(false);
            Other.setSelected(false);
        });


        Scene scene1 = new Scene(pane1, 450, 550);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Registration Form");
        primaryStage.show();
    }
}
