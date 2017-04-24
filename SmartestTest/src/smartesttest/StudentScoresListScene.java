/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class StudentScoresListScene extends TeacherDash {
    
    @Override
    public Scene getScene() {
        
        GridPane gp = drawTeacherDash();
        
        Label lblTitle = new Label();
        lblTitle.setText("Student Scores");
        gp.add(lblTitle, 1, 0);
        
        Label lblTestCode = new Label();
        lblTestCode.setText("Test Code: 87961");
        gp.add(lblTestCode, 1, 1);
        
        Label lblStu1 = new Label();
        lblStu1.setText("Matt");
        gp.add(lblStu1, 1, 2);
        
        Button btnViewScore1 = new Button();
        btnViewScore1.setText("View Score");
        gp.add(btnViewScore1, 2, 2);
        
        Label lblStu2 = new Label();
        lblStu2.setText("John");
        gp.add(lblStu2, 1, 3);
        
        Button btnViewScore2 = new Button();
        btnViewScore2.setText("View Score");
        gp.add(btnViewScore2, 2, 3);
        
        Label lblStu3 = new Label();
        lblStu3.setText("Victor");
        gp.add(lblStu3, 1, 4);
        
        Button btnViewScore3 = new Button();
        btnViewScore3.setText("View Score");
        gp.add(btnViewScore3, 2, 4);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
