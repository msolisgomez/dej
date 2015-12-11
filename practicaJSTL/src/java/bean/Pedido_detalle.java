/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author michael
 */
public class Pedido_detalle {
    private Integer id_pedido_detalle;
    private Integer ticket;
    private Integer id_producto;
    private Integer cantidad;
    private Producto producto;
    
    
    
    public Pedido_detalle() {
    }

    public Pedido_detalle(Integer id_pedido_detalle, Integer ticket, Integer id_producto, Integer cantidad) {
        this.id_pedido_detalle = id_pedido_detalle;
        this.ticket = ticket;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
    public Integer getId_pedido_detalle() {
        return id_pedido_detalle;
    }

    public void setId_pedido_detalle(Integer id_pedido_detalle) {
        this.id_pedido_detalle = id_pedido_detalle;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public void sumarProducto(){
    this.cantidad ++;
    }
    
    public Integer getTotal(){
    return cantidad*producto.getValor();
    }
    
    
    
    
}
