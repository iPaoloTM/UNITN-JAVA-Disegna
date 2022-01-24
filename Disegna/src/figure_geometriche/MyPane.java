/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure_geometriche;

import java.util.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author andreatomasoni
 */
public class MyPane extends BorderPane {
    
    MyPanel pannello = new MyPanel();
    HBox bottom = new HBox();
    MyButton sel_figura = new MyButton("Sel. figura");
    Label figura = new Label();
    MyButton cancella = new MyButton("Cancella");
    ColorPicker colore = new ColorPicker();
    TextField valore = new TextField();
    MyButton selezione = new MyButton("AGGIUNTA");
    
    double misura = 30.0;
    MyPane a;
    double x;
    double y;
    
    LinkedList forme = new LinkedList();
    boolean abile = false;
    
    MyPane() {
        
        a = this;
        figura.setMinWidth(80);
        valore.setMinWidth(30);
        valore.setText("" + misura);
        
        bottom.getChildren().addAll(sel_figura, figura, cancella, colore, valore, selezione);
        
        BorderPane.setAlignment(pannello, Pos.CENTER);
        this.setCenter(pannello);
        BorderPane.setAlignment(bottom, Pos.BOTTOM_CENTER);
        bottom.setAlignment(Pos.CENTER);
        this.setBottom(bottom);
        
        ListenerSelFigura lsf = new ListenerSelFigura(this);
        sel_figura.setOnAction(lsf);
        
        pannello.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                controllo();
                
                x = t.getX();
                y = t.getY();
                
            if(abile == false) {
                
                try{
                     misura = Double.parseDouble(valore.getText());
                } catch(NumberFormatException ex) {
                    System.exit(1);
                }
                
                String scelta = figura.getText();
                
                switch(scelta) {
                    case "cerchio":
                    case "Cerchio":
                    case "CERCHIO":
                        MyCerchio c = new MyCerchio(x,y,misura, a);
                        c.x = x;
                        c.y = y;
                        forme.add(c);
                        pannello.getChildren().add(c);
                        break;
                    
                    case "quadrato":
                    case "Quadrato":
                    case "QUADRATO":
                        MyQuadrato q = new MyQuadrato((x-(1.41*misura)/2),(y-(1.41*misura)/2),1.41*misura,1.41*misura,a);
                        q.x = x;
                        q.y = y;
                        forme.add(q);
                        pannello.getChildren().add(q);
                        break;
                        
                    case "triangolo":
                    case "Triangolo":
                    case "TRIANGOLO":
                        MyTriangolo tr = new MyTriangolo(x-misura/2, y-misura/2, x,y+misura/2, x+misura/2,y-misura/2, a);
                        tr.x = x;
                        tr.y = y;
                        forme.add(tr);
                        pannello.getChildren().add(tr);
                        break;
                }
            } else {
                
                Random generatore = new Random(System.currentTimeMillis());
                
                double distanza = 0;
                int min = 0;
                int min_appoggio = 0;
                double var_appoggio = 100000;
                
                for(int i = 0; i < forme.size(); i++) {
                    String s = forme.get(i).getClass().getName();
                    
                    if(s.equals("figure_geometriche.MyCerchio")) {
                        MyCerchio c = (MyCerchio) forme.get(i);
                        distanza = Math.sqrt(Math.pow(x-c.x, 2) + Math.pow(y-c.y, 2));
                    }
                    if(s.equals("figure_geometriche.MyQuadrato")) {
                        MyQuadrato q = (MyQuadrato) forme.get(i);
                        distanza = Math.sqrt(Math.pow(x-q.x, 2) + Math.pow(y-q.y, 2));
                    }
                    if(s.equals("figure_geometriche.MyTriangolo")) {
                        MyTriangolo tr = (MyTriangolo) forme.get(i);
                        distanza = Math.sqrt(Math.pow(x-tr.x, 2) + Math.pow(y-tr.y, 2));
                    }   
                    min++;
                    
                    if(distanza < var_appoggio) {
                        var_appoggio = distanza;
                        min_appoggio = min;
                    }
                }
                System.out.println(" " + min_appoggio);
                
                String e = forme.get(min_appoggio-1).getClass().getName();
                
                switch(e) {
                    case "figure_geometriche.MyCerchio":
                        MyCerchio c = (MyCerchio) forme.get(min_appoggio-1);
                        c.setFill(Color.rgb(generatore.nextInt(256), generatore.nextInt(256), generatore.nextInt(256)));
                        
                    case "figure_geometriche.MyQuadrato":
                        MyQuadrato q = (MyQuadrato) forme.get(min_appoggio-1);
                        q.setFill(Color.rgb(generatore.nextInt(256), generatore.nextInt(256), generatore.nextInt(256)));
                        
                    case "figure_geometriche.MyTriangolo":
                        MyTriangolo tr = (MyTriangolo) forme.get(min_appoggio-1);
                        tr.setFill(Color.rgb(generatore.nextInt(256), generatore.nextInt(256), generatore.nextInt(256)));
                }
            }
        } 
        });
        
        cancella.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                pannello.getChildren().clear();
 
            }
        });
        
        selezione.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                
                String s = selezione.getText();
                
                if(s.equals("AGGIUNTA")) {
                    selezione.setText("SELEZIONE");
                }
                if(s.equals("SELEZIONE")) {
                    selezione.setText("AGGIUNTA");
                }
            }
        });
    }
    
    public boolean controllo(String s) {
        boolean check = false;
        
        switch(s) {
            case "":
            case "cerchio":
            case "Cerchio":
            case "CERCHIO":
            case "triangolo":
            case "Triangolo":
            case "TRIANGOLO":
            case "quadrato":
            case "Quadrato":
            case "QUADRATO":
                check = true;
        }
        return check;
    }
    
    public boolean controllo() {
        String s = selezione.getText();
        
        if(s.equals("SELEZIONE")) {abile = true;}
        if(s.equals("AGGIUNTA")) {abile = false;}
        
        return abile;
    }
}
