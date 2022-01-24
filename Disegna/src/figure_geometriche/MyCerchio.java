/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure_geometriche;

import javafx.scene.shape.Circle;

/**
 *
 * @author andreatomasoni
 */
public class MyCerchio extends Circle {
    
    MyPane awe = null;
    
    double x;
    double y;
    
    MyCerchio(double x, double y, double raggio, MyPane a) {
        super(x,y,raggio);
        awe = a;
        this.setFill(awe.colore.getValue());
    }
}
