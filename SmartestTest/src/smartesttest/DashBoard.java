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
        
        ManageUserScene mus = new ManageUserScene();
        Scene scene = mus.getScene();
        
        //Testing testing 1,2,3...
        
        //CreateTestScene CTS = new CreateTestScene();
        //Scene scene = CTS.getScene();
        //AddQuestionScene AQ = new AddQuestionScene();
        //Scene scene = AQ.getScene();
        //ManageTestsScene MTS = new ManageTestsScene();
        //Scene scene = MTS.getScene();        
        
        primaryStage.setTitle("SmartTest!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
