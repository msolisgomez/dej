/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
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
            request.setAttribute("rut", rut);
            request.setAttribute("nombre", nombre);
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            //response.sendRedirect("index.jsp").f;        
        } else if (seleccion.equals("agregar")) {

            agregarProd(request);
            HttpSession session = request.getSession();
            List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
            request.setAttribute("total", getTotalPedido(sessionPedidoDet));
            request.getRequestDispatcher("Controlador?pressedButton=iniciarPagina").forward(request, response);

        } else if (seleccion.equals("ENVIAR PEDIDO")) { 

           if(grabarPedido(request)){
           HttpSession session = request.getSession();
           String nombre=request.getParameter("nombre");
           String rut=request.getParameter("rut");
           
            List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
            Integer ultTickIngres=0;
            ultTickIngres=pedao.ultimoPedido(Integer.parseInt(rut));
            request.setAttribute("nombre", nombre);
            request.setAttribute("ticket",ultTickIngres );
            request.setAttribute("total",getTotalPedido(sessionPedidoDet));
            session.removeAttribute("sessionPedidoDet");
            request.getRequestDispatcher("pedidosTicket.jsp").forward(request, response);
           
           }
           else{
           request.getRequestDispatcher("pagina2.jsp").forward(request, response);
           }

            Boolean agranda_bebida_papas = Boolean.parseBoolean(request.getParameter("agranda_bebida_papas"));
            if (agranda_bebida_papas != null) {
                out.println("agranda_bebida_papas seleccionado ");
            }
            Boolean para_llevar = Boolean.parseBoolean(request.getParameter("para_llevar"));
            if (para_llevar != null) {
                out.println("para_llevar seleccionado ");
            }
            String medio_pago = request.getParameter("medio_pago");

//            Integer val = pedao.pedidoIngresa(new Pedido(rut, medio_pago, agranda_bebida_papas, para_llevar, total));

            Cliente cliente = grabarCliente(request);

        } else if (seleccion.equals("buscar")) {

            Integer rut = Integer.parseInt(request.getParameter("rut"));
            List<Pedido> datos = pedao.pedidoRut(rut);
            request.setAttribute("datos", datos);
            if(!datos.isEmpty()){
            request.getRequestDispatcher("misPedidos.jsp").forward(request, response);
            }
            else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if (seleccion.equals("buscar otro rut")) {
            request.getRequestDispatcher("misPedidos.jsp").forward(request, response);

        } else if (seleccion.equals("almacenar")) {
            Integer rut = Integer.parseInt(request.getParameter("rut"));
            String nombre=request.getParameter("nombre");
            Integer valor = cdao.clienteIngresa(new Cliente(rut,nombre));
         request.setAttribute("valor", valor);
         request.getRequestDispatcher("regCli.jsp").forward(request,response);

        } else if (seleccion.equals("eliminar producto")) {
            elimProd(request);
            HttpSession session = request.getSession();
            List<Pedido_detalle> sessionPedidoDet = (List<Pedido_detalle>) session.getAttribute("sessionPedidoDet");
            request.setAttribute("total", getTotalPedido(sessionPedidoDet));
            request.getRequestDispatcher("Controlador?pressedButton=iniciarPagina").forward(request, response);

        } else if (seleccion.equals("9")) {
            response.sendRedirect("pagina4.jsp");

        } else if (seleccion.equals("10")) {
            response.sendRedirect("pagina7.jsp");

        }

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
        processRequest(request, response);
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

    private Cliente grabarCliente(HttpServletRequest request) throws ServletException, IOException {
        ClienteDAO cdao = ClienteDAOImpl.getCdao();
        Integer rut = Integer.parseInt(request.getParameter("rut"));
        String nombre = request.getParameter("nombre");
        Cliente cliente = new Cliente(rut, nombre);
        Integer valor = cdao.clienteIngresa(cliente);
        request.setAttribute("valor", valor);
        //request.getRequestDispatcher("regCli.jsp").forward(request,response);
        if (valor == 0) {
            cliente = null;
        }
        return cliente;
    }

    private List<Pedido_detalle> agregarProd(HttpServletRequest request) {
        Integer id_producto = Integer.parseInt(request.getParameter("sele"));
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
//ultcreado**************************************************+
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
        Integer ultTicket=0;

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
        ultTicket=pedao.ultimoPedido(rut);
         for (Pedido_detalle pde : sessionPedidoDet) {
            pde.setTicket(ultTicket);
            pde.setId_producto(pde.getProducto().getId_producto());
            val=peddao.pedidoDetIngresa(pde);
            if(val==0){
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
