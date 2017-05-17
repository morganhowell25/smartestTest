package smartesttest;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class ViewScoresScene extends StudentDash {

    public Scene getScene() {
        GridPane gp = drawStudentDash();
        
        StudentDash studentDash = this;
        
        int studentid = 0;
        ArrayList<String> takenTests = server.pullTakenTestList(studentid);

        Label testList = new Label("Tests Taken");
        gp.add(testList, 1, 0);

        for (int i = 0; i < takenTests.size(); i++) {
            Label testPinCode = new Label(takenTests.get(i));
            gp.add(testPinCode, 1, i + 1);

            Button btnViewScores = new Button();
            btnViewScores.setText("View Test");
            gp.add(btnViewScores, 2, i+1);
            final int index = i;

            btnViewScores.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("View Test Clicked!");
                    GradedTest gt = server.pullStudentGradedTest(studentid, (takenTests.get(index)));

                    ViewStudentScoreScene scoreScene = new ViewStudentScoreScene(gt);
                    scoreScene.STAGE = studentDash.STAGE;
                    studentDash.update(scoreScene.getScene());
                }
            });
        }

     
        ScrollPane sp = new ScrollPane();
        sp.setContent(gp);
        Scene scene = new Scene(sp, 700, 500);
        return scene;
    }
}
