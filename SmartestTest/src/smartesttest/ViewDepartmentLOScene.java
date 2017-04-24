/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class ViewDepartmentLOScene extends TeacherDash
{
    public ViewDepartmentLOScene()
    {
        
    }
            
    public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
        
        TitledPane tp = new TitledPane();
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Java"), 0, 0);
        grid.add(new Button("View LO"), 1, 0);
        grid.add(new Label("C++"), 0, 1);
        grid.add(new Button("View LO"), 1, 1);
        grid.add(new Label("C#"), 0, 2);
        grid.add(new Button("View LO"), 1, 2);
        tp.setText("Syntax");
        tp.setContent(grid);
        gp.add(tp,1,0);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}

