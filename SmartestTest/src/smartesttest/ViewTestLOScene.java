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
public class ViewTestLOScene extends TeacherDash {
    
    @Override
    public Scene getScene() {
        
        GridPane gp = drawTeacherDash();
        
        Label lblTitle = new Label();
        lblTitle.setText("Learning Outcomes");
        gp.add(lblTitle, 1, 0);
        
        Label lblTestCode = new Label();
        lblTestCode.setText("Test Code: 87961");
        gp.add(lblTestCode, 1, 1);
        
        Label lblLO = new Label();
        lblLO.setText("Learning Outcomes     ");
        gp.add(lblLO, 1, 2);
        
        Label lblStats = new Label();
        lblStats.setText("Stats");
        gp.add(lblStats, 2, 2);
        
        Label lblLO1 = new Label();
        lblLO1.setText("LO1");
        gp.add(lblLO1, 1, 3);
        
        Label lblStats1 = new Label();
        lblStats1.setText("(5 + 7)/20");
        gp.add(lblStats1, 2, 3);
        
        Label lblLO2 = new Label();
        lblLO2.setText("LO2");
        gp.add(lblLO2, 1, 4);
        
        Label lblStats2 = new Label();
        lblStats2.setText("3/10");
        gp.add(lblStats2, 2, 4);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
        
    }
}
