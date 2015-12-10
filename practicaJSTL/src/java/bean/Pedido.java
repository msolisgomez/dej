/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author michael
 */
public class Pedido {
    private Integer ticket;
    private Integer rut;
    private String medio_pago;
    private Boolean agranda_bebida_papas;
    private Boolean para_llevar;
    private Integer total;

    public Pedido() {
    }

    public Pedido(Integer ticket, Integer rut, String medio_pago, Boolean agranda_bebida_papas, Boolean para_llevar, Integer total) {
        this.ticket = ticket;
        this.rut = rut;
        this.medio_pago = medio_pago;
        this.agranda_bebida_papas = agranda_bebida_papas;
        this.para_llevar = para_llevar;
        this.total = total;
    }

    public Pedido(Integer rut, String medio_pago, Boolean agranda_bebida_papas, Boolean para_llevar, Integer total) {
        this.rut = rut;
        this.medio_pago = medio_pago;
        this.agranda_bebida_papas = agranda_bebida_papas;
        this.para_llevar = para_llevar;
        this.total = total;
    }
    
    

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public Boolean getAgranda_bebida_papas() {
        return agranda_bebida_papas;
    }

    public void setAgranda_bebida_papas(Boolean agranda_bebida_papas) {
        this.agranda_bebida_papas = agranda_bebida_papas;
    }

    public Boolean getPara_llevar() {
        return para_llevar;
    }

    public void setPara_llevar(Boolean para_llevar) {
        this.para_llevar = para_llevar;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
    
}
