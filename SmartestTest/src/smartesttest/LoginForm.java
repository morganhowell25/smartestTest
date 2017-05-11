/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import static smartesttest.server.mySeed;

/**
 *
 * @author csc190
 */
public class LoginForm {
    //protected Stage pStage;
    public void start(Stage primaryStage) {
        LoginForm lForm = this;
        primaryStage.setTitle("SmartTest");
        update(primaryStage, lForm.getScene());
       
    }

    public Scene getScene() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        LoginForm lf = this;
        
        Text scenetitle = new Text("Welcome");
        gp.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        gp.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gp.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        gp.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gp.add(pwBox, 1, 2);

        Button btnSignIn = new Button("Sign in");
        gp.add(btnSignIn, 1, 5);
        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sign-In Clicked!");
                String uname = userTextField.getText();
                String pword = pwBox.getText();
                //System.out.println(pword);
                //String pwordHashed = server.hasher(pword);
                //System.out.println(pwordHashed);
                ArrayList<ArrayList<String>> newCred = server.pullUInfo(uname);
                //System.out.println(newCred);
                StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
                //encryptor.setPassword(newCred.get(1).get(0));
                //System.out.println(newCred.get(1).get(0));
                encryptor.setPassword(mySeed);
                String passHashedDecrypted = encryptor.decrypt(newCred.get(1).get(0));
                //System.out.println(passHashedDecrypted);
                if (uname.equals(newCred.get(0).get(0)) && pword.equals(passHashedDecrypted)) {
                  
                    if (newCred.get(2).get(0).equals("admin")) {
                        AdminDash adminDash = new AdminDash();
                        Stage primaryStage = new Stage();
                        adminDash.start(primaryStage);
                        //primaryStage.close();
                    } else if (newCred.get(2).get(0).equals("teacher")) {
                        TeacherDash teacherDash = new TeacherDash();
                        Stage primaryStage = new Stage();
                        teacherDash.start(primaryStage);
                    } else {
                        StudentDash studentDash = new StudentDash();
                        Stage primaryStage = new Stage();
                        studentDash.start(primaryStage);
                        System.out.println("After start clicked");
                        //this..close();
                        System.out.println("After close clicked");
                    }
                } else {
                    Alert loginFail = new Alert(Alert.AlertType.ERROR);
                    loginFail.setTitle("Error!");
                    loginFail.setHeaderText("Login Failed!");
                    loginFail.setContentText("Invalid login credentials");
                    loginFail.showAndWait();
                }
            }
            
         });
               
        Scene scene = new Scene(gp, 700, 500);
    return scene ;
}

public void update(Stage primaryStage, Scene newScene){
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
