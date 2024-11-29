/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionfinal;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author paveg
 */
public class ManejadorArchivos {

    public static ArrayList<Object> leerArchivo(String archivo) throws ClassNotFoundException{
        ArrayList<Object> objetos = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            //Maneja la conexión con el archivo
            FileInputStream fis = new FileInputStream(archivo);
            //Maneja las operaciones para interpretar los objetos
            //del archivo
            ois = new ObjectInputStream(fis);
            Object objeto;
            while ((objeto = ois.readObject()) != null) {
                objetos.add(objeto);
            }

            return objetos;
        } catch (EOFException ex) {
            return objetos;
        } catch (IOException ex) {
            return null;
        } finally {
            try {
                ois.close();
            } catch (Exception ex) {
            }
        }

    }

    public static Object leerObjeto(String archivo, int numObjeto) throws ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            Object objeto = null;
            for (int i = 0; i <= numObjeto; i++) {
                objeto = ois.readObject();
            }
            return objeto;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (EOFException ex) {
            return null; 
        } catch (IOException ex) {
            return null;
        } finally {
            try {
                ois.close();
            } catch (Exception ex) {
            }
        }
    }

    public static ArrayList<Object> reemplazarObjeto(String archivo,
            int numObjeto, Object nuevoObjeto) throws ClassNotFoundException {
        //Obtener todos los objetos
        ArrayList<Object> objetos = leerArchivo(archivo);
        //Reemplazar en la lista el objeto indicado con la nueva versión
        objetos.set(numObjeto, nuevoObjeto);
        //Escribir en el archivo todos los objetos, asegurándonos de abrir el archivo
        //sin conservar el contenido
        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream(archivo));
            for (int i = 0; i < objetos.size(); i++) {
                escritor.writeObject(objetos.get(i));
            }
            //Si todo va bien devolvemos la nueva lista de objetos para 
            //que se carguen en la lista 
            return objetos;
        } catch (IOException ex) {
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

    public static ArrayList<Object> agregarObjeto(String archivo,
            Object nuevoObjeto) throws ClassNotFoundException {
        //Escribir en el archivo la nueva línea, asegurándonos de abrir el archivo
        //y conservar el contenido
        
        ObjectOutputStream escritor = null;
        try {
            //Obtener todas las líneas del archivo
            ArrayList<Object> objetos = leerArchivo(archivo);
            if(objetos==null)
                objetos=new ArrayList<>();
            //Añadir el nuevo objeto a la línea
            objetos.add(nuevoObjeto);
            File flArchivo=new File(archivo);
            if(flArchivo.length()>0)
                escritor = new ObjectOutputStreamSinHeader(new FileOutputStream(flArchivo, true));
            else
                escritor = new ObjectOutputStream(new FileOutputStream(flArchivo, true));
            escritor.writeObject(nuevoObjeto);
            //Si todo va bien devolvemos la lista de objetos para 
            //que se carguen en la lista 
            return objetos;
        } catch (IOException ex) {
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

    public static ArrayList<Object> eliminarObjeto(String archivo, int numObjeto) throws ClassNotFoundException {

        //Escribir en el archivo todas las líneas, asegurándonos de abrir el archivo
        //sin conservar el contenido
        ObjectOutputStream escritor = null;
        try {
            //Obtener todas las objetos del archivo
            ArrayList<Object> objetos = leerArchivo(archivo);
            //Eliminar la línea que ya no queremos
            objetos.remove(numObjeto);
            escritor = new ObjectOutputStream(new FileOutputStream(archivo));
            for (int i = 0; i < objetos.size(); i++) {
                escritor.writeObject(objetos.get(i));
            }
            //Si todo va bien devolvemos la nueva lista de líneas para 
            //que se carguen en la lista 
            return objetos;
        } catch (IOException ex) {
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
}
