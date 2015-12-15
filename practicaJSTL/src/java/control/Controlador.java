
package control;

import bean.Cliente;
import bean.Pedido;
import bean.Pedido_detalle;
import bean.Producto;
import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.PedidoDAO;
import dao.PedidoDAOImpl;
import dao.PedidoDetalleDAO;
import dao.PedidoDetalleDAOImpl;
import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Duoc
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String seleccion = request.getParameter("pressedButton");
        ClienteDAO cdao = ClienteDAOImpl.getCdao();
        ProductoDAO pdao = ProductoDAOImpl.getPdao();
        PedidoDAO pedao = PedidoDAOImpl.getPedao();
        
        if (seleccion.equals("iniciarPagina")) {
            List<Producto> productos = pdao.productoTodos();
            String rut = (request.getParameter("rut"));

            String nombre = (request.getParameter("nombre"));
            if(nombre==null|| nombre.isEmpty()){
                nombre = (String)request.getAttribute("nombre");
            }
            request.setAttribute("rut", rut);
            request.setAttribute("nombre", nombre);
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (seleccion.equals("AGREGAR")) {

            agregarProd(request,null);
            HttpSession session = request.getSession();
            List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
            request.setAttribute("total", getTotalPedido(sessionPedidoDet));
            request.getRequestDispatcher("Controlador?pressedButton=iniciarPagina").forward(request, response);

        } else if (seleccion.equals("ENVIAR PEDIDO")) {

            if (grabarPedido(request)) {
                HttpSession session = request.getSession();
                String nombre = request.getParameter("nombre");
                String rut = request.getParameter("rut");
                List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
                Integer ultTickIngres = 0;
                ultTickIngres = pedao.ultimoPedido(Integer.parseInt(rut));
                request.setAttribute("nombre", nombre);
                request.setAttribute("ticket", ultTickIngres);
                request.setAttribute("total", getTotalPedido(sessionPedidoDet));
                session.removeAttribute("sessionPedidoDet");
                request.getRequestDispatcher("pedidosTicket.jsp").forward(request, response);

            } 
            else {
                request.getRequestDispatcher("pagina2.jsp").forward(request, response);
            }

        } else if (seleccion.equals("Buscar Pedidos")) {

            Integer rut = Integer.parseInt(request.getParameter("rut"));
            List<Pedido> pedidos = pedao.pedidoRut(rut);
            request.setAttribute("pedidos", pedidos);
             if(!pedidos.isEmpty()){
            request.getRequestDispatcher("misPedidos.jsp").forward(request, response);
            }
            else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            

        } else if (seleccion.equals("repetirPedido")) {
            Integer ticket = Integer.parseInt(request.getParameter("ticket"));
            Integer rut = Integer.parseInt(request.getParameter("rut"));
            PedidoDetalleDAO pDetDao = new PedidoDetalleDAOImpl();
            Cliente cli = cdao.clienteBuscar(rut);
            cleanSession(request);
            List<Pedido_detalle> detalles = pDetDao.pedidoDetalleTicket(ticket);
            for(Pedido_detalle pdet : detalles){
                for(int i=0;i<pdet.getCantidad();++i){
                    agregarProd(request,pdet.getId_producto());
                }
            }
            request.setAttribute("rut", cli.getRut());
            request.setAttribute("nombre", cli.getNombre());
            HttpSession session = request.getSession();
            List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
            request.setAttribute("total", getTotalPedido(sessionPedidoDet));
            request.getRequestDispatcher("Controlador?pressedButton=iniciarPagina").forward(request, response);
        }else if(seleccion.equals("ELIMINAR PRODUCTO")) {
            elimProd(request);
            HttpSession session = request.getSession();
            List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
            request.setAttribute("total", getTotalPedido(sessionPedidoDet));
            request.getRequestDispatcher("Controlador?pressedButton=iniciarPagina").forward(request, response);
        }

    }
    private void cleanSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("sessionPedidoDet");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//         Map<String, String> messages = new HashMap<String, String>();
//    request.setAttribute("messages", messages);
        processRequest(request, response);
      
