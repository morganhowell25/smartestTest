/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class ViewTestLOScene extends TeacherDash {
    
    public Scene getScene(String pincode) {
        
        GridPane gp = drawTeacherDash();
        
        ArrayList<ArrayList<String>> testLOs = server.pullTestLO(pincode);
        
        Label Cat1 = new Label("Category 1");
        gp.add(Cat1,1,0);
        Label Cat2 = new Label("Category 2");
        gp.add(Cat2,2,0);
        Label Correct = new Label("Correct Answers");
        gp.add(Correct,3,0);
        Label Total = new Label("Total");
        gp.add(Total,4,0);
        
        for(int i = 0; i < testLOs.get(0).size(); i++){
            Cat1 = new Label(testLOs.get(0).get(i));
            gp.add(Cat1,1,i+1);
            Cat2 = new Label(testLOs.get(1).get(i));
            gp.add(Cat2,2,i+1);
            Correct = new Label(testLOs.get(2).get(i));
            gp.add(Correct,3,i+1);
            Total = new Label(testLOs.get(3).get(i));
            gp.add(Total,4,i+1);
        }
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
        
    }
}
