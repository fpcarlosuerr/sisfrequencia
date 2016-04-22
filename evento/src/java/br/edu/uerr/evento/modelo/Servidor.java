/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fpcarlos
 */
@Entity
@Table(name = "servidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servidor.findAll", query = "SELECT s FROM Servidor s"),
    @NamedQuery(name = "Servidor.findByIdPessoa", query = "SELECT s FROM Servidor s WHERE s.servidorPK.idPessoa = :idPessoa"),
    @NamedQuery(name = "Servidor.findByIdDepartamento", query = "SELECT s FROM Servidor s WHERE s.servidorPK.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "Servidor.findByMatricula", query = "SELECT s FROM Servidor s WHERE s.matricula = :matricula"),
    @NamedQuery(name = "Servidor.findByDataEntrada", query = "SELECT s FROM Servidor s WHERE s.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Servidor.findByDataSaida", query = "SELECT s FROM Servidor s WHERE s.dataSaida = :dataSaida"),
    @NamedQuery(name = "Servidor.findByAtivado", query = "SELECT s FROM Servidor s WHERE s.ativado = :ativado")})
public class Servidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServidorPK servidorPK;
    @Size(max = 2147483647)
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "ativado")
    private Boolean ativado;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    @ManyToOne
    private Cargo idCargo;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @JoinColumn(name = "id_situacao_servidor", referencedColumnName = "id")
    @ManyToOne
    private SituacaoServidor idSituacaoServidor;

    public Servidor() {
    }

    public Servidor(ServidorPK servidorPK) {
        this.servidorPK = servidorPK;
    }

    public Servidor(int idPessoa, int idDepartamento) {
        this.servidorPK = new ServidorPK(idPessoa, idDepartamento);
    }

    public ServidorPK getServidorPK() {
        return servidorPK;
    }

    public void setServidorPK(ServidorPK servidorPK) {
        this.servidorPK = servidorPK;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Boolean getAtivado() {
        return ativado;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public SituacaoServidor getIdSituacaoServidor() {
        return idSituacaoServidor;
    }

    public void setIdSituacaoServidor(SituacaoServidor idSituacaoServidor) {
        this.idSituacaoServidor = idSituacaoServidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servidorPK != null ? servidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servidor)) {
            return false;
        }
        Servidor other = (Servidor) object;
        if ((this.servidorPK == null && other.servidorPK != null) || (this.servidorPK != null && !this.servidorPK.equals(other.servidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.evento.modelo.Servidor[ servidorPK=" + servidorPK + " ]";
    }
    
}
