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
public class ManageTestsScene extends TeacherDash
{


    public ManageTestsScene()
    {
    
    }
    
    public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
       
        //Upon clicking Manage Tests
        
        //Labels
        Label lbMenu = new Label("List of Tests");
        Label lbCodes = new Label("Test Code");
        Label lbScores = new Label("Student Scores");
        Label lbLO = new Label("Learning Outcomes");
        
        //Add values into table somehow...
        
        //Add to GridPane
        gp.setHgap(40);
        gp.add(lbMenu,1,0);
        gp.add(lbCodes,1,1);
        gp.add(lbScores,2,1);
        gp.add(lbLO,3,1);
        //end add to GridPane
  
    
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }    
}
