/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author msolis
 */
public class Producto {
    private Integer id_producto;
    private String descripcion;
    private Integer valor;
    

    public Producto() {
    }

    public Producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    
    

    public Producto(Integer id_producto, String descripcion, Integer valor) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Producto(String descripcion, Integer valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    
    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    
}
