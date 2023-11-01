/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;

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
    
    
    public Boolean listarTodos(){
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
    
}
