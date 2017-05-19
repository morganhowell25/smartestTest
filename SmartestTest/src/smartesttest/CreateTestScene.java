/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class CreateTestScene extends TeacherDash {

    protected int numQ = 0; // Number of questions currently added to Test
    protected ArrayList<Question> arrQ = new ArrayList<Question>();

   public CreateTestScene(int cuID) {
        super(cuID);
    }
    
    
    public void addQuestion(Question question)
    {
        arrQ.add(question);
    }
    
    public void editQuestion(Question question, int index)
    {
        arrQ.add(index, question);
    }

    public Scene getScene(Question q, boolean editFlag, int indexEdit) {
        GridPane gp = drawTeacherDash();

        TeacherDash teacherDash = this;
        CreateTestScene cts = this;
        
        if (editFlag) {
            arrQ.set(indexEdit, q);
        }
        else if(!editFlag && q!=null){
            arrQ.add(q);
        }
        
        
        //if (q != null && !editFlag) {
            //++numQ;
            //arrQ.add(q);
            for (int i = 0; i < arrQ.size(); i++) {
                final int indexEditQ = i;
                Label lblQ = new Label("Question " + (i + 1));
                gp.add(lblQ, 1, 3 + i);
                Button btnEdit = new Button("Edit");
                gp.add(btnEdit, 2, 3 + i);

                btnEdit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Edit Clicked!");
                        AddQuestionScene aqs = new AddQuestionScene(currentUserID, cts, true);
                        aqs.STAGE = teacherDash.STAGE;
                       // editQuestion((arrQ.get(indexEditQ)), indexEditQ);
                        teacherDash.update(aqs.getScene(arrQ.get(indexEditQ), indexEditQ));
                    }
                });
            }
        //}

        System.out.println("numQ = " + numQ);
        System.out.println(arrQ);
        //Upon clicking Create Test
        Button btnFinalize = new Button("Finalize");
        gp.add(btnFinalize, 1, 0);
        btnFinalize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Finalize Button Clicked!");
                Alert finalizeAlert = new Alert(Alert.AlertType.CONFIRMATION);
                finalizeAlert.setTitle("Confirmation");
                finalizeAlert.setHeaderText(null);
                finalizeAlert.setContentText("Changes cannot be made after finalizing test.");
                finalizeAlert.showAndWait();
                //String dummyPincode = "56072";
                Random rand = new Random();
                int n = rand.nextInt(100000);
                n = n < 0 ? 0 - n : n;
                String thePin = ""+ n;
                Question [] quArr = arrQ.toArray(new Question[arrQ.size()]); 
                Test theTest = new Test(quArr, thePin, currentUserID);
                server.saveTest(thePin, currentUserID, theTest);
                finalizeAlert.setTitle("Success");
                finalizeAlert.setHeaderText(null);
                finalizeAlert.setContentText("Lesson Submitted.");
                finalizeAlert.showAndWait();
            }
        });

        /*Button btnEditQuestion = new Button("Edit");//Need to have an edit for EACH question. How?
        gp.add(btnEditQuestion,1,1);*/
        Button btnAddQuestion = new Button("+ Add Question");
        gp.add(btnAddQuestion, 1, 2);
        btnAddQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Question Clicked!");
                AddQuestionScene aqs = new AddQuestionScene(currentUserID, cts, false);
                aqs.STAGE = teacherDash.STAGE;
                teacherDash.update(aqs.getScene(null, 0));
            }
        });

        //Button btnBack = new Button("< Back");
        //gp.add(btnBack, 1, 3);    
        ScrollPane sp = new ScrollPane();
        sp.setContent(gp);
        Scene scene = new Scene(sp, 700, 500);
        return scene;
    }

}
