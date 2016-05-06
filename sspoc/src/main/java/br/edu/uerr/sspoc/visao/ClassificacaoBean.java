/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.GrupoProdutoControle;
import br.edu.uerr.sspoc.controle.SubgrupoProdutoControle;
import br.edu.uerr.sspoc.modelo.Cliente;
import br.edu.uerr.sspoc.modelo.GrupoProduto;
import br.edu.uerr.sspoc.modelo.SubgrupoProduto;
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
public class ClassificacaoBean extends AbstractBean implements Serializable{
    
    private GrupoProduto grupoProduto;
    
    private SubgrupoProduto subgrupoProduto;
    
    @EJB
    private GrupoProdutoControle grupoProdutoControle;
    
    @EJB
    private SubgrupoProdutoControle subgrupoProdutoControle;
    
    private List<GrupoProduto> listGrupoProduto = new ArrayList<>();
    
    private List<SubgrupoProduto> listSubgrupoProduto = new ArrayList<>();
    
    
    public ClassificacaoBean(){
        
    }
    
    public String abreForm(){
        try {
            grupoProduto = new GrupoProduto();
            listGrupoProduto = new ArrayList<>();
            listGrupoProduto = grupoProdutoControle.findAll();
            return redirect("/sistema/produto/formClassificacao.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaForm(GrupoProduto aux){
        try {
            grupoProduto = new GrupoProduto();
            grupoProduto = grupoProdutoControle.pegarGrupoProdutoPeloId(aux.getId());
            return redirect("/sistema/produto/formClassificacao.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            grupoProdutoControle.salvar(grupoProduto);
            
            showFacesMessage("Classificação Salvo com Sucesso!!!", 2);
            grupoProduto = new GrupoProduto();
            listGrupoProduto = new ArrayList<>();
            listGrupoProduto = grupoProdutoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar Classificação" + e.getMessage(), 4);
        }
    }
    
    public void removerForm(GrupoProduto aux){
        try {            
            grupoProdutoControle.remover(aux);
            
            showFacesMessage("Classificação Deletada com Sucesso!!!", 2);
            listGrupoProduto = new ArrayList<>();
            listGrupoProduto = grupoProdutoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar Classificação " + e.getMessage(), 4);
        }
    }
    
    
    //SubClassificação
    public String abreSubForm(){
        try {
            subgrupoProduto = new SubgrupoProduto();
            subgrupoProduto.setIdGrupoProduto(new GrupoProduto());
            listGrupoProduto = new ArrayList<>();
            listGrupoProduto = grupoProdutoControle.findAll();
            listSubgrupoProduto = new ArrayList<>();
            listSubgrupoProduto = subgrupoProdutoControle.findAll();
            
            return redirect("/sistema/produto/formSubClassificacao.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaSubForm(SubgrupoProduto aux){
        try {
            grupoProduto = new GrupoProduto();
            subgrupoProduto = new SubgrupoProduto();
            subgrupoProduto = subgrupoProdutoControle.pegarSubgrupoProdutoPeloId(aux.getId());
            grupoProduto = grupoProdutoControle.pegarGrupoProdutoPeloId(aux.getIdGrupoProduto().getId());
            return redirect("/sistema/produto/formSubClassificacao.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaSubForm(){
        try {
            subgrupoProdutoControle.salvar(subgrupoProduto);
            
            
            showFacesMessage("Classificação Salvo com Sucesso!!!", 2);
             subgrupoProduto = new SubgrupoProduto();
             listSubgrupoProduto = new ArrayList<>();
            listSubgrupoProduto = subgrupoProdutoControle.findAll();
             
            
        } catch (Exception e) {
            showFacesMessage("Error ao salvar Classificação" + e.getMessage(), 4);
        }
    }
    
    public void removerSubForm(SubgrupoProduto aux){
        try {            
            subgrupoProdutoControle.remover(aux);
            
            
            showFacesMessage("Classificação Deletada com Sucesso!!!", 2);
            listSubgrupoProduto = new ArrayList<>();
            listSubgrupoProduto = subgrupoProdutoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar Classificação " + e.getMessage(), 4);
        }
    }
    
    
    
    
    //Gets e Set

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public SubgrupoProduto getSubgrupoProduto() {
        return subgrupoProduto;
    }

    public void setSubgrupoProduto(SubgrupoProduto subgrupoProduto) {
        this.subgrupoProduto = subgrupoProduto;
    }

    public List<GrupoProduto> getListGrupoProduto() {
        return listGrupoProduto;
    }

    public void setListGrupoProduto(List<GrupoProduto> listGrupoProduto) {
        this.listGrupoProduto = listGrupoProduto;
    }

    public List<SubgrupoProduto> getListSubgrupoProduto() {
        return listSubgrupoProduto;
    }

    public void setListSubgrupoProduto(List<SubgrupoProduto> listSubgrupoProduto) {
        this.listSubgrupoProduto = listSubgrupoProduto;
    }

    
    
}
