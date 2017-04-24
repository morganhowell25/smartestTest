
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class ViewScoresScene extends StudentDash
{
    public ViewScoresScene()
    {
        
    }
    
    public Scene getScene()
    {
        GridPane gp = drawStudentDash();
        
        //Implement manage user buttons here
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
