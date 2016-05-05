/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.UsuarioControle;
import br.edu.uerr.sspoc.modelo.Usuario;
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
public class UsuarioBean extends AbstractBean implements Serializable{
    
    private Usuario usuario;
    
    @EJB
    private UsuarioControle usuarioControle;
    
    private List<Usuario> listUsuario = new ArrayList<>();
    
    public UsuarioBean(){
        
    }
    
    public String abreForm(){
        try {
            usuario = new Usuario();
            listUsuario = new ArrayList<>();
            listUsuario = usuarioControle.findAll();
            return redirect("/sistema/usuario/formUsuario.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaForm(Usuario aux){
        try {
            usuario = new Usuario();
            usuario = usuarioControle.pegarUsuarioPeloId(aux.getId());
            return redirect("/sistema/usuario/formUsuario.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            usuarioControle.salvar(usuario);
            showFacesMessage("Usuário Salvo com Sucesso!!!", 2);
            listUsuario = new ArrayList<>();
            listUsuario = usuarioControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar usuário" + e.getMessage(), 4);
        }
    }
    
    public void removerForm(Usuario aux){
        try {            
            usuarioControle.remover(aux);
            showFacesMessage("Usuário Deletado com Sucesso!!!", 2);
            listUsuario = new ArrayList<>();
            listUsuario = usuarioControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar usuário" + e.getMessage(), 4);
        }
    }
    
    
    //Gets e Set

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
    
    
    
}
