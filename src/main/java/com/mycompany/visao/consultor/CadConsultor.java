/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.consultor;

import com.mycompany.dao.DaoConsultor;
import com.mycompany.visao.vendedor.*;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.modelo.ModConsultor;
import com.mycompany.visao.pedido.CadPedido;
import javax.swing.JOptionPane;

/**
 *
 * @author Thagory
 */
public class CadConsultor extends javax.swing.JDialog {

    /**
     * Creates new form CadConsultor
     */
    public CadConsultor() {
        initComponents();
        
//        if(!existeDadosTemporarios()){
//            DaoConsultor daoConsultor = new DaoConsultor();
//            
//            int id = daoConsultor.buscarProximoId();
//            if(id > 0){
//                tfId.setText(String.valueOf(id));
//            }
//            
//            btnSalvar.setText(Constantes.BTN_SALVAR_TEXT);
//            btnExcluir.setVisible(false);
//        }else{
//            btnSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
//            btnExcluir.setVisible(true);
//        }
//        
        setLocationRelativeTo(null);
        tfId.setEnabled(false);
        
        tfId.setText(String.valueOf(DadosTemporarios.linhas));
    }
    
    private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModConsultor){
            int id = ((ModConsultor) DadosTemporarios.tempObject).getId();
            String nome = ((ModConsultor) DadosTemporarios.tempObject).getNome();
            String dataInicio = ((ModConsultor) DadosTemporarios.tempObject).getDataInicio();
            String dataTermino = ((ModConsultor) DadosTemporarios.tempObject).getDataTermino();
            Double preco = ((ModConsultor) DadosTemporarios.tempObject).getPreco();
            
            tfId.setText(String.valueOf(id));
            tfNome.setText(nome);
            tfDataInicio.setText(dataInicio);
            tfDataTermino.setText(dataTermino);
            tfPreco.setText(String.valueOf(preco));
            
            DadosTemporarios.tempObject = null;
            return true;
        }else
            return false;
    }
    
//    private void inserir(){
//        DaoConsultor daoConsultor = new DaoConsultor();
//        
//        if(daoConsultor.inserir(Integer.parseInt(tfId.getText()), tfNome.getText(), tfDataInicio.getText(), tfDataTermino.getText(), Double.parseDouble(tfPreco.getText()))){
//            JOptionPane.showMessageDialog(null, "Consultor salvo com sucesso!" );
//            
//            tfId.setText("");
//            tfNome.setText("");
//            tfDataInicio.setText("");
//            tfDataTermino.setText("");
//            tfPreco.setText("");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o consultor!" );
//        }
//    }
    
//    private void alterar(){
//        DaoConsultor daoConsultor = new DaoConsultor();
//        
//        if(daoConsultor.alterar(Integer.parseInt(tfId.getText()), tfNome.getText(), tfDataInicio.getText(), tfDataTermino.getText(), Double.parseDouble(tfPreco.getText()))){
//            JOptionPane.showMessageDialog(null, "Consultor alterado com sucesso!");
//            
//            tfId.setText("");
//            tfNome.setText("");
//            tfDataInicio.setText("");
//            tfDataTermino.setText("");
//            tfPreco.setText("");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o consultor!");
//        }
//                
//        dispose();
//    }
    
//    private void excluir(){
//        DaoConsultor daoConsultor = new DaoConsultor();
//        
//        if(daoConsultor.excluir(Integer.parseInt(tfId.getText()))){
//            JOptionPane.showMessageDialog(null, "Consultor" + tfNome.getText() + " excluido com sucesso!");
//            
//            tfId.setText("");
//            tfNome.setText("");
//            tfDataInicio.setText("");
//            tfDataTermino.setText("");
//            tfPreco.setText("");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o consultor!");
//        }
////        ((ListVendedor) Formularios.listConsultor).listarTodos();
//        
//        dispose();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDataInicio = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfDataTermino = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        tfId.setEditable(false);

        jLabel2.setText("NOME");

        jLabel3.setText("Data Inicio");

        jLabel4.setText("Preço");

        try {
            tfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar.setText("Incluir");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        try {
            tfDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Data Termino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(tfId)
                            .addComponent(jLabel2)
                            .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(tfDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnSalvar)
                        .addGap(32, 32, 32)
                        .addComponent(btnExcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        DaoConsultor daoConsultor = new DaoConsultor();
//        
//        if(btnSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
//            inserir();
//            
////            tfId.setText(String.valueOf(daoConsultor.buscarProximoId()));
//        }else if(btnSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
//            alterar();
//            ((ListVendedor) Formularios.listConsultor).listarTodos();
//            dispose();
//        }

        
        ModConsultor consultor = new ModConsultor();
        
        consultor.setId(Integer.parseInt(tfId.getText()));
        consultor.setNome(tfNome.getText());
        consultor.setDataInicio(tfDataInicio.getText());
        consultor.setDataTermino(tfDataTermino.getText());
        consultor.setPreco(Double.parseDouble(tfPreco.getText()));
        
        DadosTemporarios.tempObject = (ModConsultor) consultor;
        
        tfId.setText("");
        tfNome.setText("");
        tfDataInicio.setText("");
        tfDataTermino.setText("");
        tfPreco.setText("");
        
        ((CadPedido) Formularios.cadPedido).insereConsultor();
        ((CadPedido) Formularios.cadPedido).somarPrecos();
        ((CadPedido) Formularios.cadPedido).subTotalDespesas();
        ((CadPedido) Formularios.cadPedido).subTotalLiquido();
        
        dispose();
        
        Formularios.cadConsultor = null;
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        int escolha  =
//                JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o consultor " + tfNome.getText() + "?");
//        if(escolha == JOptionPane.YES_OPTION)
//            excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadConsultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadConsultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadConsultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadConsultor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadConsultor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField tfDataInicio;
    private javax.swing.JFormattedTextField tfDataTermino;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
