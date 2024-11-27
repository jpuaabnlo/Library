/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author charl
 */
class Admin extends Usuario {
    private String identificador = "Admin";

    public Admin(int clave, String apodo, String nombre, String apellidos, String contraseña) {
        super(clave, apodo, nombre, apellidos, contraseña);
    }

    public String getIdentificador() {
        return identificador;
    }
}
