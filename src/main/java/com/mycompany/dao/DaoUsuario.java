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
public class DaoUsuario extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String nome, String senha){
        try{
            sql = "INSERT INTO USUARIO (ID,NOME SENHA) VALUES (?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, senha);
            
            getStatement().executeQuery();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, String nome, String senha){
        try{
            sql = "UPDATE USUARIO SET NOME = ?, SENHA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(3, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, senha);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterarSenha(int id, String novaSenha){
        try{
            sql = "UPDATE USUARIO SET SENHA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(2, id);
            getStatement().setString(1, novaSenha);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM USUARIO WHERE ID = ?";
            
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
                    " SELECT                              "+
                    "   USU.ID AS ID,                     "+
                    "   USU.NOME AS NOME,                 "+
                    "   USU.SENHA AS SENHA                "+
                    " FROM                                "+
                    "   USUARIO USU                       ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = 
                    " SELECT                              "+
                    "   USU.ID AS ID,                     "+
                    "   USU.NOME AS NOME,                 "+
                    "   USU.SENHA AS SENHA                "+
                    " FROM                                "+
                    "   USUARIO USU                       "+
                    "WHERE USU.ID - ?                     ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                    " SELECT                              "+
                    "   USU.ID AS ID,                     "+
                    "   USU.NOME AS NOME,                 "+
                    "   USU.SENHA AS SENHA                "+
                    " FROM                                "+
                    "   USUARIO USU                       "+
                    "WHERE USU.NOME LIKE ?                ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet recuperaSenha (String nome){
        try{
            sql = 
                    " SELECT                              "+
                    "   USU.ID AS ID,                     "+
                    "   USU.SENHA AS SENHA                "+
                    " FROM                                "+
                    "   USUARIO USU                       "+
                    "WHERE USU.NOME LIKE ?                ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return getResultado();
    }
    
     public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PESSOA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
    
}
