/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import java.util.List;

/**
 *
 * @author Duoc
 */
public interface ClienteDAO {
    public Integer clienteIngresa(Cliente cli);
    public List<Cliente> clienteTodos(); 
    public Boolean clienteExiste(Integer id);
    public Integer clienteElimina(Integer id);
    
    
    
}
