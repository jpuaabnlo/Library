/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;

import java.util.ArrayList;

/**
 *
 * @author charl
 */
public class Leer {
    public static void main(String [] args) throws ClassNotFoundException{
        ArrayList<Object> solicitante = ManejadorArchivos.leerArchivo("Solicitante.txt");
        for(Object soli : solicitante){
            System.out.println(soli);
            System.out.println("--------------------------");
        }
    }
}
