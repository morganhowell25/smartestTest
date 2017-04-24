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
        for (int i = 0; i < 11; i+=5) 
        {
            Label questionTxt = new Label((i/5+1) + ") Question text goes here");
            gp.add(questionTxt, 1, i);

            ToggleGroup questionAnswers = new ToggleGroup();
            int j = 1;
            while(j < 5) 
            {
                RadioButton ans1 = new RadioButton("answer " + j);
                ans1.setToggleGroup(questionAnswers);
                gp.add(ans1, 1, (j+i));
                j++;
            }
            j = 1;
        }

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
