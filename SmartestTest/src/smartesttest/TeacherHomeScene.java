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
    public TeacherHomeScene(){
        
    }
    
    public Scene getScene(){
        GridPane gp = drawTeacherDash();
        
        Text scenetitle = new Text("SELECT A TAB");
        gp.add(scenetitle, 0, 0, 2, 1);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
