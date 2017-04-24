/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class DashBoard 
{
    public DashBoard()
    {

    }
    
    public void start(Stage primaryStage) 
    {
        //Stage primaryStage = new Stage();
        
        //ViewTestLOScene vtlos = new ViewTestLOScene();
        //Scene scene = vtlos.getScene();
        
        primaryStage.setTitle("SmartTest!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
