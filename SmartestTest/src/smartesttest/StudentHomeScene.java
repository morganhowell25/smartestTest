/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class StudentHomeScene extends StudentDash{
    
    public StudentHomeScene(int cuID) {
        super(cuID);
    }
    
    public Scene getScene()
    {
        GridPane gp = drawStudentDash();
        
        Label welcome = new Label("Welcome to the Student Dash!");
        gp.add(welcome,1,0);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}