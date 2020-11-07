package ColoringGANN;

import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;

public class TrainingForm extends javax.swing.JFrame {
    public GeneticTrainer geneticTrainer;
    
    public TrainingForm() {
        initComponents();
        
        geneticTrainer = new GeneticTrainer(sl_trainingRatio.getValue()/100f, sl_populationSize.getValue(), sl_mutationRate.getValue()/100f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_load = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_generate = new javax.swing.JButton();
        sl_trainingRatio = new javax.swing.JSlider();
        lbl_trainingRatio = new javax.swing.JLabel();
        ed_trainingRatio = new javax.swing.JTextField();
        sl_populationSize = new javax.swing.JSlider();
        lbl_populationSize = new javax.swing.JLabel();
        ed_populationSize = new javax.swing.JTextField();
        ed_mutationRate = new javax.swing.JTextField();
        lbl_mutationRate = new javax.swing.JLabel();
        sl_mutationRate = new javax.swing.JSlider();
        btn_autoTrain1 = new javax.swing.JButton();
        btn_nextGen1 = new javax.swing.JButton();

        setTitle("Color Gun - Training");
        setMinimumSize(new java.awt.Dimension(500, 260));
        setPreferredSize(new java.awt.Dimension(500, 260));
        setResizable(false);
        getContentPane().setLayout(null);

        btn_load.setText("Load");
        btn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadActionPerformed(evt);
            }
        });
        getContentPane().add(btn_load);
        btn_load.setBounds(20, 20, 80, 23);

        btn_save.setText("Save");
        getContentPane().add(btn_save);
        btn_save.setBounds(110, 20, 90, 23);

        btn_generate.setText("Generate");
        btn_generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_generate);
        btn_generate.setBounds(270, 180, 90, 30);
        getContentPane().add(sl_trainingRatio);
        sl_trainingRatio.setBounds(160, 60, 210, 22);

        lbl_trainingRatio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_trainingRatio.setText("Training/Test Ratio");
        getContentPane().add(lbl_trainingRatio);
        lbl_trainingRatio.setBounds(20, 60, 130, 20);

        ed_trainingRatio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ed_trainingRatio);
        ed_trainingRatio.setBounds(380, 60, 90, 30);

        sl_populationSize.setMaximum(10000);
        sl_populationSize.setMinimum(100);
        sl_populationSize.setValue(5000);
        getContentPane().add(sl_populationSize);
        sl_populationSize.setBounds(160, 100, 210, 22);

        lbl_populationSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_populationSize.setText("Population Size");
        getContentPane().add(lbl_populationSize);
        lbl_populationSize.setBounds(20, 100, 110, 20);

        ed_populationSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ed_populationSize);
        ed_populationSize.setBounds(380, 100, 90, 30);

        ed_mutationRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(ed_mutationRate);
        ed_mutationRate.setBounds(380, 140, 90, 30);

        lbl_mutationRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_mutationRate.setText("Mutation Rate");
        getContentPane().add(lbl_mutationRate);
        lbl_mutationRate.setBounds(20, 140, 110, 20);

        sl_mutationRate.setValue(10);
        getContentPane().add(sl_mutationRate);
        sl_mutationRate.setBounds(160, 140, 210, 22);

        btn_autoTrain1.setText("Auto Train");
        btn_autoTrain1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_autoTrain1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_autoTrain1);
        btn_autoTrain1.setBounds(150, 180, 100, 30);

        btn_nextGen1.setText("Next Gen");
        btn_nextGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextGen1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nextGen1);
        btn_nextGen1.setBounds(20, 180, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            geneticTrainer.dataset.loadDataset(selectedFile);
        }
    }//GEN-LAST:event_btn_loadActionPerformed

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        System.out.println("Professional : ");
        
        float[] hsb = Color.RGBtoHSB(255, 0, 0, null);
        System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        printColors(geneticTrainer.bestANN.generateColor(0, Color.red));
        
        hsb = Color.RGBtoHSB(0, 255, 0, null);
        System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        printColors(geneticTrainer.bestANN.generateColor(0, Color.green));
        
        hsb = Color.RGBtoHSB(0, 0, 255, null);
        System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        printColors(geneticTrainer.bestANN.generateColor(0, Color.blue));
        
        hsb = Color.RGBtoHSB(0, 0, 0, null);
        System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        printColors(geneticTrainer.bestANN.generateColor(0, Color.black));
        
        hsb = Color.RGBtoHSB(255, 255, 255, null);
        System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        printColors(geneticTrainer.bestANN.generateColor(0, Color.white));
        
    }//GEN-LAST:event_btn_generateActionPerformed
    
    private void printColors(Color[] c){
        for(int i=0; i<c.length; i++) {
            float[] hsb = Color.RGBtoHSB(c[i].getRed(), c[i].getGreen(), c[i].getBlue(), null);
            System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        }
        System.out.println("-----------");
        System.out.println();
    }
    
    private void btn_nextGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextGen1ActionPerformed
        geneticTrainer.nextGen();
    }//GEN-LAST:event_btn_nextGen1ActionPerformed

    private void btn_autoTrain1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_autoTrain1ActionPerformed
        for(int i=0; i<100; i++) {
            geneticTrainer.nextGen();
        }
    }//GEN-LAST:event_btn_autoTrain1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_autoTrain1;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_load;
    private javax.swing.JButton btn_nextGen1;
    private javax.swing.JButton btn_save;
    private javax.swing.JTextField ed_mutationRate;
    private javax.swing.JTextField ed_populationSize;
    private javax.swing.JTextField ed_trainingRatio;
    private javax.swing.JLabel lbl_mutationRate;
    private javax.swing.JLabel lbl_populationSize;
    private javax.swing.JLabel lbl_trainingRatio;
    private javax.swing.JSlider sl_mutationRate;
    private javax.swing.JSlider sl_populationSize;
    private javax.swing.JSlider sl_trainingRatio;
    // End of variables declaration//GEN-END:variables
}
