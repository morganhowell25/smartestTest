/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author csc190
 */
public class DashBoard 
{
    public Scene myScene;
    public Stage myStage;
    
    
    public DashBoard()
    {
        //myStage = new Stage();
    }
    
    public EventHandler<ActionEvent> addUserClick() 
    {
        DashBoard dash = this;
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                AddUserScene auScene = new AddUserScene();
                System.out.println("Add User Button Clicked");                
                Stage stage2 = new Stage();
                stage2.setScene(auScene.getScene());
                stage2.show();
            }
        };
    }
    
    public EventHandler<ActionEvent> manageUserClick() 
    {
        ManageUserScene muScene = new ManageUserScene();
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                System.out.println("Manage User Button Clicked");
                ManageUserScene muScene = new ManageUserScene();                
                Stage stage2 = new Stage();
                stage2.setScene(muScene.getScene());
                stage2.show();
            }
        };
    }
    
    public void start(Stage primaryStage) 
    {
        myStage = primaryStage;
        
        AdminHomeScene x = new AdminHomeScene();
        myScene = x.getScene();
        
        myStage.setTitle("SmartTest!");
        update();
        
    }
    
    public Stage getStage()
    {
        return myStage;
    }
    
    public void update()
    {
        myStage.setScene(myScene);
        myStage.show();
    }
}
