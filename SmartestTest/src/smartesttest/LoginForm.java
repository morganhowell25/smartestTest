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

    protected Stage pStage = new Stage();
    public void start(Stage primaryStage) {
        LoginForm lForm = this;
        pStage = primaryStage;
        pStage.setTitle("SmartTest");
        update(pStage, lForm.getScene());
    }

    public Scene getScene() {
        //server.addUser("admin",utils.encrypt("admin1"),"admin");
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        /*Question q = new Question("My Question?", new String[]{"True","False"}, 5, 1,new ArrayList<ArrayList<String>>());
        String strQ = utils.toStr(q);
        //System.out.println(strQ);
        Question q2 = (Question) utils.toObj(strQ);
        //System.out.println("q2 = " + q2);*/
        Question[] arrQ = new Question[3];
        ArrayList<String> arrCat1 = new ArrayList<String>();
        arrCat1.add("Colors");
        arrCat1.add("Dogs");
        ArrayList<String> arrCat2 = new ArrayList<String>();
        arrCat2.add("Blue");
        arrCat2.add("Scottish");
        ArrayList<ArrayList<String>> arrLOs = new ArrayList<ArrayList<String>>();
        arrLOs.add(arrCat1);
        arrLOs.add(arrCat2);
        arrQ[0] = new Question("My Question1?", new String[]{"True","False"}, 5, 1,arrLOs);
        arrQ[1] = new Question("My Question2?", new String[]{"Dog","Cat"}, 4, 0,arrLOs);
        arrQ[2] = new Question("My Question3?", new String[]{"Hi","There"}, 3, 1,arrLOs);
        Test myTest = new Test(arrQ, "8", 2);
        //server.saveTest(myTest.getPincode(),myTest.getTeacherID(),myTest);
 
        /*StudentScoresListStruct ssls = new StudentScoresListStruct();
        ssls.id = 3;
        ssls.uname = "cheese";
        ssls.score = "100";
        String ss = utils.toStr(ssls);
        //System.out.println(ss);
        StudentScoresListStruct ssl = (StudentScoresListStruct)utils.toObj(ss);*/
        
        /*GradedTest gt = new GradedTest(myTest, new int[]{1,0,1}, 3);
        String strgt = utils.toStr(gt);
        GradedTest gt2 = (GradedTest)utils.toObj(strgt);*/
        
        
        
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
                //System.out.println("Sign-In Clicked!");
                String uname = userTextField.getText(); // Uname the user entered
                uname = uname.trim(); // Remove leading and trailing whitespace
                String pword = pwBox.getText(); // Password the user entered
                ////System.out.println(pword);
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
                    ////System.out.println("newCred = " + newCred);
                    // If no info was pulled from the DB, the user entered an invalid username

                    if (newCred == null || newCred.get(0).isEmpty() || newCred.get(1).isEmpty() || newCred.get(2).isEmpty()) {
                        Alert loginFail = new Alert(Alert.AlertType.ERROR);
                        loginFail.setTitle("Error!");
                        loginFail.setHeaderText("Login Failed!");
                        loginFail.setContentText("Invalid login credentials.");
                        loginFail.showAndWait();
                    } else { // Info was pulled from DB
                        // Decrypt the password from the database
                        ////System.out.println(newCred.get(1).get(0));
                        passPulled = utils.decrypt(newCred.get(1).get(0));
                        ////System.out.println(passPulled);
                        
                        // Compare the uname and password the user entered to the info pulled from DB
                        if (uname.equals(newCred.get(0).get(0)) && pword.equals(passPulled)) {
                            ArrayList<String> arrID = server.pullID(newCred.get(0).get(0));
                            int userID = Integer.parseInt(arrID.get(0));
                            //System.out.println("User ID = " + userID);
                            if (newCred.get(2).get(0).equals("admin")) {
                                Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
                                loginSuccess.setTitle("Login Form");
                                loginSuccess.setHeaderText("Login Successful!");
                                loginSuccess.setContentText("Press OK to proceed.");
                                loginSuccess.showAndWait();
                                AdminDash adminDash = new AdminDash(userID);
                                Stage primaryStage = new Stage();
                                adminDash.start(primaryStage);
                                pStage.close();
                            } else if (newCred.get(2).get(0).equals("teacher")) { // If user is teacher, load TeacherDash
                                Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
                                loginSuccess.setTitle("Login Form");
                                loginSuccess.setHeaderText("Login Successful!");
                                loginSuccess.setContentText("Press OK to proceed.");
                                loginSuccess.showAndWait();
                                TeacherDash teacherDash = new TeacherDash(userID);
                                Stage primaryStage = new Stage();
                                teacherDash.start(primaryStage);
                                pStage.close();
                            } else { // If user is student, load StudentDash
                                Alert loginSuccess = new Alert(Alert.AlertType.INFORMATION);
                                loginSuccess.setTitle("Login Form");
                                loginSuccess.setHeaderText("Login Successful!");
                                loginSuccess.setContentText("Press OK to proceed.");
                                loginSuccess.showAndWait();
                                StudentDash studentDash = new StudentDash(userID);
                                Stage primaryStage = new Stage();
                                studentDash.start(primaryStage);
                                pStage.close();
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