//            String rut = (request.getParameter("rut"));
//            String nombre = (request.getParameter("nombre"));
//            if (rut == null || rut.trim().isEmpty()) {
//        messages.put("rut", "NO PUEDE ESTAR VACIO");
//    }
//    if (nombre == null || nombre.trim().isEmpty()) {
//        messages.put("nombre", "NO PUEDE ESTAR VACIO");
//    }
//    request.getRequestDispatcher("Controlador?pressedButton=iniciarPagina").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          processRequest(request, response);
            
    }

   
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<Pedido_detalle> agregarProd(HttpServletRequest request, Integer id_prod) {
        Integer id_producto = id_prod;
        if (id_producto == null) {
            id_producto = Integer.parseInt(request.getParameter("sele"));
        }
        HttpSession session = request.getSession();
        List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
        if (sessionPedidoDet == null) {
            sessionPedidoDet = new ArrayList<Pedido_detalle>();

        }
        for (Pedido_detalle pde : sessionPedidoDet) {
            if (id_producto == pde.getProducto().getId_producto()) {
                pde.sumarProducto();
                session.setAttribute("sessionPedidoDet", sessionPedidoDet);
                return sessionPedidoDet;
            }
        }
        ProductoDAO pdao = new ProductoDAOImpl();
        Producto prod = pdao.getProductoById(id_producto);
        Pedido_detalle pde = new Pedido_detalle();
        pde.setCantidad(1);
        pde.setProducto(prod);
        sessionPedidoDet.add(pde);
        session.setAttribute("sessionPedidoDet", sessionPedidoDet);
        return sessionPedidoDet;
    }
    
    private List<Pedido_detalle> elimProd(HttpServletRequest request) {
        Integer id_producto = Integer.parseInt(request.getParameter("id_producto"));
        HttpSession session = request.getSession();
        List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
        if (sessionPedidoDet == null) {
            sessionPedidoDet = new ArrayList<Pedido_detalle>();

        }
        for (Pedido_detalle pde : sessionPedidoDet) {
            if (id_producto == pde.getProducto().getId_producto()) {
                pde.restarProducto();
                session.setAttribute("sessionPedidoDet", sessionPedidoDet);
                return sessionPedidoDet;
            }
        }
        ProductoDAO pdao = new ProductoDAOImpl();
        Producto prod = pdao.getProductoById(id_producto);
        Pedido_detalle pde = new Pedido_detalle();
        pde.setCantidad(1);
        pde.setProducto(prod);
        sessionPedidoDet.remove(pde);
        session.setAttribute("sessionPedidoDet", sessionPedidoDet);
        return sessionPedidoDet;

    }

    private Boolean grabarPedido(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
        Integer rut = Integer.parseInt(request.getParameter("rut"));
        ClienteDAO cdao = new ClienteDAOImpl();
        PedidoDAO pedao = new PedidoDAOImpl();
        PedidoDetalleDAO peddao = new PedidoDetalleDAOImpl();
        Integer val = 0;
        Integer ultTicket = 0;

        if (!cdao.clienteExiste(rut)) {
            String nombre = request.getParameter("nombre");
            val = cdao.clienteIngresa(new Cliente(rut, nombre));
            if (val == 0) {
                return false;
            }

        }
        Pedido pe = new Pedido();
        pe.setRut(rut);
        pe.setMedio_pago(request.getParameter("medio_pago"));
        pe.setAgranda_bebida_papas(request.getParameter("agranda_bebida_papas") == null ? false : true);
        pe.setPara_llevar(request.getParameter("para_llevar") == null ? false : true);
        pe.setTotal(getTotalPedido(sessionPedidoDet));
        val = pedao.pedidoIngresa(pe);
        if (val == 0) {
            return false;
        }
        ultTicket = pedao.ultimoPedido(rut);
        for (Pedido_detalle pde : sessionPedidoDet) {
            pde.setTicket(ultTicket);
            pde.setId_producto(pde.getProducto().getId_producto());
            val = peddao.pedidoDetIngresa(pde);
            if (val == 0) {
                return false;
            }
        }
        return true;
    }

    private Integer getTotalPedido(List<Pedido_detalle> listDet) {
        Integer tot = 0;
        for (Pedido_detalle pde : listDet) {
            tot = tot + pde.getCantidad() * pde.getProducto().getValor();
        }
        return tot;
    }
}
