/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author 10156
 */
public class ModCliente {
    private int id;
    private String empresa;
    private String contato;
    private String cnpj;
    private String cidade;
    private String endereco;
    private String estado;
    private String cep;
    private String email;
    private String celular;
    private String telefone;

    @Override
    public String toString() {
        return "ModCliente{" + "id=" + id + ", empresa=" + empresa + ", contato=" + contato + ", cnpj=" + cnpj + ", cidade=" + cidade + ", endereco=" + endereco + ", estado=" + estado + ", cep=" + cep + ", email=" + email + ", celular=" + celular + ", telefone=" + telefone + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ModCliente(int id, String empresa, String contato, String cnpj, String cidade, String endereco, String estado, String cep, String email, String celular, String telefone) {
        this.id = id;
        this.empresa = empresa;
        this.contato = contato;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.endereco = endereco;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
    }

}
