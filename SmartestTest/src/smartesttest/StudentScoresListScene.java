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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class StudentScoresListScene extends TeacherDash {

    protected String pincode; // The pincode of the specific test that the teacher is viewing the student scores for

    // Specific Constructor: pass in pincode from ManageTestsScene when clicking the "View Student Scores" button for a specific test.
    public StudentScoresListScene(String pincode) {
        this.pincode = pincode;
    }

    public Scene getScene() {

        GridPane gp = drawTeacherDash();

        TeacherDash teacherDash = this;

        // Five controls below are default controls and will always appear on the scene.
        Label lblTitle = new Label();
        lblTitle.setText("Student Scores");
        gp.add(lblTitle, 1, 0);

        Label lblTestCode = new Label();
        lblTestCode.setText("Test Code: " + pincode);
        gp.add(lblTestCode, 1, 1);

        Label lblID = new Label();
        lblID.setText("ID");
        gp.add(lblID, 1, 2);

        Label lblStudent = new Label();
        lblStudent.setText("Student          "); // Add spaces to separate the columns
        gp.add(lblStudent, 2, 2);

        Label lblScore = new Label();
        lblScore.setText("Score");
        gp.add(lblScore, 3, 2);

        // Collect a set of corresponding unames and scores that match the give pincode.
        ArrayList<StudentScoresListStruct> arrSSLStruct = server.viewStudentScores(pincode);

        // Test case: if no students have taken the specific test, don't open the scene, and return to ManageTestsScene.
        // IDK if this will work.
        /*if (arrSSLStruct.isEmpty()) {
            TeacherDash.btnManageTests.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ManageTests Clicked!");
                ManageTestsScene mts = new ManageTestsScene();
                mts.STAGE = teacherDash.STAGE;
                teacherDash.update(mts.getScene());
            }
        });
        }*/
        
        // Pop up a dialog box with a warning that no students have taken the test
        if (arrSSLStruct.isEmpty()) { // If no students have taken the specific test
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText(null);
            alert.setContentText("No students have taken this test!");
            alert.showAndWait();
        } else { // At least one student has taken the specific test
            // Create four controls in the same row for each student that took the specific test.
            System.out.println(String.valueOf(arrSSLStruct.size()));
            for (int i = 0; i < arrSSLStruct.size(); i++) {
                // Add each student's id to a label
                Label lblStuID = new Label();
                lblStuID.setText(String.valueOf(arrSSLStruct.get(i).id));
                gp.add(lblStuID, 1, i + 3);

                // Add each student's uname to a label
                Label lblUname = new Label();
                lblUname.setText(arrSSLStruct.get(i).uname);
                gp.add(lblUname, 2, i + 3);

                // Add each student's correspoding score to a label in the same row
                Label lblStuScore = new Label();
                lblStuScore.setText(arrSSLStruct.get(i).score);
                gp.add(lblStuScore, 3, i + 3);

                // Add a "View Score" button for each row in the table
                Button btnViewScore = new Button();
                btnViewScore.setText("View Score");
                gp.add(btnViewScore, 4, i + 3);

                // Might need to change this implementation.
                // Might need to change Constructor in ViewStudentScoreSceneTeacher to take as paramters student's id and pincode
                // so, in that class, you can call "pullStudentGradedTest(int id, int pincode);" This method will return the GradedTest object
                // that belongs to the student, and then ViewStudentScoreSceneTeacher would handle the GradedTest.
                btnViewScore.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("View Score Clicked!");
                        GradedTest gt = new GradedTest();
                        ViewStudentScoreSceneTeacher vssst = new ViewStudentScoreSceneTeacher(gt);
                        vssst.STAGE = teacherDash.STAGE;
                        teacherDash.update(vssst.getScene());
                    }
                });
            }
        }

        // These four controls are for testing purposes, so the Scene doesn't load blank before we load the database and test if the 
        // above code works. They will be removed once above code is confirmed to work.
        /*Label lblID1 = new Label();
        lblID1.setText("005");
        gp.add(lblID1, 1, 3);

        Label lblStu1 = new Label();
        lblStu1.setText("Matt");
        gp.add(lblStu1, 2, 3);

        Label lblStuScore1 = new Label();
        lblStuScore1.setText("95");
        gp.add(lblStuScore1, 3, 3);

        Button btnViewScore1 = new Button();
        btnViewScore1.setText("View Score");
        gp.add(btnViewScore1, 4, 3);*/
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}