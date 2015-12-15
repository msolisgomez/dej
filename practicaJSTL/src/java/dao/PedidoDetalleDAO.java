/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pedido_detalle;
import bean.Producto;
import java.util.List;

/**
 *
 * @author pc
 */
public interface PedidoDetalleDAO {
     public Integer pedidoDetIngresa(Pedido_detalle pd);
     public Integer pedidoDetBusqueda(Integer rut); 
     public List<Pedido_detalle> pedidoDetalleTodos();
     public List<Pedido_detalle> pedidoDetalleTicket(Integer ticket);
}
