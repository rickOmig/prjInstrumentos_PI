/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lojainstrumentos.view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lojainstrumentos.dao.ProdutosDAO;
import lojainstrumentos.dao.VendasDAO;
import lojainstrumentos.model.Produto;
import lojainstrumentos.model.Venda;

/**
 *
 * @author alves
 */
public class TelaVendaProdutos extends javax.swing.JDialog {

    /**
     * Creates new form TelaVendaProdutos
     */
    public TelaVendaProdutos() {
        initComponents();
        readTabela();
    }

    public void readTabela() {
        //Chama DAO para consulta
        ArrayList<Produto> lista = ProdutosDAO.listarProduto();

        DefaultTableModel modelo = (DefaultTableModel) tableProdutos.getModel();

        //Zera tabela
        modelo.setRowCount(0);

        //Adicionar linhas com for
        for (Produto item : lista) {
            modelo.addRow(new String[]{
                String.valueOf(item.getCodigoProd()),
                String.valueOf(item.getNomeProd()),
                String.valueOf(item.getQuantidadeProd()),
                String.valueOf(item.getPrecoProd()),
                String.valueOf(item.getDescricaoProd())
            }
            );
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
        lblDigiteCPF = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCarrinho = new javax.swing.JTable();
        btnFinalizarCompra = new javax.swing.JButton();
        jtxtCampo_CPF = new javax.swing.JFormattedTextField();
        TelaVendas = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        jtxtValorTotal = new javax.swing.JFormattedTextField();
        spnQuantidade = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(600, 300));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(5, 41, 32));

        lblDigiteCPF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDigiteCPF.setForeground(new java.awt.Color(255, 255, 255));
        lblDigiteCPF.setText("ID do Cliente:");

        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantidade.setText("Quantidade :");

        tableCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "QTD", "PREÇO UNI.", "DESCRIÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCarrinho);

        btnFinalizarCompra.setBackground(new java.awt.Color(136, 115, 70));
        btnFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarCompra.setText("FINALIZAR COMPRA");
        btnFinalizarCompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        try {
            jtxtCampo_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtCampo_CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCampo_CPFActionPerformed(evt);
            }
        });

        TelaVendas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TelaVendas.setForeground(new java.awt.Color(255, 255, 255));
        TelaVendas.setText("TELA DE VENDAS");

        lblValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblValorTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblValorTotal.setText("VALOR TOTAL : ");

        jtxtValorTotal.setEditable(false);
        jtxtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtValorTotalActionPerformed(evt);
            }
        });

        spnQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "ESTOQUE", "PREÇO", "DESCRICAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableProdutos);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TelaVendas)
                .addGap(231, 231, 231))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblValorTotal)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDigiteCPF)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtCampo_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionar))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnFinalizarCompra)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(0, 79, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TelaVendas)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQuantidade)
                        .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtCampo_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdicionar))
                    .addComponent(lblDigiteCPF))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorTotal)
                    .addComponent(btnFinalizarCompra))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        boolean retorno = false;
        try {
            // validação obrigatoria
            if (tableCarrinho.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Adicione ao menos um produto ao carrinho!");
            }

            if (jtxtCampo_CPF.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite o ID!");
            }

            Venda vendas = new Venda();

            int linhaSelecionada = tableCarrinho.getSelectedRow();

            /*DefaultTableModel modelo = (DefaultTableModel) tableCarrinho.getModel();
            int id = Integer.parseInt(modelo.getValueAt(linhaSelecionada, 0).toString());
            String nome = (modelo.getValueAt(linhaSelecionada, 1).toString());
            int qtdEstoque = Integer.parseInt(modelo.getValueAt(linhaSelecionada, 2).toString());
            double preco = Double.parseDouble(modelo.getValueAt(linhaSelecionada, 3).toString());
            String descricao = (modelo.getValueAt(linhaSelecionada, 4).toString());
            double qtdTotal = (Integer) spnQuantidade.getValue();
            int idCliente = Integer.parseInt(jtxtCampo_CPF.getText());
            double precoTotal = preco * qtdTotal;*/
            //vendas.setidProd(id);
            DefaultTableModel carrinho = (DefaultTableModel) tableCarrinho.getModel();
            ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
            for (int i = 0; i < tableCarrinho.getRowCount(); i++) {
                Venda obj = new Venda();
                obj.setidProd(Integer.parseInt(carrinho.getValueAt(i, 0).toString()));
                obj.setProdutoVendido(carrinho.getValueAt(i, 1).toString());
                double qtd = Double.parseDouble(String.valueOf((carrinho.getValueAt(i, 2))));
                obj.setQuantidadeVenda(qtd);
                double valor = Double.parseDouble(String.valueOf((carrinho.getValueAt(i, 3))));
                obj.setValorTotal(valor * qtd);
                obj.setDescricaoProd(carrinho.getValueAt(i, 4).toString());
                obj.setIdCliente(Integer.parseInt(jtxtCampo_CPF.getText()));

                //Passo o objeto para a lista de retorno
                //listaRetorno.add(obj);
                retorno = VendasDAO.salvarVenda(obj);

            }

            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Compra efetuada!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Erro ao efetuar compra!");
            }

            //Implementar DAO
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro no sql: " + ex);
        }

    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private void jtxtCampo_CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCampo_CPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCampo_CPFActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int linhaSelecionada = tableProdutos.getSelectedRow();
        DefaultTableModel carrinho = (DefaultTableModel) tableCarrinho.getModel();
        DefaultTableModel produtos = (DefaultTableModel) tableProdutos.getModel();
        Object[] dados = {produtos.getValueAt(linhaSelecionada, 0).toString(),
            produtos.getValueAt(linhaSelecionada, 1).toString(),
            spnQuantidade.getValue(),
            produtos.getValueAt(linhaSelecionada, 3).toString(),
            produtos.getValueAt(linhaSelecionada, 4).toString()};

        double quantidade = +Double.parseDouble(spnQuantidade.getValue().toString());
        double precoUnitario = +Double.parseDouble(produtos.getValueAt(linhaSelecionada, 3).toString());
        double valorTotal = precoUnitario * quantidade;
        carrinho.addRow(dados);

        jtxtValorTotal.setText(String.valueOf(valorTotal));
        /*ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
        for (int i = 0; i <= tableCarrinho.getRowCount(); i++) {
            Venda obj = new Venda();
            obj.setidProd((Integer) carrinho.getValueAt(i, 0));
            obj.setProdutoVendido(carrinho.getValueAt(i, 1).toString());
            obj.setQuantidadeVenda((Integer) carrinho.getValueAt(i, 2));
            obj.setValorTotal((Integer) carrinho.getValueAt(i, 3));
            obj.setDescricaoProd(carrinho.getValueAt(i, 4).toString());

            //Passo o objeto para a lista de retorno
            listaRetorno.add(obj);}*/


    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jtxtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtValorTotalActionPerformed

    }//GEN-LAST:event_jtxtValorTotalActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.tableCarrinho.getModel();
        model.removeRow(tableCarrinho.getSelectedRow());
    }//GEN-LAST:event_btnRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVendaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendaProdutos().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TelaVendas;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btnRemover;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField jtxtCampo_CPF;
    private javax.swing.JFormattedTextField jtxtValorTotal;
    private javax.swing.JLabel lblDigiteCPF;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JTable tableCarrinho;
    private javax.swing.JTable tableProdutos;
    // End of variables declaration//GEN-END:variables
}
