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
<<<<<<< HEAD
                int id  = 6;
                ArrayList<String> newTest = server.pullTest(pincode);
                System.out.println("sub Clicked!");
                if (newTest.isEmpty()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Pincode does not exist");
                    alert.setContentText("please input a valid pincode.");
                    alert.showAndWait();
                } else if(server.pullStudentGradedTest(id,pincode)==null){
                    Test myTest = (Test) utils.toObj(newTest.get(0));
                    TestScene ts = new TestScene(myTest);
                    ts.STAGE = tts.STAGE;
                    tts.update(ts.getScene());
                }else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Test Taken");
                    alert.setContentText("You have already taken this test.");
                    alert.showAndWait();
=======
                boolean validPIN = true;
                for (int i = 0; i < pincode.length(); i++) {
                    if (!(pincode.charAt(i) >= '0' && pincode.charAt(i) <= '9')) {
                        validPIN = false;
                        break;
                    }
                }
                if (validPIN == false) {
                    Alert badPIN = new Alert(Alert.AlertType.ERROR);
                    badPIN.setTitle("Invalid PIN");
                    badPIN.setHeaderText("Invalid PIN");
                    badPIN.setContentText("Please use only numeric characters");
                    badPIN.showAndWait();
                } else {
                    ArrayList<String> newTest = server.pullTest(pincode);
                    System.out.println("sub Clicked!");
                    if (newTest.isEmpty()) {
                        System.out.println("if statement");
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Error");
                        alert.setHeaderText("You done fucked up");
                        alert.setContentText("Y u pass bad pincode fucker?");
                        alert.showAndWait();
                    } else {
                        Test myTest = (Test) utils.toObj(newTest.get(0));
                        System.out.println("else statement");
                        TestScene ts = new TestScene(myTest);
                        ts.STAGE = tts.STAGE;
                        tts.update(ts.getScene());
                    }
>>>>>>> origin/timV4
                }
            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
