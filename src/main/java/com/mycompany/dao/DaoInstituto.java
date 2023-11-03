/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;
import java.time.Clock;

/**
 *
 * @author thagory.8187
 */
public class DaoInstituto extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, String nome, String cnpj){
        try{
            sql = "INSERT INTO INSTITUTO (ID, NOME, CNPJ) VALUES (?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, cnpj);
            
            getStatement().executeQuery();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public Boolean alterar(int id, String nome, String cnpj){
        try{
            sql = "UPDATE INSTITUTO SET NOME = ?, CNPJ = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(3, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, cnpj);
            
            getStatement().executeQuery();
            
            return true;
        }catch(Exception e ){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir (int id){
        try{
            sql = "DELETE FROM INSTITUTO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeQuery();
            
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
                "   ID AD ID,                     "+
                "   NOME AS NOME,                 "+
                "   CNPJ AS CNPJ                  "+
                "FROM                             "+
                "   INSTITUTO INS                 "+
                "ORDER BY 1                       ";
            
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
                "   NOME AS NOME,                 "+    
                "   CNPJ AS CNPJ                  "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
                " WHERE ID = ?                    "+
                " ORDER BY 1                      ";
            
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
                " SELECT                          "+
                "   ID AS ID,                     "+
                "   NOME AS NOME,                 "+    
                "   CNPJ AS CNPJ                  "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
                " WHERE nome like ?               "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
     
      public ResultSet listarPorCnpj(String cnpj){
        try{
            sql = 
                " SELECT                          "+
                "   ID AS ID,                     "+
                "   NOME AS NOME,                 "+    
                "   CNPJ AS CNPJ                  "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
                " WHERE nome like ?               "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cnpj + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
      
      public int buscarProximoId(){
          int id = -1;
          try{
              sql = "SELECT IF NULL(MAX(ID), 0) + I FROM INSTITUTO";
              
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
