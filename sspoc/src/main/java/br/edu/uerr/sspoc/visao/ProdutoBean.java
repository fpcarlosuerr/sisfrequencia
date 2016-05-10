/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.ProdutoControle;
import br.edu.uerr.sspoc.controle.SubgrupoProdutoControle;
import br.edu.uerr.sspoc.modelo.Produto;
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
public class ProdutoBean extends AbstractBean implements Serializable{
    
    private Produto produto;
    
    @EJB
    private ProdutoControle produtoControle;
    
    @EJB
    private SubgrupoProdutoControle subgrupoProdutoControle;

    
    private List<Produto> listProduto = new ArrayList<>();
    
    private List<SubgrupoProduto> listSubgrupoProduto = new ArrayList<>();
    
    
    
    
    
    
    public ProdutoBean() {
    }
    
    public String abreForm(){
        try {
           produto = new Produto();
           listProduto = new ArrayList<>();
           listProduto = produtoControle.findAll();
           listSubgrupoProduto = new ArrayList<>();
           listSubgrupoProduto = subgrupoProdutoControle.findAll();
            return redirect("/sistema/produto/formProduto.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public String editaForm(Produto aux){
        try {
            produto = new Produto();
            produto = produtoControle.pegarProdutoPeloId(aux.getId());
            listSubgrupoProduto = new ArrayList<>();
           listSubgrupoProduto = subgrupoProdutoControle.findAll();
            return redirect("/sistema/produto/formProduto.xhtml");
        } catch (Exception e) {
            return null;
        }
    }
    
    public void salvaForm(){
        try {
            //produto.setIdSubgrupoProduto(subgrupoProdutoControle.pegarSubgrupoProdutoPeloId(1));
            produtoControle.salvar(produto);
            
            showFacesMessage("Produto Salvo com Sucesso!!!", 2);
           produto = new Produto();
           listProduto = new ArrayList<>();
           listProduto = produtoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao salvar empresa" + e.getMessage(), 4);
        }
    }
    
    public void removerForm(Produto aux){
        try {            
            produtoControle.remover(aux);
            
            showFacesMessage("Produto Deletada com Sucesso!!!", 2);
            listProduto = new ArrayList<>();
           listProduto = produtoControle.findAll();
        } catch (Exception e) {
            showFacesMessage("Error ao deletar empresa" + e.getMessage(), 4);
        }
    }
    
    
    
    //Gets e Sets

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListProduto() {
        return listProduto;
    }

    public void setListProduto(List<Produto> listProduto) {
        this.listProduto = listProduto;
    }

    public List<SubgrupoProduto> getListSubgrupoProduto() {
        return listSubgrupoProduto;
    }

    public void setListSubgrupoProduto(List<SubgrupoProduto> listSubgrupoProduto) {
        this.listSubgrupoProduto = listSubgrupoProduto;
    }
    
    
    
}
