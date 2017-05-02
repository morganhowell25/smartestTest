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
public abstract class DashBoard 
{

    //public static Scene GLOBALSCENE;
    
    public void start(Stage primaryStage, AppScene x){}
    
    public void update(AppScene x){}

    public Scene myScene;
    public Stage myStage;
    
    
    public DashBoard()
    {
        //myStage = new Stage();
    }
    
    public EventHandler<ActionEvent> addUserClick() 
    {
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                AddUserScene auScene = new AddUserScene();
                System.out.println("Add User Button Clicked");                
                Stage stage2 = new Stage();
                stage2.setScene(auScene.getScene());
                stage2.show();
                
                //If we could jsut access the varaibles form DashBoard
                //we would be good
            }
        };
    }
    
    public EventHandler<ActionEvent> manageUserClick() 
    {
        DashBoard dash = this;
        return new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                System.out.println("Manage User Button Clicked");
                ManageUserScene muScene = new ManageUserScene();
                dash.update(muScene.getScene());
            }
        };
    }
    
    public EventHandler<ActionEvent> importLOClick() 
    {
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) 
            {
                ImportLOsScene auScene = new ImportLOsScene ();
                System.out.println("Import LO's Button Clicked");                
            }
        };
        return handler;
    }
    
    public void start(Stage primaryStage) 
    {
        /*myStage = primaryStage;
        
        AdminHomeScene ahs = new AdminHomeScene();
        ahs.myStage = this.myStage;
        myScene = ahs.getScene();
        
        myStage.setTitle("SmartTest");
        update(myScene);*/
        
    }
    
    public Stage getStage()
    {
        return myStage;
    }
    
    public void update(Scene newScene)
    {
        myStage.setScene(newScene);
        myStage.show();
    }

}
