/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.visao;

import br.edu.uerr.sspoc.controle.ProdutoControle;
import br.edu.uerr.sspoc.modelo.IndiceMarkup;
import br.edu.uerr.sspoc.modelo.Produto;
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
public class PainelABean extends AbstractBean implements Serializable {

    private IndiceMarkup indiceMarkup;

    private Produto produto;

    private List<Produto> listProduto = new ArrayList<>();

    @EJB
    private ProdutoControle produtoControle;

    private double novoPrecoVenda;

    private double novoPrecoVenda2;

    public PainelABean() {
    }

    public String abreForm() {
        try {
            indiceMarkup = new IndiceMarkup();
            listProduto = new ArrayList<>();
            listProduto = produtoControle.findAll();

            return redirect("/sistema/markup/formPainel1.xhtml");
        } catch (Exception e) {
            return null;
        }
    }

    public void calculaIndice() {

        indiceMarkup.calculaMarkupDivisor();
        System.out.println(indiceMarkup.getMarkupDivisor());
    }

    public void pegarProduto() {
        double valorMKD = indiceMarkup.getMarkupDivisor();
        double valorMKM = indiceMarkup.getMarkupMultiplicador();

        novoPrecoVenda = produto.getValorUnitario().doubleValue() / valorMKD;
        novoPrecoVenda2 = produto.getValorUnitario().doubleValue() * valorMKM;
        System.out.println(produto.getNome());
    }

    public double getPegarValorTotalEstoque() {
        try {
            double somaValor=0;
            for (Produto aux : produtoControle.findAll()) {
                somaValor+=(aux.getQuantidadeEstoque() * aux.getValorUnitario().doubleValue());
            }
            return somaValor;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int getPegarQtdTotalEstoque() {
        try {
            int somaQtd=0;
            for (Produto aux : produtoControle.findAll()) {
                somaQtd+=(aux.getQuantidadeEstoque() );
            }
            return somaQtd;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public double getPegaPercentagemProtudo(){
        double aux = produto.getQuantidadeEstoque() / this.getPegarQtdTotalEstoque();
        return aux;
    }

    public IndiceMarkup getIndiceMarkup() {
        return indiceMarkup;
    }

    public void setIndiceMarkup(IndiceMarkup indiceMarkup) {
        this.indiceMarkup = indiceMarkup;
    }

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

    public double getNovoPrecoVenda() {
        return novoPrecoVenda;
    }

    public void setNovoPrecoVenda(double novoPrecoVenda) {
        this.novoPrecoVenda = novoPrecoVenda;
    }

    public double getNovoPrecoVenda2() {
        return novoPrecoVenda2;
    }

    public void setNovoPrecoVenda2(double novoPrecoVenda2) {
        this.novoPrecoVenda2 = novoPrecoVenda2;
    }

}
