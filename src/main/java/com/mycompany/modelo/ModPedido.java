/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author thagory.8187
 */
public class ModPedido {
    private int id;
    private String data;
    private String vendedor;
    private int idInstituto;
    private int idCliente;
    private int numeroProjeto;
    private String escopoProjeto;
    private String prazo;
    private String formaPagamento;
    private Double valorProjeto;
    private Double custoFixo;
    private Double custoAdverso;
    private int idConsultor;
    private Double total;
    private Double subTotalDespesas;
    private Double subTotalLiquido;

    public ModPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getIdInstituto() {
        return idInstituto;
    }

    public void setIdInstituto(int idInstituto) {
        this.idInstituto = idInstituto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumeroProjeto() {
        return numeroProjeto;
    }

    public void setNumeroProjeto(int numeroProjeto) {
        this.numeroProjeto = numeroProjeto;
    }

    public String getEscopoProjeto() {
        return escopoProjeto;
    }

    public void setEscopoProjeto(String escopoProjeto) {
        this.escopoProjeto = escopoProjeto;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorProjeto() {
        return valorProjeto;
    }

    public void setValorProjeto(Double valorProjeto) {
        this.valorProjeto = valorProjeto;
    }

    public Double getCustoFixo() {
        return custoFixo;
    }

    public void setCustoFixo(Double custoFixo) {
        this.custoFixo = custoFixo;
    }

    public Double getCustoAdverso() {
        return custoAdverso;
    }

    public void setCustoAdverso(Double custoAdverso) {
        this.custoAdverso = custoAdverso;
    }

    public int getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(int idConsultor) {
        this.idConsultor = idConsultor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubTotalDespesas() {
        return subTotalDespesas;
    }

    public void setSubTotalDespesas(Double subTotalDespesas) {
        this.subTotalDespesas = subTotalDespesas;
    }

    public Double getSubTotalLiquido() {
        return subTotalLiquido;
    }

    public void setSubTotalLiquido(Double subTotalLiquido) {
        this.subTotalLiquido = subTotalLiquido;
    }

    @Override
    public String toString() {
        return "ModPedido{" + "id=" + id + ", data=" + data + ", vendedor=" + vendedor + ", idInstituto=" + idInstituto + ", idCliente=" + idCliente + ", numeroProjeto=" + numeroProjeto + ", escopoProjeto=" + escopoProjeto + ", prazo=" + prazo + ", formaPagamento=" + formaPagamento + ", valorProjeto=" + valorProjeto + ", custoFixo=" + custoFixo + ", custoAdverso=" + custoAdverso + ", idConsultor=" + idConsultor + ", total=" + total + ", subTotalDespesas=" + subTotalDespesas + ", subTotalLiquido=" + subTotalLiquido + '}';
    }
    
    
    
}
