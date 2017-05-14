/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class ViewStudentScoreSceneTeacher extends TeacherDash 
{
    protected GradedTest myTest;
    
    public ViewStudentScoreSceneTeacher(GradedTest test)
    {
        myTest = test;
    }

    public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
        
       Label score = new Label("Score: XX/YY = ZZ%");
        gp.add(score, 3, 0);
        
        //for each question on the test do the following
        Question[] questionList = myTest.getTestQuestions();
        for (int i = 0; i < questionList.length*5; i+=5) 
        {
            Label questionTxt = new Label((i/5+1) + ") " + questionList[i/5].getQuestion());
            gp.add(questionTxt, 1, i);

            //makes it so only one of the radio buttons maye be selcted at a time
            ToggleGroup questionAnswers = new ToggleGroup();
            
            //loops to create the radio buttons for the answers
            //can be changed instead of 5 to be less than the questions array of answers
            //in final implementation.
            String[] answers = questionList[i/5].getAnswers();
            for(int j = 1; j <= answers.length; j++) 
            {
                RadioButton ans1 = new RadioButton(answers[j-1]);
                ans1.setToggleGroup(questionAnswers);
                gp.add(ans1, 1, (j+i));
                if(questionList[i/5].getCorrectAnswer() == (j-1))
                {
                    Label correctAns = new Label("<<<<< Correct Answer!");
                    gp.add(correctAns, 2, (j+i));
                }
            }
        }
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }   
}