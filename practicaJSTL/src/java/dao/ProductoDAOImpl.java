/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
 * @author msolis
 */
public class ProductoDAOImpl implements ProductoDAO{
    private static final Logger logger = Logger.getLogger(ProductoDAOImpl.class.getName());
    private final Connection con = Conexion.getCon();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static ProductoDAOImpl pdao;

    public ProductoDAOImpl() {
    }
    
      public static ProductoDAOImpl getPdao() {
        if (pdao == null) {
            pdao = new ProductoDAOImpl();
        }
        return pdao;
    }

    @Override
    public List<Producto> productoTodos() {
       List<Producto> datos = new ArrayList<>();
       
        try {
            ps = con.prepareStatement("select id_producto, descripcion,valor from producto");
            rs = ps.executeQuery();
 
                    
            while (rs.next()) {
                datos.add(new Producto(rs.getInt(1), rs.getString(2).toUpperCase(), rs.getInt(3)));
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

    @Override
    public Integer productoIngresa(Producto pro) {
        Integer valor = 0;
        try {             //id_producto autoincrementable 
            ps = con.prepareStatement("insert into producto (descripcion, valor) values(?,?)");
            
            ps.setString(1, pro.getDescripcion());
            ps.setInt(2, pro.getValor());
            
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

//    @Override
//    public Integer productoBaja(Producto pro) {
//        
//       
//        Integer valor = 0;
//        try {
//            ps = con.prepareStatement("update producto set baja=? where id=?");
//            
//            ps.setBoolean(1, pro.getBaja());
//            ps.setInt(2, pro.getId());
//            valor = ps.executeUpdate();
//        } catch (SQLException ex) {
//            logger.log(Level.CONFIG, "Actualizar, sql erronea: {0}", ex.getMessage());
//        } finally {
//            if (con != null) {
//                Conexion.cerrarCon();
//            }
//        }
//        return valor;
//    }

//    @Override
//    public Boolean productoMayorCero(Integer precio) {// no usado
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
   
//
//    @Override
//    public Integer productoPrecio(Producto pro) {
//        Integer valor = 0;
//        try {
//            ps = con.prepareStatement("select precio from producto");
//            
//            ps.setInt(1, pro.getPrecio());
//           
//            valor = ps.executeUpdate();
//        } catch (SQLException ex) {
//            logger.log(Level.CONFIG, "Select, sql erronea: {0}", ex.getMessage());
//        } finally {
//            if (con != null) {
//                Conexion.cerrarCon();
//            }
//        }
//        return valor;
//    }

    @Override
    public Integer productoElimina(Integer id_producto) {
            Integer valor = 0;
        try {
            ps = con.prepareStatement("delete from producto where id_producto=?");
            ps.setInt(1, id_producto);
            valor = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.CONFIG, "Eliminar, sql erronea: {0}", ex.getMessage());
        } finally {
            if (con != null) {
                Conexion.cerrarCon();
            }
        }
        return valor;
    }

   

    @Override
    public Producto getProductoById(int id_producto) {
       Producto datos = null;
  
        try {
            ps = con.prepareStatement("select id_producto, descripcion,valor from producto where id_producto =?");
            ps.setInt(1, id_producto);
            rs = ps.executeQuery();
 
                    
            while (rs.next()) {
                datos = new Producto(rs.getInt(1), rs.getString(2).toUpperCase(), rs.getInt(3));
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
     @Override
    public Integer productoGetPrec(Producto pro) {
        List<Producto> datos = new ArrayList<>();
       Integer val = 0;
        try {
            ps = con.prepareStatement("select valor from producto where id=?");
            ps.setInt(1, pro.getId_producto());
            rs = ps.executeQuery();
            
                    
            while (rs.next()) {
                val=rs.getInt(1);
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
        return val;  
    }
    
        
    }

