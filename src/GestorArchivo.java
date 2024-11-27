/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author paveg
 */
public class GestorArchivo {
    public static ArrayList<String> leerArchivo(String archivo) throws Exception {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(archivo));
            String linea;
            while((linea=lector.readLine())!=null){
                lineas.add(linea);
            }
            return lineas;
        } catch (FileNotFoundException ex) {
            throw new Exception("Archivo no encontrado");
        } catch (IOException ex) {
            throw new Exception("Error al leer el archivo");
        }

    }
    public static String leerLinea(String archivo,int numLinea) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(archivo));
            String linea=null;
            for (int i = 0; i<=numLinea; i++) {
                linea=lector.readLine();
            }
            return linea;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }

    }
    public static ArrayList<String> reemplazarLinea(String archivo,
        int numLinea, String nuevaLinea) {
        //Obtener todas las líneas del archivo 
        ArrayList<String> lineas;
        BufferedWriter escritor = null;
        try {
            lineas = leerArchivo(archivo);
            //Reemplazar en la lista la línea indicada con la nueva versión de la línea lineas.set(numLinea, nuevaLinea);
            //Escribir en el archivo todas las líneas, asegurándonos de abrir el archivo //sin conservar el contenido
            escritor = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < lineas.size(); i++) {
            escritor.write(lineas.get(i) + "\n");
            }
            //Si todo va bien devolvemos la nueva lista de líneas para
            //que se carguen en la lista
            return lineas;
        }catch(Exception ex) {
            //Si algo no va bien, devolvemos null para indicar que no se realizó la operación 
            return null;
        } 
        finally{
            try {
                //Cerramos el archivo para asegurar que se reflejen las modificaciones 
                escritor.close();
            }catch (IOException ex) {
                //Si algo no va bien, devolvemos null para indicar que no se realizó la operación 
                return null;
            }
        }
    }
    
    public static ArrayList<String> agregarLinea(String archivo,
            String nuevaLinea) {
        //Escribir en el archivo la nueva línea, asegurándonos de abrir el archivo
        //y conservar el contenido
        BufferedWriter escritor = null;
        ArrayList<String> lineas;
        try {
            //Obtener todas las líneas del archivo
            lineas = leerArchivo(archivo);
        } catch (Exception ex) {

            lineas = new ArrayList<>();
        }
        try {
            //Añadir a la lista la línea nueva
            lineas.add(nuevaLinea);
            escritor = new BufferedWriter(new FileWriter(archivo, true));
            escritor.write(nuevaLinea + "\n");
            //Si todo va bien devolvemos la lista de líneas para 
            //que se carguen en la lista 
            return lineas;
        } catch (Exception ex) {
            //Si algo no va bien, devolvemos null para indicar que no se realizó la operación
            return null;
        } finally {
            try {
                //Cerramos el archivo para asegurar que se reflejen las modificaciones
                escritor.close();
            } catch (Exception ex) {
                //Si algo no va bien, devolvemos null para indicar que no se realizó la operación
                return null;
            }
        }
    }
    
    public static ArrayList<String> eliminarLinea(String archivo, int numLinea) {
        //Escribir en el archivo todas las líneas, asegurándonos de abrir el archivo
        //sin conservar el contenido
        BufferedWriter escritor = null;
        try {
            //Obtener todas las líneas del archivo
            ArrayList<String> lineas = leerArchivo(archivo);
            //Eliminar la línea que ya no queremos
            lineas.remove(numLinea);
            escritor = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < lineas.size(); i++) {
                escritor.write(lineas.get(i) + "\n");
            }
            //Si todo va bien devolvemos la nueva lista de líneas para 
            //que se carguen en la lista 
            return lineas;
        } catch (Exception ex) {
            //Si algo no va bien, devolvemos null para indicar que no se realizó la operación
            return null;
        } finally {
            try {
                //Cerramos el archivo para asegurar que se reflejen las modificaciones
                escritor.close();
            } catch (IOException ex) {
                //Si algo no va bien, devolvemos null para indicar que no se realizó la operación
                return null;
            }
        }
    }
    
    /*
    public static ArrayList<String> agregarLinea(String archivo, String nuevaLinea) {  
        BufferedWriter escritor = null;
        try{
            ArrayList<String> lineas = leerArchivo(archivo);
            lineas.add(nuevaLinea);
            escritor = new BufferedWriter(new FileWriter(archivo,true));
            escritor.write(nuevaLinea+"\n");
            return lineas;
        }catch(Exception ex){
            return null;
        }finally{
            try{
                escritor.close();
            }catch(IOException ex){
                return null;
            }
        }
    }
    
    public static ArrayList<String> eliminarLinea(String archivo, int numLinea) {        
        BufferedWriter escritor = null;
        try{
            ArrayList<String> lineas = leerArchivo(archivo);
           lineas.remove(numLinea);
            escritor =new BufferedWriter(new FileWriter(archivo));
            for(int i=0; i<lineas.size(); i++){
                escritor.write(lineas.get(i)+"\n");
            }
            return lineas;
        }catch(Exception ex){
            return null;
        }finally{
            try{
                escritor.close();
            }catch(IOException ex){
                return null;
            }
        }
    }*/
}
