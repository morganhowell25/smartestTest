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
public class TestScene extends StudentDash {

    public TestScene() {

    }

    public Scene getScene() {
        GridPane gp = drawStudentDash();

        //for each question on the test do the following
        for (int i = 0; i < 15; i+=5) 
        {
            Label questionTxt = new Label((i/5+1) + ") Question text goes here");
            gp.add(questionTxt, 1, i);

            //makes it so only one of the radio buttons maye be selcted at a time
            ToggleGroup questionAnswers = new ToggleGroup();
            
            //loops to create the radio buttons for the answers
            //can be changed instead of 5 to be less than the questions array of answers
            //in final implementation.
            for(int j = 1; j < 5; j++) 
            {
                RadioButton ans1 = new RadioButton("answer " + j);
                ans1.setToggleGroup(questionAnswers);
                gp.add(ans1, 1, (j+i));                
            }
        }

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
