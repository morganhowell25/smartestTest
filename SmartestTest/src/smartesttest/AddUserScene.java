/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class AddUserScene extends AdminDash{
    public AddUserScene(){
        
    }
    public Scene getScene(){
        
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
        TextField userPassTxt = new TextField();
        gp.add(userPassTxt,2,5);
        
        //ending button
        Button confirm = new Button("Confirm");
        gp.add(confirm,2,6);
        
                
        
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
    
}
