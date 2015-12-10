/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Duoc
 */
public class Cliente {
    private Integer rut;
    private String nombre;

    public Cliente() {
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    

    public Cliente(Integer rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
