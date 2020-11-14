package ColoringGANN;

import java.util.Random;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GANN {
    private static Random rand = new Random(System.currentTimeMillis());
    double[] input_layer = new double[6];
    double[] hidden_layer = new double[64];
    double[] hidden_layer2 = new double[48];
    double[] output_layer = new double[12];
    public double[] dna = new double[input_layer.length * hidden_layer.length + hidden_layer.length * hidden_layer2.length + hidden_layer2.length * output_layer.length];

    public void randomize() {
        for (int i = 0; i < dna.length; i++) {
            dna[i] = rand.nextGaussian();
        }
    }
    
    public boolean saveDNA(File path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            for (int i=0; i<dna.length; i++) {
                myWriter.write("" + dna[i]);
                if(i < dna.length-1) {
                    myWriter.write(",");
                }
            }
            myWriter.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean loadDNA(File path) {
        try {
            Scanner sc = new Scanner(path);
            sc.useDelimiter(",");
            
            double[] dna = new double[this.dna.length];
            
            int i=0;
            while (sc.hasNext()) {
                if (i == this.dna.length) {
                   JOptionPane.showMessageDialog(null, "Dna size does not match!", "Error!", JOptionPane.ERROR_MESSAGE);
                   sc.close();
                   return false;
                }
                
                double d = Double.parseDouble(sc.next().trim());
                dna[i] = d;
                i++;
            }
            sc.close();
            
            if (i < this.dna.length) {
                JOptionPane.showMessageDialog(null, "Dna size does not match!", "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            copyDNA(dna);
            
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } 
    }
    
    public void copyDNA(double[] dna) {
        if(dna.length != this.dna.length) {
            JOptionPane.showMessageDialog(null, "Dna size does not match!", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for(int i=0; i<dna.length; i++) {
            this.dna[i] = dna[i];
        }
    }

    public Color[] generateColor(int mode, Color c) {
        Color[] colors = new Color[4];

        double[] colorData = fowardPropagation(mode, c);

        for (int i = 0; i < 4; i++) {
            float r = (float) colorData[i * 3];
            float g = (float) colorData[i * 3 + 1];
            float b = (float) colorData[i * 3 + 2];
            
            colors[i] = new Color(r, g, b);
        }

        return colors;
    }

    private double[] fowardPropagation(int mode, Color c) {
        input_layer[0] = (mode == 0) ? 1 : 0;
        input_layer[1] = (mode == 1) ? 1 : 0;
        input_layer[2] = (mode == 2) ? 1 : 0;
        
        input_layer[3] = c.getRed()/255.0;
        input_layer[4] = c.getGreen()/255.0;
        input_layer[5] = c.getBlue()/255.0;

        
        double[][] weight_input_to_hidden = new double[hidden_layer.length][input_layer.length];
        double[][] weight_hidden_to_hidden2 = new double[hidden_layer2.length][hidden_layer.length];
        double[][] weight_hidden2_to_output = new double[output_layer.length][hidden_layer2.length];
        
        int offset = 0;
        for (int i = 0; i < hidden_layer.length; i++) {
            for (int k = 0; k < input_layer.length; k++) {
                weight_input_to_hidden[i][k] = dna[i * input_layer.length + k];
                offset += 1;
            }
        }
        
        int hidden_layer_offset = offset;
        for (int i = 0; i < hidden_layer2.length; i++) {
            for (int k = 0; k < hidden_layer.length; k++) {
                weight_hidden_to_hidden2[i][k] = dna[hidden_layer_offset + i * hidden_layer.length + k];
                offset += 1;
            }
        }
        
        int hidden2_layer_offset = offset;
        for (int i = 0; i < output_layer.length; i++) {
            for (int k = 0; k < hidden_layer2.length; k++) {
                weight_hidden2_to_output[i][k] = dna[hidden2_layer_offset + i * hidden_layer2.length + k];
            }
        }
        
        
        for (int i = 0; i < hidden_layer.length; i++) {
            double total = 0;
            for (int k = 0; k < input_layer.length; k++) {
                total += input_layer[k] * weight_input_to_hidden[i][k];
            }
            // Activation function Sigmoid
            hidden_layer[i] = sigmoid(total);
        }
        
        for (int i = 0; i < hidden_layer2.length; i++) {
            double total = 0;
            for (int k = 0; k < hidden_layer.length; k++) {
                total += hidden_layer[k] * weight_hidden_to_hidden2[i][k];
            }
            // Activation function Sigmoid
            hidden_layer2[i] = sigmoid(total);
        }

        for (int i = 0; i < output_layer.length; i++) {
            double total = 0;
            for (int k = 0; k < hidden_layer2.length; k++) {
                total += hidden_layer2[k] * weight_hidden2_to_output[i][k];
            }
            output_layer[i] = sigmoid(total);
        }

        return output_layer;
    }
    
    private double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public GANN clone() {
        GANN baru = new GANN();

        for (int i = 0; i < dna.length; i++) {
            baru.dna[i] = this.dna[i];
        }

        return baru;
    }
    
    public GANN mutate(double mutationRate) {
        boolean hasMutate = false;
        
        for (int i = 0; i < dna.length; i++) {
            if(rand.nextDouble() < mutationRate) {
                this.dna[i] = rand.nextGaussian();
		hasMutate = true;
            }
        }
        
        if (!hasMutate) {
            mutate(mutationRate);
        }
        
        return this;
    }
}
