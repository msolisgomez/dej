/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pedido;

import java.util.List;

/**
 *
 * @author michael
 */
public interface PedidoDAO {
     public Integer pedidoIngresa(Pedido pe);
     public Integer ultimoPedido(Integer rut); 
     public List<Pedido> pedidoRut(Integer rut); 
     
    
}
