/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class AdminDash extends DashBoard implements AppScene
{
    protected Scene SCENE;
    protected Stage STAGE;
    
    AdminDash(){}
    
    public void start(Stage primaryStage, AppScene x) 
    {
        
        //Admin Buttons
        STAGE = primaryStage;
        
        STAGE.setTitle("SmartTest!");
        update(x);
    }
    
    public GridPane drawAdminDash()
    {
        GridPane gp = new GridPane();
        
        Button btnAddUser = new Button();
        btnAddUser.setText("Add User");
        gp.add(btnAddUser, 0, 0);
        btnAddUser.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("we didnt fuck it up!");
                AddUserScene x = new AddUserScene();
                update(x);
            }
        });
        
        Button btnManageUser = new Button();
        btnManageUser.setText("Manage User");
        gp.add(btnManageUser, 0, 1);
                
        Button btnImportLO = new Button();
        btnImportLO.setText("Import LO");
        gp.add(btnImportLO, 0, 2);
                
        return gp;
    }
    
    public void update(AppScene x){
        SCENE = x.getScene();
        STAGE.setScene(SCENE);
        STAGE.show();
    }
    
    public Scene getScene(){
        return SCENE;
    }
}
