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

/**
 *
 * @author csc190
 */
public class CreateTestScene extends TeacherDash
{
    public CreateTestScene()
    {
        
    }
    
    public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
        
        //Upon clicking Create Test
        
        Button btnFinalize = new Button("Finalize");
        gp.add(btnFinalize,1,0);
        
        Button btnEditQuestion = new Button("Edit");//Need to have an edit for EACH question. How?
        gp.add(btnEditQuestion,1,1);
        
        Button btnAddQuestion = new Button("+ Add Question");
        gp.add(btnAddQuestion,1,2);
        
        btnAddQuestion.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Question Clicked!");
                AddQuestionScene aqs = new AddQuestionScene();               
            }
        });
        
        Button btnBack = new Button("< Back");
        gp.add(btnBack, 1, 3);        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
