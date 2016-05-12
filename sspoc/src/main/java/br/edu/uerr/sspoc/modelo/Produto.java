/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fpcarlos
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByQuantidadeEstoque", query = "SELECT p FROM Produto p WHERE p.quantidadeEstoque = :quantidadeEstoque"),
    @NamedQuery(name = "Produto.findByQuantidadeEstoqueMinimo", query = "SELECT p FROM Produto p WHERE p.quantidadeEstoqueMinimo = :quantidadeEstoqueMinimo"),
    @NamedQuery(name = "Produto.findByValorUnitario", query = "SELECT p FROM Produto p WHERE p.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Produto.findByValorCusto", query = "SELECT p FROM Produto p WHERE p.valorCusto = :valorCusto"),
    @NamedQuery(name = "Produto.findByValorVenda", query = "SELECT p FROM Produto p WHERE p.valorVenda = :valorVenda"),
    @NamedQuery(name = "Produto.findByPorcentoRateioCusto", query = "SELECT p FROM Produto p WHERE p.porcentoRateioCusto = :porcentoRateioCusto")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;
    @Column(name = "quantidade_estoque_minimo")
    private Integer quantidadeEstoqueMinimo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Column(name = "valor_custo")
    private BigDecimal valorCusto;
    @Column(name = "valor_venda")
    private BigDecimal valorVenda;
    @Column(name = "porcento_rateio_custo")
    private BigDecimal porcentoRateioCusto;
    @OneToMany(mappedBy = "idProduto")
    private List<Venda> vendaList;
    @JoinColumn(name = "id_subgrupo_produto", referencedColumnName = "id")
    @ManyToOne
    private SubgrupoProduto idSubgrupoProduto;
    @OneToMany(mappedBy = "idProduto")
    private List<ProdutoHistoriaPreco> produtoHistoriaPrecoList;

    public Produto() {
    }
    
    
    
    

    public Produto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Integer getQuantidadeEstoqueMinimo() {
        return quantidadeEstoqueMinimo;
    }

    public void setQuantidadeEstoqueMinimo(Integer quantidadeEstoqueMinimo) {
        this.quantidadeEstoqueMinimo = quantidadeEstoqueMinimo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getPorcentoRateioCusto() {
        return porcentoRateioCusto;
    }

    public void setPorcentoRateioCusto(BigDecimal porcentoRateioCusto) {
        this.porcentoRateioCusto = porcentoRateioCusto;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    public SubgrupoProduto getIdSubgrupoProduto() {
        return idSubgrupoProduto;
    }

    public void setIdSubgrupoProduto(SubgrupoProduto idSubgrupoProduto) {
        this.idSubgrupoProduto = idSubgrupoProduto;
    }

    @XmlTransient
    public List<ProdutoHistoriaPreco> getProdutoHistoriaPrecoList() {
        return produtoHistoriaPrecoList;
    }

    public void setProdutoHistoriaPrecoList(List<ProdutoHistoriaPreco> produtoHistoriaPrecoList) {
        this.produtoHistoriaPrecoList = produtoHistoriaPrecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sspoc.modelo.Produto[ id=" + id + " ]";
    }
    
}
