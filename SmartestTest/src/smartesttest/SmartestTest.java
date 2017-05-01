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
        //1. pop up the log in TO DO
        //2. based on decision
        //switch role student/...
        //one case below as a branch of it
        AdminDash adminDash = new AdminDash();
        adminDash.start(primaryStage);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
