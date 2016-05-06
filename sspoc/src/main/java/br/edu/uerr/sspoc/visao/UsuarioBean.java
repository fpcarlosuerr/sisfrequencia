/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.EmpresaControle;
import br.edu.uerr.sspoc.controle.GrupoControle;
import br.edu.uerr.sspoc.controle.UsuarioControle;
import br.edu.uerr.sspoc.controle.UsuarioGrupoControle;
import br.edu.uerr.sspoc.modelo.Empresa;
import br.edu.uerr.sspoc.modelo.Grupo;
import br.edu.uerr.sspoc.modelo.Usuario;
import br.edu.uerr.sspoc.modelo.UsuarioGrupo;
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
    
    private Grupo   grupo;
    
    private Empresa empresa;
    
    private UsuarioGrupo usuarioGrupo;
    
    @EJB
    private UsuarioControle usuarioControle;
    
    @EJB
    private GrupoControle grupoControle;
    
    @EJB
    private EmpresaControle empresaControle;
    
    @EJB
    private UsuarioGrupoControle usuarioGrupoControle;
    
    private List<Usuario> listUsuario = new ArrayList<>();
    
    private List<Grupo> listGrupos = new ArrayList<>();
       
    private List<Empresa> listEmpresa = new ArrayList<>();
    
    private List<Grupo> listGrupoUsuario = new ArrayList<>();
    
    
    
    
    public UsuarioBean(){
        
    }
    
    public String abreForm(){
        try {
            usuario = new Usuario();
            usuarioGrupo = new UsuarioGrupo();
            empresa = new Empresa();
            //grupo = new Grupo();
            
            listEmpresa = new ArrayList<>();
            listEmpresa = empresaControle.findAll();
            listGrupos = new ArrayList<>();
            listGrupos = grupoControle.findAll();
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
            usuarioGrupo = new UsuarioGrupo();
            listGrupoUsuario = new ArrayList<>();
            empresa = new Empresa();
            grupo = new Grupo();
            Integer idGrupo = null;
            Integer idEmpresa = null;
            for (UsuarioGrupo aux1 : usuario.getUsuarioGrupoList()) {                
                idGrupo = aux1.getIdGrupo().getId();                
                listGrupos.add(grupoControle.pegarGrupoPeloId(idGrupo));
                //idEmpresa = aux1.getIdEmpresa().getId();
            }
            
            empresa = empresaControle.pegarEmpresaPeloId(idEmpresa);
            
            
            
            return redirect("/sistema/usuario/formUsuario.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            usuarioControle.salvar(usuario);
            usuarioGrupo = new UsuarioGrupo();
            
            usuarioGrupo.setIdEmpresa(empresa);
            usuarioGrupo.setIdGrupo(grupo);
            usuarioGrupo.setIdUsuario(usuario);
            usuarioGrupoControle.salvar(usuarioGrupo);
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
    //Grupo de Usuários
    public String abreGrupoForm(){
        try {
            grupo = new Grupo();
            listGrupos = new ArrayList<>();
            listGrupos = grupoControle.findAll();
            return redirect("/sistema/usuario/formGrupo.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaGrupoForm(Usuario aux){
        try {
            grupo = new Grupo();
            grupo = grupoControle.pegarGrupoPeloId(aux.getId());
            return redirect("/sistema/usuario/formGrupo.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaGrupoForm(){
        try {
            grupoControle.salvar(grupo);
            showFacesMessage("Grupo Salvo com Sucesso!!!", 2);
            listGrupos = new ArrayList<>();
            listGrupos = grupoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar usuário" + e.getMessage(), 4);
        }
    }
    
    public void removerGrupoForm(Grupo aux){
        try {            
            grupoControle.remover(aux);
            showFacesMessage("Grupo Deletado com Sucesso!!!", 2);
            listGrupos = new ArrayList<>();
            listGrupos = grupoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar grupo " + e.getMessage(), 4);
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Grupo> getListGrupos() {
        return listGrupos;
    }

    public void setListGrupos(List<Grupo> listGrupos) {
        this.listGrupos = listGrupos;
    }

    public List<Empresa> getListEmpresa() {
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public UsuarioGrupo getUsuarioGrupo() {
        return usuarioGrupo;
    }

    public void setUsuarioGrupo(UsuarioGrupo usuarioGrupo) {
        this.usuarioGrupo = usuarioGrupo;
    }

    public List<Grupo> getListGrupoUsuario() {
        return listGrupoUsuario;
    }

    public void setListGrupoUsuario(List<Grupo> listGrupoUsuario) {
        this.listGrupoUsuario = listGrupoUsuario;
    }
    
    
    
}
