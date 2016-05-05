/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Entity
@Table(name = "custo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Custo.findAll", query = "SELECT c FROM Custo c"),
    @NamedQuery(name = "Custo.findById", query = "SELECT c FROM Custo c WHERE c.id = :id"),
    @NamedQuery(name = "Custo.findByNome", query = "SELECT c FROM Custo c WHERE c.nome = :nome"),
    @NamedQuery(name = "Custo.findByValor", query = "SELECT c FROM Custo c WHERE c.valor = :valor")})
public class Custo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne
    private Empresa idEmpresa;
    @JoinColumn(name = "id_tipo_custo", referencedColumnName = "id")
    @ManyToOne
    private TipoCusto idTipoCusto;

    public Custo() {
    }

    public Custo(Integer id) {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public TipoCusto getIdTipoCusto() {
        return idTipoCusto;
    }

    public void setIdTipoCusto(TipoCusto idTipoCusto) {
        this.idTipoCusto = idTipoCusto;
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
        if (!(object instanceof Custo)) {
            return false;
        }
        Custo other = (Custo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sspoc.modelo.Custo[ id=" + id + " ]";
    }
    
}
