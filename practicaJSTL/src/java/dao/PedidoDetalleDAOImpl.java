/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Pedido_detalle;
import bean.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class PedidoDetalleDAOImpl implements PedidoDetalleDAO{
      private static final Logger logger = Logger.getLogger(PedidoDetalleDAOImpl.class.getName());
    private final Connection con = Conexion.getCon();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static PedidoDetalleDAOImpl peddao;

    public PedidoDetalleDAOImpl() {
    }
    

    
    
    @Override
    public Integer pedidoDetIngresa(Pedido_detalle pd) {
      Integer valor = 0;
        try {             //id_producto autoincrementable 
            ps = con.prepareStatement("insert into pedido_detalle(ticket,id_producto,cantidad)values(?,?,?)");
                   
            ps.setInt(1, pd.getTicket());
            ps.setInt(2, pd.getId_producto());
            ps.setInt(3, pd.getCantidad());
            
            
            
            valor = ps.executeUpdate();
            
        } catch (SQLException ex) {
            logger.log(Level.CONFIG, "Insertar, sql erronea: {0}", ex.getMessage());
        } finally {
            if (con != null) {
                Conexion.cerrarCon();
            }
        }
        return valor;
    }

    @Override
    public Integer pedidoDetBusqueda(Integer rut) {
        Integer valor = 0;
        try {
            ps = con.prepareStatement("select id_pedido_detalle, ticket,id_producto,cantidad from pedido_detalle where rut=?");
            ps.setInt(1, rut);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.CONFIG, "Buscar, sql erronea: {0}", ex.getMessage());
        } finally {
            if (con != null) {
                Conexion.cerrarCon();
            }
        }
        return valor;
    }

    @Override
    public List<Pedido_detalle> pedidoDetalleTodos() {
       List<Pedido_detalle> datos = new ArrayList<>();
       
        try {
            ps = con.prepareStatement("select id_pedido_detalle, ticket,id_producto,cantidad from pedido_detalle");
            rs = ps.executeQuery();
 
                    
            while (rs.next()) {
                datos.add(new Pedido_detalle(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            logger.log(Level.CONFIG, "Select, sql erronea: {0}", ex.getMessage());
        } finally {
            if (con != null) {
                Conexion.cerrarCon();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return datos;  
        
    }
    
    

   
    

    
}
