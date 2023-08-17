/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.taller1javafx;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Fiorella Quijano
 */
public class ManejoArchivo {
    
    public static void registrarDatos(String archivon, String nombre, String fecha, String genero, String reservacion,ArrayList<String> tecnologias, String educacion, String ubicacion){
        File archivo= new File(archivon);
        if(!archivo.exists()){
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(nombre,true))){  
            String linea= "nombre,fecha de nacimiento, genero, reservacion,tecnologias,nivel educacional, ubicacion\n";
            bw.write(linea);
            String info= nombre+","+ fecha+ ","+ genero+","+ reservacion+","+ arregloAlinea(tecnologias)+","+educacion+","+ ubicacion+"\n";
            bw.write(info);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        }else{
            try(BufferedWriter bw= new BufferedWriter(new FileWriter(nombre,true))){
            String info= nombre+","+ fecha+ ","+ genero+","+ reservacion+","+ arregloAlinea(tecnologias)+","+educacion+","+ ubicacion+"\n";
            bw.write(info);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        }
    }
    
    public static String arregloAlinea(ArrayList<String> tecnologias){
        StringBuilder sb= new StringBuilder();
        for(String s: tecnologias){
            sb.append(s+"\\|");
        }
        return sb.toString();
    }
}
