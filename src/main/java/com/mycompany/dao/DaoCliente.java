/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;
import javax.print.attribute.SetOfIntegerSyntax;

/**
 *
 * @author thagory.8187
 */
public class DaoCliente extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String empresa, String contato, String cnpj, String cidade, String endereco, String estado, String cep, String email, String celular, String telefone){
        try{
            sql = "INSERT INTO CLIENTE (ID, EMPRESA, CONTATO, CNPJ, CIDADE, ENDERECO, ESTADO, CEP, EMAIL, CELULAR, TELEFONE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, empresa);
            getStatement().setString(3, contato);
            getStatement().setString(4, cnpj);
            getStatement().setString(5, cidade);
            getStatement().setString(6, endereco);
            getStatement().setString(7, estado);
            getStatement().setString(8, cep);
            getStatement().setString(9, email);
            getStatement().setString(10, celular);
            getStatement().setString(11, telefone);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, String empresa, String contato, String cnpj, String cidade, String endereco, String estado, String cep, String email, String celular, String telefone){
        try{
            sql = "UPDATE CLIENTE SET EMPRESA = ?, CONTATO = ?, CNPJ = ?, CIDADE = ?, ENDERECO = ?, ESTADO = ?, CEP = ?, EMAIL = ?, CELULAR = ?, TELEFONE = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(11, id);
            getStatement().setString(1, empresa);
            getStatement().setString(2, contato);
            getStatement().setString(3, cnpj);
            getStatement().setString(4, cidade);
            getStatement().setString(5, endereco);
            getStatement().setString(6, estado);
            getStatement().setString(7, cep);
            getStatement().setString(8, email);
            getStatement().setString(9, celular);
            getStatement().setString(10, telefone);
            
            getStatement().executeQuery();
            
            return true;            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM CLIENTE WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try{
            sql = 
                " SELECT                               "+
                "    ID AS ID,                            "+
                "    EMPRESA AS EMPRESA,                  "+
                "    CONTATO AS CONTATO,                  "+
                "    CNPJ AS CNPJ,                        "+
                "    CIDADE AS CIDADE,                    "+
                "    ENDERECO AS ENDERECO,                "+
                "    ESTADO AS ESTADO,                    "+
                "    CEP AS CEP,                          "+
                "    EMAIL AS EMAIL,                      "+
                "    CELULAR AS CELULAR,                  "+
                "    TELEFONE AS TELEFONE                 "+
                " FROM                                    "+
                "    CLIENTE                              "+
                " WHERE ID = ?                            "+
                " ORDER BY 1                              ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = 
                " SELECT                               "+
                "    ID AS ID,                            "+
                "    EMPRESA AS EMPRESA,                  "+
                "    CONTATO AS CONTATO,                  "+
                "    CNPJ AS CNPJ,                        "+
                "    CIDADE AS CIDADE,                    "+
                "    ENDERECO AS ENDERECO,                "+
                "    ESTADO AS ESTADO,                    "+
                "    CEP AS CEP,                          "+
                "    EMAIL AS EMAIL,                      "+
                "    CELULAR AS CELULAR,                  "+
                "    TELEFONE AS TELEFONE                 "+
                " FROM                                    "+
                "    CLIENTE  CLI                         "+
                " WHERE CLI.ID = ?                        "+
                " ORDER BY 1                              ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public ResultSet listarPorEmpresa(String empresa){
        try{
            sql = 
                " SELECT                               "+
                "    ID AS ID,                            "+
                "    EMPRESA AS EMPRESA,                  "+
                "    CONTATO AS CONTATO,                  "+
                "    CNPJ AS CNPJ,                        "+
                "    CIDADE AS CIDADE,                    "+
                "    ENDERECO AS ENDERECO,                "+
                "    ESTADO AS ESTADO,                    "+
                "    CEP AS CEP,                          "+
                "    EMAIL AS EMAIL,                      "+
                "    CELULAR AS CELULAR,                  "+
                "    TELEFONE AS TELEFONE                 "+
                " FROM                                    "+
                "    CLIENTE  CLI                         "+
                " WHERE CLI.EMPRESA = ?                   "+
                " ORDER BY 1                              ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(2, empresa + "%");
            
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
     
    public ResultSet listarPorCnpj(String cnpj){
        try{
            sql = 
                " SELECT                               "+
                "    ID AS ID,                            "+
                "    EMPRESA AS EMPRESA,                  "+
                "    CONTATO AS CONTATO,                  "+
                "    CNPJ AS CNPJ,                        "+
                "    CIDADE AS CIDADE,                    "+
                "    ENDERECO AS ENDERECO,                "+
                "    ESTADO AS ESTADO,                    "+
                "    CEP AS CEP,                          "+
                "    EMAIL AS EMAIL,                      "+
                "    CELULAR AS CELULAR,                  "+
                "    TELEFONE AS TELEFONE                 "+
                " FROM                                    "+
                "    CLIENTE  CLI                         "+
                " WHERE CLI.CNPJ = ?                      "+
                " ORDER BY 1                              ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(4, cnpj + "%");
            
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCidade(String cidade){
        try{
            sql = 
                " SELECT                               "+
                "    ID AS ID,                            "+
                "    EMPRESA AS EMPRESA,                  "+
                "    CONTATO AS CONTATO,                  "+
                "    CNPJ AS CNPJ,                        "+
                "    CIDADE AS CIDADE,                    "+
                "    ENDERECO AS ENDERECO,                "+
                "    ESTADO AS ESTADO,                    "+
                "    CEP AS CEP,                          "+
                "    EMAIL AS EMAIL,                      "+
                "    CELULAR AS CELULAR,                  "+
                "    TELEFONE AS TELEFONE                 "+
                " FROM                                    "+
                "    CLIENTE  CLI                         "+
                " WHERE CLI.CIDADE = ?                    "+
                " ORDER BY 1                              ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(5, cidade + "%");
            
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CLIENTE";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
            
            id = getResultado().getInt(1);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return id;
    }
    
}
