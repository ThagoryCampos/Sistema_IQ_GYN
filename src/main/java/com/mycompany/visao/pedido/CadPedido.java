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
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModConsultor;
import com.mycompany.modelo.ModPedido;
import com.mycompany.visao.consultor.CadConsultor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


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
        
         if(!existeDadosTemporarios()){
            DaoPedido daoPedido = new DaoPedido();
            
            int id = daoPedido.buscarProximoId();
            if(id > 0){
                tfId.setText(String.valueOf(id));
            }
            
            btnSalvar.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnSalvar.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        setLocationRelativeTo(null);
        tfId.setEnabled(false);
        
        carregaEmpresa();
        carregaInstituto();
        carregaVendedor();
        carregaFormaPagamento();
        
        existeDadosTemporarios();
//      
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
        
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableConsultor.getModel();
        defaultTableModel.setRowCount(0);
   }
    
    private String formatarMoeda(Double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(valor);
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
            lblTotalCompra.setText(String.valueOf(total));
            lblSubTotalDespesas.setText(String.valueOf(subTotalDespesas));
            lblSubTotalLiquido.setText(String.valueOf(subTotalLiquido));
            
            
//            int index = 0;
//            for(int i = 0; i < jcbVendedor.getItemCount(); i++){
//                if(jcbVendedor.getItemAt(i).equals(idConsultor)){
//                    index = i;
//                    break;    
//                }
//            }
//            jcbVendedor.setSelectedIndex(index);
//            
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
    
    private void inserir(){
        DaoPedido daoPedido = new DaoPedido();
        
        if (daoPedido.inserir(Integer.parseInt(tfId.getText()), tfData.getText(), String.valueOf(jcbVendedor.getSelectedItem()), Integer.parseInt(tfInstituto.getText()), Integer.parseInt(tfEmpresa.getText()), Integer.parseInt(tfNumeroProjeto.getText()), taEscopoProjeto.getText(), tfData.getText(), tfFormaPagamento.getText(), Double.parseDouble(tfValorProjeto.getText()), Double.parseDouble(tfCustoFixo.getText()), Double.parseDouble(tfCustoAdverso.getText()), Double.parseDouble(lblTotalCompra.getText()), Double.parseDouble(lblSubTotalDespesas.getText()), Double.parseDouble(lblSubTotalLiquido.getText()))){
            JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!");
            
            tfId.setText("");
            tfData.setText("");
            tfVendedor.setText("");
            tfInstituto.setText("");
            tfEmpresa.setText("");
            tfNumeroProjeto.setText("");
            taEscopoProjeto.setText("");
            tfPrazo.setText("");
            tfFormaPagamento.setText("");
            tfValorProjeto.setText("");
            tfCustoFixo.setText("");
            tfCustoAdverso.setText("");
            lblTotalCompra.setText("");
            lblSubTotalDespesas.setText("");
            lblSubTotalLiquido.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o pedido!");
        }   
    }
//    
    private void alterar(){
        DaoPedido daoPedido = new DaoPedido();
        
        if (daoPedido.alterar(Integer.parseInt(tfId.getText()), tfData.getText(), tfVendedor.getText(), Integer.parseInt(tfInstituto.getText()), Integer.parseInt(tfEmpresa.getText()), Integer.parseInt(tfNumeroProjeto.getText()), taEscopoProjeto.getText(), tfData.getText(), tfFormaPagamento.getText(), Double.parseDouble(tfValorProjeto.getText()), Double.parseDouble(tfCustoFixo.getText()), Double.parseDouble(tfCustoAdverso.getText()), Double.parseDouble(lblTotalCompra.getText()), Double.parseDouble(lblSubTotalDespesas.getText()), Double.parseDouble(lblSubTotalLiquido.getText()))){
            JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!");
            
            tfId.setText("");
            tfData.setText("");
            tfVendedor.setText("");
            tfInstituto.setText("");
            tfEmpresa.setText("");
            tfNumeroProjeto.setText("");
            taEscopoProjeto.setText("");
            tfPrazo.setText("");
            tfFormaPagamento.setText("");
            tfValorProjeto.setText("");
            tfCustoFixo.setText("");
            tfCustoAdverso.setText("");
            lblTotalCompra.setText("");
            lblSubTotalDespesas.setText("");
            lblSubTotalLiquido.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possivél salvar o pedido!");
        }   
    }
    
    private void excluir(){
        DaoPedido daoPedido = new DaoPedido();
        
        if(daoPedido.excluir(Integer.parseInt(tfId.getText())))
            JOptionPane.showMessageDialog(null, "Pedido excluiro com sucesso!");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o pedido!");
        
        ((ListPedido) Formularios.listPedido).listarTodos();
        
        dispose();
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
                jcbFormaPagamento.addItem(resultSet.getString("DESCRICAO"));
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

        JPanel = new javax.swing.JPanel();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcbFormaPagamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableConsultor = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        lblTotalCompra = new javax.swing.JLabel();
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
        tfData = new javax.swing.JFormattedTextField();
        tfVendedor = new javax.swing.JTextField();
        tfInstituto = new javax.swing.JTextField();
        tfEmpresa = new javax.swing.JTextField();
        tfFormaPagamento = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnInserirConsultor = new javax.swing.JButton();
        lblSubTotalDespesas = new javax.swing.JLabel();
        tfCustoAdverso = new javax.swing.JTextField();
        tfCustoFixo = new javax.swing.JTextField();
        tfValorProjeto = new javax.swing.JTextField();
        tfPrazo = new javax.swing.JFormattedTextField();
        lblSubTotalLiquido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableConsultor.setColumnSelectionAllowed(true);
        tableConsultor.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableConsultor);
        tableConsultor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel24.setText("Total");

        lblTotalCompra.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

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

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnExcluir.setText("Excluir");

        btnInserirConsultor.setText("Inserir Consultor");
        btnInserirConsultor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInserirConsultorMouseClicked(evt);
            }
        });
        btnInserirConsultor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirConsultorActionPerformed(evt);
            }
        });

        lblSubTotalDespesas.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSubTotalDespesas.setToolTipText("");

        tfCustoAdverso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCustoAdversoFocusLost(evt);
            }
        });

        tfCustoFixo.setEditable(false);
        tfCustoFixo.setEnabled(false);
        tfCustoFixo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCustoFixoFocusLost(evt);
            }
        });

        tfValorProjeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorProjetoFocusLost(evt);
            }
        });

        try {
            tfPrazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblSubTotalLiquido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSubTotalLiquido.setToolTipText("");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanelLayout.createSequentialGroup()
                                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfEndereco)
                                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(30, 30, 30)
                                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                            .addComponent(tfCnpj))))
                                .addGap(16, 16, 16)
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(30, 30, 30)
                                        .addComponent(tfCep))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTelefone))
                                    .addGroup(JPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(JPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfEstado))))
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jcbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jcbInstituto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel26)
                                        .addComponent(tfCustoAdverso, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                        .addComponent(tfPrazo))
                                    .addComponent(tfValorProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91)
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(JPanelLayout.createSequentialGroup()
                                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)
                                            .addComponent(btnInserirConsultor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfCustoFixo)))
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel22)
                                    .addGroup(JPanelLayout.createSequentialGroup()
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubTotalDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(461, 461, 461)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(169, 169, 169))
                            .addComponent(lblTotalCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JPanelLayout.createSequentialGroup()
                    .addGap(166, 166, 166)
                    .addComponent(lblSubTotalLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(551, Short.MAX_VALUE)))
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumeroProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCustoFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserirConsultor)
                    .addComponent(tfCustoAdverso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel24)
                            .addGroup(JPanelLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(32, 32, 32))
                            .addComponent(lblTotalCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnExcluir)))
                    .addComponent(lblSubTotalDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                    .addContainerGap(918, Short.MAX_VALUE)
                    .addComponent(lblSubTotalLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)))
        );

        lblSubTotalDespesas.getAccessibleContext().setAccessibleName("subTotalLiquidoProjeto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnInserirConsultorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirConsultorMouseClicked
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableConsultor.getModel();
        defaultTableModel.addRow(new Object[]{"","","","",""});
        
        DadosTemporarios.linhas = defaultTableModel.getRowCount();
        
        if (Formularios.cadConsultor == null)
            Formularios.cadConsultor = new CadConsultor();

        Formularios.cadConsultor.setModal(true);
        Formularios.cadConsultor.setVisible(true);
    }//GEN-LAST:event_btnInserirConsultorMouseClicked

    public void subTotalDespesas(){
                           
        lblSubTotalDespesas.setText("0.00");
//        tfCustoAdverso.setText("0.00");
//        Double custoAdverso = Double.parseDouble(tfCustoAdverso.getText());
//        Double custoFixo = Double.parseDouble(tfCustoFixo.getText());
//        Double totalConsultores = Double.parseDouble(lblTotalCompra.getText());
//        Double total = custoAdverso + custoFixo + totalConsultores;
//        
//        DecimalFormat df = new DecimalFormat("#.##");
//        
//        String calculaTtlFormatado = df.format(total);
//        
//        lblSubTotalDespesas.setText(calculaTtlFormatado);
        try {
            
            if(tfCustoAdverso.getText().equals(""))
                tfCustoAdverso.setText("0.0");
                    
            Double custoAdverso = Double.parseDouble(tfCustoAdverso.getText());
            Double custoFixo = Double.parseDouble(tfCustoFixo.getText());
            Double totalConsultores = Double.parseDouble(lblTotalCompra.getText());
            Double total = custoAdverso + custoFixo + totalConsultores;

            DecimalFormat df = new DecimalFormat("#.##");

            String calculaTtlFormatado = df.format(total);

            lblSubTotalDespesas.setText(calculaTtlFormatado);
            
            // Obtenha os valores como Strings dos campos de texto
//            String strCustoAdverso = tfCustoAdverso.getText();
//            String strCustoFixo = tfCustoFixo.getText();
//            String strTotalConsultores = lblTotalCompra.getText();
//
//            // Converta as Strings para Double
//            Double custoAdverso = Double.parseDouble(strCustoAdverso);
//            Double custoFixo = Double.parseDouble(strCustoFixo);
//            Double totalConsultores = Double.parseDouble(strTotalConsultores);
//
//            // Calcule o total
//            Double total = custoAdverso + custoFixo + totalConsultores;
//
//            // Defina o formato de moeda brasileira (Real)
//            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
//
//            // Formate o valor total para o padrão desejado (R$###.###,##)
//            String totalFormatado = formatoMoeda.format(total);
//            
//            // Atualize o componente de exibição (pode ser um JLabel, por exemplo)
//            lblSubTotalDespesas.setText(totalFormatado);
        } catch (NumberFormatException e) {
            // Trate exceções ao tentar converter as Strings para números
            System.err.println("Erro ao converter valores: " + e.getMessage());
        }        
    }
    
    public void subTotalLiquido(){
//        Double SubTotalDespesas = Double.parseDouble(lblSubTotalDespesas.getText());
//        Double ValorProjeto = Double.parseDouble(tfValorProjeto.getText());
//        Double total = ValorProjeto - SubTotalDespesas;
//        
//        DecimalFormat df = new DecimalFormat("#.##");
//        
//        String calculaTtlFormatado = df.format(total);
//        
//        lblSubTotalLiquido.setText(calculaTtlFormatado);

       try {
            Double SubTotalDespesas = Double.parseDouble(lblSubTotalDespesas.getText());
            Double ValorProjeto = Double.parseDouble(tfValorProjeto.getText());
            Double total = ValorProjeto - SubTotalDespesas;

            DecimalFormat df = new DecimalFormat("#.##");

            String calculaTtlFormatado = df.format(total);

            lblSubTotalLiquido.setText(calculaTtlFormatado);

           
            // Obtenha os valores como Strings dos componentes
//            String strSubTotalDespesas = lblSubTotalDespesas.getText();
//            String strValorProjeto = tfValorProjeto.getText();
//
//            // Remove caracteres não numéricos e substitui a vírgula apenas se seguida por dígitos
//            String cleanedSubTotalDespesas = strSubTotalDespesas.replaceAll("[^\\d,]", "");
//            String cleanedValorProjeto = strValorProjeto.replaceAll("[^\\d,]", "");
//
//            // Converta as Strings para Double
//            Double subTotalDespesas = NumberFormat.getInstance(Locale.getDefault()).parse(cleanedSubTotalDespesas).doubleValue();
//            Double valorProjeto = NumberFormat.getInstance(Locale.getDefault()).parse(cleanedValorProjeto).doubleValue();
//
//            // Calcule o total
//            Double totalLiquido = valorProjeto - subTotalDespesas;
//
//            // Defina o formato de moeda brasileira (Real)
//            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
//
//            // Formate o valor total para o padrão desejado (R$###.###,##)
//            String totalLiquidoFormatado = formatoMoeda.format(totalLiquido);
//
//            // Atualize o componente de exibição (pode ser um JLabel, por exemplo)
//            lblSubTotalLiquido.setText(totalLiquidoFormatado);
        } catch (NumberFormatException e) {
            // Trate exceções ao converter as Strings para números
            System.err.println("Erro ao converter valores: " + e.getMessage());
        }
        
    }
        
    private void custoFixo(){
        Double ValorProjeto = Double.parseDouble(tfValorProjeto.getText());
        float porcentagem = 0.2f;
        
        Double custoAdverso = ValorProjeto * porcentagem;
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        String custoAdvFormatado = df.format(custoAdverso);
        
        tfCustoFixo.setText(custoAdvFormatado);
             
    }
    
    public void insereConsultor(){
    
        if(DadosTemporarios.tempObject != null){
    //            JOptionPane.showMessageDialog(null, ((ModConsultor) DadosTemporarios.tempObject).getNome());

            String id = String.valueOf(((ModConsultor) DadosTemporarios.tempObject).getId());
            String nome = ((ModConsultor) DadosTemporarios.tempObject).getNome();
            String dataInicio = ((ModConsultor) DadosTemporarios.tempObject).getDataInicio();
            String dataTermino = ((ModConsultor) DadosTemporarios.tempObject).getDataTermino();
            String preco = String.valueOf(((ModConsultor) DadosTemporarios.tempObject).getPreco());

            tableConsultor.setValueAt(id, DadosTemporarios.linhas -1, 0);
            tableConsultor.setValueAt(nome, DadosTemporarios.linhas -1, 1);
            tableConsultor.setValueAt(dataInicio, DadosTemporarios.linhas -1, 2);
            tableConsultor.setValueAt(dataTermino, DadosTemporarios.linhas -1, 3);
            tableConsultor.setValueAt(preco, DadosTemporarios.linhas -1, 4);
        }
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        DaoPedido daoPedido = new DaoPedido();
       
        if (btnSalvar.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            tfId.setText(String.valueOf(daoPedido.buscarProximoId()));
        }else if(btnSalvar.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            ((ListPedido) Formularios.listPedido).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jcbFormaPagamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFormaPagamentoItemStateChanged
        recuperaFormaPagamento();
    }//GEN-LAST:event_jcbFormaPagamentoItemStateChanged

    private void tfValorProjetoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorProjetoFocusLost
        custoFixo();
        somarPrecos();
        subTotalDespesas();
        subTotalLiquido();
    }//GEN-LAST:event_tfValorProjetoFocusLost

    private void btnInserirConsultorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirConsultorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInserirConsultorActionPerformed

    private void tfCustoFixoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCustoFixoFocusLost
        custoFixo();
        
    }//GEN-LAST:event_tfCustoFixoFocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Formularios.cadPedido = null;
    }//GEN-LAST:event_formWindowClosed

    private void tfCustoAdversoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCustoAdversoFocusLost
        insereConsultor();
        somarPrecos();
        subTotalDespesas();
        subTotalLiquido();
    }//GEN-LAST:event_tfCustoAdversoFocusLost
     
    
    public void somarPrecos() {
        double soma = 0.0;
        
        for (int i = 0; i < tableConsultor.getRowCount(); i++) {
            // Obtém o valor da coluna de preços na linha atual
            String precoStr = (String) tableConsultor.getValueAt(i, 4);

            // Converte o valor para um número (double)
            double preco = Double.parseDouble(precoStr);

            // Soma ao total
            soma += preco;
        }
        
        lblTotalCompra.setText(String.valueOf(soma));
    }
    
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
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserirConsultor;
    private javax.swing.JButton btnSalvar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcbEmpresa;
    private javax.swing.JComboBox<String> jcbFormaPagamento;
    private javax.swing.JComboBox<String> jcbInstituto;
    private javax.swing.JComboBox<String> jcbVendedor;
    private javax.swing.JLabel lblSubTotalDespesas;
    private javax.swing.JLabel lblSubTotalLiquido;
    private javax.swing.JLabel lblTotalCompra;
    private javax.swing.JTextArea taEscopoProjeto;
    private javax.swing.JTable tableConsultor;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JFormattedTextField tfCnpj;
    private javax.swing.JTextField tfCustoAdverso;
    private javax.swing.JTextField tfCustoFixo;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmpresa;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfFormaPagamento;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfInstituto;
    private javax.swing.JTextField tfNumeroProjeto;
    private javax.swing.JFormattedTextField tfPrazo;
    private javax.swing.JFormattedTextField tfTelefone;
    private javax.swing.JTextField tfValorProjeto;
    private javax.swing.JTextField tfVendedor;
    // End of variables declaration//GEN-END:variables
}
