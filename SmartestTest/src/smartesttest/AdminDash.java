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
public class AdminDash extends DashBoard
{
    public AdminDash()
    {
        
    }
    
    public GridPane drawAdminDash()
    {
        GridPane gp = new GridPane();
        
        Button btnAddUser = new Button();
        btnAddUser.setText("Add User");
        gp.add(btnAddUser, 0, 0);
        btnAddUser.setOnAction(addUserClick());
        
        Button btnManageUser = new Button();
        btnManageUser.setText("Manage User");
        gp.add(btnManageUser, 0, 1);
        btnManageUser.setOnAction(manageUserClick());
        
        Button btnImportLO = new Button();
        btnImportLO.setText("Import LO");
        gp.add(btnImportLO, 0, 2);
        
        return gp;
    }
}
