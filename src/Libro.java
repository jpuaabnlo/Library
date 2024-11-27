/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author charl
 */
public class Libro {
    private String clave;
    private String nombre;
    private String autor;
    private boolean disponible = true; // Por defecto disponible

    public Libro(String clave, String nombre, String autor) {
        this.clave = clave;
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getClave() { 
        return clave; 
    }
    public void setClave(String clave) { 
        this.clave = clave; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getAutor() { 
        return autor; 
    }
    public void setAutor(String autor) { 
        this.autor = autor; 
    }

    public boolean isDisponible() { 
        return disponible; 
    }
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }

    @Override
    public String toString() {
        return clave + "&$" + nombre + "&$" + autor + "&$" + disponible;
    }
}


