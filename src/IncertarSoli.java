/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacionfinal;


/**
 *
 * @author charl
 */
public class IncertarSoli {
    public static void main(String [] args){
        try{
            Solicitante a = new Solicitante("Paula Hernandez");
            
            Solicitante b = new Solicitante("Raul Rodriguez");
            
            Solicitante c = new Solicitante("Sofia Vieyra");
            
            Solicitante d = new Solicitante("Saul Mondoya");
            
            Solicitante e = new Solicitante("Juan Toledo");
            
            Solicitante f = new Solicitante("Yair Montes");
            
            ManejadorArchivos.agregarObjeto("Solicitante.txt", a);
            ManejadorArchivos.agregarObjeto("Solicitante.txt", b);
            ManejadorArchivos.agregarObjeto("Solicitante.txt", c);
            ManejadorArchivos.agregarObjeto("Solicitante.txt", d);
            ManejadorArchivos.agregarObjeto("Solicitante.txt", e);
            ManejadorArchivos.agregarObjeto("Solicitante.txt", f);
        }catch(ClassNotFoundException ex){
            System.err.println("Error al Escrir");
        }
    }
}
