/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros;

import com.mycompany.ferramentas.BancoDeDadosMySql;

import com.mycompany.ferramentas.Formularios;
import com.mycompany.sistemaiq_gyn.SistemaIQ_GYN;
import com.mycompany.visao.cliente.CadCliente;
import com.mycompany.visao.cliente.ListCliente;
import com.mycompany.visao.formaPagamento.CadFormaPagamento;
import com.mycompany.visao.formaPagamento.ListFormaPagamento;
import com.mycompany.visao.vendedor.CadVendedor;
import com.mycompany.visao.vendedor.ListVendedor;
import com.mycompany.visao.instituto.CadInstituto;
import com.mycompany.visao.instituto.ListInstituto;
import com.mycompany.visao.pedido.ListPedido;
import com.mycompany.visao.pedido.CadPedido;
import com.mycompany.visao.usuario.CadUsuario;
import com.mycompany.visao.usuario.ListUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author 10156
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        if (!BancoDeDadosMySql.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);
        }
        
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Seja Bem Vindo! \nRealize login para continuar!");
        
        if(escolha == JOptionPane.YES_OPTION){
            if(Formularios.telaLogin == null)
                Formularios.telaLogin = new TelaLogin();
            
            Formularios.telaLogin.setModal(true);
            Formularios.telaLogin.setVisible(true);
        }else{
            System.exit(0);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnCadastro = new javax.swing.JMenu();
        miCadastroUsuario = new javax.swing.JMenuItem();
        miCadastroCliente = new javax.swing.JMenuItem();
        miCadastroConsultor = new javax.swing.JMenuItem();
        miCadastroInstituto = new javax.swing.JMenuItem();
        miCadastroVendedor = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miCadFormaPagamento = new javax.swing.JMenuItem();
        miCadastroPedido = new javax.swing.JMenuItem();
        miConsultaEstadoCivil = new javax.swing.JMenu();
        miConsultaUsuario = new javax.swing.JMenuItem();
        miConsultaCliente = new javax.swing.JMenuItem();
        miConsultaConsultor = new javax.swing.JMenuItem();
        miConsultaInstituto = new javax.swing.JMenuItem();
        miConsultaVendedor = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miConsultaFormaPagamento = new javax.swing.JMenuItem();
        miConsultaPedidos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE VENDAS  - INSTITUTO QUALITEC | v. 1.0.0.5");

        jLabel1.setText("Thagory Campos");

        jLabel3.setText("(44) 997 536 985");

        mnCadastro.setText("Cadastros");

        miCadastroUsuario.setText("Usuario");
        miCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroUsuarioActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroUsuario);

        miCadastroCliente.setText("Cliente");
        miCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroClienteActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroCliente);

        miCadastroConsultor.setText("Consultor");
        miCadastroConsultor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroConsultorActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroConsultor);

        miCadastroInstituto.setText("Instituto");
        miCadastroInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroInstitutoActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroInstituto);

        miCadastroVendedor.setText("Vendedor");
        miCadastroVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroVendedorActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroVendedor);
        mnCadastro.add(jSeparator3);

        miCadFormaPagamento.setText("Forma de Pagamento");
        miCadFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadFormaPagamentoActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadFormaPagamento);

        miCadastroPedido.setText("Pedido");
        miCadastroPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastroPedidoActionPerformed(evt);
            }
        });
        mnCadastro.add(miCadastroPedido);

        menuBar.add(mnCadastro);

        miConsultaEstadoCivil.setText("Consultas");

        miConsultaUsuario.setText("Usuario");
        miConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaUsuarioActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaUsuario);

        miConsultaCliente.setText("Cliente");
        miConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaClienteActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaCliente);

        miConsultaConsultor.setText("Consultor");
        miConsultaConsultor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaConsultorActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaConsultor);

        miConsultaInstituto.setText("Instituto");
        miConsultaInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaInstitutoActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaInstituto);

        miConsultaVendedor.setText("Vendedor");
        miConsultaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaVendedorActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaVendedor);
        miConsultaEstadoCivil.add(jSeparator2);

        miConsultaFormaPagamento.setText("Forma de Pagamento");
        miConsultaFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaFormaPagamentoActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaFormaPagamento);

        miConsultaPedidos.setText("Pedidos");
        miConsultaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultaPedidosActionPerformed(evt);
            }
        });
        miConsultaEstadoCivil.add(miConsultaPedidos);

        menuBar.add(miConsultaEstadoCivil);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(781, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroUsuarioActionPerformed
        if (Formularios.cadUsuario == null)
            Formularios.cadUsuario = new CadUsuario();
        
        Formularios.cadUsuario.setVisible(true);
    }//GEN-LAST:event_miCadastroUsuarioActionPerformed
       
    private void miConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaUsuarioActionPerformed
        if (Formularios.listUsuario == null)
            Formularios.listUsuario = new ListUsuario();
        ((ListUsuario)Formularios.listUsuario).listarTodos();
        Formularios.listUsuario.setVisible(true);
    }//GEN-LAST:event_miConsultaUsuarioActionPerformed

    private void miCadastroInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroInstitutoActionPerformed
        if (Formularios.cadInstituto == null)
            Formularios.cadInstituto = new CadInstituto();
        
        Formularios.cadInstituto.setVisible(true);
    }//GEN-LAST:event_miCadastroInstitutoActionPerformed

    private void miConsultaInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaInstitutoActionPerformed
        if (Formularios.listInstituto == null)
            Formularios.listInstituto = new ListInstituto();
        ((ListInstituto)Formularios.listInstituto).listarTodos();
        Formularios.listInstituto.setVisible(true);
    }//GEN-LAST:event_miConsultaInstitutoActionPerformed

    private void miCadastroConsultorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroConsultorActionPerformed
        if (Formularios.cadVendedor == null)
            Formularios.cadVendedor = new CadVendedor();
        
        Formularios.cadVendedor.setVisible(true);
    }//GEN-LAST:event_miCadastroConsultorActionPerformed

    private void miConsultaConsultorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaConsultorActionPerformed
        if (Formularios.listVendedor == null)
            Formularios.listVendedor = new ListVendedor();
        ((ListVendedor)Formularios.listVendedor).listarTodos();
        Formularios.listVendedor.setVisible(true);
    }//GEN-LAST:event_miConsultaConsultorActionPerformed

    private void miCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroClienteActionPerformed
        if (Formularios.cadCliente == null)
            Formularios.cadCliente = new CadCliente();
        
        Formularios.cadCliente.setVisible(true);
    }//GEN-LAST:event_miCadastroClienteActionPerformed

    private void miConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaClienteActionPerformed
        if (Formularios.listCliente == null)
            Formularios.listCliente = new ListCliente();
        ((ListCliente)Formularios.listCliente).listarTodos();
        Formularios.listCliente.setVisible(true);
    }//GEN-LAST:event_miConsultaClienteActionPerformed

    private void miConsultaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaPedidosActionPerformed
        if (Formularios.listPedido == null)
            Formularios.listPedido = new ListPedido();
        ((ListPedido)Formularios.listPedido).listarTodos();
        Formularios.listPedido.setVisible(true);
    }//GEN-LAST:event_miConsultaPedidosActionPerformed

    private void miCadastroPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroPedidoActionPerformed
            if (Formularios.cadPedido == null)
            Formularios.cadPedido = new CadPedido();
        
            Formularios.cadPedido.setVisible(true);
    }//GEN-LAST:event_miCadastroPedidoActionPerformed

    private void miCadFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadFormaPagamentoActionPerformed
        if(Formularios.cadFormaPagamento == null)
            Formularios.cadFormaPagamento = new CadFormaPagamento();
        
        Formularios.cadFormaPagamento.setVisible(true);
    }//GEN-LAST:event_miCadFormaPagamentoActionPerformed

    private void miConsultaFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaFormaPagamentoActionPerformed
        if(Formularios.listFormaPagamento == null)
            Formularios.listFormaPagamento = new ListFormaPagamento();
        ((ListFormaPagamento)Formularios.listFormaPagamento).listarTodos();
        Formularios.listFormaPagamento.setVisible(true);
    }//GEN-LAST:event_miConsultaFormaPagamentoActionPerformed

    private void miConsultaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultaVendedorActionPerformed
        if(Formularios.listVendedor == null)
            Formularios.listVendedor = new ListVendedor();
        ((ListVendedor)Formularios.listVendedor).listarTodos();
        Formularios.listVendedor.setVisible(true);
    }//GEN-LAST:event_miConsultaVendedorActionPerformed

    private void miCadastroVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastroVendedorActionPerformed
        if(Formularios.cadVendedor == null)
            Formularios.cadVendedor = new CadVendedor();
        
        Formularios.cadVendedor.setVisible(true);
    }//GEN-LAST:event_miCadastroVendedorActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* CreatemiConsultaProduto and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miCadFormaPagamento;
    private javax.swing.JMenuItem miCadastroCliente;
    private javax.swing.JMenuItem miCadastroConsultor;
    private javax.swing.JMenuItem miCadastroInstituto;
    private javax.swing.JMenuItem miCadastroPedido;
    private javax.swing.JMenuItem miCadastroUsuario;
    private javax.swing.JMenuItem miCadastroVendedor;
    private javax.swing.JMenuItem miConsultaCliente;
    private javax.swing.JMenuItem miConsultaConsultor;
    private javax.swing.JMenu miConsultaEstadoCivil;
    private javax.swing.JMenuItem miConsultaFormaPagamento;
    private javax.swing.JMenuItem miConsultaInstituto;
    private javax.swing.JMenuItem miConsultaPedidos;
    private javax.swing.JMenuItem miConsultaUsuario;
    private javax.swing.JMenuItem miConsultaVendedor;
    private javax.swing.JMenu mnCadastro;
    // End of variables declaration//GEN-END:variables
}
