/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.taller1javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Fiorella Quijano
 */
public class Ventana2 extends Application{
    
    @Override
    public void start(Stage stage) throws IOException {
        
        stage.setTitle("Registration Form");
        GridPane gp= new GridPane();
        gp.setHgap(1);
        gp.setVgap(2);
        Label mensaje= new Label("Gracias por ingresar sus datos");
        Button salir= new Button("Salir");
        salir.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event){
            stage.close();
            
        }
    });
        salir.setStyle("-fx-text-fill:white ;-fx-background-color: darkslateblue");
        gp.add(mensaje,0,0);
        gp.add(salir,0,1);
        Scene s= new Scene(gp,600,400);
        stage.setScene(s);
        stage.show();
        
    }
}
