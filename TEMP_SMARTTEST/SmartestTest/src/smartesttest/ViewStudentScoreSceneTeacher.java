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
public class ViewStudentScoreSceneTeacher extends TeacherDash 
{

public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
        
        Label score = new Label("Score: XX/YY = ZZ%");
        gp.add(score, 3, 0);
        
        //for each question on the test do the following
        for (int i = 0; i < 15; i+=5) 
        {
            Label questionTxt = new Label((i/5+1) + ") Question text goes here");
            gp.add(questionTxt, 1, i+1);

            for(int j = 1; j < 5; j++) 
            {
                Label ans1 = new Label("answer " + j);
                gp.add(ans1, 1, (j+i+1));                
            }
            //Something that gets the correct answer
            //highlight the correct answer
            Label correctAnswer = new Label("<<< The correct answer!");
            gp.add(correctAnswer, 2, i+3);
        }
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }   
}