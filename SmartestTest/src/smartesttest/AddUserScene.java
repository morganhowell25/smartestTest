/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class AddUserScene extends AdminDash implements AppScene
{
    public AddUserScene()
    {
        
    }
    public Scene getScene()
    {
        GridPane gp = drawAdminDash();
        Label userTypeLbl = new Label("User Type");
        gp.add(userTypeLbl,2,0);
        
        //the code for a dropdown menu
        ObservableList<String> options = FXCollections.observableArrayList("Admin","Teacher","Student");
        ComboBox typeBox = new ComboBox(options);
        typeBox.setPromptText("User Type");
        gp.add(typeBox,2,1);
        
        //one text field
        Label userNameLbl = new Label("Username");
        gp.add(userNameLbl,2,2);
        TextField userNameTxt = new TextField();
        gp.add(userNameTxt,2,3);
        
        //and another
        Label userPassLbl = new Label("Password");
        gp.add(userPassLbl,2,4);
        PasswordField userPassTxt = new PasswordField();
        gp.add(userPassTxt,2,5);
        
        //ending button
        Button confirm = new Button("Confirm");
        gp.add(confirm,2,6);
        
        confirm.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Confirm Clicked!");
                ArrayList<String> unames = server.checkUname(userNameTxt.getText());
                String enteredPass = userPassTxt.getText();
                boolean validPass = true;
                for(int i = 0; i < enteredPass.length(); i++){
                    if(!((enteredPass.charAt(i) >= 'a' && enteredPass.charAt(i) <= 'z') || (enteredPass.charAt(i) >= 'A' && enteredPass.charAt(i) <= 'Z') || (enteredPass.charAt(i) >= '0' && enteredPass.charAt(i) <= '9'))){
                        validPass = false;
                        break;
                    }
                }
                if(validPass == false){
                    Alert badAlert = new Alert(AlertType.ERROR);
                    badAlert.setTitle("Failed to Add User");
                    badAlert.setHeaderText("Invalid password");
                    badAlert.setContentText("Please only use alphanumeric characters");
                    badAlert.showAndWait();
                }
                else if(userNameTxt.getText().isEmpty()){
                    Alert nullAlert = new Alert(AlertType.ERROR);
                    nullAlert.setTitle("Failed to Add User");
                    nullAlert.setHeaderText("Username cannot be empty");
                    nullAlert.setContentText("Please enter a non-empty username");
                    nullAlert.showAndWait();
                }
                else if(!(unames.isEmpty())){
                    Alert badAlert = new Alert(AlertType.ERROR);
                    badAlert.setTitle("Failed to Add User");
                    badAlert.setHeaderText("Username already exists");
                    badAlert.setContentText("Please choose a unique username");
                    badAlert.showAndWait();
                }
                else if(typeBox.getValue() == null){
                    Alert badAlert = new Alert(AlertType.ERROR);
                    badAlert.setTitle("Failed to Add User");
                    badAlert.setHeaderText("No UserType Selected");
                    badAlert.setContentText("Please choose a User Type");
                    badAlert.showAndWait();
                }
                else{
                    server.addUser(userNameTxt.getText(), utils.encrypt(userPassTxt.getText()), typeBox.getValue().toString().toLowerCase());
                    Alert goodAlert = new Alert(AlertType.INFORMATION);
                    goodAlert.setTitle("User Added Successfully");
                    goodAlert.setHeaderText(null);
                    goodAlert.setContentText("Press OK to continue");
                    goodAlert.showAndWait();
                }
            }
        });
        
                
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
    
}
