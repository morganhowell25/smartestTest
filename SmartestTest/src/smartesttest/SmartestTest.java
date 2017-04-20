/**
 * Morgan Howell, Andy Jenkins, Matthew Hirsch, Gianfranco Leto, Victor Daniel-Kalio, Tim Daigle
 */
package smartesttest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
        DashBoard dash = new DashBoard();
        dash.start(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
