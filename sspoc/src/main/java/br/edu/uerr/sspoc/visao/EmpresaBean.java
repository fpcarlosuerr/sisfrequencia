/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.EmpresaControle;
import br.edu.uerr.sspoc.modelo.Empresa;
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
public class EmpresaBean extends AbstractBean implements Serializable{
    
    private Empresa empresa;
    
    @EJB
    private EmpresaControle empresaControle;
    
    private List<Empresa> listEmpresa = new ArrayList<>();
    
    public EmpresaBean(){
        
    }
    
    public String abreForm(){
        try {
            empresa = new Empresa();
            listEmpresa = new ArrayList<>();
            listEmpresa = empresaControle.findAll();
            return redirect("/sistema/empresa/formEmpresa.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaForm(Empresa aux){
        try {
            empresa = new Empresa();
            empresa = empresaControle.pegarEmpresaPeloId(aux.getId());
            return redirect("/sistema/empresa/formEmpresa.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            empresaControle.salvar(empresa);
            showFacesMessage("Empresa Salvo com Sucesso!!!", 2);
            empresa = new Empresa();
            listEmpresa = new ArrayList<>();
            listEmpresa = empresaControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar empresa" + e.getMessage(), 4);
        }
    }
    
    public void removerForm(Empresa aux){
        try {            
            empresaControle.remover(aux);
            showFacesMessage("Empresa Deletada com Sucesso!!!", 2);
            listEmpresa = new ArrayList<>();
            listEmpresa = empresaControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar empresa" + e.getMessage(), 4);
        }
    }
    
    
    //Gets e Set

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListEmpresa() {
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }
    
    
    
}
