/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;



import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import static smartesttest.server.pullTests;

/**
 *
 * @author csc190
 */
public class ManageTestsScene extends TeacherDash{
    
    public ManageTestsScene(int cuID) {
        super(cuID);
    }
    //hold until we have tid
    int tid = 0;
    
    public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
        ManageTestsScene mts = this;
        //Upon clicking Manage Tests
        
        //Labels
        Label lbCodes = new Label("Test Code");
        Label lbScores = new Label("Student Scores");
        Label lbLO = new Label("Learning Outcomes");
        
        ArrayList<String> tTests = pullTests(tid);
        for (int i = 0; i<tTests.size(); i++){
            final int x = i;
            Label pin = new Label(tTests.get(i));
            gp.add(pin,1,i+2);
            Button score = new Button("View Student Scores");
            gp.add(score,2,i+2);
            Button LOs = new Button("View Test LOs");
            gp.add(LOs,3,i+2);
            score.setOnAction(new EventHandler<ActionEvent>() { 
                    @Override
                    public void handle(ActionEvent event) {
                        StudentScoresListScene ssls = new StudentScoresListScene(/*tTests.get(x)*/ currentUserID);
                        ssls.STAGE = mts.STAGE;
                        mts.update(ssls.getScene());
                    }
            });
            LOs.setOnAction(new EventHandler<ActionEvent>() { 
                    @Override
                    public void handle(ActionEvent event) {
                        ViewTestLOScene vtl = new ViewTestLOScene(currentUserID);
                        vtl.STAGE = mts.STAGE;
                        mts.update(vtl.getScene(tTests.get(x)));
                    }
            });
        }
        
        //Add to GridPane
        gp.setHgap(40);
        gp.add(lbCodes,1,1);
        gp.add(lbScores,2,1);
        gp.add(lbLO,3,1);
        //end add to GridPane
  
    
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }    
}
