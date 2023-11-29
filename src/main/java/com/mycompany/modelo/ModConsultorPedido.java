/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author thagory.8187
 */
public class ModConsultorPedido {
    private int id;
    private int idPedido;
    private String nomeConsultor;
    private double valor;

    public ModConsultorPedido(int id, int idPedido, String nomeConsultor, double valor) {
        this.id = id;
        this.idPedido = idPedido;
        this.nomeConsultor = nomeConsultor;
        this.valor = valor;
    }

    public ModConsultorPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeConsultor() {
        return nomeConsultor;
    }

    public void setNomeConsultor(String nomeConsultor) {
        this.nomeConsultor = nomeConsultor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ModConsultorPedido{" + "id=" + id + ", idPedido=" + idPedido + ", nomeConsultor=" + nomeConsultor + ", valor=" + valor + '}';
    }
}
