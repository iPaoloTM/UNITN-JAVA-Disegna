/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure_geometriche;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author andreatomasoni
 */
public class MyQuadrato extends Rectangle {
    
    MyPane awe = null;
    
    double x;
    double y;
    
    MyQuadrato(double x, double y, double width, double height, MyPane a) {
        super(x,y,width,height);
        awe = a;
        
        this.setFill(awe.colore.getValue());
    }
}
