/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.pedido;

import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoConsultor;
import com.mycompany.dao.DaoInstituto;
import com.mycompany.dao.DaoPedido;
import com.mycompany.dao.DaoVendedor;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModConsultorPedido;
import com.mycompany.modelo.ModInstituto;
import com.mycompany.modelo.ModPedido;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thagory.8187
 */
public class ListPedido extends javax.swing.JFrame {

    /**
     * Creates new form ListPedido
     */
    public ListPedido() {
        initComponents();
        
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        
        listarTodos();
    }
    
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);
            
            DaoPedido daoPedido = new DaoPedido();
            
            ResultSet resultSet = daoPedido.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String data = resultSet.getString(2);
                String vendedor = resultSet.getString(3);
                String idInstituto = resultSet.getString(4);
                String idCliente = resultSet.getString(5);
                String numeroProjeto = resultSet.getString(6);
                String escopoProjeto = resultSet.getString(7);
                String prazo = resultSet.getString(8);
                String formaPagamento = resultSet.getString(9);
                String valorProjeto = resultSet.getString(10);
                String custoFixo = resultSet.getString(11);
                String custoAdverso = resultSet.getString(12);
                String total = resultSet.getString(13);
                String subTotalDespesas = resultSet.getString(14);
                String subTotalLiquido = resultSet.getString(15);
                
                defaultTableModel.addRow(new Object[] {id, data,vendedor,idInstituto, idCliente, numeroProjeto, escopoProjeto, prazo, formaPagamento, valorProjeto, custoFixo, custoAdverso, total, subTotalDespesas, subTotalLiquido });
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);
            
            DaoPedido daoPedido = new DaoPedido();
            
            ResultSet resultSet = daoPedido.listarPorId(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String data = resultSet.getString(2);
                String vendedor = resultSet.getString(3);
                String idInstituto = resultSet.getString(4);
                String idCliente = resultSet.getString(5);
                String numeroProjeto = resultSet.getString(6);
                String escopoProjeto = resultSet.getString(7);
                String prazo = resultSet.getString(8);
                String formaPagamento = resultSet.getString(9);
                String valorProjeto = resultSet.getString(10);
                String custoFixo = resultSet.getString(11);
                String custoAdverso = resultSet.getString(12);
                String total = resultSet.getString(13);
                String subTotalDespesas = resultSet.getString(14);
                String subTotalLiquido = resultSet.getString(15);
                
                defaultTableModel.addRow(new Object[] {id, data,vendedor,idInstituto, idCliente, numeroProjeto, escopoProjeto, prazo, formaPagamento, valorProjeto, custoFixo, custoAdverso, total, subTotalDespesas, subTotalLiquido });
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void listarPorNumeroPedido(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);
            
            DaoPedido daoPedido = new DaoPedido();
            
            ResultSet resultSet = daoPedido.listarPorNumeroPedido(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String data = resultSet.getString(2);
                String vendedor = resultSet.getString(3);
                String idInstituto = resultSet.getString(4);
                String idCliente = resultSet.getString(5);
                String numeroProjeto = resultSet.getString(6);
                String escopoProjeto = resultSet.getString(7);
                String prazo = resultSet.getString(8);
                String formaPagamento = resultSet.getString(9);
                String valorProjeto = resultSet.getString(10);
                String custoFixo = resultSet.getString(11);
                String custoAdverso = resultSet.getString(12);
                String total = resultSet.getString(13);
                String subTotalDespesas = resultSet.getString(14);
                String subTotalLiquido = resultSet.getString(15);
                
                defaultTableModel.addRow(new Object[] {id, data,vendedor,idInstituto, idCliente, numeroProjeto, escopoProjeto, prazo, formaPagamento, valorProjeto, custoFixo, custoAdverso, total, subTotalDespesas, subTotalLiquido });
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void listarPorInstituto(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);
            
            DaoPedido daoPedido = new DaoPedido();
            
            ResultSet resultSet = daoPedido.listarPorInstituto(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String data = resultSet.getString(2);
                String vendedor = resultSet.getString(3);
                String idInstituto = resultSet.getString(4);
                String idCliente = resultSet.getString(5);
                String numeroProjeto = resultSet.getString(6);
                String escopoProjeto = resultSet.getString(7);
                String prazo = resultSet.getString(8);
                String formaPagamento = resultSet.getString(9);
                String valorProjeto = resultSet.getString(10);
                String custoFixo = resultSet.getString(11);
                String custoAdverso = resultSet.getString(12);
                String total = resultSet.getString(13);
                String subTotalDespesas = resultSet.getString(14);
                String subTotalLiquido = resultSet.getString(15);
                
                defaultTableModel.addRow(new Object[] {id, data,vendedor,idInstituto, idCliente, numeroProjeto, escopoProjeto, prazo, formaPagamento, valorProjeto, custoFixo, custoAdverso, total, subTotalDespesas, subTotalLiquido });
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void listarPorCliente(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tablePedido.getModel();
            
            tablePedido.setModel(defaultTableModel);
            
            DaoPedido daoPedido = new DaoPedido();
            
            ResultSet resultSet = daoPedido.listarPorCliente(Integer.parseInt(tfFiltro.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String data = resultSet.getString(2);
                String vendedor = resultSet.getString(3);
                String idInstituto = resultSet.getString(4);
                String idCliente = resultSet.getString(5);
                String numeroProjeto = resultSet.getString(6);
                String escopoProjeto = resultSet.getString(7);
                String prazo = resultSet.getString(8);
                String formaPagamento = resultSet.getString(9);
                String valorProjeto = resultSet.getString(10);
                String custoFixo = resultSet.getString(11);
                String custoAdverso = resultSet.getString(12);
                String total = resultSet.getString(13);
                String subTotalDespesas = resultSet.getString(14);
                String subTotalLiquido = resultSet.getString(15);
                
                defaultTableModel.addRow(new Object[] {id, data,vendedor,idInstituto, idCliente, numeroProjeto, escopoProjeto, prazo, formaPagamento, valorProjeto, custoFixo, custoAdverso, total, subTotalDespesas, subTotalLiquido });
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedido = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Pedido");

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "RUA", "CEP", "NÚM. RESIDÊNCIA", "NOME", "SOBRENOME", "GENERO", "TELEFONE", "EMAIL", "ESTADO CIVIL" }));

        tablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DATA", "VENDEDOR", "INSTITUTO", "CLIENTE", "NUMERO PROJETO", "ESCOPO PROJETO", "PRAZO", "FORMA PAGTO", "VALOR PROJETO", "CUSTO FIXO", "CUSTO ADVERSO", "TOTAL", "SUB TOTAL DESPESAS", "SUB TOTAL LIQUIDO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePedido.getTableHeader().setReorderingAllowed(false);
        tablePedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePedido);
        if (tablePedido.getColumnModel().getColumnCount() > 0) {
            tablePedido.getColumnModel().getColumn(6).setResizable(false);
        }

        jcbBuscar.setText("Buscar");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBuscar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedidoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                //Pega os dados da pessoa
                ModPedido modPedido = new ModPedido();

                modPedido.setId(Integer.parseInt(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 0))));
                modPedido.setData(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 1)));
                modPedido.setVendedor(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 2)));
