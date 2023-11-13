/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.pedido;

import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoFormaPagamento;
import com.mycompany.dao.DaoVendedor;
import com.mycompany.dao.DaoInstituto;
import com.mycompany.dao.DaoPedido;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModPedido;
import com.mycompany.visao.consultor.CadConsultor;
import com.mycompany.visao.instituto.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author thagory.8187
 */
public class CadPedido extends javax.swing.JFrame {

    /**
     * Creates new form CadInstituto
     */
    public CadPedido() {
        initComponents();
        
        carregaEmpresa();
        carregaInstituto();
        carregaVendedor();
        carregaFormaPagamento();
        
      
        recuperaFormaPagamento();
        recuperaEmpresas();
        recuperaInstituto();
        recuperaVendedor();
        
        tfVendedor.setVisible(false);
        tfInstituto.setVisible(false);
        tfEmpresa.setVisible(false);
        tfFormaPagamento.setVisible(false);
        
        tfCelular.setEditable(false);
        tfTelefone.setEditable(false);
   }
    
    private Boolean existeDadosTemporarios(){
        if(DadosTemporarios.tempObject instanceof ModPedido){
            int id = ((ModPedido) DadosTemporarios.tempObject).getId();
            String data = ((ModPedido) DadosTemporarios.tempObject).getData();
            String vendedor = ((ModPedido) DadosTemporarios.tempObject).getVendedor();
            int idInstituto = ((ModPedido) DadosTemporarios.tempObject).getIdInstituto();
            int idCliente = ((ModPedido) DadosTemporarios.tempObject).getIdCliente();
            int numeroProjeto = ((ModPedido) DadosTemporarios.tempObject).getNumeroProjeto();
            String escopoProjeto = ((ModPedido) DadosTemporarios.tempObject).getEscopoProjeto();
            String prazo = ((ModPedido) DadosTemporarios.tempObject).getPrazo();
            String formaPagamento = ((ModPedido) DadosTemporarios.tempObject).getFormaPagamento();
            Double valorProjeto = ((ModPedido) DadosTemporarios.tempObject).getValorProjeto();
            Double custoFixo = ((ModPedido) DadosTemporarios.tempObject).getCustoFixo();
            Double custoAdverso = ((ModPedido) DadosTemporarios.tempObject).getCustoAdverso();
            int idConsultor = ((ModPedido) DadosTemporarios.tempObject).getIdConsultor();
            Double total = ((ModPedido) DadosTemporarios.tempObject).getTotal();
            Double subTotalDespesas = ((ModPedido) DadosTemporarios.tempObject).getSubTotalDespesas();
            Double subTotalLiquido = ((ModPedido) DadosTemporarios.tempObject).getSubTotalLiquido();
            
            tfId.setText(String.valueOf(id));
            tfData.setText(data);
            tfVendedor.setText(vendedor);
            tfInstituto.setText(String.valueOf(idInstituto));
            tfEmpresa.setText(String.valueOf(idCliente));
            tfNumeroProjeto.setText(String.valueOf(numeroProjeto));
            taEscopoProjeto.setText(escopoProjeto);
            tfPrazo.setText(prazo);
            tfFormaPagamento.setText(formaPagamento);
            tfValorProjeto.setText(String.valueOf(valorProjeto));
            tfCustoFixo.setText(String.valueOf(custoFixo));
            tfCustoAdverso.setText(String.valueOf(custoAdverso));
//            tableConsultor.sett
            labelTotalCompra.setText(String.valueOf(total));
            tfSubTotalDespesas.setText(String.valueOf(subTotalDespesas));
            lblSubTotalLiquido.setText(String.valueOf(subTotalLiquido));
            
            int index = 0;
            for(int i = 0; i < jcbVendedor.getItemCount(); i++){
                if(jcbVendedor.getItemAt(i).equals(idConsultor)){
                    index = i;
                    break;    
                }
            }
            jcbVendedor.setSelectedIndex(index);
            
            int index1 = 0;
            for(int i = 0; i < jcbInstituto.getItemCount(); i++){
                if(jcbInstituto.getItemAt(i).equals(idInstituto)){
                    index1 = i;
                    break;    
                }
            }
            jcbInstituto.setSelectedIndex(index1);
            
            
            int index2 = 0;
            for(int i = 0; i < jcbEmpresa.getItemCount(); i++){
                if(jcbEmpresa.getItemAt(i).equals(idCliente)){
                    index2 = i;
                    break;    
                }
            }
            jcbInstituto.setSelectedIndex(index2);
            
            int index3 = 0;
            for(int i = 0; i < jcbFormaPagamento.getItemCount(); i++){
                if(jcbFormaPagamento.getItemAt(i).equals(formaPagamento)){
                    index3 = i;
                    break;    
                }
            }
            jcbFormaPagamento.setSelectedIndex(index3);
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
//    private void inserir(){
//        DaoPedido daoPedido = new DaoPedido();
//        
//        if (daoPedido.inserir(Integer.parseInt(tfId.getText(), tfData.getText(), tfVendedor.getText(), Integer.parseInt(tfInstituto.getText(), Integer.parseInt(tfEmpresa.getText()), Integer.parseInt(tfNumeroProjeto.getText(), taEscopoProjeto.getText(), tfPrazo.getText(),tfFormaPagamento.getText(), Double.parseDouble(tfValorProjeto.getText(), Double.parseDouble(tfCustoFixo.getText(), Double.parseDouble(tfCustoAdverso.getText(), Double.parseDouble(labelTotalCompra.getText()), Double.parseDouble(tfSubTotalDespesas.getText()), Double.parseDouble(tfSubTotalLiquido.getText())))))))){
//            JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!");
//            
//            tfId.setText("");
//            tfData.setText("");
//            tfVendedor.setText("");
//            tfInstituto.setText("");
//            tfEmpresa.setText("");
//            tfNumeroProjeto.setText("");
//            taEscopoProjeto.setText("");
//            tfPrazo.setText("");
//            tfFormaPagamento.setText("");
//            tfValorProjeto.setText("");
//            tfCustoFixo.setText("");
//            tfCustoAdverso.setText("");
//            labelTotalCompra.setText("");
//            tfSubTotalDespesas.setText("");
//            tfSubTotalLiquido.setText("");
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possivél salvar o pedido!");
//        }   
//    }
//    
//    private void inserir(){
//        DaoPedido daoPedido = new DaoPedido();
//        
//        if (daoPedido.alterar(Integer.parseInt(tfId.getText(), tfData.getText(), tfVendedor.getText(), Integer.parseInt(tfInstituto.getText(), Integer.parseInt(tfEmpresa.getText()), Integer.parseInt(tfNumeroProjeto.getText(), taEscopoProjeto.getText(), tfPrazo.getText(),tfFormaPagamento.getText(), Double.parseDouble(tfValorProjeto.getText(), Double.parseDouble(tfCustoFixo.getText(), Double.parseDouble(tfCustoAdverso.getText(), Integer.parseInt(tfConsultor.getText()), Double.parseDouble(labelTotal.getText()), Double.parseDouble(tfSubTotalDespesas.getText()), Double.parseDouble(tfSubTotalLiquido.getText())))))))){
//            JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!");
//            
//            tfId.setText("");
//            tfData.setText("");
//            tfVendedor.setText("");
//            tfInstituto.setText("");
//            tfEmpresa.setText("");
//            tfNumeroProjeto.setText("");
//            taEscopoProjeto.setText("");
//            tfPrazo.setText("");
//            tfFormaPagamento.setText("");
//            tfValorProjeto.setText("");
//            tfCustoFixo.setText("");
//            tfCustoAdverso.setText("");
//            tfConsultor.setText("");
//            labelTotal.setText("");
//            tfSubTotalDespesas.setText("");
//            tfSubTotalLiquido.setText("");
//            
//        }else{
//            JOptionPane.showMessageDialog(null, "Não foi possivél salvar o pedido!");
//        }   
//    }
//    
//    private void excluir(){
//        DaoPedido daoPedido = new DaoPedido();
//        
//        if(daoPedido.excluir(Integer.parseInt(tfId.getText())))
//            JOptionPane.showMessageDialog(null, "Pedido excluiro com sucesso!");
//        else
//            JOptionPane.showMessageDialog(null, "Não foi possível excluir o pedido!");
//        
//        ((ListPedido) Formularios.listPedido).listarTodos();
//        
//        dispose();
//    }
    
    private boolean camposObrigatoriosPreenchidos(JTextField campos[]){
        boolean b = true;
        
        for(int i = 0; i < campos.length; i++){
            if(campos[i].getText().equals("")){
                JOptionPane.showMessageDialog(null, "O campo " + campos[i].getToolTipText() + " é obrigatório!");
                campos[i].requestFocus();
                b = false;
                break;
            }
        }
        
        return b;
    }
    
    private void carregaInstituto(){
        try{
            DaoInstituto daoInstituto = new DaoInstituto();
            
            ResultSet resultSet = daoInstituto.listarTodos();
         
            while(resultSet.next())
                jcbInstituto.addItem(resultSet.getString("EMPRESA"));
       }catch(Exception e){
            System.err.println(e.getMessage());
       }
    }
    
    private void carregaVendedor(){
        try{
            DaoVendedor daoConsultor = new DaoVendedor();
        
            ResultSet resultSet = daoConsultor.listarTodos();
        
            while(resultSet.next())
                jcbVendedor.addItem(resultSet.getString("NOME"));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }    
    }
    
    private void carregaEmpresa(){
        try{
            DaoCliente daoCliente = new DaoCliente();
        
            ResultSet resultSet = daoCliente.listarTodos();
        
            while(resultSet.next()){
                jcbEmpresa.addItem(resultSet.getString("EMPRESA"));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
     private void carregaFormaPagamento(){
        try{
            DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();
        
            ResultSet resultSet = daoFormaPagamento.listarTodos();
        
            while(resultSet.next()){
                jcbEmpresa.addItem(resultSet.getString("DESCRICAO"));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    private void recuperaFormaPagamento(){
        try{
            DaoFormaPagamento daoFormaPagamento = new DaoFormaPagamento();
            
            ResultSet resultSet = daoFormaPagamento.listarPorDescricao(jcbFormaPagamento.getSelectedItem().toString());
            
            resultSet.next();
            tfFormaPagamento.setText(resultSet.getString("ID"));
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void recuperaInstituto(){
        try{
            DaoInstituto daoInstituto = new DaoInstituto();
            
            ResultSet resultSet = daoInstituto.listarPorEmpresa(jcbInstituto.getSelectedItem().toString());
            
            resultSet.next();
            tfInstituto.setText(resultSet.getString("ID"));
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void recuperaVendedor(){
        try{
            DaoVendedor daoConsultor = new DaoVendedor();
            
            ResultSet resultSet = daoConsultor.listarPorNome(jcbVendedor.getSelectedItem().toString());
            
            resultSet.next();
            tfEmpresa.setText(resultSet.getString("ID"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void recuperaEmpresas(){
        try{
            DaoCliente daoCliente = new DaoCliente();
            
            ResultSet resultSet = daoCliente.listarPorEmpresa(jcbEmpresa.getSelectedItem().toString());
            
            resultSet.next();
            tfEmpresa.setText(resultSet.getString("ID"));
            tfCnpj.setText(resultSet.getString("CNPJ"));
            tfEstado.setText(resultSet.getString("ESTADO"));
            tfCidade.setText(resultSet.getString("CIDADE"));
            tfCep.setText(resultSet.getString("CEP"));
            tfEndereco.setText(resultSet.getString("ENDERECO"));
            tfTelefone.setText(resultSet.getString("TELEFONE"));
            tfEmail.setText(resultSet.getString("EMAIL"));
            tfCelular.setText(resultSet.getString("CELULAR"));
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jcbEmpresa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfNumeroProjeto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taEscopoProjeto = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tfPrazo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcbFormaPagamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableConsultor = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        labelTotalCompra = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jcbInstituto = new javax.swing.JComboBox<>();
        jcbVendedor = new javax.swing.JComboBox<>();
        tfCnpj = new javax.swing.JFormattedTextField();
        tfCep = new javax.swing.JFormattedTextField();
        tfTelefone = new javax.swing.JFormattedTextField();
        tfCelular = new javax.swing.JFormattedTextField();
        tfValorProjeto = new javax.swing.JFormattedTextField();
        tfCustoAdverso = new javax.swing.JFormattedTextField();
        tfCustoFixo = new javax.swing.JFormattedTextField();
        tfData = new javax.swing.JFormattedTextField();
        tfVendedor = new javax.swing.JTextField();
        tfInstituto = new javax.swing.JTextField();
        tfEmpresa = new javax.swing.JTextField();
        tfFormaPagamento = new javax.swing.JTextField();
        btnSalvar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tfSubTotalDespesas = new javax.swing.JFormattedTextField();
        lblSubTotalLiquido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Data");

        tfId.setEnabled(false);

        jLabel2.setText("Nº Pedido");

        jLabel3.setText("Vendedor");

        jLabel4.setText("Instituto");

        jLabel5.setText("Empresa *");

        jcbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEmpresaItemStateChanged(evt);
            }
        });

        jLabel7.setText("CNPJ");

        jLabel8.setText("Estado");

        tfEstado.setEditable(false);

        jLabel9.setText("Cidade");

        tfCidade.setEditable(false);

        jLabel10.setText("Cep");

        jLabel11.setText("Endereço");

        tfEndereco.setEditable(false);

        jLabel12.setText("Telefone");

        tfEmail.setEditable(false);

        jLabel13.setText("E-mail");

        jLabel14.setText("Celular");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Cliente");

        jLabel16.setText("Nº Projeto");

        tfNumeroProjeto.setEditable(false);

        taEscopoProjeto.setColumns(20);
        taEscopoProjeto.setRows(5);
        jScrollPane1.setViewportView(taEscopoProjeto);

        jLabel17.setText("Escopo Projeto");

        jLabel18.setText("Prazo");

        jLabel19.setText("Valor Projeto *");

        jLabel20.setText("Forma Pagamento");

        jLabel21.setText("Custo Fixo");

        jLabel22.setText("Custo Adverso");

        jcbFormaPagamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFormaPagamentoItemStateChanged(evt);
            }
        });

        tableConsultor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Nome", "Data Inicio", "Data Termino", "Preço"
            }
        ));
        tableConsultor.setColumnSelectionAllowed(true);
        tableConsultor.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableConsultor);
        tableConsultor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tableConsultor.getColumnModel().getColumnCount() > 0) {
            tableConsultor.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel24.setText("Total");

        labelTotalCompra.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelTotalCompra.setText("lblTotal");

        jLabel25.setText("Sub-Total Despesas");

        jLabel26.setText("Sub-Total  Liquido Projeto");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel27.setText("Projeto");

        jcbInstituto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbInstitutoItemStateChanged(evt);
            }
        });

        jcbVendedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbVendedorItemStateChanged(evt);
            }
        });

        try {
            tfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfValorProjeto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        tfCustoAdverso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        tfCustoFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar1.setText("Excluir");

        jButton1.setText("Inserir Consultor");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfSubTotalDespesas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        lblSubTotalLiquido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfEndereco)
                                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                            .addComponent(tfCnpj))))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(30, 30, 30)
                                        .addComponent(tfCep))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTelefone))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfEstado))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jcbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jcbInstituto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel22))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(tfNumeroProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(234, 234, 234)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(tfPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfValorProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfCustoAdverso, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfCustoFixo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(tfSubTotalDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(labelTotalCompra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSubTotalLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCustoFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCustoAdverso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTotalCompra)
                        .addComponent(jLabel24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSubTotalDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addGap(7, 7, 7)
                .addComponent(lblSubTotalLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSalvar1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lblSubTotalLiquido.getAccessibleContext().setAccessibleName("subTotalLiquidoProjeto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbVendedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbVendedorItemStateChanged
        recuperaVendedor();
    }//GEN-LAST:event_jcbVendedorItemStateChanged

    private void jcbInstitutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbInstitutoItemStateChanged
        recuperaInstituto();
    }//GEN-LAST:event_jcbInstitutoItemStateChanged

    private void jcbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEmpresaItemStateChanged
        recuperaEmpresas();
    }//GEN-LAST:event_jcbEmpresaItemStateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableConsultor.getModel();
        defaultTableModel.addRow(new Object[]{"","","","",""});
        
        DadosTemporarios.linhas = defaultTableModel.getRowCount();
        
        if (Formularios.cadConsultor == null)
            Formularios.cadConsultor = new CadConsultor();
        
        Formularios.cadConsultor.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void calculaTotalCompra(Double ValorProjeto, Double SubTotalDespesas){
        Double total = ValorProjeto - SubTotalDespesas;
        
        lblSubTotalLiquido.setText(String.valueOf(total));
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbFormaPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFormaPagamentoItemStateChanged
        recuperaFormaPagamento();
    }//GEN-LAST:event_jcbFormaPagamentoItemStateChanged

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
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcbEmpresa;
    private javax.swing.JComboBox<String> jcbFormaPagamento;
    private javax.swing.JComboBox<String> jcbInstituto;
    private javax.swing.JComboBox<String> jcbVendedor;
    private javax.swing.JLabel labelTotalCompra;
    private javax.swing.JLabel lblSubTotalLiquido;
    private javax.swing.JTextArea taEscopoProjeto;
    private javax.swing.JTable tableConsultor;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JFormattedTextField tfCnpj;
    private javax.swing.JFormattedTextField tfCustoAdverso;
    private javax.swing.JFormattedTextField tfCustoFixo;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmpresa;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfFormaPagamento;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfInstituto;
    private javax.swing.JTextField tfNumeroProjeto;
    private javax.swing.JTextField tfPrazo;
    private javax.swing.JFormattedTextField tfSubTotalDespesas;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JFormattedTextField tfValorProjeto;
    private javax.swing.JTextField tfVendedor;
    // End of variables declaration//GEN-END:variables
}
