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
@Table(name = "grupo_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoProduto.findAll", query = "SELECT g FROM GrupoProduto g"),
    @NamedQuery(name = "GrupoProduto.findById", query = "SELECT g FROM GrupoProduto g WHERE g.id = :id"),
    @NamedQuery(name = "GrupoProduto.findByNome", query = "SELECT g FROM GrupoProduto g WHERE g.nome = :nome")})
public class GrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "idGrupoProduto")
    private List<SubgrupoProduto> subgrupoProdutoList;

    public GrupoProduto() {
    }

    public GrupoProduto(Integer id) {
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
    public List<SubgrupoProduto> getSubgrupoProdutoList() {
        return subgrupoProdutoList;
    }

    public void setSubgrupoProdutoList(List<SubgrupoProduto> subgrupoProdutoList) {
        this.subgrupoProdutoList = subgrupoProdutoList;
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
        if (!(object instanceof GrupoProduto)) {
            return false;
        }
        GrupoProduto other = (GrupoProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sspoc.modelo.GrupoProduto[ id=" + id + " ]";
    }
    
}
