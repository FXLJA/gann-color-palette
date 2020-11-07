package ColoringGANN;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import javax.swing.JOptionPane;

public class PanelWarna extends javax.swing.JPanel {
    private Color color = Color.BLACK;
    
    public void setColor(Color color){
        this.color = color;
        
        String RValue = Integer.toHexString(color.getRed()).toUpperCase();
        String GValue = Integer.toHexString(color.getGreen()).toUpperCase();
        String BValue = Integer.toHexString(color.getBlue()).toUpperCase();
        
        String Hex = "#";
        Hex += (RValue.length() == 1 ? "0" : "") + RValue;
        Hex += (GValue.length() == 1 ? "0" : "") + GValue;
        Hex += (BValue.length() == 1 ? "0" : "") + BValue;
        
        jTextField1.setText(Hex);
        
        validate();
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.fillRect(0, 0, 100, 20);
    }

    public PanelWarna() {
        initComponents();
    }
    
    public String getText() {
        return jTextField1.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(80, 40));
        setPreferredSize(new java.awt.Dimension(80, 40));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("#000000");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(0, 20, 80, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        copyTexttoClipboard();
        JOptionPane.showMessageDialog(null, jTextField1.getText() + " copied to Clipboard!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        copyTexttoClipboard();
        JOptionPane.showMessageDialog(null, jTextField1.getText() + " copied to Clipboard!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_formMouseClicked
    
    private void copyTexttoClipboard() {
        StringSelection stringSelection = new StringSelection(jTextField1.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
