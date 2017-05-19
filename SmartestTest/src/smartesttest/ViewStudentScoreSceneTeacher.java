/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class ViewStudentScoreSceneTeacher extends TeacherDash {

    protected GradedTest myGradedTest;

    public ViewStudentScoreSceneTeacher(GradedTest test, int cuID) {
        super(cuID);
        myGradedTest = test;
    }

    public Scene getScene() {
        GridPane gp = drawTeacherDash();
        
        Label score = new Label("Score: "+ myGradedTest.getScore()+"/"+
                myGradedTest.getTotalPoints()+" = " + myGradedTest.getPercent()+"%");
        gp.add(score, 3, 0);

        //for each question on the test do the following
        Question[] questionList = myGradedTest.getTest().getTestQuestions();
        //Gets the highest number of answers form the questions and uses that to adress spacing on the gridpane
        int highestNumAns = -1;
        for(Question q: questionList)
        {
            if(q.getAnswers().length > highestNumAns)
                highestNumAns = q.getAnswers().length+1;
        }
        
        for (int i = 0; i < questionList.length * highestNumAns; i += highestNumAns) {
            Label questionTxt = new Label((i / highestNumAns + 1) + ") " +
                    questionList[i / highestNumAns].getQuestion());
            gp.add(questionTxt, 1, i);

            //makes it so only one of the radio buttons maye be selcted at a time
            ToggleGroup questionAnswers = new ToggleGroup();

            //loops to create the radio buttons for the answers
            String[] answers = questionList[i / highestNumAns].getAnswers();
            for (int j = 1; j <= answers.length; j++) {
                RadioButton ans1 = new RadioButton(answers[j - 1]);
                ans1.setToggleGroup(questionAnswers);
                gp.add(ans1, 1, (j + i));
                if (questionList[i / highestNumAns].getCorrectAnswer() == (j - 1)) {
                    Label correctAns = new Label("<<<<< Correct Answer is #"+j);
                    gp.add(correctAns, 2, (j + i));
                }
                //Sets the radio buttons to show the students answer
                if ((j - 1) == myGradedTest.getStuAns()[i / highestNumAns]) {
                    ans1.setSelected(true);
                }
                //Disables the buttons so the student can not press them
                ans1.setDisable(true);
            }
        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(gp);
        Scene scene = new Scene(sp, 700, 500);
        return scene;
    }
}
