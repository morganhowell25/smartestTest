/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

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
public class TeacherDash extends DashBoard {
        
    protected Scene SCENE;
    protected Stage STAGE;
    protected int currentUserID;

    public void start(Stage primaryStage){
        STAGE = primaryStage;
        
        //TeacherHomeScene ths = new TeacherHomeScene();
        StudentScoresListScene ths = new StudentScoresListScene("99999");
        ths.STAGE = this.STAGE;
        SCENE = ths.getScene();
        
        STAGE.setTitle("SmartTest");
        update(SCENE);
    }
    
    public GridPane drawTeacherDash()
    {
        GridPane gp = new GridPane();
        
        TeacherDash teacherDash = this;
        
        //We should create the buttons in a method and call this method
        // here. would make the code more readable. ie createTestButton()
        Button btnCreateTest = new Button();
        btnCreateTest.setText("Create Test");
        gp.add(btnCreateTest, 0, 0);
        
        btnCreateTest.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("CreateTest Clicked!");
                CreateTestScene cts = new CreateTestScene();
                cts.STAGE = teacherDash.STAGE;
                teacherDash.update(cts.getScene(null));
            }
        });
        
        Button btnManageTests = new Button();
        btnManageTests.setText("Manage Tests");
        gp.add(btnManageTests, 0, 1);
        
        btnManageTests.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ManageTests Clicked!");
                ManageTestsScene mts = new ManageTestsScene();
                mts.STAGE = teacherDash.STAGE;
                teacherDash.update(mts.getScene());
            }
        });
        
        Button btnViewLO = new Button();
        btnViewLO.setText("View Department LO's");
        gp.add(btnViewLO, 0, 2);
        
        btnViewLO.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("ViewLO Clicked!");
                ViewDepartmentLOScene vdlos = new ViewDepartmentLOScene();
                vdlos.STAGE = teacherDash.STAGE;
                teacherDash.update(vdlos.getScene());
            }
        });
        
        return gp;
    }
    
    public void update(Scene newScene){
        STAGE.setScene(newScene);
        STAGE.show();
    }
}
