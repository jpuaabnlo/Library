/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charl
 */
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Usuario {
    private int clave;
    private String apodo;
    private String nombre;
    private String apellidos;
    private String contrasena;
    
    public Usuario(){}
    
    public Usuario(int clave, String apodo, String nombre, String apellidos, String contrasena) {
        this.clave = clave;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
    }

    public Usuario(String apodo, String contrasena) {
        this.apodo = apodo;
        this.contrasena = contrasena;
    }
    
    
    
    public Usuario(String linea) {
        String[] elementos = linea.split("\\&\\$");
        this.clave = Integer.parseInt(elementos[0]);
        this.apodo = elementos[1];
        this.nombre = elementos[2];
        this.apellidos = elementos[3];
        this.contrasena = elementos[4];
    }

    public String getApodo() { 
        return apodo; 
    }
    public void setApodo(String apodo) { 
         if (apodo.matches("[A,G,S,I]{1}[0-9]{2}[0-9]{3}[0-9]{3}")) {
             this.apodo = apodo;
             int carrera = Integer.parseInt(apodo.substring(1)),
                     año = Integer.parseInt(apodo.charAt(7) + "" + apodo.charAt(8)),
                    anio = (apodo.charAt(4) - 48) * 10 + (apodo.charAt(5) - 48);
         }
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        nombre = nombre.trim().replaceAll(" +", " ");
        if (nombre.length() > 1 && nombre.length() <= 30) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre debe tener entre 2 y 30 caracteres");
        }
    }

    public String getApellidos() { return apellidos; 
    }
    public void setApellidos(String apellidos) { 
        this.apellidos = apellidos; 
    }

    public String getContraseña() { 
        return contrasena; 
    }
    public void setContraseña(String contrasena) { 
        this.contrasena = contrasena; 
    }

    public static boolean esAlumno(String apodo) {
        return Pattern.matches("S\\d{8}", apodo);
    }

    public Object[] toArray(){
        return new Object[]{clave, apodo, nombre, apellidos, contrasena};
    }
    
    @Override
    public String toString() {
        return apodo + "&$" + nombre + "&$" + apellidos + "&$" + contrasena;
    }
}

