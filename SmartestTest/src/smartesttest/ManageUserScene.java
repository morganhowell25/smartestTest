/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

/**
 *
 * @author csc190
 */
public class ManageUserScene extends AdminDash
{
    public ManageUserScene()
    {
        
    }
            
    public Scene getScene()
    {
        GridPane gp = drawAdminDash();
        
        Label userID = new Label("ID");
        Label userRole = new Label("Role");
        Label userName = new Label("Username");
        Label delete = new Label("Change Password?");
        gp.add(userID,1,0);
        gp.add(userRole,2,0);
        gp.add(userName,3,0);
        gp.add(delete,4,0);
        
        
        
        ArrayList<ArrayList<String>> arrUsers = server.pullUserList();
        
        for (int i = 0; i < arrUsers.size(); i++){
            for (int j = 0; j < arrUsers.get(i).size(); j++){
                Label myLbl = new Label((arrUsers.get(i)).get(j));
                gp.add(myLbl,1+i,1+j);
                final int buttonInd = j+1;
                Button delBtn = new Button("Change Password");
        
                delBtn.setOnAction(new EventHandler<ActionEvent>() { 
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("ChangePass Clicked!");
                        TextInputDialog dialog = new TextInputDialog("password");
                        dialog.setTitle("Password Change");
                        dialog.setHeaderText(null);
                        dialog.setContentText("Please enter new password:");
                        Optional<String> result = dialog.showAndWait();
                        if (result.isPresent()){
                            server.resetPWD(result.get(),buttonInd);
                        }
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Password Changed Successfully");
                        alert.setHeaderText(null);
                        alert.setContentText("Press OK to continue");

                        alert.showAndWait();
                    }
                });
                gp.add(delBtn,4,1+j);
            }
            
        }
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(gp);
        Scene scene = new Scene(sp, 700, 500);
        return scene;
    }
}
