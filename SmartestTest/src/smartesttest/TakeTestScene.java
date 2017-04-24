/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class TakeTestScene extends StudentDash
{
    public TakeTestScene()
    {
        
    }
            
    public Scene getScene()
    {
        GridPane gp = drawStudentDash();
        
        Label l = new Label("Insert Pincode");
        gp.add(l,1,0);
        
        TextField input = new TextField();
        gp.add(input,1,1);
        
        Button sub = new Button("Submit");
        gp.add(sub,1,2);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}

