/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author thagory.8187
 */
public class DaoVendedor extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String nome, String telefone, String email){
        try{
            sql = "INSERT INTO VENDEDOR(ID, NOME, TELEFONE, EMAIL) VALUES (?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, telefone);
            getStatement().setString(4, email);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean inserirConsultor(int id, int idPedido, String nomeConsultor, double valor){
        try{
            sql = "INSERT INTO CONSULTORESPEDIDO(ID, IDPEDIDO, NOME_CONSULTOR, VALOR) VALUES (?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPedido);
            getStatement().setString(3, nomeConsultor);
            getStatement().setDouble(4, valor);
                        
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public Boolean alterar(int id, String nome, String telefone, String email){
        try{
            sql = "UPDATE VENDEDOR SET NOME = ?, TELEFONE = ?, EMAIL = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(4, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, telefone);
            getStatement().setString(3, email);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM VENDEDOR WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public ResultSet listarTodos(){
        try{
            sql =
                "SELECT                       "+
                "   ID AS ID,                 "+
                "   NOME AS NOME,             "+
                "   TELEFONE AS TELEFONE,     "+
                "   EMAIL AS EMAIL            "+
                "FROM                         "+
                "   VENDEDOR VEN              "+
                "ORDER BY 1                   ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int pId){
        try{
            sql = 
                "SELECT                          "+
                "   ID AS ID,                    "+
                "   NOME AS NOME,                "+
                "   TELEFONE AS TELEFONE,        "+
                "   EMAIL AS EMAIL               "+
                "FROM                            "+
                "   VENDEDOR VEN                 "+
                "WHERE ID = ?                    "+
                "ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, pId);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarConsultoresPorIdPedido(int pIdPedido){
        try{
            sql = 
                "SELECT                          "+
                "   ID AS ID,                    "+
                "   IDPEDIDO AS ID_PEDIDO,       "+
                "   NOME_CONSULTOR AS NOME_CONSULTOR, "+
                "   VALOR AS VALOR               "+
                "FROM                            "+
                "   CONSULTORESPEDIDO            "+
                "WHERE IDPEDIDO = ?             "+
                "   ORDER BY 1                   ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, pIdPedido);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNome(String pNome){
        try{
            sql = 
                "SELECT                          "+
                "   ID AS ID,                    "+
                "   NOME AS NOME,                "+
                "   TELEFONE AS TELEFONE,        "+
                "   EMAIL AS EMAIL               "+
                "FROM                            "+
                "   VENDEDOR VEN                 "+
                "WHERE VEN.NOME LIKE ?           "+
                "ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, pNome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM VENDEDOR";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
            
            id = getResultado().getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public int buscarUltimoIdConsultor(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) FROM CONSULTORESPEDIDO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
            
            id = getResultado().getInt(1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return id;
    }
}
