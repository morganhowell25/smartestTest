/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    static int current = 4;
    static int rbCurr = 60;
    
    public AddQuestionScene()
    {
                
    }
    public Scene getScene()
    {
        
        GridPane gp = drawTeacherDash();
        
        //Upon clicking Add Question...
        
        ArrayList<ArrayList<String>> deptLOs = utils.pullDepartmentLOs();
        ArrayList<String> answersArr = new ArrayList<String>();
        
        //Default question
        TextField txtQuestion = new TextField();
        TextField txtPoints = new TextField();
        TextField txtAnsOption = new TextField();  
        TextField txtAnsOption2 = new TextField();  

        RadioButton rbLO = new RadioButton();
        //Create radiobuttons for each department LO and add to bottom
        for(int i=0; i<deptLOs.size(); i++){
        rbLO = new RadioButton(deptLOs.get(i).toString());
        gp.add(rbLO,1,rbCurr);
        rbCurr++;
        }
        
        Label selectRB = new Label("Select Appropriate Learning Outcomes");
        Label selectCorrect = new Label("Select Correct");
        Label lbQuestion = new Label("Type Question Here");
        Label lbPoints = new Label("Enter Number of Points ");
        Label lbCorrect = new Label("Choose Correct Option");
        Label lbTypeOption = new Label("Please type aswer options below");
        Button btnNewAnswerOption = new Button("Add New Option");
        ToggleGroup answerChoices = new ToggleGroup();
        RadioButton rbAnswerChoice = new RadioButton();
        rbAnswerChoice.setToggleGroup(answerChoices);             
        RadioButton rbAnswerChoice2 = new RadioButton();
        
        rbAnswerChoice2.setToggleGroup(answerChoices); 
        
        //Buttons
        Button btnDone = new Button("Done");
        gp.add(btnDone,1,7);
        gp.add(btnNewAnswerOption,2,7);
        
        //This button action is soley for adding more answers choices.
        btnNewAnswerOption.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gp.getChildren().remove(btnDone);
                gp.getChildren().remove(btnNewAnswerOption);
                RadioButton rbAnswerChoiceN = new RadioButton();
                rbAnswerChoiceN.setToggleGroup(answerChoices);              
                TextField txtAnsOptionN = new TextField();
                answersArr.add(txtAnsOption.toString());
                gp.add(rbAnswerChoiceN,2,current);
                gp.add(txtAnsOptionN,1,current);
                gp.add(btnDone,1,current+2);
                gp.add(btnNewAnswerOption,2,current+2);
                current++;
            }   
        });     
        

               
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
                //Save the question. Call contructor.
                //Question myQ = Question(txtQuestion, answersArr, txtPoints, correctAns, selectedLOs);
                
            }
        });
            
        //Add to GridPane
        gp.add(txtQuestion,1,0);
        gp.add(txtPoints,1,1);
        gp.add(txtAnsOption,1,3);
        gp.add(txtAnsOption2,1,4);
        gp.add(rbAnswerChoice,2,3);
        gp.add(rbAnswerChoice2,2,4);
        gp.add(lbQuestion,2,0);
        gp.add(lbPoints,2,1);
        gp.add(lbTypeOption, 1,2);
        gp.add(selectCorrect,2,2);
        gp.add(selectRB,1,5);

        //gp.add(lbCorrect,2,2);
        //gp.add(rbAnswerChoice,1,3);
       
        //gp.add(rbLO,1,3);         
        //end Add GridPane
            
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
   
    }           
    
}