package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class ViewScoresScene extends StudentDash
{   
    public Scene getScene()
    {
        GridPane gp = drawStudentDash();
        
        //Show a table of tests taken some editing needs to be done to 
        //make it look pretty will be done dyanmically based on the 
        //information pulled form DB
        Label testList = new Label("Tests Taken");
        gp.add(testList, 1, 0);
        Label scoreList = new Label("Score");
        gp.add(scoreList, 2, 0);
        
        Label testPinCode = new Label("8675309");
        gp.add(testPinCode, 1, 1);
        Label testScore = new Label("34/75");
        gp.add(testScore, 2, 1);
        Button testBtn = new Button("View Results");
        gp.add(testBtn, 3, 1);
        
        Label testPinCode2 = new Label("1234567");
        gp.add(testPinCode2, 1, 2);
        Label testScore2 = new Label("84/100");
        gp.add(testScore2, 2, 2);
        Button testBtn2 = new Button("View Results");
        gp.add(testBtn2, 3, 2);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
