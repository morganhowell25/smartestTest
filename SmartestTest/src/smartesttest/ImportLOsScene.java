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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author csc190
 */
public class ImportLOsScene extends AdminDash {

    public Scene getScene() {
        GridPane gp = drawAdminDash();

        //Implement manage user buttons here
        Text scenetitle = new Text("Upload XML Document");
        gp.add(scenetitle, 1, 0);

        TextField tfEnter = new TextField();
        tfEnter.setPromptText("Enter Filepath");
        gp.add(tfEnter, 1, 1);

        Button btnUpload = new Button();
        btnUpload.setText("Upload");
        gp.add(btnUpload, 1, 2);

        btnUpload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Upload Clicked!");
                String filepath = tfEnter.getText();
                try {
                    // Create an Scanner to read from the input file
                    Scanner fileIn = new Scanner(new File(filepath));

                    // Read the Learning Outcomes from the input file
                    String strCat1 = null;
                    while (fileIn.hasNext()) {
                        String line = fileIn.nextLine();
                        if (line.substring(0,2).equals("LO")) {
                            strCat1 = line.substring(5); // Extract the LO from the file
                            System.out.println(strCat1);
                            String query = "INSERT INTO tbl_deptLOs (cat1, cat2, correct, total) VALUES ('" + strCat1 + "', 'default', 'XX', 'ZZ');";
                            DBHandler.execNonQuery(query);
                        } 
                        else {
                            String strCat2 = line.trim(); // Remove the leading whitespace 
                            strCat2 = strCat2.substring(5); // Extract the LO from the file
                            System.out.println(strCat2);
                            String query = "INSERT INTO tbl_deptLOs (cat1, cat2, correct, total) VALUES ('" + strCat1 + "', '" + strCat2 + "', 'XX', 'ZZ');";
                            DBHandler.execNonQuery(query);
                        }
                    }

                    fileIn.close(); // Close the input stream
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
