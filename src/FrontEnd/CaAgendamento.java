/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;

import BackEnd.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CaAgendamento extends javax.swing.JDialog {

    private Conexao c;
    
    public CaAgendamento() {
        initComponents();
        this.setModal(true);
        this.c = new Conexao();
        this.GetListarConsultas();
    }
    
    private void GetListarConsultas() {
        DefaultTableModel d = (DefaultTableModel) grdAgendamento.getModel();
        
        //Limpar linhas
        while(d.getRowCount() > 0)
            d.removeRow(0);
        
        //Definir SQL
        this.c.setResultSet("SELECT * FROM consultas as C INNER JOIN pacientes as P ON C.idpaciente = P.idpaciente");
        
        //Mostrar resultado
        try {
            if (this.c.getResultSet().first()) {
                do {
                    d.addRow(
                       new Object[] {
                           this.c.getResultSet().getString("C.idconsulta"),
                           this.c.getResultSet().getString("C.dataconsulta"),
                           this.c.getResultSet().getString("P.nomepaciente")
                       }
                    );                 
                } while(this.c.getResultSet().next());
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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

        btnNovoAgendamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdAgendamento = new javax.swing.JTable();
        btnEditarAgendamento = new javax.swing.JButton();
        btnExclAgendamento = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuarios");

        btnNovoAgendamento.setText("Novo Agendamento");
        btnNovoAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAgendamentoActionPerformed(evt);
            }
        });

        grdAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Data", "Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grdAgendamento);

        btnEditarAgendamento.setText("Editar Agendamento");
        btnEditarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAgendamentoActionPerformed(evt);
            }
        });

        btnExclAgendamento.setText("Excluir Agendamento");
        btnExclAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExclAgendamentoActionPerformed(evt);
            }
        });

        btnMenu.setText("Retornar ao Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnNovoAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnMenu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnEditarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnExclAgendamento))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoAgendamento)
                    .addComponent(btnEditarAgendamento)
                    .addComponent(btnExclAgendamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnNovoAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAgendamentoActionPerformed
        // TODO add your handling code here:
        new CaAgendamentoEntrada(-1).setVisible(true);
        this.GetListarConsultas();
    }//GEN-LAST:event_btnNovoAgendamentoActionPerformed

    private void btnEditarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAgendamentoActionPerformed
        // TODO add your handling code here:
        if (grdAgendamento.getRowCount() > 0) {
            if (grdAgendamento.getSelectedRowCount() > 0) {
                String Consulta = String.valueOf(grdAgendamento.getValueAt(grdAgendamento.getSelectedRow(), 0));
                new CaAgendamentoEntrada(Integer.valueOf(Consulta)).setVisible(true);
                this.GetListarConsultas();
            }
            else
                JOptionPane.showMessageDialog(this, "Selecionar uma consulta");
        }
        else
            JOptionPane.showMessageDialog(this, "Não existem consultas cadastradas");   
    }//GEN-LAST:event_btnEditarAgendamentoActionPerformed

    private void btnExclAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExclAgendamentoActionPerformed
        // TODO add your handling code here:
        if (grdAgendamento.getRowCount() > 0) {
            if (grdAgendamento.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this, 
                        "Confirmar exclusão da consulta?", 
                        "Excluir", 
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            String Consulta = String.valueOf(grdAgendamento.getValueAt(grdAgendamento.getSelectedRow(), 0));
                            this.c.SQLExecute("DELETE FROM consultas WHERE idconsulta = " + Consulta);
                            this.GetListarConsultas();
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Selecionar uma consulta");
        }
        else
            JOptionPane.showMessageDialog(this, "Não existem consultas cadastradas");
    }//GEN-LAST:event_btnExclAgendamentoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarAgendamento;
    private javax.swing.JButton btnExclAgendamento;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNovoAgendamento;
    private javax.swing.JTable grdAgendamento;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
