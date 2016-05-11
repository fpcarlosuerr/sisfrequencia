/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.CustoControle;
import br.edu.uerr.sspoc.controle.EmpresaControle;
import br.edu.uerr.sspoc.controle.TipoCustoControle;
import br.edu.uerr.sspoc.modelo.Custo;
import br.edu.uerr.sspoc.modelo.Empresa;
import br.edu.uerr.sspoc.modelo.TipoCusto;
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
public class CustoBean extends AbstractBean implements Serializable{
    
    private Custo custo;
    
    @EJB
    private CustoControle custoControle;
    
    @EJB
    private TipoCustoControle tipoCustoControle;
    
    @EJB
    private EmpresaControle empresaControle;
    
    private List<Empresa> listEmpresa = new ArrayList<>();
    
    private List<Custo> listCusto = new ArrayList<>();
    
    private List<TipoCusto> listTipoCusto = new ArrayList<>();

    public CustoBean() {
    }
    
    
    public String abreForm(){
        try {
            custo = new Custo();
            listEmpresa = new ArrayList<>();
            listTipoCusto = new ArrayList<>();
            listCusto = new ArrayList<>();
            
            listEmpresa = empresaControle.findAll();
            listTipoCusto = tipoCustoControle.findAll(); 
            listCusto = custoControle.findAll();
            
            return redirect("/sistema/custo/formCusto.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaForm(Custo aux){
        try {
            custo = new Custo();
            custo = custoControle.pegarCustoPeloId(aux.getId());
            
            listEmpresa = new ArrayList<>();
            listTipoCusto = new ArrayList<>();
            
            listEmpresa = empresaControle.findAll();
            listTipoCusto = tipoCustoControle.findAll();   
            
            return redirect("/sistema/custo/formCusto.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            custoControle.salvar(custo);
            
            showFacesMessage("Custo Salvo com Sucesso!!!", 2);
           custo = new Custo();
            listEmpresa = new ArrayList<>();
            listTipoCusto = new ArrayList<>();
            listCusto = new ArrayList<>();
            
            listEmpresa = empresaControle.findAll();
            listTipoCusto = tipoCustoControle.findAll(); 
            listCusto = custoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar custo" + e.getMessage(), 4);
        }
    }
    
    public void removerForm(Custo aux){
        try {         
            custoControle.remover(aux);
            
            showFacesMessage("Custo Deletada com Sucesso!!!", 2);
            custo = new Custo();
            listEmpresa = new ArrayList<>();
            listTipoCusto = new ArrayList<>();
            
            listEmpresa = empresaControle.findAll();
            listTipoCusto = tipoCustoControle.findAll(); 
        } catch (Exception e) {
            showFacesMessage("Error ao deletar custo" + e.getMessage(), 4);
        }
    }
    
    
    
    

    public Custo getCusto() {
        return custo;
    }

    public void setCusto(Custo custo) {
        this.custo = custo;
    }

    public List<Empresa> getListEmpresa() {
        return listEmpresa;
    }

    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

    public List<Custo> getListCusto() {
        return listCusto;
    }

    public void setListCusto(List<Custo> listCusto) {
        this.listCusto = listCusto;
    }

    public List<TipoCusto> getListTipoCusto() {
        return listTipoCusto;
    }

    public void setListTipoCusto(List<TipoCusto> listTipoCusto) {
        this.listTipoCusto = listTipoCusto;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
