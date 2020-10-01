package ColoringGANN;

public class ColourPickForm extends javax.swing.JFrame {

    public ColourPickForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panelWarna1 = new ColoringGANN.PanelWarna();
        panelWarna2 = new ColoringGANN.PanelWarna();
        panelWarna3 = new ColoringGANN.PanelWarna();
        panelWarna4 = new ColoringGANN.PanelWarna();
        panelWarna5 = new ColoringGANN.PanelWarna();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(570, 480));
        setPreferredSize(new java.awt.Dimension(570, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professional", "Colourful", "Monochrome" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(100, 20, 202, 30);
        getContentPane().add(jColorChooser1);
        jColorChooser1.setBounds(10, 60, 540, 311);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 410, 120, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pilih Tema :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 10);

        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 380, 120, 23);
        getContentPane().add(panelWarna1);
        panelWarna1.setBounds(140, 390, 80, 40);
        getContentPane().add(panelWarna2);
        panelWarna2.setBounds(220, 390, 80, 40);
        getContentPane().add(panelWarna3);
        panelWarna3.setBounds(300, 390, 80, 40);
        getContentPane().add(panelWarna4);
        panelWarna4.setBounds(380, 390, 80, 40);
        getContentPane().add(panelWarna5);
        panelWarna5.setBounds(460, 390, 80, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private ColoringGANN.PanelWarna panelWarna1;
    private ColoringGANN.PanelWarna panelWarna2;
    private ColoringGANN.PanelWarna panelWarna3;
    private ColoringGANN.PanelWarna panelWarna4;
    private ColoringGANN.PanelWarna panelWarna5;
    // End of variables declaration//GEN-END:variables

}
