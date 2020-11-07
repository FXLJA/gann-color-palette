package ColoringGANN;

import java.awt.Color;

public class ColourPickForm extends javax.swing.JFrame {

    public ColourPickForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmb_tema = new javax.swing.JComboBox<>();
        colorChooser = new javax.swing.JColorChooser();
        btn_save = new javax.swing.JButton();
        lbl_tema = new javax.swing.JLabel();
        btn_generate = new javax.swing.JButton();
        btn_trainingForm = new javax.swing.JButton();
        btn_printHex = new javax.swing.JButton();
        HexField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Gun");
        setMinimumSize(new java.awt.Dimension(570, 480));
        setPreferredSize(new java.awt.Dimension(570, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        cmb_tema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professional", "Colourful", "Monochrome" }));
        getContentPane().add(cmb_tema);
        cmb_tema.setBounds(100, 20, 202, 30);
        getContentPane().add(colorChooser);
        colorChooser.setBounds(10, 60, 560, 311);

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save);
        btn_save.setBounds(10, 410, 120, 22);

        lbl_tema.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_tema.setText("Pilih Tema :");
        getContentPane().add(lbl_tema);
        lbl_tema.setBounds(20, 20, 80, 30);

        btn_generate.setText("Generate");
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generate);
        btn_generate.setBounds(10, 380, 120, 22);

        btn_trainingForm.setText("Training Form");
        btn_trainingForm.setToolTipText("");
        btn_trainingForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trainingFormActionPerformed(evt);
            }
        });
        getContentPane().add(btn_trainingForm);
        btn_trainingForm.setBounds(430, 20, 120, 30);

        btn_printHex.setText("Print Hex");
        btn_printHex.setToolTipText("");
        btn_printHex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printHexActionPerformed(evt);
            }
        });
        getContentPane().add(btn_printHex);
        btn_printHex.setBounds(320, 20, 100, 30);

        HexField.setEditable(false);
        HexField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        HexField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(HexField);
        HexField.setBounds(140, 380, 110, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_generateActionPerformed

    private void btn_trainingFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trainingFormActionPerformed
        Main.trainingFrame.show();
    }//GEN-LAST:event_btn_trainingFormActionPerformed

    private void btn_printHexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printHexActionPerformed
        Color rgbColor = colorChooser.getColor();
        
        String RValue = Integer.toHexString(rgbColor.getRed()).toUpperCase();
        String GValue = Integer.toHexString(rgbColor.getGreen()).toUpperCase();
        String BValue = Integer.toHexString(rgbColor.getBlue()).toUpperCase();
        String Hex = RValue + GValue + BValue;
        HexField.setText(Hex);
    }//GEN-LAST:event_btn_printHexActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HexField;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_printHex;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_trainingForm;
    private javax.swing.JComboBox<String> cmb_tema;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JLabel lbl_tema;
    // End of variables declaration//GEN-END:variables

}
