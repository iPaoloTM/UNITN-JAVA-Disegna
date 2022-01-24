/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure_geometriche;

import javafx.scene.shape.Polygon;

/**
 *
 * @author andreatomasoni
 */
public class MyTriangolo extends Polygon {
    
    MyPane awe = null;
    
    double x;
    double y;
    
    MyTriangolo(double x1, double y1, double x2, double y2, double x3, double y3,MyPane a) {
        super(x1,y1,x2,y2,x3,y3);
        
        awe = a;
        
        this.setFill(awe.colore.getValue());
        this.setRotate(180);
    }
}
