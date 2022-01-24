/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure_geometriche;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author andreatomasoni
 */
public class Disegna extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        MyPane root = new MyPane();
        Scene scene = new Scene(root, 700,700);
        
        primaryStage.setTitle("Disegna!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
