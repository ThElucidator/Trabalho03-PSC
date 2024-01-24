package FrontEnd;
import BackEnd.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

     private Conexao c;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        int c;
        this.c = new Conexao();
    }

    private void GetListarConsultas() {
        DefaultTableModel d = (DefaultTableModel) grdMenu.getModel();
        
        //Limpar linhas
        while(d.getRowCount() > 0)
            d.removeRow(0);
        
        //Definir SQL
        this.c.setResultSet("SELECT * FROM espera as E INNER JOIN pacientes as P ON E.idpaciente = P.idpaciente INNER JOIN consultas as C ON E.idconsultas = C.iconsultas ORDER BY E.horariochegada");
        
        //Mostrar resultado
        try {
            if (this.c.getResultSet().first()) {
                do {
                    d.addRow(
                       new Object[] {
                           this.c.getResultSet().getString("E.idespera"),
                           this.c.getResultSet().getString("E.horariochegada"),
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

        btnNovoEspera = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdMenu = new javax.swing.JTable();
        btnExclEspera = new javax.swing.JButton();
        MnMain = new javax.swing.JMenuBar();
        MnCadastro = new javax.swing.JMenu();
        jMenuPaciente = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNovoEspera.setText("Nova Espera");
        btnNovoEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoEsperaActionPerformed(evt);
            }
        });

        grdMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Horário de Entrada", "Nome do Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grdMenu);

        btnExclEspera.setText("Excluir Espera");
        btnExclEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExclEsperaActionPerformed(evt);
            }
        });

        MnCadastro.setText("Acessar Cadastros");

        jMenuPaciente.setText("Pacientes");
        jMenuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPacienteActionPerformed(evt);
            }
        });
        MnCadastro.add(jMenuPaciente);

        jMenuConsultas.setText("Agendamento");
        jMenuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultasActionPerformed(evt);
            }
        });
        MnCadastro.add(jMenuConsultas);

        MnMain.add(MnCadastro);

        setJMenuBar(MnMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnNovoEspera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExclEspera)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoEspera)
                    .addComponent(btnExclEspera))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPacienteActionPerformed
        // TODO add your handling code here:
        new CaPacientes().setVisible(true);
    }//GEN-LAST:event_jMenuPacienteActionPerformed

    private void jMenuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultasActionPerformed
        // TODO add your handling code here:
        new CaAgendamento().setVisible(true);
    }//GEN-LAST:event_jMenuConsultasActionPerformed

    private void btnNovoEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoEsperaActionPerformed
        // TODO add your handling code here:
        new CaEspera(-1).setVisible(true);
        this.GetListarConsultas();
    }//GEN-LAST:event_btnNovoEsperaActionPerformed

    private void btnExclEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExclEsperaActionPerformed
        // TODO add your handling code here:
        if (grdMenu.getRowCount()>0){
            if (grdMenu.getSelectedRowCount()>0){
                if(JOptionPane.showConfirmDialog(this,
                        "Confirmar exclusão da espera?",
                        "Excluir",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            String Espera = String.valueOf(grdMenu.getValueAt(grdMenu.getSelectedRow(), 0));
                            this.c.SQLExecute("DELETE FROM espera WHERE idespera = " + Espera);
                            this.c.SQLExecute("Delete FROM consultas WHERE idconsultas = " + Espera);
                            this.GetListarConsultas();
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Selecionar uma Espera");
        }
        else
            JOptionPane.showMessageDialog(this, "Não existem Esperas registradas");

    }//GEN-LAST:event_btnExclEsperaActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnCadastro;
    private javax.swing.JMenuBar MnMain;
    private javax.swing.JButton btnExclEspera;
    private javax.swing.JButton btnNovoEspera;
    private javax.swing.JTable grdMenu;
    private javax.swing.JMenuItem jMenuConsultas;
    private javax.swing.JMenuItem jMenuPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
