/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class ManageUserScene extends AdminDash
{
    public ManageUserScene()
    {
        
    }
            
    public Scene getScene()
    {
        GridPane gp = drawAdminDash();
        
        //table setup
        TableView table = new TableView();
        table.setEditable(true);
 
        TableColumn userNameCol = new TableColumn("User");
        TableColumn roleCol = new TableColumn("Role");
        TableColumn delCol = new TableColumn("Delete?");
        
        table.getColumns().addAll(userNameCol, roleCol, delCol);
        
        gp.add(table,1,4);
        
        //note: tableview and gridpane don't really get along (try gp.add(table,1,0)
        //it would also be possible to just use gridpane as a sort of less sophisticated table
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
