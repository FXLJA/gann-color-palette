package ColoringGANN;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;

public class ColourPickForm extends javax.swing.JFrame {

    public ColourPickForm() {
        initComponents();

        colorChooser.getSelectionModel().addChangeListener((ChangeEvent e) -> {
            panelWarna1.setColor(colorChooser.getColor());
        });

        AbstractColorChooserPanel panels[] = colorChooser.getChooserPanels();
        colorChooser.removeChooserPanel(panels[0]); // Remove Swatch
        colorChooser.removeChooserPanel(panels[2]); // Remove HSL
        colorChooser.removeChooserPanel(panels[4]); // Remove CMYK
        colorChooser.setPreviewPanel(new JPanel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cmb_tema = new javax.swing.JComboBox<>();
        colorChooser = new javax.swing.JColorChooser();
        btn_save = new javax.swing.JButton();
        lbl_tema = new javax.swing.JLabel();
        btn_generate = new javax.swing.JButton();
        btn_trainingForm = new javax.swing.JButton();
        panelWarna1 = new ColoringGANN.PanelWarna();
        panelWarna2 = new ColoringGANN.PanelWarna();
        panelWarna3 = new ColoringGANN.PanelWarna();
        panelWarna4 = new ColoringGANN.PanelWarna();
        panelWarna5 = new ColoringGANN.PanelWarna();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Color Gun");
        setMaximumSize(new java.awt.Dimension(680, 480));
        setMinimumSize(new java.awt.Dimension(680, 480));
        setPreferredSize(new java.awt.Dimension(680, 480));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ColoringGANN/UBM.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 80));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 0, 120, 80);

        cmb_tema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Analogous", "Triadic", "Monochrome" }));
        getContentPane().add(cmb_tema);
        cmb_tema.setBounds(100, 20, 140, 30);
        getContentPane().add(colorChooser);
        colorChooser.setBounds(10, 60, 630, 311);

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        getContentPane().add(btn_save);
        btn_save.setBounds(10, 410, 110, 22);

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
        btn_generate.setBounds(10, 380, 110, 22);

        btn_trainingForm.setText("Training Form");
        btn_trainingForm.setToolTipText("");
        btn_trainingForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trainingFormActionPerformed(evt);
            }
        });
        getContentPane().add(btn_trainingForm);
        btn_trainingForm.setBounds(520, 20, 120, 30);
        getContentPane().add(panelWarna1);
        panelWarna1.setBounds(130, 380, 80, 40);
        getContentPane().add(panelWarna2);
        panelWarna2.setBounds(220, 380, 80, 40);
        getContentPane().add(panelWarna3);
        panelWarna3.setBounds(310, 380, 80, 40);
        getContentPane().add(panelWarna4);
        panelWarna4.setBounds(400, 380, 80, 40);
        getContentPane().add(panelWarna5);
        panelWarna5.setBounds(490, 380, 80, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
        
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                
                try (FileWriter myWriter = new FileWriter(selectedFile.getAbsolutePath())) {
                    myWriter.write(panelWarna1.getText() + "\n");
                    myWriter.write(panelWarna2.getText() + "\n");
                    myWriter.write(panelWarna3.getText() + "\n");
                    myWriter.write(panelWarna4.getText() + "\n");
                    myWriter.write(panelWarna5.getText() + "\n");
                }
                
                JOptionPane.showMessageDialog(null, "Tema Warna berhasil disimpan!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        GANN bestANN = Main.trainingFrame.geneticTrainer.bestANNTest;

        if (bestANN == null) {
            JOptionPane.showMessageDialog(null, "Load a dataset and train the GANN first", "Error!", JOptionPane.WARNING_MESSAGE);
        }

        Color c[] = bestANN.generateColor(cmb_tema.getSelectedIndex(), colorChooser.getColor());

        panelWarna2.setColor(c[0]);
        panelWarna3.setColor(c[1]);
        panelWarna4.setColor(c[2]);
        panelWarna5.setColor(c[3]);
    }//GEN-LAST:event_btn_generateActionPerformed

    private void btn_trainingFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trainingFormActionPerformed
        Main.trainingFrame.show();
    }//GEN-LAST:event_btn_trainingFormActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int result = JOptionPane.showConfirmDialog(this, "Do you want to Quit?", "Quit?", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            setVisible(false);
            dispose();
            
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_trainingForm;
    private javax.swing.JComboBox<String> cmb_tema;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_tema;
    private ColoringGANN.PanelWarna panelWarna1;
    private ColoringGANN.PanelWarna panelWarna2;
    private ColoringGANN.PanelWarna panelWarna3;
    private ColoringGANN.PanelWarna panelWarna4;
    private ColoringGANN.PanelWarna panelWarna5;
    // End of variables declaration//GEN-END:variables

}
