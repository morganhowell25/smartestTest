/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartesttest;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author csc190
 */
public class ImportLOsScene extends AdminDash{
    public ImportLOsScene(){
        
    }
    
    public Scene getScene(){
        GridPane gp = drawAdminDash();
        
        //Implement manage user buttons here
        Text scenetitle = new Text("Upload XML Document");
        gp.add(scenetitle, 0, 0, 2, 1);
        
        Button btnXML = new Button();
        btnXML.setText("Upload");
        gp.add(btnXML, 0, 2);
        
        Scene scene = new Scene(gp, 700, 500);
        return scene;
    }
}
