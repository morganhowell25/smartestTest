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
        /*
        DashBoard dash = new DashBoard();
        dash.start(primaryStage);
        */
        //1. Pop up the LoginForm: TO DO
        //2. Based on whichever role you login as:
        //3. Load AdminDash, TeacherDash, or StudentDash
        //4. Implement using a switch statement, maybe
        
        // If you login as admin, call this:
        //AdminDash adminDash = new AdminDash();
        //adminDash.start(primaryStage);
        
        // If you login as teacher, call this:
        TeacherDash teacherDash = new TeacherDash();
        teacherDash.start(primaryStage);
        
        // If you login as student, call this:

        //StudentDash studentDash = new StudentDash();
        //studentDash.start(primaryStage);git com

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}