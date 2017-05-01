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
        DashBoard dash = new AdminDash();
        AdminHomeScene s = new AdminHomeScene();
        dash.start(primaryStage, s);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
