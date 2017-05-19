/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.io.File;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author csc190
 */
public class ImportLOsScene extends AdminDash {
    //public boolean disabled;
    
    public Scene getScene() {
        //System.out.println(disabled);
        
        GridPane gp = drawAdminDash();

        //Implement manage user buttons here
        Text scenetitle = new Text("Upload Learning Outcomes Document");
        gp.add(scenetitle, 1, 0);

        TextField tfEnter = new TextField();
        tfEnter.setPromptText("Enter Filepath");
        tfEnter.setPrefWidth(300); // Make the text field wider
        gp.add(tfEnter, 1, 1);

        Button btnUpload = new Button();
        btnUpload.setText("Upload");
        //if (disabled) { // If the LOs have already been uploaded
        //    btnUpload.setDisable(disabled); // Disable upload the button
        //}
        gp.add(btnUpload, 1, 2);
        
        btnUpload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Upload Clicked!");
                String filepath = tfEnter.getText();
                filepath = filepath.trim(); // Remove leading and trailing whitespace
                try {
                    // Create an Scanner to read from the input file
                    Scanner fileIn = new Scanner(new File(filepath));

                    // Read the Learning Outcomes from the input file
                    String strCat1 = null;
                    while (fileIn.hasNext()) {
                        String line = fileIn.nextLine();
                        if (line.substring(0, 2).equals("LO")) { // If the line read is a category 1 Learning Outcome
                            //strCat1 = line.substring(5); // Extract the LO from the file
                            strCat1 = line;
                            strCat1 = strCat1.replaceFirst("([^;]*;){1}", ""); // Remove all characters before the semicolon ";" in the string
                            strCat1 = strCat1.trim(); // Remove the leading whitespace
                            System.out.println(strCat1);
                            server.uploadOneLO(strCat1, "default");
                        } else { // The line read is a category 2 Learning Outcome
                            String strCat2 = line;
                            //strCat2 = strCat2.substring(7); // Extract the LO from the file
                            strCat2 = strCat2.replaceFirst("([^;]*;){1}", ""); // Remove all characters before the semicolon ";" in the string
                            strCat2 = strCat2.trim(); // Remove the leading whitespace
                            System.out.println(strCat2);
                            server.uploadOneLO(strCat1, strCat2);
                        }
                    }

                    fileIn.close(); // Close the input stream
                    Alert uploadSuccess = new Alert(Alert.AlertType.INFORMATION);
                    uploadSuccess.setTitle("Upload Learning Outcomes");
                    uploadSuccess.setHeaderText("Upload Successful!");
                    uploadSuccess.setContentText("Press OK to proceed.");
                    uploadSuccess.showAndWait();
                    //disabled = true; // Set protected class variable to true
                    btnUpload.setDisable(true);// Disable the button so it cannot be clicked again.
                    //System.out.println(disabled);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    Alert uploadFail = new Alert(Alert.AlertType.ERROR);
                    uploadFail.setTitle("Upload Learning Outcomes");
                    uploadFail.setHeaderText("File Not Found!");
                    uploadFail.setContentText("Invalid filepath entered.");
                    uploadFail.showAndWait();
                }
            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}