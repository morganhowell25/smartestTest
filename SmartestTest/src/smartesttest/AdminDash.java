/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class AdminDash extends DashBoard 
{
    protected Scene SCENE;
    protected Stage STAGE;
    protected int currentUserID;
    
    public AdminDash(){} // Here lies a blank constructor.
    // Tis meant to honor Captain Morgan. Yoho.
    
    public AdminDash(int cuID){
            this.currentUserID = cuID;
    }
      
    public void start(Stage primaryStage){
        STAGE = primaryStage;
        
        AdminHomeScene ahs = new AdminHomeScene();
        ahs.STAGE = this.STAGE;
        SCENE = ahs.getScene();
        
        STAGE.setTitle("SmartTest");
        update(SCENE);
    } 
    
    public GridPane drawAdminDash()
    {
        GridPane gp = new GridPane();
        gp.setHgap(15);
        gp.setVgap(5);
        gp.setPadding(new Insets(10, 10, 10, 10));
        
        AdminDash adminDash = this;
        
        Button btnAddUser = new Button();
        btnAddUser.setText("Add User");
        gp.add(btnAddUser, 0, 0);

        btnAddUser.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("AddUser Clicked!");
                AddUserScene aus = new AddUserScene();
                aus.STAGE = adminDash.STAGE;
                adminDash.update(aus.getScene());
            }
        });
        
        Button btnManageUser = new Button();
        btnManageUser.setText("Manage User");
        gp.add(btnManageUser, 0, 1);
        
        btnManageUser.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ManageUser Clicked!");
                ManageUserScene mus = new ManageUserScene();
                mus.STAGE = adminDash.STAGE;
                adminDash.update(mus.getScene());
            }
        });
   
        Button btnImportLO = new Button();
        btnImportLO.setText("Import LO's");
        gp.add(btnImportLO, 0, 2);
          
        btnImportLO.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ImportLO Clicked!");
                ImportLOsScene ilos = new ImportLOsScene();
                ilos.STAGE = adminDash.STAGE;
                adminDash.update(ilos.getScene());
            }
        });

        //btnManageUser.setOnAction(manageUserClick()); 

        return gp;
    }
    
    public void update(Scene newScene){
        STAGE.setScene(newScene);
        STAGE.show();
    }
}
