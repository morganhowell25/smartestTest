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
public class StudentDash extends DashBoard
{
    protected Scene SCENE;
    protected Stage STAGE;
    protected int currentUserID;
          
    public void start(Stage primaryStage){
        STAGE = primaryStage;
        
        StudentHomeScene shs = new StudentHomeScene();
        shs.STAGE = this.STAGE;
        SCENE = shs.getScene();
        
        STAGE.setTitle("SmartTest");
        update(SCENE);
    } 
    
    public GridPane drawStudentDash()
    {
        GridPane gp = new GridPane();
        
        StudentDash studentDash = this;
        
        Button btnTakeTest = new Button();
        btnTakeTest.setText("Take Test");
        gp.add(btnTakeTest, 0, 0);

        btnTakeTest.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("TakeTest Clicked!");
                TakeTestScene tts = new TakeTestScene();
                tts.STAGE = studentDash.STAGE;
                studentDash.update(tts.getScene());
            }
        });
        
        Button btnViewScores = new Button();
        btnViewScores.setText("Past Tests");
        gp.add(btnViewScores, 0, 1);
        
        btnViewScores.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("PastTests Clicked!");
                ViewScoresScene vss = new ViewScoresScene();
                vss.STAGE = studentDash.STAGE;
                studentDash.update(vss.getScene());
            }
        });
   
        return gp;
    }
    
    public void update(Scene newScene){
        STAGE.setScene(newScene);
        STAGE.show();
    }
}