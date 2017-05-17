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
import javafx.scene.control.Alert;
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
public class AddQuestionScene extends TeacherDash {

    static int current = 4; //for updating index of new textfield
    static TextField txtAnsOptionN;
    static RadioButton rbAnswerChoiceN;
    protected CreateTestScene cts = null;
    protected boolean editFlag = false;

    public AddQuestionScene(CreateTestScene cts, boolean editFlag) {
        this.cts = cts;
        this.editFlag = editFlag;
    }

    public Scene getScene(Question myQ, int indexEditQ) {
        TeacherDash teachDash = this;

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
        //Add first two fields to array
        //if(myQ==null){
        textFieldArr.add(txtAnsOption);
        textFieldArr.add(txtAnsOption2);
        //}
        //Label creation
        Label selectRB = new Label("Select Appropriate Learning Outcomes");
        Label selectCorrect = new Label("Select Correct");
        Label lbQuestion = new Label("Type Question Here");
        Label lbPoints = new Label("Enter Number of Points ");
        Label lbCorrect = new Label("Choose Correct Option");
        Label lbTypeOption = new Label("Please type aswer options below");

        //All kinds of buttons
        Button btnNewAnswerOption = new Button("Add New Option");
        Button btnRMOption = new Button("Delete Previous Option");
        Button btnDone = new Button("Done");
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
        for (int i = 0; i < deptLOs.size(); i++) {
            rbLO = new RadioButton(deptLOs.get(i).toString());
            gp.add(rbLO, 3, i + 1);
            rbLOSelect.add(rbLO);
            //rbCurr++;
        }

        //Button add to gp
        gp.add(btnDone, 1, 7);
        gp.add(btnNewAnswerOption, 2, 7);
        //gp.add(btnRMOption,3,7);

        if (myQ != null) {
            txtQuestion.setText(myQ.getQuestion());
            txtPoints.setText("" + myQ.getPointValue());
            //txtAnsOption.setText(answers[0]);
            //txtAnsOption2.setText(answers[1]);
            for (int k = 0; k < myQ.getAnswers().length; k++) {
                System.out.println("Answers: " + myQ.getAnswers()[k]);
            }
            //if(answers.length>2){
            for (int i = 0; i < myQ.getAnswers().length; i++) {
                //btnNewAnswerOption
                gp.getChildren().remove(btnDone);
                gp.getChildren().remove(btnNewAnswerOption);
                gp.getChildren().remove(btnRMOption);
                rbAnswerChoiceN = new RadioButton();
                rbAnswerChoiceN.setToggleGroup(answerChoices);
                txtAnsOptionN = new TextField();
                //Add newly creates option and radiobtn to their arraylists
                if (i == myQ.getAnswers().length - 1 || i == myQ.getAnswers().length - 2) {
                    textFieldArr.add(txtAnsOptionN);
                    rbArr.add(rbAnswerChoiceN);
                    //Add to gp
                    gp.add(rbAnswerChoiceN, 2, current + 1);
                    gp.add(txtAnsOptionN, 1, current + 1);
                }
                gp.add(btnDone, 1, current + 2);
                gp.add(btnNewAnswerOption, 2, current + 2);
                gp.add(btnRMOption, 2, current + 3);
                current++;
                System.out.println("Current Add: " + current);
                System.out.println("ARRAY: " + textFieldArr.get(i));

                textFieldArr.get(i).setText(myQ.getAnswers()[i]);
            }
            //}
            int correct = myQ.getCorrectAnswer();
            rbArr.get(correct).setSelected(true);
            ArrayList<ArrayList<String>> setUpLOs = myQ.getLOs();
            for (int j = 0; j < setUpLOs.size(); j++) {
                if (setUpLOs.get(j).equals(deptLOs.get(j))) {
                    rbLOSelect.get(j).setSelected(true);
                }

            }
        }

        //This button action is soley for adding more answers choices.
        btnNewAnswerOption.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gp.getChildren().remove(btnDone);
                gp.getChildren().remove(btnNewAnswerOption);
                gp.getChildren().remove(btnRMOption);
                rbAnswerChoiceN = new RadioButton();
                rbAnswerChoiceN.setToggleGroup(answerChoices);
                txtAnsOptionN = new TextField();
                //Add newly creates option and radiobtn to their arraylists
                textFieldArr.add(txtAnsOptionN);
                rbArr.add(rbAnswerChoiceN);
                //Add to gp
                gp.add(rbAnswerChoiceN, 2, current + 1);
                gp.add(txtAnsOptionN, 1, current + 1);
                gp.add(btnDone, 1, current + 2);
                gp.add(btnNewAnswerOption, 2, current + 2);
                gp.add(btnRMOption, 2, current + 3);
                current++;
                System.out.println("Current Add: " + current);

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

        btnRMOption.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (current < 5) {
                    Alert DeleteAlert = new Alert(Alert.AlertType.WARNING);
                    DeleteAlert.setTitle("Warning!");
                    DeleteAlert.setHeaderText(null);
                    DeleteAlert.setContentText("Cannot Delete Further");
                    DeleteAlert.showAndWait();
                } else {
                    gp.getChildren().remove(textFieldArr.get(textFieldArr.size() - 1));
                    gp.getChildren().remove(rbArr.get(rbArr.size() - 1));
                    textFieldArr.remove(textFieldArr.get(textFieldArr.size() - 1));
                    rbArr.remove(rbArr.get(rbArr.size() - 1));
                    current--;
                    System.out.println("Current Minus: " + current);
                }
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
                try {
                    //GET ALL USER INPUT
                    String StrQuestion = txtQuestion.getText();
                    int intPoints = Integer.parseInt(txtPoints.getText());
                    //Save ALL answer options in textFieldArr to answerArr
                    for (int i = 0; i < textFieldArr.size(); i++) {
                        answersArr.add(textFieldArr.get(i).getText());
                        System.out.println("answer Option: " + textFieldArr.get(i).getText() + "\n"); //Testing what I add
                        System.out.println("ACTUAL ARR: " + answersArr.get(i)); //Should match above
                    }
                    //Find selected RB               
                    int correctAns = 0;
                    int index = 0;
                    boolean rbSelect = false;
                    while (rbSelect == false) {
                        if (rbArr.get(index).isSelected()) {
                            correctAns = index;
                            rbSelect = true;
                        } else {
                            index++;
                        }
                    }
                    //System.out.println("Selected RB index = " + correctAns);
                    //Find selected LOs
                    for (int k = 0; k < rbLOSelect.size(); k++) {
                        if (rbLOSelect.get(k).isSelected()) {
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
                    //Convert ArrayLists to Array
                    String[] ansArray = answersArr.toArray(new String[answersArr.size()]);
                    //ArrayList<ArrayList<String>> selLOsArray = selectedLOs.toArray(new String[selectedLOs.size()]);
                    ArrayList<ArrayList<String>> selLOsArray = new ArrayList<ArrayList<String>>(); //please fix
                    Question myQ = new Question(StrQuestion, ansArray, intPoints, correctAns, selLOsArray);

                    //Now go back to old scene
                    cts.STAGE = teachDash.STAGE;
                    teachDash.update(cts.getScene(myQ,editFlag, indexEditQ));
                } catch (NumberFormatException exc) {
                    Alert DeleteAlert = new Alert(Alert.AlertType.WARNING);
                    DeleteAlert.setTitle("Warning!");
                    DeleteAlert.setHeaderText(null);
                    DeleteAlert.setContentText("Add a point value!");
                    DeleteAlert.showAndWait();
                }
            }
        });

        //Add to GridPane
        gp.add(txtQuestion, 1, 0);
        gp.add(txtPoints, 1, 1);
        //if(myQ==null){
        gp.add(txtAnsOption, 1, 3);
        gp.add(txtAnsOption2, 1, 4);
        gp.add(rbAnswerChoice, 2, 3);
        gp.add(rbAnswerChoice2, 2, 4);
        //}
        gp.add(lbQuestion, 2, 0);
        gp.add(lbPoints, 2, 1);
        gp.add(lbTypeOption, 1, 2);
        gp.add(selectCorrect, 2, 2);
        gp.add(selectRB, 4, 0);
        //gp.add(lbCorrect,2,2);
        //gp.add(rbAnswerChoice,1,3);     
        //gp.add(rbLO,1,3);         
        //end Add GridPane

        Scene scene = new Scene(gp, 900, 700);
        return scene;
   
    }           
    
}
