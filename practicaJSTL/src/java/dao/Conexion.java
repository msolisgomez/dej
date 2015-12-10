package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion instancia = getInstancia();
    private static final Logger logger = Logger.getLogger(Conexion.class.getName());

    private Conexion() {
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver); //Declara el driver, sino existe genera una exeption
        } catch (ClassNotFoundException ex) {
            logger.log(Level.CONFIG, "No se puede cargar el Driver: {0}", ex.getMessage());
        }
    }
    
    //Usando singleton crea una sola instancia de la clase
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    private  Connection creaCon() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/et_dej4501"; //Nombre de la base de datos
        String user = "root"; //Usuario de conexión
        String pass = "root"; //Contraseña
        try {
            con = DriverManager.getConnection(url, user, pass); //Objeto de conexión
        } catch (SQLException ex) {
            logger.log(Level.CONFIG, "Error al establecer la conexion: {0}", ex.getMessage());
        } catch (Exception ex) {
            logger.log(Level.CONFIG, "Error generico en la conexion: {0}", ex.getMessage());
        }
        return con;
    }

    public static Connection getCon() {
        return instancia.creaCon();
    }

    public static void cerrarCon() {
        try {
            if (instancia.creaCon() != null) {
                instancia.creaCon().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
