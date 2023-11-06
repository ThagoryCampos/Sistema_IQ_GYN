/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.cliente;

import com.mycompany.dao.DaoCliente;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModCliente;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thagory.8187
 */
public class ListCliente extends javax.swing.JFrame {

    /**
     * Creates new form ListCliente
     */
    public ListCliente() {
        initComponents();
      
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        
        listarTodos();
    }
    
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCliente.getModel();
            
            tableCliente.setModel(defaultTableModel);
            
            DaoCliente daoCliente = new DaoCliente();
            
            ResultSet resultSet = daoCliente.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String empresa = resultSet.getString(2);
                String contato = resultSet.getString(3);
                String cnpj = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String estado = resultSet.getString(7);
                String cep = resultSet.getString(8);
                String email = resultSet.getString(9);
                String celular = resultSet.getString(10);
                String telefone = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, empresa, contato, cnpj, cidade, endereco, estado, cep, email, celular, telefone});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void ListarPorId(int pId){
        try{
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCliente.getModel();
            
            tableCliente.setModel(defaultTableModel);
            
            DaoCliente daoCliente = new DaoCliente();
            
            ResultSet resultSet = daoCliente.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String empresa = resultSet.getString(2);
                String contato = resultSet.getString(3);
                String cnpj = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String estado = resultSet.getString(7);
                String cep = resultSet.getString(8);
                String email = resultSet.getString(9);
                String celular = resultSet.getString(10);
                String telefone = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, empresa, contato, cnpj, cidade, endereco, estado, cep, email, celular, telefone});
                
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void ListarPorEmpresa(){
        try{
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCliente.getModel();
            
            tableCliente.setModel(defaultTableModel);
            
            DaoCliente daoCliente = new DaoCliente();
            
            ResultSet resultSet = daoCliente.listarPorEmpresa(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String empresa = resultSet.getString(2);
                String contato = resultSet.getString(3);
                String cnpj = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String estado = resultSet.getString(7);
                String cep = resultSet.getString(8);
                String email = resultSet.getString(9);
                String celular = resultSet.getString(10);
                String telefone = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, empresa, contato, cnpj, cidade, endereco, estado, cep, email, celular, telefone});
                
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void ListarPorCidade(){
        try{
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCliente.getModel();
            
            tableCliente.setModel(defaultTableModel);
            
            DaoCliente daoCliente = new DaoCliente();
            
            ResultSet resultSet = daoCliente.listarPorCidade(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String empresa = resultSet.getString(2);
                String contato = resultSet.getString(3);
                String cnpj = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String estado = resultSet.getString(7);
                String cep = resultSet.getString(8);
                String email = resultSet.getString(9);
                String celular = resultSet.getString(10);
                String telefone = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, empresa, contato, cnpj, cidade, endereco, estado, cep, email, celular, telefone});
                
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void ListarPorCnpj(){
        try{
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableCliente.getModel();
            
            tableCliente.setModel(defaultTableModel);
            
            DaoCliente daoCliente = new DaoCliente();
            
            ResultSet resultSet = daoCliente.listarPorCnpj(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String empresa = resultSet.getString(2);
                String contato = resultSet.getString(3);
                String cnpj = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String estado = resultSet.getString(7);
                String cep = resultSet.getString(8);
                String email = resultSet.getString(9);
                String celular = resultSet.getString(10);
                String telefone = resultSet.getString(11);
                
                defaultTableModel.addRow(new Object[]{id, empresa, contato, cnpj, cidade, endereco, estado, cep, email, celular, telefone});
                
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

        jPanel1 = new javax.swing.JPanel();
        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        jcbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "EMPRESA", "CIDADE", "CNPJ" }));

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "EMPRESA", "CONTATO", "CNPJ", "CIDADE", "ENDERECO", "ESTADO", "CEP", "E-MAIL", "CELULAR", "TELEFONE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCliente.getTableHeader().setReorderingAllowed(false);
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCliente);
        if (tableCliente.getColumnModel().getColumnCount() > 0) {
            tableCliente.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableCliente.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableCliente.getColumnModel().getColumn(5).setPreferredWidth(400);
        }

        jcbBuscar.setText("Buscar");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBuscar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseClicked
        try{
            if (evt.getClickCount() == 2){
                    //Pega os dados da pessoa
               ModCliente modCliente = new ModCliente();

                modCliente.setId(Integer.parseInt(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 0))));
                modCliente.setEmpresa(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 1)));
                modCliente.setContato(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 2)));
                modCliente.setCnpj(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 3)));
                modCliente.setCidade(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 4)));
                modCliente.setEndereco(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 5)));
                modCliente.setEstado(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 6)));
                modCliente.setCep(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 7)));
                modCliente.setEmail(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 8)));
                modCliente.setCelular(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 9)));
                modCliente.setTelefone(String.valueOf(tableCliente.getValueAt(tableCliente.getSelectedRow(), 10)));

                DadosTemporarios.tempObject = (ModCliente) modCliente;

                CadCliente cadCliente = new CadCliente();
                cadCliente.setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tableClienteMouseClicked

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            ListarPorId(Integer.parseInt(tfFiltro.getText()));
            break;
            case 2:
            ListarPorEmpresa();
            break;
            case 3:
            ListarPorCidade();
            break;
            case 4:
            ListarPorCnpj();
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
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
