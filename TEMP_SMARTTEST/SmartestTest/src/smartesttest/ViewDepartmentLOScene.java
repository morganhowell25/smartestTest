/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import static smartesttest.utils.pullDepartmentLOs;

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
        int hold = 0;
        int j = 0;
        int k = 0;
        
        ArrayList<ArrayList<String>> LOs = pullDepartmentLOs();
        
        for(int i = 0; i < LOs.get(0).size(); i++){
            hold = i;
            tp = new TitledPane();
            grid = new GridPane();
            grid.setVgap(4);
            grid.setPadding(new Insets(5, 5, 5, 5));
            k = 0;
            while(i<LOs.get(0).size() && LOs.get(0).get(hold).equals(LOs.get(0).get(i))){
                grid.add(new Label(LOs.get(1).get(i)+": "+LOs.get(2).get(i)+"/"+LOs.get(3).get(i)), 0, k);
                k++;
                if(i<LOs.get(0).size()-1 && !LOs.get(0).get(hold).equals(LOs.get(0).get(i+1))){
                    tp.setText(LOs.get(0).get(hold)+": "+LOs.get(2).get(hold)+"/"+LOs.get(3).get(hold));
                    tp.setContent(grid);
                    gp.add(tp,1,j);
                    j++;
                }
                i++;
            }
        }
        tp.setText(LOs.get(0).get(hold)+": "+LOs.get(2).get(hold)+"/"+LOs.get(3).get(hold));
        tp.setContent(grid);
        gp.add(tp,1,j);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}

