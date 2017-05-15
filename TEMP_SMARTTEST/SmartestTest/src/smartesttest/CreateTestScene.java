/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

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
             
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
