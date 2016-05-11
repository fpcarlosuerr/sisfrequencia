/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.sspoc.modelo;

import javax.persistence.Transient;

/**
 *
 * @author fpcarlos
 */
public class IndiceMarkup {
    
    @Transient
    private double precoVenda;
    @Transient
    private double custoIndiretoFabricacao;
    @Transient
    private double icmsSobreVendas;
    @Transient
    private double pisCofins;
    @Transient
    private double despesasComerciaisFixas;
    @Transient
    private double despesasAdministrativas;
    @Transient
    private double despesasFinanceiras;
    @Transient
    private double custoOportunidade;
    @Transient
    private double margemLucroDesejada;
    @Transient
    private double markupDivisor;

    public IndiceMarkup() {
    }

    public void calculaMarkupDivisor() {
        markupDivisor = precoVenda - (custoIndiretoFabricacao + icmsSobreVendas + pisCofins + despesasAdministrativas + despesasComerciaisFixas + despesasFinanceiras + custoOportunidade + margemLucroDesejada);
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    
    public double getCustoIndiretoFabricacao() {
        return custoIndiretoFabricacao;
    }

    public void setCustoIndiretoFabricacao(double custoIndiretoFabricaccao) {
        this.custoIndiretoFabricacao = custoIndiretoFabricacao;
    }

    public double getIcmsSobreVendas() {
        return icmsSobreVendas;
    }

    public void setIcmsSobreVendas(double icmsSobreVendas) {
        this.icmsSobreVendas = icmsSobreVendas;
    }

    public double getPisCofins() {
        return pisCofins;
    }

    public void setPisCofins(double pisCofins) {
        this.pisCofins = pisCofins;
    }

    public double getDespesasComerciaisFixas() {
        return despesasComerciaisFixas;
    }

    public void setDespesasComerciaisFixas(double despesasComerciaisFixas) {
        this.despesasComerciaisFixas = despesasComerciaisFixas;
    }

    public double getDespesasAdministrativas() {
        return despesasAdministrativas;
    }

    public void setDespesasAdministrativas(double despesasAdministrativas) {
        this.despesasAdministrativas = despesasAdministrativas;
    }

    public double getDespesasFinanceiras() {
        return despesasFinanceiras;
    }

    public void setDespesasFinanceiras(double despesasFinanceiras) {
        this.despesasFinanceiras = despesasFinanceiras;
    }

    public double getCustoOportunidade() {
        return custoOportunidade;
    }

    public void setCustoOportunidade(double custoOportunidade) {
        this.custoOportunidade = custoOportunidade;
    }

    public double getMargemLucroDesejada() {
        return margemLucroDesejada;
    }

    public void setMargemLucroDesejada(double margemLucroDesejada) {
        this.margemLucroDesejada = margemLucroDesejada;
    }

    public double getMarkupDivisor() {
        return markupDivisor;
    }

    public void setMarkupDivisor(double markupDivisor) {
        this.markupDivisor = markupDivisor;
    }

}
