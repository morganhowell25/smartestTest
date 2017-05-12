package smartesttest;

import java.util.ArrayList;
import static java.util.Arrays.fill;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
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
        ArrayList<ToggleGroup> answerButtons = new ArrayList<ToggleGroup>();
        
        //for each question on the test do the following
        Question[] questionList = myTest.getTestQuestions();
        for (int i = 0; i < questionList.length*5; i+=5) 
        {
            Label questionTxt = new Label((i/5+1) + ") " + questionList[i/5].getQuestion());
            gp.add(questionTxt, 2, i);

            //makes it so only one of the radio buttons maye be selcted at a time
            ToggleGroup questionAnswers = new ToggleGroup();
            
            //loops to create the toggle buttons for the answers
            String[] answers = questionList[i/5].getAnswers();
            for(int j = 1; j <= answers.length; j++) 
            {
                RadioButton ans = new RadioButton(answers[j-1]);
                ans.setToggleGroup(questionAnswers);
                gp.add(ans, 2, (j+i)); 
            }
            //used to be able to tell where we are on the gridpane to be able
            //to add the sumbit button at the end
            currentRow += i;
            //stores each answer roup so that the answers can be pulled form it later
            answerButtons.add(questionAnswers);
        }
        //list of student answers to be used with the graded test
        //sets them all to a defult value of -1
        int[] stuAns = new int[questionList.length];
        fill(stuAns, -1);
        
        //create the sumbit button
        Button btnSumbit = new Button();
        btnSumbit.setText("Sumbit");
        gp.add(btnSumbit, 4, currentRow);
        btnSumbit.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sumbit Clicked!");
                
                //loop for each group of answers loop
                for(int i = 0; i < answerButtons.size(); i++)
                {
                    //loop for each answer in the group and see if its selcted
                    //if it is add it to the list of answers
                    for(int j=0; j< answerButtons.get(i).getToggles().size(); j++)
                    {
                        if(answerButtons.get(i).getToggles().get(j).isSelected())
                            stuAns[i] = j;
                    }
                }
                //testing to see if it correctly pulls the students answers
                //#worksfristtime
                for(int x=0; x< stuAns.length; x++)
                    System.out.println("Student Answered: " + stuAns[x]);
            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
