/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class AdminHomeScene extends AdminDash
{

    public AdminHomeScene()
    {
        
    }
            
    public Scene getScene()
    {
        GridPane gp = drawAdminDash();
        
        //my one addition
        Label homeText = new Label("Hello Admin! Please choose a tab to begin");
        gp.add(homeText,0,3);
        
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}