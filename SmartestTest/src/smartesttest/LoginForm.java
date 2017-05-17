/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class LoginForm {

    //protected Stage pStage;
    public void start(Stage primaryStage) {
        LoginForm lForm = this;
        primaryStage.setTitle("SmartTest");
        update(primaryStage, lForm.getScene());
    }

    public Scene getScene() {
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        LoginForm lf = this;

        Text scenetitle = new Text("Welcome");
        gp.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        gp.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gp.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        gp.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gp.add(pwBox, 1, 2);

        Button btnSignIn = new Button("Sign in");
        gp.add(btnSignIn, 1, 5);
        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sign-In Clicked!");
                String uname = userTextField.getText(); // Uname the user entered
                uname = uname.trim(); // Remove leading and trailing whitespace
                String pword = pwBox.getText(); // Password the user entered
                //System.out.println(pword);
                //the following snippet protects against basic SQL injection
                boolean validUname = true;
                for (int i = 0; i < uname.length(); i++) {
                    if (!((uname.charAt(i) >= 'a' && uname.charAt(i) <= 'z') || (uname.charAt(i) >= 'A' && uname.charAt(i) <= 'Z') || (uname.charAt(i) >= '0' && uname.charAt(i) <= '9'))) {
                        validUname = false;
                        break;
                    }
                }
                boolean validPass = true;
                for (int i = 0; i < pword.length(); i++) {
                    if (!((pword.charAt(i) >= 'a' && pword.charAt(i) <= 'z') || (pword.charAt(i) >= 'A' && pword.charAt(i) <= 'Z') || (pword.charAt(i) >= '0' && pword.charAt(i) <= '9'))) {
                        validPass = false;
                        break;
                    }
                }
                ArrayList<ArrayList<String>> newCred = null;
                String passPulled = null; // Password pulled from the database to compare with what the user entered

                if (validUname == false || validPass == false || uname.isEmpty() || pword.isEmpty()) {
                    Alert badLogin = new Alert(Alert.AlertType.ERROR);
                    badLogin.setTitle("Invalid Login");
                    badLogin.setHeaderText("Invalid username or password");
                    badLogin.setContentText("Please use only alphanumeric characters");
                    badLogin.showAndWait();
                } else {
                    newCred = server.pullUInfo(uname); // Pull user info from DB according to uname they entered
                    System.out.println(newCred);
                    // If no info was pulled from the DB, the user entered an invalid username

                    if (newCred.get(0).isEmpty() && newCred.get(1).isEmpty() && newCred.get(2).isEmpty()) {
                        Alert loginFail = new Alert(Alert.AlertType.ERROR);
                        loginFail.setTitle("Error!");
                        loginFail.setHeaderText("Login Failed!");
                        loginFail.setContentText("Invalid login credentials.");
                        loginFail.showAndWait();
                    } else { // Info was pulled from DB
                        if (newCred.get(1).get(0).equals("admin1")) { // If the default admin is logging in, don't decrypt the password in the DB
                            passPulled = newCred.get(1).get(0);
                        } else { // If anyone else is logging in, decrypt the password from the database
                            System.out.println(newCred.get(1).get(0));
                            passPulled = server.decrypt(newCred.get(1).get(0));
                            System.out.println(passPulled);
                        }
                        // Compare the uname and password the user entered to the info pulled from DB
                        if (uname.equals(newCred.get(0).get(0)) && pword.equals(passPulled)) {
                            if (newCred.get(2).get(0).equals("admin")) { // If user is admin, load AdminDash
                                Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
                                loginSuccess.setTitle("Login Form");
                                loginSuccess.setHeaderText("Login Successful!");
                                loginSuccess.setContentText("Press OK to proceed.");
                                loginSuccess.showAndWait();
                                AdminDash adminDash = new AdminDash();
                                Stage primaryStage = new Stage();
                                adminDash.start(primaryStage);
                                //primaryStage.close();
                            } else if (newCred.get(2).get(0).equals("teacher")) { // If user is teacher, load TeacherDash
                                Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
                                loginSuccess.setTitle("Login Form");
                                loginSuccess.setHeaderText("Login Successful!");
                                loginSuccess.setContentText("Press OK to proceed.");
                                loginSuccess.showAndWait();
                                TeacherDash teacherDash = new TeacherDash();
                                Stage primaryStage = new Stage();
                                teacherDash.start(primaryStage);
                            } else { // If user is student, load StudentDash
                                Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
                                loginSuccess.setTitle("Login Form");
                                loginSuccess.setHeaderText("Login Successful!");
                                loginSuccess.setContentText("Press OK to proceed.");
                                loginSuccess.showAndWait();
                                StudentDash studentDash = new StudentDash();
                                Stage primaryStage = new Stage();
                                studentDash.start(primaryStage);
                                System.out.println("After start clicked");
                                //this..close();
                                System.out.println("After close clicked");
                            }
                        } else { // The user entered invalid login credentials
                            Alert loginFail = new Alert(Alert.AlertType.ERROR);
                            loginFail.setTitle("Error!");
                            loginFail.setHeaderText("Login Failed!");
                            loginFail.setContentText("Invalid login credentials.");
                            loginFail.showAndWait();
                        }
                    }
                }

            }
        });

        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }

    public void update(Stage primaryStage, Scene newScene) {
        primaryStage.setScene(newScene);
        primaryStage.show();
    }
}
