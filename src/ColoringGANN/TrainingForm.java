package ColoringGANN;

import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TrainingForm extends javax.swing.JFrame {
    public GeneticTrainer geneticTrainer;
    
    SwingWorker worker;
        
    public TrainingForm() {
        initComponents();
        initSliders();
        
        geneticTrainer = new GeneticTrainer(sl_trainingRatio.getValue()/100f, sl_populationSize.getValue(), sl_mutationRate.getValue()/100f);
        worker = null;
    }
    
    private void initSliders() {
        ed_trainingRatio.setText("" + sl_trainingRatio.getValue()/100f);
        ed_populationSize.setText("" + sl_populationSize.getValue());
        ed_mutationRate.setText("" + sl_mutationRate.getValue()/100f);
        
        sl_trainingRatio.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ed_trainingRatio.setText("" + sl_trainingRatio.getValue()/100f);
                geneticTrainer.trainingtestRatio = sl_trainingRatio.getValue()/100f;
            }
        });
        sl_populationSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ed_populationSize.setText("" + sl_populationSize.getValue());
                geneticTrainer.maxPopulationSize = sl_populationSize.getValue();
            }
        });
        sl_mutationRate.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ed_mutationRate.setText("" + sl_mutationRate.getValue()/100f);
                geneticTrainer.mutationRate = sl_mutationRate.getValue()/100f;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_load = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        sl_trainingRatio = new javax.swing.JSlider();
        lbl_trainingRatio = new javax.swing.JLabel();
        sl_populationSize = new javax.swing.JSlider();
        lbl_populationSize = new javax.swing.JLabel();
        ed_populationSize = new javax.swing.JTextField();
        ed_mutationRate = new javax.swing.JTextField();
        lbl_mutationRate = new javax.swing.JLabel();
        sl_mutationRate = new javax.swing.JSlider();
        btn_autoTrain1 = new javax.swing.JButton();
        btn_nextGen1 = new javax.swing.JButton();
        ed_trainingRatio = new javax.swing.JTextField();
        lbl_scoreTraining = new javax.swing.JLabel();
        lbl_scoreTest = new javax.swing.JLabel();
        btn_saveGANN = new javax.swing.JButton();
        btn_loadGANN = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setTitle("Color Gun - Training");
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        btn_load.setText("Load Dataset");
        btn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadActionPerformed(evt);
            }
        });
        getContentPane().add(btn_load);
        btn_load.setBounds(20, 20, 120, 23);

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reset);
        btn_reset.setBounds(160, 20, 90, 23);

        sl_trainingRatio.setValue(99);
        getContentPane().add(sl_trainingRatio);
        sl_trainingRatio.setBounds(160, 60, 210, 22);

        lbl_trainingRatio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_trainingRatio.setText("Training/Test Ratio");
        getContentPane().add(lbl_trainingRatio);
        lbl_trainingRatio.setBounds(20, 60, 130, 20);

        sl_populationSize.setMaximum(2000);
        sl_populationSize.setMinimum(10);
        sl_populationSize.setValue(200);
        getContentPane().add(sl_populationSize);
        sl_populationSize.setBounds(160, 100, 210, 22);

        lbl_populationSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_populationSize.setText("Population Size");
        getContentPane().add(lbl_populationSize);
        lbl_populationSize.setBounds(20, 100, 110, 20);

        ed_populationSize.setEditable(false);
        ed_populationSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ed_populationSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(ed_populationSize);
        ed_populationSize.setBounds(380, 100, 90, 30);

        ed_mutationRate.setEditable(false);
        ed_mutationRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ed_mutationRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(ed_mutationRate);
        ed_mutationRate.setBounds(380, 140, 90, 30);

        lbl_mutationRate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_mutationRate.setText("Mutation Rate");
        getContentPane().add(lbl_mutationRate);
        lbl_mutationRate.setBounds(20, 140, 110, 20);

        sl_mutationRate.setMinimum(1);
        sl_mutationRate.setMinorTickSpacing(1);
        sl_mutationRate.setValue(10);
        getContentPane().add(sl_mutationRate);
        sl_mutationRate.setBounds(160, 140, 210, 22);

        btn_autoTrain1.setText("+100 Generation");
        btn_autoTrain1.setEnabled(false);
        btn_autoTrain1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_autoTrain1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_autoTrain1);
        btn_autoTrain1.setBounds(150, 180, 120, 30);

        btn_nextGen1.setText("Next Gen");
        btn_nextGen1.setEnabled(false);
        btn_nextGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextGen1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nextGen1);
        btn_nextGen1.setBounds(20, 180, 110, 30);

        ed_trainingRatio.setEditable(false);
        ed_trainingRatio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ed_trainingRatio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(ed_trainingRatio);
        ed_trainingRatio.setBounds(380, 60, 90, 30);

        lbl_scoreTraining.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_scoreTraining.setText("BestTrainingScore :");
        getContentPane().add(lbl_scoreTraining);
        lbl_scoreTraining.setBounds(290, 200, 190, 20);

        lbl_scoreTest.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_scoreTest.setText("BestTestScore :");
        getContentPane().add(lbl_scoreTest);
        lbl_scoreTest.setBounds(290, 180, 190, 20);

        btn_saveGANN.setText("Save ANN");
        btn_saveGANN.setEnabled(false);
        btn_saveGANN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveGANNActionPerformed(evt);
            }
        });
        getContentPane().add(btn_saveGANN);
        btn_saveGANN.setBounds(380, 20, 90, 23);

        btn_loadGANN.setText("Load GANN");
        btn_loadGANN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadGANNActionPerformed(evt);
            }
        });
        getContentPane().add(btn_loadGANN);
        btn_loadGANN.setBounds(270, 20, 90, 23);

        jProgressBar1.setMaximum(99);
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(20, 240, 450, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            geneticTrainer.loadDataset(selectedFile);
            
            lbl_scoreTest.setText(String.format("Test Score : %.4f%%", (1-geneticTrainer.bestTestScore)*100));
            lbl_scoreTraining.setText(String.format("Training Score : %.4f%%", (1-geneticTrainer.bestScore)*100));

            sl_trainingRatio.setEnabled(false);
            btn_saveGANN.setEnabled(true);
            btn_nextGen1.setEnabled(true);
            btn_autoTrain1.setEnabled(true);
        }
    }//GEN-LAST:event_btn_loadActionPerformed
    
    private void printColors(Color[] c){
        for(int i=0; i<c.length; i++) {
            float[] hsb = Color.RGBtoHSB(c[i].getRed(), c[i].getGreen(), c[i].getBlue(), null);
            System.out.println(String.format("%f, %f, %f", hsb[0], hsb[1], hsb[2]));
        }
    }
    
    private void btn_nextGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextGen1ActionPerformed
        if(worker == null || worker.isDone())
            worker = new GenWorker();
            worker.execute();
    }//GEN-LAST:event_btn_nextGen1ActionPerformed

    private void btn_autoTrain1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_autoTrain1ActionPerformed
        if(worker == null || worker.isDone())
            worker = new ProgressWorker();
            worker.execute();
    }//GEN-LAST:event_btn_autoTrain1ActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Do you want to reset?", "Reset?", JOptionPane.YES_NO_OPTION);
        
        if (result != JOptionPane.YES_OPTION)
            return;
        
        geneticTrainer = new GeneticTrainer(sl_trainingRatio.getValue()/100f, sl_populationSize.getValue(), sl_mutationRate.getValue()/100f);
        
        btn_saveGANN.setEnabled(false);
        btn_nextGen1.setEnabled(false);
        btn_autoTrain1.setEnabled(false);
        sl_trainingRatio.setEnabled(true);
        
        sl_trainingRatio.setValue(66);
        sl_populationSize.setValue(200);
        sl_mutationRate.setValue(10);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_loadGANNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadGANNActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
             boolean IsSucess = geneticTrainer.loadGANN(selectedFile);

            if(IsSucess) {
                JOptionPane.showMessageDialog(null, "DNA berhasil diload!", "Message", JOptionPane.INFORMATION_MESSAGE);
                btn_saveGANN.setEnabled(true);
                lbl_scoreTest.setText(String.format("Test Score : %.4f%%", (1-geneticTrainer.bestTestScore)*100));
                lbl_scoreTraining.setText(String.format("Training Score : %.4f%%", (1-geneticTrainer.bestScore)*100));
            }
        }
    }//GEN-LAST:event_btn_loadGANNActionPerformed

    private void btn_saveGANNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveGANNActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            boolean IsSucess = geneticTrainer.bestANNTest.saveDNA(selectedFile);
            
            if(IsSucess) {
                JOptionPane.showMessageDialog(null, "DNA berhasil disimpan!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_saveGANNActionPerformed
    
    private class GenWorker extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            publish(0);
            
            int population_size = geneticTrainer.population.size();
            for (int i=1; i<geneticTrainer.population.size(); i++) {
                geneticTrainer.evaluateGANNAt(i);
                publish(i*100/population_size);
            }
            
            geneticTrainer.keepBest();
            geneticTrainer.reproduction();
            return null;
        }
        
        @Override
        protected void process(List<Integer> chunks) {
            jProgressBar1.setValue(chunks.get(chunks.size() - 1));
            super.process(chunks);
        }

        @Override
        protected void done() {
            jProgressBar1.setValue(100);
            
            lbl_scoreTest.setText(String.format("Test Score : %.4f%%", (1-geneticTrainer.bestTestScore)*100));
            lbl_scoreTraining.setText(String.format("Training Score : %.4f%%", (1-geneticTrainer.bestScore)*100));
        }
    }
    
    private class ProgressWorker extends SwingWorker<Void, Integer> {
        
        @Override
        protected Void doInBackground() throws Exception {
            publish(0);
            for (int i = 0; i < 100; i++) {
                geneticTrainer.nextGen();
                
                publish(i+1);
            }
            done();
            return null;
        }

        @Override
        protected void process(List<Integer> chunks) {
            jProgressBar1.setValue(chunks.get(chunks.size() - 1));
            lbl_scoreTest.setText(String.format("Test Score : %.4f%%", (1-geneticTrainer.bestTestScore)*100));
            lbl_scoreTraining.setText(String.format("Training Score : %.4f%%", (1-geneticTrainer.bestScore)*100));
            
            super.process(chunks);
        }

        @Override
        protected void done() {
            jProgressBar1.setValue(100);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_autoTrain1;
    private javax.swing.JButton btn_load;
    private javax.swing.JButton btn_loadGANN;
    private javax.swing.JButton btn_nextGen1;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_saveGANN;
    private javax.swing.JTextField ed_mutationRate;
    private javax.swing.JTextField ed_populationSize;
    private javax.swing.JTextField ed_trainingRatio;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbl_mutationRate;
    private javax.swing.JLabel lbl_populationSize;
    private javax.swing.JLabel lbl_scoreTest;
    private javax.swing.JLabel lbl_scoreTraining;
    private javax.swing.JLabel lbl_trainingRatio;
    private javax.swing.JSlider sl_mutationRate;
    private javax.swing.JSlider sl_populationSize;
    private javax.swing.JSlider sl_trainingRatio;
    // End of variables declaration//GEN-END:variables
}
