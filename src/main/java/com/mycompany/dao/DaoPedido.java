/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author thagory.8187
 */
public class DaoPedido extends BancoDeDadosMySql{
    private String sql;
    
    public Boolean inserir(int id, String data, String vendedor, int idInstituto, int idCliente, int numeroProjeto, String escopoProjeto, String prazo, String formaPagamento, double valorProjeto, double custoFixo, double custoAdverso, int idConsultor, double total, double subTotalDespesas, double subTotalLiquido){
        try{
            sql = "INSERT INTO PEDIDO (ID, DATA, VENDEDOR, IDINSTITUTO, IDCLIENTE, NUMEROPROJETO, ESCOPOPROJETO, PRAZO, FORMAPAGAMENTO, VALORPROJETO, CUSTOFIXO, CUSTOADVERSO, IDCONSULTOR, TOTAL, SUBTOTALDESPESAS, SUBTOTALLIQUIDO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, data);
            getStatement().setString(3, vendedor);
            getStatement().setInt(4, idInstituto);
            getStatement().setInt(5, idCliente);
            getStatement().setInt(6, numeroProjeto);
            getStatement().setString(7, escopoProjeto);
            getStatement().setString(8, prazo);
            getStatement().setString(9, formaPagamento);
            getStatement().setDouble(10, valorProjeto);
            getStatement().setDouble(11, custoFixo);
            getStatement().setDouble(12, custoAdverso);
            getStatement().setInt(13, idConsultor);
            getStatement().setDouble(14, total);
            getStatement().setDouble(15, subTotalDespesas);
            getStatement().setDouble(16, subTotalLiquido);
            
            getStatement().executeUpdate();
            
            return true;            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
      public Boolean alterar(int id, String data, String vendedor, int idInstituto, int idCliente, int numeroProjeto, String escopoProjeto, String prazo, String formaPagamento, double valorProjeto, double custoFixo, double custoAdverso, int idConsultor, double total, double subTotalDespesas, double subTotalLiquido){
        try{
            sql = "UPDATE PEDIDO SET DATA = ?, VENDEDOR = ?, IDINSTITUTO = ?, IDCLIENTE = ?, NUMEROPROJETO = ?, ESCOPOPROJETO = ?, PRAZO = ?, FORMAPAGAMENTO = ?, VALORPROJETO = ?, CUSTOFIXO = ?, CUSTOADVERSO = ?, IDCONSULTOR = ?, TOTAL = ?, SUBTOTALDESPESAS = ?, SUBTOTALLIQUIDO  = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(16, id);
            getStatement().setString(1, data);
            getStatement().setString(2, vendedor);
            getStatement().setInt(3, idInstituto);
            getStatement().setInt(4, idCliente);
            getStatement().setInt(5, numeroProjeto);
            getStatement().setString(6, escopoProjeto);
            getStatement().setString(7, prazo);
            getStatement().setString(8, formaPagamento);
            getStatement().setDouble(9, valorProjeto);
            getStatement().setDouble(10, custoFixo);
            getStatement().setDouble(11, custoAdverso);
            getStatement().setInt(12, idConsultor);
            getStatement().setDouble(13, total);
            getStatement().setDouble(14, subTotalDespesas);
            getStatement().setDouble(15, subTotalLiquido);
            
            getStatement().executeUpdate();
            
            return true;            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM PEDIDO WHERE ID = ?";
            
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
                    " SELECT                                       "+
                    "   PED.ID AS ID,                              "+
                    "   PED.DATA AS DATA,                          "+
                    "   PED.VENDEDOR AS VENDEDOR,                  "+
                    "   INS.IDINSTITUTO AS INSTITUTO,              "+
                    "   CLI.IDCLIENTE AS CLIENTE,                  "+
                    "   PED.NUMEROPROJETO AS PROJETO Nº,           "+
                    "   PED.PRAZO AS PRAZO,                        "+
                    "   PED.FORMAPAGAMENTO AS FORMA PAGTO,         "+
                    "   PED.VALORPROJETO AS VALOR PROJETO,         "+
                    "   PED.CUSTOFIXO AS CUSTO FIXO,               "+
                    "   PED.CUSTOADVERSO AS CUSTO ADVERSO,         "+
                    "   CON.IDCONSULTOR AS CONSULTOR,              "+
                    "   PED.TOTAL AS TOTAL,                        "+
                    "   PED.SUBTOTALDESPESAS AS SUB TOTAL DESPESAS,"+
                    "   PED.SUBTOTALLIQUIDO AS SUB TOTAL LIQUIDO   "+
                    "FROM                                          "+
                    "   PEDIDO PED                                 "+
                    "JOIN INSTITUTO INS ON                         "+
                    "   INS.ID = PED.IDINSTUTO                     "+
                    "JOIN CLIENTE CLI ON                           "+
                    "   CLI.ID = PED.IDCLIENTE                     "+
                    "JOIN CONSULTOR CON ON                         "+
                    "   CON.ID - PED.IDCONSULTOR                   ";
            
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
                    " SELECT                                       "+
                    "   PED.ID AS ID,                              "+
                    "   PED.DATA AS DATA,                          "+
                    "   PED.VENDEDOR AS VENDEDOR,                  "+
                    "   INS.IDINSTITUTO AS INSTITUTO,              "+
                    "   CLI.IDCLIENTE AS CLIENTE,                  "+
                    "   PED.NUMEROPROJETO AS PROJETO Nº,           "+
                    "   PED.PRAZO AS PRAZO,                        "+
                    "   PED.FORMAPAGAMENTO AS FORMA PAGTO,         "+
                    "   PED.VALORPROJETO AS VALOR PROJETO,         "+
                    "   PED.CUSTOFIXO AS CUSTO FIXO,               "+
                    "   PED.CUSTOADVERSO AS CUSTO ADVERSO,         "+
                    "   CON.IDCONSULTOR AS CONSULTOR,              "+
                    "   PED.TOTAL AS TOTAL,                        "+
                    "   PED.SUBTOTALDESPESAS AS SUB TOTAL DESPESAS,"+
                    "   PED.SUBTOTALLIQUIDO AS SUB TOTAL LIQUIDO   "+
                    " FROM                                         "+
                    "   PEDIDO PED                                 "+
                    " JOIN INSTITUTO INS ON                        "+
                    "   INS.ID = PED.IDINSTUTO                     "+
                    " JOIN CLIENTE CLI ON                          "+
                    "   CLI.ID = PED.IDCLIENTE                     "+
                    " JOIN CONSULTOR CON ON                        "+
                    "   CON.ID - PED.IDCONSULTOR                   "+
                    " WHERE                                        "+
                    "   PED.ID = ?                                 ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
     
    public ResultSet listarPorNumeroPedido(int numeroPedido){
        try{
            sql = 
                    " SELECT                                       "+
                    "   PED.ID AS ID,                              "+
                    "   PED.DATA AS DATA,                          "+
                    "   PED.VENDEDOR AS VENDEDOR,                  "+
                    "   INS.IDINSTITUTO AS INSTITUTO,              "+
                    "   CLI.IDCLIENTE AS CLIENTE,                  "+
                    "   PED.NUMEROPROJETO AS PROJETO Nº,           "+
                    "   PED.PRAZO AS PRAZO,                        "+
                    "   PED.FORMAPAGAMENTO AS FORMA PAGTO,         "+
                    "   PED.VALORPROJETO AS VALOR PROJETO,         "+
                    "   PED.CUSTOFIXO AS CUSTO FIXO,               "+
                    "   PED.CUSTOADVERSO AS CUSTO ADVERSO,         "+
                    "   CON.IDCONSULTOR AS CONSULTOR,              "+
                    "   PED.TOTAL AS TOTAL,                        "+
                    "   PED.SUBTOTALDESPESAS AS SUB TOTAL DESPESAS,"+
                    "   PED.SUBTOTALLIQUIDO AS SUB TOTAL LIQUIDO   "+
                    "FROM                                          "+
                    "   PEDIDO PED                                 "+
                    "JOIN INSTITUTO INS ON                         "+
                    "   INS.ID = PED.IDINSTUTO                     "+
                    "JOIN CLIENTE CLI ON                           "+
                    "   CLI.ID = PED.IDCLIENTE                     "+
                    "JOIN CONSULTOR CON ON                         "+
                    "   CON.ID - PED.IDCONSULTOR                   "+
                    " WHERE                                        "+
                    "   PED.NUMEROPEDIDO = ?                       ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, numeroPedido);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorInstituto(int instituto){
        try{
            sql = 
                    " SELECT                                       "+
                    "   PED.ID AS ID,                              "+
                    "   PED.DATA AS DATA,                          "+
                    "   PED.VENDEDOR AS VENDEDOR,                  "+
                    "   INS.IDINSTITUTO AS INSTITUTO,              "+
                    "   CLI.IDCLIENTE AS CLIENTE,                  "+
                    "   PED.NUMEROPROJETO AS PROJETO Nº,           "+
                    "   PED.PRAZO AS PRAZO,                        "+
                    "   PED.FORMAPAGAMENTO AS FORMA PAGTO,         "+
                    "   PED.VALORPROJETO AS VALOR PROJETO,         "+
                    "   PED.CUSTOFIXO AS CUSTO FIXO,               "+
                    "   PED.CUSTOADVERSO AS CUSTO ADVERSO,         "+
                    "   CON.IDCONSULTOR AS CONSULTOR,              "+
                    "   PED.TOTAL AS TOTAL,                        "+
                    "   PED.SUBTOTALDESPESAS AS SUB TOTAL DESPESAS,"+
                    "   PED.SUBTOTALLIQUIDO AS SUB TOTAL LIQUIDO   "+
                    "FROM                                          "+
                    "   PEDIDO PED                                 "+
                    "JOIN INSTITUTO INS ON                         "+
                    "   INS.ID = PED.IDINSTUTO                     "+
                    "JOIN CLIENTE CLI ON                           "+
                    "   CLI.ID = PED.IDCLIENTE                     "+
                    "JOIN CONSULTOR CON ON                         "+
                    "   CON.ID - PED.IDCONSULTOR                   "+
                    " WHERE                                        "+
                    "   INS.ID = ?                                 ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, instituto);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public ResultSet listarPorCliente(int idCliente){
        try{
            sql = 
                    " SELECT                                       "+
                    "   PED.ID AS ID,                              "+
                    "   PED.DATA AS DATA,                          "+
                    "   PED.VENDEDOR AS VENDEDOR,                  "+
                    "   INS.IDINSTITUTO AS INSTITUTO,              "+
                    "   CLI.IDCLIENTE AS CLIENTE,                  "+
                    "   PED.NUMEROPROJETO AS PROJETO Nº,           "+
                    "   PED.PRAZO AS PRAZO,                        "+
                    "   PED.FORMAPAGAMENTO AS FORMA PAGTO,         "+
                    "   PED.VALORPROJETO AS VALOR PROJETO,         "+
                    "   PED.CUSTOFIXO AS CUSTO FIXO,               "+
                    "   PED.CUSTOADVERSO AS CUSTO ADVERSO,         "+
                    "   CON.IDCONSULTOR AS CONSULTOR,              "+
                    "   PED.TOTAL AS TOTAL,                        "+
                    "   PED.SUBTOTALDESPESAS AS SUB TOTAL DESPESAS,"+
                    "   PED.SUBTOTALLIQUIDO AS SUB TOTAL LIQUIDO   "+
                    "FROM                                          "+
                    "   PEDIDO PED                                 "+
                    "JOIN INSTITUTO INS ON                         "+
                    "   INS.ID = PED.IDINSTUTO                     "+
                    "JOIN CLIENTE CLI ON                           "+
                    "   CLI.ID = PED.IDCLIENTE                     "+
                    "JOIN CONSULTOR CON ON                         "+
                    "   CON.ID - PED.IDCONSULTOR                   "+
                    " WHERE                                        "+
                    "   CLI.ID = ?                                 ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, idCliente);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PEDIDO";
            
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
