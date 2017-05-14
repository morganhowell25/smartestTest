/**
 * Morgan Howell, Andy Jenkins, Matthew Hirsch, Gianfranco Leto, Victor Daniel-Kalio, Tim Daigle
 */
package smartesttest;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class SmartestTest extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Add test data into the database to test the functionality of the StudentScoresListScene class.
        // Add 5 student users into tbl_user
        /*utils.addUser("charles123", null, "student");
        utils.addUser("uname456", null, "student");
        utils.addUser("geogre87", null, "student");
        utils.addUser("pleytwa", null, "student");
        utils.addUser("KingsFan117", null, "student");
        // Add 4 gradedTest records
        utils.saveGradedTest(1, "99999", null, "85");
        utils.saveGradedTest(2, "99998", null, "89");
        utils.saveGradedTest(3, "99999", null, "97");
        utils.saveGradedTest(4, "99999", null, "92");*/
        
        /*
        DashBoard dash = new DashBoard();
        dash.start(primaryStage);
        */
        //1. Pop up the LoginForm: TO DO
        //2. Based on whichever role you login as:
        //3. Load AdminDash, TeacherDash, or StudentDash
        //4. Implement using a switch statement, maybe
        
        LoginForm lForm = new LoginForm();
        lForm.start(primaryStage);
        // If you login as admin, call this:
        //AdminDash adminDash = new AdminDash();
        //adminDash.start(primaryStage);
        
        // If you login as teacher, call this:


        //TeacherDash teacherDash = new TeacherDash();

        //AdminDash teacherDash = new AdminDash();

        //teacherDash.start(primaryStage);
        
        // If you login as student, call this:

        //StudentDash studentDash = new StudentDash();
        //studentDash.start(primaryStage);
            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
