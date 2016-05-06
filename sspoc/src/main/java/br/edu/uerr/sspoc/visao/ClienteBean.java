/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.ClienteControle;
import br.edu.uerr.sspoc.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author fpcarlos
 */
@Named
@SessionScoped
public class ClienteBean extends AbstractBean implements Serializable{
    
    private Cliente cliente;
    
    @EJB
    private ClienteControle clienteControle;
    
    private List<Cliente> listCliente = new ArrayList<>();
    
    public ClienteBean(){
        
    }
    
    public String abreForm(){
        try {
            cliente = new Cliente();
            listCliente = new ArrayList<>();
            listCliente = clienteControle.findAll();
            return redirect("/sistema/cliente/formCliente.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaForm(Cliente aux){
        try {
            cliente = new Cliente();
            cliente = clienteControle.pegarClientePeloId(aux.getId());
            return redirect("/sistema/cliente/formCliente.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            clienteControle.salvar(cliente);
            showFacesMessage("Cliente Salvo com Sucesso!!!", 2);
            cliente = new Cliente();
            listCliente = new ArrayList<>();
            listCliente = clienteControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar cliente" + e.getMessage(), 4);
        }
    }
    
    public void removerForm(Cliente aux){
        try {            
            clienteControle.remover(aux);
            showFacesMessage("Cliente Deletada com Sucesso!!!", 2);
            listCliente = new ArrayList<>();
            listCliente = clienteControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar cliente" + e.getMessage(), 4);
        }
    }
    
    
    //Gets e Set

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }
    
    
    
}
