/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.evento.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fpcarlos
 */
@Embeddable
public class ServidorPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pessoa")
    private int idPessoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_departamento")
    private int idDepartamento;

    public ServidorPK() {
    }

    public ServidorPK(int idPessoa, int idDepartamento) {
        this.idPessoa = idPessoa;
        this.idDepartamento = idDepartamento;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPessoa;
        hash += (int) idDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServidorPK)) {
            return false;
        }
        ServidorPK other = (ServidorPK) object;
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uerr.evento.modelo.ServidorPK[ idPessoa=" + idPessoa + ", idDepartamento=" + idDepartamento + " ]";
    }
    
}
