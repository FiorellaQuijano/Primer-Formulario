package ec.edu.espol.taller1javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private String s= null;

    @Override
    public void start(Stage stage) throws IOException {
        
        GridPane gr= new GridPane();
        
        HBox hb1= new HBox();
        Label nombre= new Label("Nombre");
        gr.add(nombre,0,0);
        
        TextField nombreT= new TextField();
        gr.add(nombreT,1,0);
        
        
        
        HBox hb2= new HBox();
        Label fecha= new Label("Fecha de nacimiento");
        gr.add(fecha,0,1);
        
        DatePicker fechaD= new DatePicker(LocalDate.now());
        fechaD.setEditable(false); 
        gr.add(fechaD,1,1);
        
 
        
        HBox hb3= new HBox();
        Label genero= new Label("Género");
        gr.add(genero,0,2);
        
        ToggleGroup g1= new ToggleGroup();
        RadioButton m= new RadioButton("Masculino");
        RadioButton f= new RadioButton("Femenino");
        m.setToggleGroup(g1);
        f.setToggleGroup(g1);
        gr.add(m,1,2);
        gr.add(f,2,2);
        m.setSelected(true);
      
        
        
        Label reservar= new Label("Reservación");
        gr.add(reservar,0,3);
        
        Button b1= new Button("Si");
        Button b2= new Button("No");
        
        b1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                s="Si";
            }
        });  
        
        b2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                s="No";
            }
        });    
        
        gr.add(b1,1,3);
        gr.add(b2,2,3);
        
        
        Label tecnologia= new Label("Tecnologías conocidas");
        gr.add(tecnologia,0,4);
        
        CheckBox cb1= new CheckBox("JAVA");
        CheckBox cb2= new CheckBox("DotNet");
        gr.add(cb1,1,4);
        gr.add(cb2,2,4);
        
        
        
        Label educacion= new Label("Nivel educional");
        gr.add(educacion,0,5);
        
        ListView<String> leducacion= new ListView<>();
        ObservableList<String> items= FXCollections.observableArrayList("Ingeniero","Graduado","PHD","Maestría");
        leducacion.setItems(items);
        gr.add(leducacion,1,5);
        
       
        Label ubicacion= new Label("Ubicación");
        gr.add(ubicacion,0,6);
        
        ComboBox cb= new ComboBox();
        ObservableList<String> cItems= FXCollections.observableArrayList("Manta","Guayaquil","Quito");
        cb.setItems(cItems);
        gr.add(cb,1,6);
        
        Label mensaje= new Label("");
        mensaje.setStyle("-fx-text-fill:red");
        gr.add(mensaje,2,6);
        
        Button b4= new Button("Registrar");
        b4.setStyle("-fx-text-fill:white ;-fx-background-color: darkslateblue");
        Button b5= new Button("Siguiente");
        b5.setStyle("-fx-text-fill:white ;-fx-background-color: darkslateblue");
        b5.setDisable(true);
        
        //Cambiar página
        b5.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            Parent root;
            try{
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    });
        
        gr.add(b4,0,7);
        gr.add(b5,1,7);
        //Registro de informacion
        b4.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event){
               String nombreS= nombreT.getText();
               String fechaS= fechaD.getEditor().getText();
               RadioButton generoS= (RadioButton)g1.getSelectedToggle();
               String sgenero= generoS.getText();
               String reservacionS= s;
//               if(s.equals("Si")){
//                   reservacionS= "Si";
//               }else if(s.equals("No")){
//                   reservacionS= "No";
//               }else{
//                   reservacionS= null;
//               }
               ArrayList<String> tecnologias= new ArrayList<String>();
               if(cb1.isSelected()){
                   tecnologias.add(cb1.getText());
               }if(cb2.isSelected()){
                   tecnologias.add(cb2.getText());
               
               }
               String nivelS= leducacion.getSelectionModel().getSelectedItem();
               
               String ubicacionS=cb.getPromptText();
               
               System.out.println(nombreS+"," +fechaS+"," +sgenero+","+ reservacionS+","+ tecnologias+","+nivelS+","+ ubicacionS);
               if(nombreS!=null && fechaS!=null && sgenero !=null && reservacionS !=null && tecnologias.isEmpty() && nivelS !=null && ubicacionS!=null){
                    
                   ManejoArchivo.registrarDatos("datos.txt", nombreS, fechaS, sgenero, reservacionS, tecnologias, nivelS, ubicacionS);
                   b5.setDisable(false);
                   mensaje.setText("Se han guardado los datos");
               }else{
                   mensaje.setText("Debe llenar todos los campos");
               }
           }
    });
        gr.setHgap(3);
        gr.setVgap(7);
        VBox vb= new VBox();
        
        vb.getChildren().add(gr);
        vb.setPadding(new Insets(15,12,15,12));
        vb.setStyle("-fx-background-color: #EBEC98");
        scene = new Scene(vb, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    
    

    public static void main(String[] args) {
        launch();
    }

}