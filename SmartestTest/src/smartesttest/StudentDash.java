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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class StudentDash extends DashBoard
{
    protected Scene SCENE;
    protected Stage STAGE;
    protected int currentUserID;
          
    public void start(Stage primaryStage){
        STAGE = primaryStage;
        
        Question[] questions = new Question[6];
        questions[0] = new Question();
        String[] answers = new String[]{"andy", "is a", "butt"};
        questions[1] = new Question("Question here", answers, 1, 2, new ArrayList<ArrayList<String>>());
        questions[2] = new Question();
        String[] answers1 = new String[]{"True", "False"};
        questions[3] = new Question("Question here", answers1, 1, 1, new ArrayList<ArrayList<String>>());
        String[] answers2 = new String[]{"andy", "is a", "butt", "can","this","have","more answers?"};
        questions[4] = new Question("Question here What happens if I use a \n in the question", answers2, 1, 2, new ArrayList<ArrayList<String>>());
        questions[5] = new Question();
        
        //Notes Run time issue 2 of them.
        // Need to be able to scroll, tests ill have mutiple questions. Applies to all scenes.
        // If there are more than 5 answers it overlaps.
                
        Test t = new Test(questions, 8675309, 72);
        GradedTest gt = new GradedTest(t, new int[]{0,2,2,1,6,0}, 23);
        gt.grade();
        //TestScene shs = new TestScene(t);
        //ViewStudentScoreSceneTeacher shs = new ViewStudentScoreSceneTeacher(gt);
        //ViewStudentScoreScene shs = new ViewStudentScoreScene(gt);
        StudentHomeScene shs = new StudentHomeScene();
        shs.STAGE = this.STAGE;
        SCENE = shs.getScene();
        
        STAGE.setTitle("SmartTest");
        update(SCENE);
    } 
    
    public GridPane drawStudentDash()
    {
        GridPane gp = new GridPane();
        
        StudentDash studentDash = this;
        
        Button btnTakeTest = new Button();
        btnTakeTest.setText("Take Test");
        gp.add(btnTakeTest, 0, 0);

        btnTakeTest.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("TakeTest Clicked!");
                TakeTestScene tts = new TakeTestScene();
                tts.STAGE = studentDash.STAGE;
                studentDash.update(tts.getScene());
            }
        });
        
        Button btnViewScores = new Button();
        btnViewScores.setText("Past Tests");
        gp.add(btnViewScores, 0, 1);
        
        btnViewScores.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("PastTests Clicked!");
                ViewScoresScene vss = new ViewScoresScene();
                vss.STAGE = studentDash.STAGE;
                studentDash.update(vss.getScene());
            }
        });
   
        return gp;
    }
    
    public void update(Scene newScene){
        STAGE.setScene(newScene);
        STAGE.show();
    }
}