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
    
    public Boolean inserir(int id, String cnpj, String empresa){
        try{
            sql = "INSERT INTO INSTITUTO (ID, CNPJ, EMPRESA) VALUES (?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, cnpj);
            getStatement().setString(3, empresa);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public Boolean alterar(int id, String cnpj, String empresa){
        try{
            sql = "UPDATE INSTITUTO SET CNPJ = ?, EMPRESA = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(3, id);
            getStatement().setString(1, cnpj);
            getStatement().setString(2, empresa);
            
            getStatement().executeUpdate();
            
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
                "   CNPJ AS CNPJ,                 "+
                "   EMPRESA AS EMPRESA            "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
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
                "   CNPJ AS CNPJ,                 "+
                "   EMPRESA AS EMPRESA            "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
                " WHERE INS.ID = ?                "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
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
                "   CNPJ AS CNPJ,                 "+
                "   EMPRESA AS EMPRESA            "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
                " WHERE INS.CNPJ LIKE ?           "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cnpj + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
     public ResultSet listarPorEmpresa(String empresa){
        try{
            sql = 
                " SELECT                          "+
                "   ID AS ID,                     "+
                "   CNPJ AS CNPJ,                 "+
                "   EMPRESA AS EMPRESA            "+
                " FROM                            "+
                "   INSTITUTO INS                 "+
                " WHERE INS.EMPRESA LIKE ?        "+
                " ORDER BY 1                      ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, empresa + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
      
    public int buscarProximoId(){
          int id = 0;
        
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
