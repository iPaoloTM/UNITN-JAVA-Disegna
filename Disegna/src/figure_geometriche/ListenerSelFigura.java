/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure_geometriche;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author andreatomasoni
 */
public class ListenerSelFigura implements EventHandler {
    MyPane awe = null;
    
    ListenerSelFigura(MyPane a) {
        awe = a;
    }
    
    @Override
    public void handle(Event t) {
        
        boolean check;
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Selezione figura");
        dialog.setHeaderText("");
        dialog.setContentText("Figura da disegnare: ");
        
        String s = dialog.showAndWait().get();
        
        check = awe.controllo(s);
        System.out.println(check);
        
        if(check==true) {           
            awe.figura.setText(s);
            awe.figura.setAlignment(Pos.CENTER);
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("FIGURA NON DISPONIBILE O ERRATA");
            alert.showAndWait();
        }
 
    }
}
