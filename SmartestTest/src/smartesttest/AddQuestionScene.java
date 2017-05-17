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
import javax.swing.ButtonGroup;

/**
 *
 * @author csc190
 */
public class AddQuestionScene extends TeacherDash
{
    static int current = 4; //for updating index of new textfield
    static TextField txtAnsOptionN;
    
    public AddQuestionScene()
    {
                
    }
    
    public Scene getScene()
    {
        
        GridPane gp = drawTeacherDash();
        
        //Upon clicking Add Question...
   
//Initialize some things 
        ArrayList<ArrayList<String>> deptLOs = server.pullDepartmentLOs();
        ArrayList<String> answersArr = new ArrayList<String>();
        ArrayList<TextField> textFieldArr = new ArrayList<TextField>();
        ArrayList<RadioButton> rbArr = new ArrayList<RadioButton>();
        ArrayList<RadioButton> rbLOSelect = new ArrayList<RadioButton>();
        ArrayList<String> selectedLOs = new ArrayList<String>();
        
        //Default question at start
        TextField txtQuestion = new TextField();
        TextField txtPoints = new TextField();
        TextField txtAnsOption = new TextField();  
        TextField txtAnsOption2 = new TextField();  
        
        //Label creation
        Label selectRB = new Label("Select Appropriate Learning Outcomes");
        Label selectCorrect = new Label("Select Correct");
        Label lbQuestion = new Label("Type Question Here");
        Label lbPoints = new Label("Enter Number of Points ");
        Label lbCorrect = new Label("Choose Correct Option");
        Label lbTypeOption = new Label("Please type aswer options below");
        
        //All kinds of buttons
        Button btnNewAnswerOption = new Button("Add New Option");
        ToggleGroup answerChoices = new ToggleGroup();
        RadioButton rbAnswerChoice = new RadioButton();
        rbAnswerChoice.setToggleGroup(answerChoices);             
        RadioButton rbAnswerChoice2 = new RadioButton();
        rbAnswerChoice2.setToggleGroup(answerChoices); 
        //Add to rbArr for first two RB's above
        rbArr.add(rbAnswerChoice);
        rbArr.add(rbAnswerChoice2);
//end of (main) initialization
        

        //Create radiobuttons for each department LO and add to third column
        RadioButton rbLO;
        for(int i=0; i<deptLOs.size(); i++){
            rbLO = new RadioButton(deptLOs.get(i).toString());
            gp.add(rbLO,3,i+1);
            rbLOSelect.add(rbLO);
        //rbCurr++;
        }
        
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
                txtAnsOptionN = new TextField();
                //Add newly creates option and radiobtn to their arraylists
                textFieldArr.add(txtAnsOptionN);
                rbArr.add(rbAnswerChoiceN);                
                //Add to gp
                gp.add(rbAnswerChoiceN,2,current+1);
                gp.add(txtAnsOptionN,1,current+1);
                gp.add(btnDone,1,current+2);
                gp.add(btnNewAnswerOption,2,current+2);
                current++;

                /*//Testing only
                for(int i=0; i<answersArr.size(); i++){
                    System.out.print("Answer Array: " + answersArr.get(i));
                } 
                */
                //Test here
                //String test = txtQuestion.getText();
                //System.out.println("I return: " + test);

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
        
        //Save question with all its parameters
        ButtonGroup buttonGroup = new ButtonGroup();
        btnDone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Done Buttom Clicked!");
            try{
            //GET ALL USER INPUT
                String StrQuestion = txtQuestion.getText();
                int intPoints = Integer.parseInt(txtPoints.getText());
                //Add options to arraylist                
                answersArr.add(txtAnsOption.getText());
                answersArr.add(txtAnsOption2.getText());
                //Save "N" answer options
                for(int i=0; i<textFieldArr.size();i++){
                    answersArr.add(textFieldArr.get(i).getText());
                    //System.out.println("Option: " + textFieldArr.get(i).getText() + "\n"); Testing what I add
                }
                //Find selected RB               
                int correctAns = 0;
                int index = 0;
                boolean rbSelect = false;
                while(rbSelect==false){                                                      
                    if(rbArr.get(index).isSelected()){
                        correctAns = index;
                        rbSelect = true;
                    }
                    else{
                        index++;
                    }
                }
                //System.out.println("Selected RB index = " + correctAns);
                //Find selected LOs
                for(int k=0; k<rbLOSelect.size(); k++){
                    if(rbLOSelect.get(k).isSelected()){
                        selectedLOs.add(rbLOSelect.get(k).getText());
                        System.out.println("Selected LO text = " + rbLOSelect.get(k).getText());
                    }
                }
            //End get user input
                /*TestArray
                for(int i=0; i<answersArr.size(); i++){
                    System.out.print("Answer Array: " + answersArr.get(i)+ "\n");
                }
                */                
                //Finally... save the question. Call contructor.
                //Question myQ = Question(StrQuestion, answersArr, intPoints, correctAns, selectedLOs);
                
                //Now go back to old scene
                //but how
            }
                
                catch(NumberFormatException exc){
                    System.out.println("You must enter a point value: " + exc);
                }                
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
        gp.add(selectRB,4,0);
        //gp.add(lbCorrect,2,2);
        //gp.add(rbAnswerChoice,1,3);     
        //gp.add(rbLO,1,3);         
        //end Add GridPane
            
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
   
    }           
    
}
