package FrontEnd;

import BackEnd.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CaPacientes extends javax.swing.JDialog {

    private Conexao c;
    
    public CaPacientes() {
        initComponents();
        this.setModal(true);
        this.c = new Conexao();
        this.GetListarPacientes();
    }
    
    private void GetListarPacientes() {
        DefaultTableModel d = (DefaultTableModel) grdPacientes.getModel();
        
        //Limpar linhas
        while(d.getRowCount() > 0)
            d.removeRow(0);
        
        //Definir SQL
        this.c.setResultSet("SELECT * FROM pacientes");
        
        //Mostrar resultado
        try {
            if (this.c.getResultSet().first()) {
                do {
                    d.addRow(
                       new Object[] {
                           this.c.getResultSet().getString("idpaciente"),
                           this.c.getResultSet().getString("nomepaciente"),
                           this.c.getResultSet().getString("CPFpaciente"),
                           this.c.getResultSet().getString("enderecopaciente"),
                           this.c.getResultSet().getString("contatospaciente"),
                           this.c.getResultSet().getString("observacoespaciente")
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

        btnNovoPaciente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdPacientes = new javax.swing.JTable();
        btnEditarPaciente = new javax.swing.JButton();
        btnExclPaciente = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuarios");

        btnNovoPaciente.setText("Novo Paciente");
        btnNovoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPacienteActionPerformed(evt);
            }
        });

        grdPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço", "Contatos", "Observações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(grdPacientes);

        btnEditarPaciente.setText("Editar Paciente");
        btnEditarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPacienteActionPerformed(evt);
            }
        });

        btnExclPaciente.setText("Excluir Paciente");
        btnExclPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExclPacienteActionPerformed(evt);
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
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnNovoPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarPaciente)
                        .addGap(103, 103, 103)
                        .addComponent(btnExclPaciente)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoPaciente)
                    .addComponent(btnEditarPaciente)
                    .addComponent(btnExclPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenu)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExclPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExclPacienteActionPerformed
         if (grdPacientes.getRowCount() > 0) {
            if (grdPacientes.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this,
                    "Confirmar exclusão do paciente?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String CodPaciente = String.valueOf(grdPacientes.getValueAt(grdPacientes.getSelectedRow(), 0));
                this.c.SQLExecute("DELETE FROM pacientes WHERE idpaciente = " + CodPaciente);
                this.GetListarPacientes();
            }
        }
        else
        JOptionPane.showMessageDialog(this, "Selecionar um paciente");
        }
        else
        JOptionPane.showMessageDialog(this, "Não existem pacientes cadastrados");  
    }//GEN-LAST:event_btnExclPacienteActionPerformed

    private void btnEditarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPacienteActionPerformed
        // TODO add your handling code here:
        if (grdPacientes.getRowCount() > 0) {
            if (grdPacientes.getSelectedRowCount() > 0) {
                String CodPaciente = String.valueOf(grdPacientes.getValueAt(grdPacientes.getSelectedRow(), 0));
                new CaPacientesEntrada(Integer.valueOf(CodPaciente)).setVisible(true);
                this.GetListarPacientes();
            }
            else
                JOptionPane.showMessageDialog(this, "Selecionar um paciente");
        }
        else
            JOptionPane.showMessageDialog(this, "Não existem pacientes cadastrados");
    }//GEN-LAST:event_btnEditarPacienteActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnNovoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPacienteActionPerformed
        // TODO add your handling code here:
        new CaPacientesEntrada(-1).setVisible(true);
        this.GetListarPacientes();
    }//GEN-LAST:event_btnNovoPacienteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPaciente;
    private javax.swing.JButton btnExclPaciente;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNovoPaciente;
    private javax.swing.JTable grdPacientes;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
