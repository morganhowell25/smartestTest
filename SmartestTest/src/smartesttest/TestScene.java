package smartesttest;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class TestScene extends StudentDash {
    private Test myTest; 

    public TestScene(Test test) {
        myTest = test;
    }

    public Scene getScene() {
        GridPane gp = drawStudentDash();

        int currentRow=0;
        ArrayList<RadioButton> answerButtons = new ArrayList<RadioButton>();
        
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
                answerButtons.add(ans1);
            }
            currentRow += i;
        }
        
        Button btnSumbit = new Button();
        btnSumbit.setText("Sumbit");
        gp.add(btnSumbit, 5, currentRow);
        btnSumbit.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sumbit Clicked!");
                for(RadioButton btn : answerButtons)
                {
                    
                }
            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
