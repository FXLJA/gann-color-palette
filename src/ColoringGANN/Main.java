package ColoringGANN;

import java.awt.Color;

public class Main {
    static TrainingForm trainingFrame;
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColourPickForm().setVisible(true);
                trainingFrame = new TrainingForm();
            }
        });
    }
    
}
