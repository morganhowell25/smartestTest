/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
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
        
        //Implement manage user buttons here
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