//                modPedido.setIdInstituto(Integer.parseInt(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 3))));
//                modPedido.setIdCliente(Integer.parseInt(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 4))));
                modPedido.setNumeroProjeto(Integer.parseInt(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 5))));
                modPedido.setEscopoProjeto(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 6)));
                modPedido.setPrazo(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 7)));
                modPedido.setFormaPagamento(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 8)));
                modPedido.setValorProjeto(Double.parseDouble(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 9))));
                modPedido.setCustoFixo(Double.parseDouble(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 10))));
                modPedido.setCustoAdverso(Double.parseDouble(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 11))));
                modPedido.setTotal(Double.parseDouble(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 12))));
                modPedido.setSubTotalDespesas(Double.parseDouble(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 13))));
                modPedido.setSubTotalLiquido(Double.parseDouble(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 14))));

                //
                DaoInstituto daoInstituto = new DaoInstituto();
                ResultSet resultSet = daoInstituto.listarPorId(Integer.parseInt(tablePedido.getValueAt(tablePedido.getSelectedRow(), 3).toString()));
                
                ModInstituto modInstituto = new ModInstituto();
                
                int idInstituto = -1;
                while(resultSet.next())
                idInstituto = resultSet.getInt("ID");

                modInstituto.setId(idInstituto);
                //

                //
                DaoCliente daoCliente = new DaoCliente();
                resultSet = daoCliente.listarPorId(Integer.parseInt(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 4))));
                 
                ModCliente modCliente = new ModCliente();
                
                int idCliente = -1;
                while(resultSet.next())
                idCliente = resultSet.getInt("ID");

                modCliente.setId(idCliente);
                //
                
                DadosTemporarios.tempObject = (ModPedido) modPedido;
                DadosTemporarios.tempObject2 = (ModCliente) modCliente;
                DadosTemporarios.tempObject3 = (ModInstituto) modInstituto;
                    
                int idPedido = Integer.parseInt(String.valueOf(tablePedido.getValueAt(tablePedido.getSelectedRow(), 0)));
                resultSet = new DaoVendedor().listarConsultoresPorIdPedido(idPedido);
                
                DadosTemporarios.tempObjects = new ArrayList<>();
                while(resultSet.next()){
                    ModConsultorPedido modConsultorPedido = 
                            new ModConsultorPedido( resultSet.getInt(1), 
                                                    resultSet.getInt(2), 
                                                    resultSet.getString(3), 
                                                    resultSet.getDouble(4));
                    
                    DadosTemporarios.tempObjects.add(modConsultorPedido);
                }

                CadPedido cadPedido = new CadPedido();
                Formularios.cadPedido = cadPedido;
                cadPedido.setVisible(true);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_tablePedidoMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId();
                break;
            case 2:
                listarPorNumeroPedido();
                break;
            case 3:
                listarPorInstituto();
                break;
            case 4:
                listarPorCliente();
                break;
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tablePedido;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
