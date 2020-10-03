package ColoringGANN;

public class TrainingForm extends javax.swing.JFrame {

    public TrainingForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panelWarna1 = new ColoringGANN.PanelWarna();
        panelWarna2 = new ColoringGANN.PanelWarna();
        panelWarna3 = new ColoringGANN.PanelWarna();
        panelWarna4 = new ColoringGANN.PanelWarna();
        panelWarna5 = new ColoringGANN.PanelWarna();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSlider2 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSlider3 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(497, 350));
        setPreferredSize(new java.awt.Dimension(497, 350));
        getContentPane().setLayout(null);

        jButton3.setText("Load");
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 20, 80, 23);

        jButton4.setText("Save");
        getContentPane().add(jButton4);
        jButton4.setBounds(110, 20, 90, 23);

        jButton5.setText("Auto Train");
        getContentPane().add(jButton5);
        jButton5.setBounds(380, 290, 90, 23);
        getContentPane().add(panelWarna1);
        panelWarna1.setBounds(30, 220, 80, 40);
        getContentPane().add(panelWarna2);
        panelWarna2.setBounds(120, 220, 80, 40);
        getContentPane().add(panelWarna3);
        panelWarna3.setBounds(210, 220, 80, 40);
        getContentPane().add(panelWarna4);
        panelWarna4.setBounds(300, 220, 80, 40);
        getContentPane().add(panelWarna5);
        panelWarna5.setBounds(390, 220, 80, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professional", "Colourful", "Monochrome" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(110, 180, 202, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pilih Tema :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 190, 80, 10);

        jButton6.setText("Bagus");
        getContentPane().add(jButton6);
        jButton6.setBounds(30, 290, 73, 23);

        jButton7.setText("Kurang");
        getContentPane().add(jButton7);
        jButton7.setBounds(120, 290, 67, 23);
        getContentPane().add(jSlider1);
        jSlider1.setBounds(160, 60, 210, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Training/Test Ratio");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 130, 20);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(380, 60, 90, 30);
        getContentPane().add(jSlider2);
        jSlider2.setBounds(130, 100, 240, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Population Size");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 110, 20);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(380, 100, 90, 30);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField4);
        jTextField4.setBounds(380, 140, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mutation Rate");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 140, 110, 20);
        getContentPane().add(jSlider3);
        jSlider3.setBounds(130, 140, 240, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private ColoringGANN.PanelWarna panelWarna1;
    private ColoringGANN.PanelWarna panelWarna2;
    private ColoringGANN.PanelWarna panelWarna3;
    private ColoringGANN.PanelWarna panelWarna4;
    private ColoringGANN.PanelWarna panelWarna5;
    // End of variables declaration//GEN-END:variables
}
