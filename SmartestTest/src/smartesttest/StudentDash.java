/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public abstract class StudentDash  implements AppScene
{
    public GridPane drawTeacherDash()
    {
        GridPane gp = new GridPane();
        
        Button btnTakeTest = new Button();
        btnTakeTest.setText("Take Test");
        gp.add(btnTakeTest, 0, 0);
        
        Button btnViewScores = new Button();
        btnViewScores.setText("View Scores");
        gp.add(btnViewScores, 0, 1);
        
        return gp;
    }
}
