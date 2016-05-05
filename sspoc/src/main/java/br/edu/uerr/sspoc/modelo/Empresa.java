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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findById", query = "SELECT e FROM Empresa e WHERE e.id = :id"),
    @NamedQuery(name = "Empresa.findByNome", query = "SELECT e FROM Empresa e WHERE e.nome = :nome"),
    @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj"),
    @NamedQuery(name = "Empresa.findBySigla", query = "SELECT e FROM Empresa e WHERE e.sigla = :sigla"),
    @NamedQuery(name = "Empresa.findByEndereco", query = "SELECT e FROM Empresa e WHERE e.endereco = :endereco"),
    @NamedQuery(name = "Empresa.findByTelefone", query = "SELECT e FROM Empresa e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "Empresa.findByResponsavel", query = "SELECT e FROM Empresa e WHERE e.responsavel = :responsavel"),
    @NamedQuery(name = "Empresa.findByEmial", query = "SELECT e FROM Empresa e WHERE e.emial = :emial")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 30)
    @Column(name = "sigla")
    private String sigla;
    @Size(max = 2147483647)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 30)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 2147483647)
    @Column(name = "responsavel")
    private String responsavel;
    @Size(max = 2147483647)
    @Column(name = "emial")
    private String emial;
    @OneToMany(mappedBy = "idEmpresa")
    private List<Custo> custoList;
    @OneToMany(mappedBy = "idEmpresa")
    private List<UsuarioGrupo> usuarioGrupoList;

    public Empresa() {
    }

    public Empresa(Integer id) {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    @XmlTransient
    public List<Custo> getCustoList() {
        return custoList;
    }

    public void setCustoList(List<Custo> custoList) {
        this.custoList = custoList;
    }

    @XmlTransient
    public List<UsuarioGrupo> getUsuarioGrupoList() {
        return usuarioGrupoList;
    }

    public void setUsuarioGrupoList(List<UsuarioGrupo> usuarioGrupoList) {
        this.usuarioGrupoList = usuarioGrupoList;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.sspoc.modelo.Empresa[ id=" + id + " ]";
    }
    
}
