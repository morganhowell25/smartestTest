/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public abstract class AdminDash implements AppScene
{
    public GridPane drawAdminDash()
    {
        GridPane gp = new GridPane();
        
        Button btnAddUser = new Button();
        btnAddUser.setText("Add User");
        gp.add(btnAddUser, 0, 0);
        
        Button btnManageUser = new Button();
        btnManageUser.setText("Manage User");
        gp.add(btnManageUser, 0, 1);
        
        Button btnImportLO = new Button();
        btnImportLO.setText("Import LO");
        gp.add(btnImportLO, 0, 2);
        
        return gp;
    }
}
