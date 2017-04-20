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
public abstract class TeacherDash  implements AppScene
{
    public GridPane drawTeacherDash()
    {
        GridPane gp = new GridPane();
        
        Button btnCreateTest = new Button();
        btnCreateTest.setText("Create Test");
        gp.add(btnCreateTest, 0, 0);
        
        Button btnManageTest = new Button();
        btnManageTest.setText("Manage Testsssssssssssss");
        gp.add(btnManageTest, 0, 1);
        
        Button btnViewLO = new Button();
        btnViewLO.setText("View Department LO's");
        gp.add(btnViewLO, 0, 2);
        
        return gp;
    }
}
