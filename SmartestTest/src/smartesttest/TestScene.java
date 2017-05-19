package smartesttest;

import java.util.ArrayList;
import static java.util.Arrays.fill;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class TestScene extends StudentDash {

    private Test myTest;

    public TestScene(Test test, int cuID) {
        super(cuID);
        myTest = test;
    }

    public Scene getScene() {
        GridPane gp = drawStudentDash();
        StudentDash stuDash = this;

        int currentRow = 0;
        ArrayList<ToggleGroup> answerButtons = new ArrayList<ToggleGroup>();

        //for each question on the test do the following
        Question[] questionList = myTest.getTestQuestions();
        int highestNumAns = -1;
        for(Question q: questionList)
        {
            if(q.getAnswers().length > highestNumAns)
                highestNumAns = q.getAnswers().length+1;
        }
        
        for (int i = 0; i < questionList.length * highestNumAns; i += highestNumAns) {
            Label questionTxt = new Label((i / highestNumAns+ 1) + ") "
                    + questionList[i / highestNumAns].getQuestion());
            gp.add(questionTxt, 2, i);

            //makes it so only one of the radio buttons maye be selcted at a time
            ToggleGroup questionAnswers = new ToggleGroup();

            //loops to create the toggle buttons for the answers
            String[] answers = questionList[i / highestNumAns].getAnswers();
            for (int j = 1; j <= answers.length; j++) {
                RadioButton ans = new RadioButton(answers[j - 1]);
                ans.setToggleGroup(questionAnswers);
                gp.add(ans, 2, (j + i));
            }
            //used to be able to tell where we are on the gridpane to be able
            //to add the sumbit button at the end
            currentRow += i;
            //stores each answer roup so that the answers can be pulled form it later
            answerButtons.add(questionAnswers);
        }
        //list of student answers to be used with the graded test
        //sets them all to a defult value of -1
        int[] stuAns = new int[questionList.length];
        fill(stuAns, -1);

        //create the sumbit button
        Button btnSumbit = new Button();
        btnSumbit.setText("Submit");
        gp.add(btnSumbit, 4, currentRow);
        btnSumbit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //loop for each group of answers loop
                for (int i = 0; i < answerButtons.size(); i++) {
                    //loop for each answer in the group and see if its selcted
                    //if it is add it to the list of answers
                    for (int j = 0; j < answerButtons.get(i).getToggles().size(); j++) {
                        if (answerButtons.get(i).getToggles().get(j).isSelected()) {
                            stuAns[i] = j;
                        }
                    }
                }
                boolean flag = true;
                for(int i = 0; i < stuAns.length; i++)
                {
                    if(stuAns[i]==-1)
                        flag = false;
                }
                if (flag) {

                    System.out.println("Sumbit Clicked!");

                    GradedTest graded = new GradedTest(myTest, stuAns, currentUserID);
                    graded.grade();
                    server.saveGradedTest(currentUserID, myTest.getPincode(), graded, "" + graded.getScore());
                    
                    ViewStudentScoreScene vssst = new ViewStudentScoreScene(graded, currentUserID);
                        vssst.STAGE = stuDash.STAGE;
                        stuDash.update(vssst.getScene());

                    //testing to see if it correctly pulls the students answers
                    //#worksfristtime
                    /*for (int x = 0; x < stuAns.length; x++) {
                        System.out.println("Student Answered: " + stuAns[x]);
                    }*/
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Incomplete Test");
                    alert.setContentText("Please answer all the questions before sumbiting");
                    alert.showAndWait();
                }
            }
        });
        ScrollPane sp = new ScrollPane();
        sp.setContent(gp);
        Scene scene = new Scene(sp, 700, 500);
        return scene;
    }
}
