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
public class Libro {
    private String nombre;
    private String autor;
    private boolean disponible = true; // Por defecto disponible

    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        nombre=nombre.trim().replace("  "," ").replace("  "," ");
        //entre 2 y máximo 30
        if(nombre.toLowerCase().length()>=2 && nombre.toLowerCase().length()<=30)
            this.nombre = nombre;
        else
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre "
                    + "2 y 30 caracteres");
    }

    public String getAutor() { 
        return autor; 
    }
    public void setAutor(String autor) { 
        autor=autor.trim().replace("  "," ").replace("  "," ");
        //entre 2 y máximo 30
        if(autor.toLowerCase().length()>=2 && autor.toLowerCase().length()<=30)
            this.autor = autor;
        else
            throw new IllegalArgumentException("El nombre es obligatorio y debe tener entre "
                    + "2 y 30 caracteres");
    }

    public boolean isDisponible() { 
        return disponible; 
    }
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }
    
    public Object[] toArray(){
        return new Object[]{nombre, autor, disponible};
    }

    @Override
    public String toString() {
        return nombre + "&$" + autor + "&$" + disponible;
    }
    
}


