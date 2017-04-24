/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
/**
 *
 * @author csc190
 */
public class AddQuestionScene extends TeacherDash
{
    public AddQuestionScene()
    {
                
    }
    public Scene getScene()
    {
        GridPane gp = drawTeacherDash();
        
        //Upon clicking Add Question
        
        //TextFields
        TextField txtQuestion = new TextField("Type Question Here");
        TextField txtOption = new TextField("Type Option Here");  
        TextField txtPoints = new TextField();
        
        //Labels
        Label lbPoints = new Label("Enter Number of Points ");
        Label lbQuantity = new Label("How many options?");
        Label lbCorrect = new Label("Choose Correct Option");
        
        //Radio Buttons
        RadioButton rbLO = new RadioButton("Learning Outcome 1");
        RadioButton rbCorrect = new RadioButton();
        
        //Buttons
        Button btnDone = new Button("Done");
        Button btnBack = new Button("< Back");        
        
        //Creating the Drop Down
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "1",
                        "2", //How many options should we allow?
                        "3",
                        "4"
                );
        ComboBox comboBox = new ComboBox(options);
        comboBox.setItems(options);
        //end Drop Down creation
        
        //Add to GridPane
        gp.add(txtQuestion,1,0);
        gp.add(lbQuantity,1,1);
        gp.add(comboBox,2,1);
        gp.add(lbCorrect,2,2);
        gp.add(txtOption,1,3);
        gp.add(rbCorrect,2,3);
        gp.add(lbPoints,1,4);
        gp.add(txtPoints,2,4);
        gp.add(rbLO,1,5);        
        gp.add(btnDone,2,6); 
        gp.add(btnBack,1,6);
        //end Add GridPane
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }           
    
}
