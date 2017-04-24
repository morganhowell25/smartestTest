
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Morgan Howell
 */
public class ViewStudentScoreScene extends StudentDash
{
    public ViewStudentScoreScene()
    {
        
    }
    
    public Scene getScene()
    {
        GridPane gp = drawStudentDash();
        
        //
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
