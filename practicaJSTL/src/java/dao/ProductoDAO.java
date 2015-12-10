/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Producto;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author msolis
 */
public interface ProductoDAO {
    public List<Producto> productoTodos(); 
    public Integer productoIngresa(Producto pro);
    public Integer productoElimina(Integer id_producto);
    public ResultSet getProd();
    public Producto getProductoById(int id_producto);
//    public Integer productoBaja(Producto pro);
//    public Boolean productoMayorCero(Integer precio);//no esta en uso
//    public Integer productoGetPrec(Producto pro);
//    public Integer productoPrecio(Producto pro);
    
}
