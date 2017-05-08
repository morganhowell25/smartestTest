/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class LoginForm{
    public void start(Stage primaryStage){
        LoginForm lForm = this;
        primaryStage.setTitle("SmartTest");
        update(primaryStage, lForm.getScene());
    }
            
    public Scene getScene()
    {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        
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
                
                System.out.println(uname + " " + pword);
            }
        });
               
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
    
    public void update(Stage primaryStage, Scene newScene){
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}

