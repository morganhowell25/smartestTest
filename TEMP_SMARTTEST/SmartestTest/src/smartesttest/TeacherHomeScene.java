/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author csc190
 */
public class TeacherHomeScene extends TeacherDash{
        
    public Scene getScene(){
        GridPane gp = drawTeacherDash();
        
        Text scenetitle = new Text("Welcome! Please Select A Tab.");
        gp.add(scenetitle, 1, 0);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
