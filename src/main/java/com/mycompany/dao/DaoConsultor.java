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
public class DaoConsultor extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String nome, String telefone, String email){
        try{
            sql = "INSERT INTO CONSULTOR(ID, NOME, TELEFONE, EMAIL) VALUES (?, ?, ?, ?)";
            
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
    
    public Boolean alterar(int id, String nome, String telefone, String email){
        try{
            sql = "UPDATE INTO CONSULTOR SET NOME = ?, TELEFONE = ?, EMAIL = ? WHERE ID = ?";
            
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
            sql = "DELETE FROM PESSOA WHERE ID = ?";
            
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
                "   EMAIL AS E-MAIL           "+
                "FROM                         "+
                "   CONSULTOR CON             "+
                "ORDER BY 1                   ";
            
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
                "SELECT                          "+
                "   ID AS ID,                    "+
                "   NOME AS NOME,                "+
                "   TELEFONE AS TELEFONE,        "+
                "   EMAIL AS EMAIL               "+
                "FROM                            "+
                "   CONSULTOR CON                "+
                "WHERE ID = ?                    "+
                "ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                "SELECT                          "+
                "   ID AS ID,                    "+
                "   NOME AS NOME,                "+
                "   TELEFONE AS TELEFONE,        "+
                "   EMAIL AS EMAIL               "+
                "FROM                            "+
                "   CONSULTOR CON                "+
                "WHERE CON.NOME LIKE ?               "+
                "ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CONSULTOR";
            
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
