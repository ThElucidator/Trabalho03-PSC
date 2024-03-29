/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;

import BackEnd.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CaPacientesEntrada extends javax.swing.JDialog {

    /**
     * Creates new form FoAdicionarAlunos
     */
    
    private Conexao c;
    private Integer CodPaciente;
    
    public CaPacientesEntrada(Integer CodPaciente) {
        initComponents();
        this.setModal(true);
        this.c = new Conexao();
        this.CodPaciente = CodPaciente;
        
        //Edição
        if (CodPaciente!=-1) {
            this.setTitle("Editar");
            btnCadastrar.setText("Editar");
            
            //Carregar os campos
            try {
                String SQL = " SELECT nomepaciente,CPFpaciente,enderecopaciente,contatospaciente,observacoespaciente FROM pacientes WHERE idpaciente = " + CodPaciente;
                this.c.setResultSet(SQL);
                this.c.getResultSet().first();
                txtNome.setText(this.c.getResultSet().getString("nomepaciente"));    
                txtCPF.setText(this.c.getResultSet().getString("CPFpaciente")); 
                txtEndereco.setText(this.c.getResultSet().getString("enderecopaciente"));
                txtCelular.setText(this.c.getResultSet().getString("contatospaciente")); 
                txtObservacoes.setText(this.c.getResultSet().getString("observacoespaciente")); 
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
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

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        txtCelular = new javax.swing.JFormattedTextField();
        lblCelular = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtObservacoes = new javax.swing.JTextField();
        lblEndereco1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar");

        lblNome.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCelular.setText("Celular");

        lblCPF.setText("CPF");

        lblEndereco.setText("Endereço");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacoesActionPerformed(evt);
            }
        });

        lblEndereco1.setText("Observações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtObservacoes)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(lblCPF)
                            .addComponent(lblEndereco)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular)
                            .addComponent(btnCadastrar)
                            .addComponent(txtCPF))
                        .addComponent(lblEndereco1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCPF)
                .addGap(12, 12, 12)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCelular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informar o Nome do Paciente");
            txtNome.requestFocus();
        }
        else if(txtCPF.getText().equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(this,"Informar o CPF do Paciente");
        }
        else if(txtEndereco.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Informar o Endereço do Paciente");
        }
        else if(txtCelular.getText().equals("(  )     -    ")){
            JOptionPane.showMessageDialog(this,"Informar o Celular do Paciente");
        }
        else {       
            String SQL;
            String Msg;
            
            //Cadastrar
            if (this.CodPaciente == -1) {
                Msg = "Registro adicionado com sucesso";
                SQL = "INSERT INTO pacientes (nomepaciente,CPFpaciente,contatospaciente,enderecopaciente,observacoespaciente) VALUES ('"+ txtNome.getText() +"','"+ txtCPF.getText() +"','"+ txtCelular.getText() +"','"+ txtEndereco.getText() +"','"+ txtObservacoes.getText() +"')";
            }
            //Editar
            else {
                Msg = "Registro editado com sucesso";
                SQL = "UPDATE pacientes SET nomepaciente = '"+txtNome.getText()+"',CPFpaciente = '"+txtCPF.getText()+"',contatospaciente = '"+txtCelular.getText()+"',enderecopaciente = '"+txtEndereco.getText()+"',observacoespaciente = '"+txtObservacoes.getText()+"' WHERE idpaciente = "+CodPaciente;                              
            }
            this.c.SQLExecute(SQL);
            JOptionPane.showMessageDialog(this, Msg);
            this.dispose();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacoesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEndereco1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtObservacoes;
    // End of variables declaration//GEN-END:variables
}
