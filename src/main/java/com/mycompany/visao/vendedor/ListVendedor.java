/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.vendedor;

import com.mycompany.dao.DaoVendedor;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModVendedor;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thagory.8187
 */
public class ListVendedor extends javax.swing.JFrame {

    
    /**
     * Creates new form ListVendedor
     */
    public ListVendedor() {
        listarTodos();
        initComponents();
        
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        
        listarTodos();
        
    }
    
    
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableVendedor.getModel();
            
            tableVendedor.setModel(defaultTableModel);
            
            DaoVendedor daoVendedor = new DaoVendedor();
            
            ResultSet resultSet = daoVendedor.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String telefone = resultSet.getString(3);
                String email = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, nome, telefone, email});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void ListarPorId(int pId){
        try{
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableVendedor.getModel();
            
            tableVendedor.setModel(defaultTableModel);
            
            DaoVendedor daoVendedor = new DaoVendedor();
            
            ResultSet resultSet = daoVendedor.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String telefone = resultSet.getString(3);
                String email = resultSet.getString(4);
                 defaultTableModel.addRow(new Object[]{id, nome, telefone, email});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void ListarPorNome(){
        try{
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableVendedor.getModel();
            
            tableVendedor.setModel(defaultTableModel);
            
            DaoVendedor daoVendedor = new DaoVendedor();
            
            ResultSet resultSet = daoVendedor.listarPorNome(tfFiltro.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String telefone = resultSet.getString(3);
                String email = resultSet.getString(4);
                
                defaultTableModel.addRow(new Object[]{id, nome, telefone, email});
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
        jcbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendedor = new javax.swing.JTable();
        tfFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME" }));

        jcbBuscar.setText("Buscar");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        tableVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "TELEFONE", "E-MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVendedor.getTableHeader().setReorderingAllowed(false);
        tableVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVendedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBuscar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()){
            case 0:
            listarTodos();
            break;
            case 1:
            ListarPorId(Integer.parseInt(tfFiltro.getText()));
            break;
            case 2:
            ListarPorNome();
            break;
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed

    private void tableVendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendedorMouseClicked
        try{
            if (evt.getClickCount() == 2){
                //Pega os dados da pessoa
                ModVendedor modVendedor = new ModVendedor();

                modVendedor.setId(Integer.parseInt(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 0))));
                modVendedor.setNome(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 1)));
                modVendedor.setTelefone(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 2)));
                modVendedor.setEmail(String.valueOf(tableVendedor.getValueAt(tableVendedor.getSelectedRow(), 3)));
                
                DadosTemporarios.tempObject = (ModVendedor) modVendedor;

                CadVendedor cadVendedor = new CadVendedor();
                cadVendedor.setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tableVendedorMouseClicked

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
            java.util.logging.Logger.getLogger(ListVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcbBuscar;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableVendedor;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
