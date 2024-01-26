/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;

import BackEnd.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class CaEspera extends javax.swing.JDialog {

    /**
     * Creates new form FoAdicionarAlunos
     */
    
    private Conexao c;
    private Integer Espera;
    private Integer SelectCodEspera = Espera;
    
    public CaEspera(Integer Espera) {
        initComponents();
        this.setModal(true);
        this.c = new Conexao();
        this.Espera = Espera;
    
    //Carregar combobox
        
        this.c.setComboBoxConsultasCondicional(CBAgendamento, "consultas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovoPaciente = new javax.swing.JButton();
        CBAgendamento = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        lblAgendamento = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        lblAgendamento1 = new javax.swing.JLabel();
        lblAgendamento2 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar");

        btnNovoPaciente.setText("Novo");
        btnNovoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPacienteActionPerformed(evt);
            }
        });

        CBAgendamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBAgendamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBAgendamentoItemStateChanged(evt);
            }
        });
        CBAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBAgendamentoActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblAgendamento.setText("Nome do Paciente:");

        txtNome.setEditable(false);

        txtData.setEditable(false);

        lblAgendamento1.setText("Selecione o Agendamento:");

        lblAgendamento2.setText("Data da Consulta:");

        btnAtualizar.setText("Atualizar Entradas");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgendamento1)
                    .addComponent(lblAgendamento2)
                    .addComponent(lblAgendamento)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBAgendamento, javax.swing.GroupLayout.Alignment.LEADING, 0, 300, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(18, 18, 18)
                        .addComponent(btnNovoPaciente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblAgendamento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoPaciente))
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAgendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAgendamento2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastrar)
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPacienteActionPerformed
        // TODO add your handling code here:
        new CaAgendamentoEntrada(-1).setVisible(true);
        this.c.setComboBoxConsultasCondicional(CBAgendamento, "consultas");
    }//GEN-LAST:event_btnNovoPacienteActionPerformed

    private void CBAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBAgendamentoActionPerformed
       
    }//GEN-LAST:event_CBAgendamentoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (CBAgendamento.getSelectedItem()==null) {
            JOptionPane.showMessageDialog(this, "Selecione a Consulta");
            CBAgendamento.requestFocus();
        }
        else {
            
            String SQL = "";
            String Msg = "";
            //Cadastrar
            if (this.Espera == -1) {
                
                Msg = "Registro adicionado com sucesso";
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now();  
                SQL = "UPDATE consultas SET horariochegada = '"+dtf.format(now)+"', situacaoconsulta = 'em espera' WHERE idconsulta = " + CBAgendamento.getSelectedItem();
            } 
            System.out.println(SQL);
            this.c.SQLExecute(SQL);
            
            JOptionPane.showMessageDialog(this, Msg);
            this.dispose();
        }
        
    
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        //Carregar os campos
    if(CBAgendamento.getSelectedItem()!= null)  { 
        try {
            String SQL2 = " SELECT P.nomepaciente,C.dataconsulta FROM consultas as C INNER JOIN pacientes as P ON C.idpaciente = P.idpaciente WHERE C.idconsulta = "+CBAgendamento.getSelectedItem();
            this.c.setResultSet(SQL2);
            this.c.getResultSet().first();
            txtNome.setText(this.c.getResultSet().getString("P.nomepaciente"));  
            txtData.setText(this.c.getResultSet().getString("C.dataconsulta"));
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void CBAgendamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBAgendamentoItemStateChanged
       
    }//GEN-LAST:event_CBAgendamentoItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBAgendamento;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnNovoPaciente;
    private javax.swing.JLabel lblAgendamento;
    private javax.swing.JLabel lblAgendamento1;
    private javax.swing.JLabel lblAgendamento2;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
