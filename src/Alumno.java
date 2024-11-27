/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author charl
 */
class Alumno extends Usuario {
    private String identificador = "Alumno";
    private ArrayList<String> librosPrestados = new ArrayList<>();

    public Alumno(int clave, String apodo, String nombre, String apellidos, String contraseña) {
        super(clave, apodo, nombre, apellidos, contraseña);
    }

    public Alumno(String apodo, String contraseña) {
        super(apodo, contraseña);
    }
    

    public String getIdentificador() {
        return identificador;
    }

    public ArrayList<String> getLibrosPrestados() {
        return librosPrestados;
    }

    public void añadirLibroPrestado(String libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(String libro) {
        librosPrestados.remove(libro);
    }
}
