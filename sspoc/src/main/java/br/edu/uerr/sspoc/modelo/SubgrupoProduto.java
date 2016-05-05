/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.modelo;

import java.io.Serializable;
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
@Table(name = "subgrupo_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubgrupoProduto.findAll", query = "SELECT s FROM SubgrupoProduto s"),
    @NamedQuery(name = "SubgrupoProduto.findById", query = "SELECT s FROM SubgrupoProduto s WHERE s.id = :id"),
    @NamedQuery(name = "SubgrupoProduto.findByNome", query = "SELECT s FROM SubgrupoProduto s WHERE s.nome = :nome")})
public class SubgrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idSubgrupoProduto")
    private List<Produto> produtoList;
    @JoinColumn(name = "id_grupo_produto", referencedColumnName = "id")
    @ManyToOne
    private GrupoProduto idGrupoProduto;

    public SubgrupoProduto() {
    }

    public SubgrupoProduto(Integer id) {
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

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public GrupoProduto getIdGrupoProduto() {
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(GrupoProduto idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
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
        if (!(object instanceof SubgrupoProduto)) {
            return false;
        }
        SubgrupoProduto other = (SubgrupoProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sspoc.modelo.SubgrupoProduto[ id=" + id + " ]";
    }
    
}
