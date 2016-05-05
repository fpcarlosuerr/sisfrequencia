/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Entity
@Table(name = "produto_historia_preco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoHistoriaPreco.findAll", query = "SELECT p FROM ProdutoHistoriaPreco p"),
    @NamedQuery(name = "ProdutoHistoriaPreco.findById", query = "SELECT p FROM ProdutoHistoriaPreco p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutoHistoriaPreco.findByValor", query = "SELECT p FROM ProdutoHistoriaPreco p WHERE p.valor = :valor"),
    @NamedQuery(name = "ProdutoHistoriaPreco.findByPorcentoRateio", query = "SELECT p FROM ProdutoHistoriaPreco p WHERE p.porcentoRateio = :porcentoRateio"),
    @NamedQuery(name = "ProdutoHistoriaPreco.findByDataInfo", query = "SELECT p FROM ProdutoHistoriaPreco p WHERE p.dataInfo = :dataInfo")})
public class ProdutoHistoriaPreco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "porcento_rateio")
    private BigDecimal porcentoRateio;
    @Column(name = "data_info")
    @Temporal(TemporalType.DATE)
    private Date dataInfo;
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @ManyToOne
    private Produto idProduto;

    public ProdutoHistoriaPreco() {
    }

    public ProdutoHistoriaPreco(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getPorcentoRateio() {
        return porcentoRateio;
    }

    public void setPorcentoRateio(BigDecimal porcentoRateio) {
        this.porcentoRateio = porcentoRateio;
    }

    public Date getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(Date dataInfo) {
        this.dataInfo = dataInfo;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
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
        if (!(object instanceof ProdutoHistoriaPreco)) {
            return false;
        }
        ProdutoHistoriaPreco other = (ProdutoHistoriaPreco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sspoc.modelo.ProdutoHistoriaPreco[ id=" + id + " ]";
    }
    
}
