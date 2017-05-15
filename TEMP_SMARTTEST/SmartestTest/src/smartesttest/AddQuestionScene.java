/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
        
        //Default question
        TextField txtQuestion = new TextField("Type Question Here");
        TextField txtOption = new TextField("Type Option Here");  
        TextField txtPoints = new TextField("Enter Number of Points");
        RadioButton rbLO = new RadioButton("Learning Outcome 1");
     
        //Add to GridPane
        gp.add(txtQuestion,1,0);
        //gp.add(lbQuantity,1,1);
        //gp.add(comboBox,2,1);
        //gp.add(lbCorrect,2,2);
        gp.add(txtOption,1,1);
        //gp.add(rbAnswerChoice,1,3);
        //gp.add(lbPoints,1,4);
        gp.add(txtPoints,1,2);
        gp.add(rbLO,1,3);         
        //gp.add(btnBack,1,6);
        //end Add GridPane
        
        //Label lbPoints = new Label("Enter Number of Points ");
        //Label lbQuantity = new Label("How many options?");
        //Label lbCorrect = new Label("Choose Correct Option");
        
        Button btnNewAnswerOption = new Button("Add New Option");
        
        ToggleGroup answerChoices = new ToggleGroup();
        
        int k=2;
        int q=k;
        
        btnNewAnswerOption.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                RadioButton rbAnswerChoice = new RadioButton("Select Correct");
                rbAnswerChoice.setToggleGroup(answerChoices);              
                TextField txtOption = new TextField("Type Option Here"); 
                gp.add(rbAnswerChoice,1,q);
                //q = 1 + q;
            }   
        });     
        
        //Buttons
        Button btnDone = new Button("Done");
        gp.add(btnDone,2,6);
               
        /*
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
        */
        
        
        btnDone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Done Buttom Clicked!");
                //Now return to test!
            }   
        });    
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
   
    }           
    
}
