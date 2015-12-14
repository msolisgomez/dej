/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Pedido;
import bean.Producto;
import static java.lang.System.out;
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
 * @author michael
 */
public class PedidoDAOImpl implements PedidoDAO{
    private static final Logger logger = Logger.getLogger(PedidoDAOImpl.class.getName());
    private final Connection con = Conexion.getCon();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static PedidoDAOImpl pedao;    

    public PedidoDAOImpl() {
    }
    
   public static PedidoDAOImpl getPedao() {
        if (pedao == null) {
            pedao = new PedidoDAOImpl();
        }
        return pedao;
    }

    @Override
    public Integer pedidoIngresa(Pedido pe) {
         Integer valor = 0;
        try {             //id_producto autoincrementable 
            ps = con.prepareStatement("insert into pedido (rut,medio_pago,agranda_bebida_papas"
                    + ",para_llevar,total) values(?,?,?,?,?)");
            ps.setInt(1, pe.getRut());
            ps.setString(2, pe.getMedio_pago());
            ps.setBoolean(3, pe.getAgranda_bebida_papas());
            ps.setBoolean(4, pe.getPara_llevar());
            ps.setInt(5, pe.getTotal());
            
            
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
    public Integer ultimoPedido(Integer rut) {
        Integer valor = 0;
        try {
            ps = con.prepareStatement("select max(ticket) from pedido where rut=?");
            ps.setInt(1, rut);
            rs = ps.executeQuery();
             while (rs.next()) {
                valor=(rs.getInt(1));
            }
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
    public List<Pedido> pedidoRut(Integer rut) {
       List<Pedido> datos = new ArrayList<>();
    
       
        try {
            ps = con.prepareStatement("select ticket, rut,medio_pago,agranda_bebida_papas,para_llevar,total"
                    + " from pedido where rut=?");
            ps.setInt(1,rut);
            rs = ps.executeQuery();
 
                    
            while (rs.next()) {
                datos.add(new Pedido(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getBoolean(4),rs.getBoolean(5),rs.getInt(6)));
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
    
    

