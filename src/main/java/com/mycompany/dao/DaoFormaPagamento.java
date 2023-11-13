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
public class DaoFormaPagamento extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String descricao){
        try{
            sql = "INSERT INTO FPAGAMENTO (ID, DESCRICAO) VALUES (?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, descricao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, String descricao){
        try{
            sql = "UPDATE FPAGAMENTO SET DESCRICAO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(2, id);
            getStatement().setString(1, descricao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM FPAGAMENTO WHERE ID = ?";
            
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
                " SELECT                          "+
                "   ID AS ID,                     "+
                "   DESCRICAO AS DESCRICAO        "+
                " FROM                            "+
                "   FPAGAMENTO FPA                "+
                " ORDER BY 1                      ";
                            
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
                " SELECT                          "+
                "   ID AS ID,                     "+
                "   DESCRICAO AS DESCRICAO        "+
                " FROM                            "+
                "   FPAGAMENTO FPA                "+
                " WHERE FOR.ID = ?                "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public ResultSet listarPorDescricao(String pDescricao){
        try{
            sql = 
                " SELECT                          "+
                "   ID AS ID,                     "+
                "   DESCRICAO AS DESCRICAO        "+
                " FROM                            "+
                "   FPAGAMENTO FPA                "+
                " WHERE FOR.DESCRICAO LIKE ?      "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, pDescricao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM FPAGAMENTO";
            
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
