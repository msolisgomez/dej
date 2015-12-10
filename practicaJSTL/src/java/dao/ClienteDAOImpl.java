
package dao;

import bean.Cliente;
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
 * @author Duoc
 */
public class ClienteDAOImpl implements ClienteDAO{
 private static final Logger logger = Logger.getLogger(ClienteDAOImpl.class.getName());
    private final Connection con = Conexion.getCon();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static ClienteDAOImpl cdao;    

    public ClienteDAOImpl() {
    }
    
   public static ClienteDAOImpl getCdao() {
        if (cdao == null) {
            cdao = new ClienteDAOImpl();
        }
        return cdao;
    }

    @Override
    public Integer clienteIngresa(Cliente cli) {
        Integer valor = 0;
        try {
            ps = con.prepareStatement("insert into cliente(rut,nombre)values(?,?)");
            ps.setInt(1, cli.getRut());
            ps.setString(2, cli.getNombre());
            
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
    public List<Cliente> clienteTodos() {
        List<Cliente> datos = new ArrayList<>();
        try {
            ps = con.prepareStatement("select id, nombre from cliente");
            rs = ps.executeQuery();
 
                    
            while (rs.next()) {
                datos.add(new Cliente(rs.getInt(1), rs.getString(2).toLowerCase()));
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
    public Boolean clienteExiste(Integer rut) {
       Boolean datos = false;
        try {
            ps = con.prepareStatement("select rut from cliente where rut=?");
            ps.setInt(1, rut);
            rs = ps.executeQuery();
 
                    
            while (rs.next()) {
               datos=true;
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
    public Integer clienteElimina(Integer rut) {
         Integer valor = 0;
        try {
            ps = con.prepareStatement("delete from cliente where rut=?");
            ps.setInt(1, rut);
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
}