/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Tpedidos extends javax.swing.JInternalFrame {
    Connection conexao=null;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    public Tpedidos() {
        initComponents();
        conexao = ModuloConexao.conector();
        limpaTela();
    }
    private void buscarCliente(){
            String sql = "select * from clientes where cpfcnpj=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCpfCnpjP.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    txtCpfCnpjP.setText(rs.getString(1)); 
                    txtNomeP.setText(rs.getString(2)); 
                    txtContatoP.setText(rs.getString(3));
                    txtNumeroP.setText(rs.getString(4));
                    txtEnderecoP.setText(rs.getString(5));
                    txtBairroP.setText(rs.getString(6));
                    txtCidadeP.setText(rs.getString(7));
                    BoxEstadoP.setSelectedItem(rs.getString(8));
                    txtEmailP.setText(rs.getString(10));
                    txtCepP.setText(rs.getString(11));
                   
                }else{
                    JOptionPane.showMessageDialog(null,"Cliente não cadastrado :(");
                    //as linhas abaixo limpa os campos
                    txtCpfCnpjP.setText(null);
                    txtNomeP.setText(null);
                    txtContatoP.setText(null);
                    txtNumeroP.setText(null);
                    txtEnderecoP.setText(null);
                    txtBairroP.setText(null);
                    txtCidadeP.setText(null);
                    BoxEstadoP.setSelectedItem(null);
                    txtEmailP.setText(null);
                    txtCepP.setText(null);
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    private void buscarPed(){
            String sql = "select * from pedidos where idpedidos=?";
            try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtAtend.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                BtnLimpar1.setVisible(true);
                txtAtend.setText(rs.getString(1)); 
                txtQuant.setText(rs.getString(2)); 
                BoxPaga.setSelectedItem(rs.getString(3));
                txtPrazo.setText(rs.getString(4));
                txtDescricao.setText(rs.getString(5));
                BoxFase.setSelectedItem(rs.getString(6));
                txtValor.setText(rs.getString(7));
                BoxProd.setSelectedItem(rs.getString(8));
                txtMaterial.setText(rs.getString(9));
                txtCpfCnpjP.setText(rs.getString(10));
                   
                }else{
                    JOptionPane.showMessageDialog(null,"Pedido não encontrado :(");
                    txtQuant.setText(null);
                    BoxPaga.setSelectedItem(null);
                    txtPrazo.setText(null);
                    txtDescricao.setText(null);
                    BoxFase.setSelectedItem(null);
                    txtValor.setText(null);
                    txtMaterial.setText(null);
                    BoxPaga.setSelectedItem(null);
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
      //salvar pedido
    private void addpedi(){
            String sql = "insert into pedidos(quantidade,sitpagar,prazo,complementoped,statusped,valor,tipprod,tipmat,clientes_cpfcnpj) values(?,?,?,?,?,?,?,?,?)";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1,BtnSalvar.getText());
                pst.setString(1,txtQuant.getText());
                pst.setString(2,BoxPaga.getSelectedItem().toString());
                pst.setString(3,txtPrazo.getText());
                pst.setString(4,txtDescricao.getText());
                pst.setString(5,BoxFase.getSelectedItem().toString());
                pst.setString(6,txtValor.getText());
                pst.setString(7,BoxProd.getSelectedItem().toString());
                pst.setString(8,txtMaterial.getText());
                pst.setString(9,txtCpfCnpjP.getText());
                
                //a estrutura abaixo e usada para confirma a insercao de dados na tabela
                int adicionado = pst.executeUpdate();
                if (adicionado >0){
                    JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso ;)");
                    txtQuant.setText(null);
                    BoxPaga.setSelectedItem(null);
                    txtPrazo.setText(null);
                    txtDescricao.setText(null);
                    BoxFase.setSelectedItem(null);
                    txtValor.setText(null);
                    BoxProd.setSelectedItem(null);
                    BoxPaga.setSelectedItem(null);
                    txtMaterial.setText(null);
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    private void limpaTela(){
      //limpa tabela de pedidos
      BtnLimpar1.setVisible(false);
        txtCpfCnpjP.setText(null);
        txtNomeP.setText(null);
        txtContatoP.setText(null);
        txtNumeroP.setText(null);
        txtEnderecoP.setText(null);
        txtBairroP.setText(null);
        txtCidadeP.setText(null);
        BoxEstadoP.setSelectedItem(null);
        txtEmailP.setText(null);
        txtCepP.setText(null);
      //limpa tabela de pedidos
        txtQuant.setText(null);
        BoxPaga.setSelectedItem(null);
        txtPrazo.setText(null);
        txtDescricao.setText(null);
        BoxFase.setSelectedItem(null);
        txtValor.setText(null);
        BoxProd.setSelectedItem(null);
        txtMaterial.setText(null);
       
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
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNomeP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpfCnpjP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContatoP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmailP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEnderecoP = new javax.swing.JTextField();
        txtNumeroP = new javax.swing.JTextField();
        txtBairroP = new javax.swing.JTextField();
        txtCidadeP = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        BoxProd = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        BoxTamanho = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCepP = new javax.swing.JTextField();
        BtnSalvar = new javax.swing.JButton();
        BoxEstadoP = new javax.swing.JComboBox<>();
        BtnEntrar1 = new javax.swing.JButton();
        BoxFase = new javax.swing.JComboBox<>();
        txtPrazo = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        BoxPaga = new javax.swing.JComboBox<>();
        txtMaterial = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        BtnEntrar3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtAtend = new javax.swing.JTextField();
        BtnLimpar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 236, 236));
        setClosable(true);
        setPreferredSize(new java.awt.Dimension(833, 600));

        jPanel1.setBackground(new java.awt.Color(254, 236, 236));

        jPanel3.setBackground(new java.awt.Color(236, 92, 92));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Pedidos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(102, 102, 255));

        txtNomeP.setBackground(new java.awt.Color(0, 0, 0));
        txtNomeP.setForeground(new java.awt.Color(255, 255, 255));
        txtNomeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        txtCpfCnpjP.setBackground(new java.awt.Color(0, 0, 0));
        txtCpfCnpjP.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("CPF/CNPJ:");

        txtContatoP.setBackground(new java.awt.Color(0, 0, 0));
        txtContatoP.setForeground(new java.awt.Color(255, 255, 255));
        txtContatoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContatoPActionPerformed(evt);
            }
        });

        jLabel4.setText("Contato:");

        txtEmailP.setBackground(new java.awt.Color(0, 0, 0));
        txtEmailP.setForeground(new java.awt.Color(255, 255, 255));
        txtEmailP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailPActionPerformed(evt);
            }
        });

        jLabel5.setText("Email:");

        jLabel6.setText("Endereço:");

        jLabel7.setText("N°:");

        jLabel8.setText("Bairro:");

        jLabel9.setText("Cidade:");

        jLabel10.setText("UF:");

        txtEnderecoP.setBackground(new java.awt.Color(0, 0, 0));
        txtEnderecoP.setForeground(new java.awt.Color(255, 255, 255));
        txtEnderecoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoPActionPerformed(evt);
            }
        });

        txtNumeroP.setBackground(new java.awt.Color(0, 0, 0));
        txtNumeroP.setForeground(new java.awt.Color(255, 255, 255));

        txtBairroP.setBackground(new java.awt.Color(0, 0, 0));
        txtBairroP.setForeground(new java.awt.Color(255, 255, 255));

        txtCidadeP.setBackground(new java.awt.Color(0, 0, 0));
        txtCidadeP.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        BoxProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CAMISA", "BERMUDA", "CALÇA" }));
        BoxProd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BoxProdItemStateChanged(evt);
            }
        });
        BoxProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxProdActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo do Produto:");

        jLabel12.setText("Tipo do Material:");

        jLabel15.setText("Prazo:");

        jLabel16.setText("Quantidade:");

        txtQuant.setBackground(new java.awt.Color(0, 0, 0));
        txtQuant.setForeground(new java.awt.Color(255, 255, 255));
        txtQuant.setBorder(null);
        txtQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantActionPerformed(evt);
            }
        });

        jLabel17.setText("Tamanho:");

        BoxTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "P", "M", "G", "GG" }));

        jLabel18.setText("Fase:");

        jLabel19.setText("Descrição:");

        txtDescricao.setBackground(new java.awt.Color(0, 0, 0));
        txtDescricao.setColumns(20);
        txtDescricao.setForeground(new java.awt.Color(255, 255, 255));
        txtDescricao.setRows(5);
        jScrollPane3.setViewportView(txtDescricao);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Valor do Orçamento:");

        txtValor.setBackground(new java.awt.Color(0, 0, 0));
        txtValor.setForeground(new java.awt.Color(255, 255, 255));
        txtValor.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        jLabel22.setText("CEP:");

        txtCepP.setBackground(new java.awt.Color(0, 0, 0));
        txtCepP.setForeground(new java.awt.Color(255, 255, 255));

        BtnSalvar.setBackground(new java.awt.Color(236, 92, 92));
        BtnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnSalvar.setText("Salvar");
        BtnSalvar.setBorder(null);
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });

        BoxEstadoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));

        BtnEntrar1.setBackground(new java.awt.Color(236, 92, 92));
        BtnEntrar1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BtnEntrar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnEntrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/magnifier.png"))); // NOI18N
        BtnEntrar1.setBorder(null);
        BtnEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrar1ActionPerformed(evt);
            }
        });

        BoxFase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PEDIDO COLETADO", "EM PREPARAÇÃO", "PRONTO PARA ENTREGA", "ENTREGA", " " }));

        txtPrazo.setBackground(new java.awt.Color(0, 0, 0));
        txtPrazo.setForeground(new java.awt.Color(255, 255, 255));
        txtPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrazoActionPerformed(evt);
            }
        });

        jLabel23.setText("Situação do pagamento:");

        BoxPaga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PAGO", "A PAGAR", "PARCIALMENTE PAGO" }));
        BoxPaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxPagaActionPerformed(evt);
            }
        });

        txtMaterial.setBackground(new java.awt.Color(0, 0, 0));
        txtMaterial.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(236, 92, 92));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        BtnEntrar3.setBackground(new java.awt.Color(0, 0, 0));
        BtnEntrar3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BtnEntrar3.setForeground(new java.awt.Color(255, 255, 255));
        BtnEntrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/magnifier.png"))); // NOI18N
        BtnEntrar3.setBorder(null);
        BtnEntrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrar3ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("CODIGO DE ATENDIMENTO:");

        txtAtend.setBackground(new java.awt.Color(0, 0, 0));
        txtAtend.setForeground(new java.awt.Color(255, 255, 255));

        BtnLimpar1.setBackground(new java.awt.Color(0, 0, 0));
        BtnLimpar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnLimpar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnLimpar1.setText("Limpar");
        BtnLimpar1.setBorder(null);
        BtnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(BtnEntrar3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnEntrar3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtAtend)
                    .addComponent(BtnLimpar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(BtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCpfCnpjP, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(BtnEntrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(139, 139, 139))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(116, 116, 116))
                                                .addComponent(txtEnderecoP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel7)
                                                    .addComponent(txtNumeroP, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22)
                                                    .addComponent(txtCepP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel3))))
                                    .addComponent(txtNomeP, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(BoxProd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(BoxFase, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtMaterial))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(BoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel17)))
                                            .addComponent(jLabel15)
                                            .addComponent(txtPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtContatoP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmailP, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(BoxPaga, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairroP, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCidadeP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(BoxEstadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtNomeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtContatoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmailP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(BtnEntrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtCpfCnpjP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCepP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBairroP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidadeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnderecoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BoxEstadoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxPaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtValor)
                                .addGap(1, 1, 1))
                            .addComponent(BtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePActionPerformed

    private void txtEnderecoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoPActionPerformed

    private void BoxProdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BoxProdItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxProdItemStateChanged

    private void BoxProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxProdActionPerformed

    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed
 // TODO add your handling code here:
        addpedi();
    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void BtnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrar1ActionPerformed
        // TODO add your handling code here:
        buscarCliente();
    }//GEN-LAST:event_BtnEntrar1ActionPerformed

    private void BtnEntrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrar3ActionPerformed
        // TODO add your handling code here:
        
        buscarPed();
        buscarCliente();
    }//GEN-LAST:event_BtnEntrar3ActionPerformed

    private void txtPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrazoActionPerformed

    private void BoxPagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxPagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxPagaActionPerformed

    private void txtContatoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContatoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContatoPActionPerformed

    private void txtEmailPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailPActionPerformed

    private void txtQuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantActionPerformed

    private void BtnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpar1ActionPerformed
        // TODO add your handling code here:
        limpaTela();
    }//GEN-LAST:event_BtnLimpar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxEstadoP;
    private javax.swing.JComboBox<String> BoxFase;
    private javax.swing.JComboBox<String> BoxPaga;
    private javax.swing.JComboBox<String> BoxProd;
    private javax.swing.JComboBox<String> BoxTamanho;
    private javax.swing.JButton BtnEntrar1;
    private javax.swing.JButton BtnEntrar3;
    private javax.swing.JButton BtnLimpar1;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAtend;
    private javax.swing.JTextField txtBairroP;
    private javax.swing.JTextField txtCepP;
    private javax.swing.JTextField txtCidadeP;
    private javax.swing.JTextField txtContatoP;
    private javax.swing.JTextField txtCpfCnpjP;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtEmailP;
    private javax.swing.JTextField txtEnderecoP;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtNomeP;
    private javax.swing.JTextField txtNumeroP;
    private javax.swing.JFormattedTextField txtPrazo;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
