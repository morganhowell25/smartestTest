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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static smartesttest.utils.pullTest;
import static smartesttest.utils.toObj;

/**
 *
 * @author csc190
 */
public class TakeTestScene extends StudentDash {

    public Scene getScene() {
        GridPane gp = drawStudentDash();
        TakeTestScene tts = this;
        
        Label lblTake = new Label("Take A Test");
        gp.add(lblTake, 1, 0);

        TextField input = new TextField();
        input.setPromptText("Enter PINcode");
        gp.add(input, 1, 1);

        Button sub = new Button("Submit");
        gp.add(sub, 1, 2);

        sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String pincode = input.getText();
                ArrayList<String> newTest = pullTest(pincode);
                System.out.println("sub Clicked!");
                if (newTest.isEmpty()) {
                    System.out.println("if statement");
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("You done fucked up");
                    alert.setContentText("Y u pass bad pincode fucker?");
                    alert.showAndWait();
                } else {
                    Test myTest = (Test) toObj(newTest.get(0));
                    System.out.println("else statement");
                    TestScene ts = new TestScene();
                    ts.STAGE = tts.STAGE;
                    tts.update(ts.getScene());
                }
            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
