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
    double[] input_layer = new double[4];
    double[] hidden_layer = new double[16];
    double[] output_layer = new double[12];
    public double[] dna = new double[input_layer.length * hidden_layer.length + hidden_layer.length * output_layer.length];

    public void randomize() {
        for (int i = 0; i < dna.length; i++) {
            dna[i] = rand.nextGaussian() * 2 - 1;
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
            float h = (float) colorData[i * 3];
            float s = (float) colorData[i * 3 + 1];
            float v = (float) colorData[i * 3 + 2];
            
            colors[i] = Color.getHSBColor(h, s, v);
        }

        return colors;
    }

    private double[] fowardPropagation(int mode, Color c) {
        float[] color_hsb = new float[3];
        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), color_hsb);

        input_layer[0] = mode;
        input_layer[1] = color_hsb[0];
        input_layer[2] = color_hsb[1];
        input_layer[3] = color_hsb[2];

        double[][] weight_input_to_hidden = new double[hidden_layer.length][input_layer.length];
        double[][] weight_hidden_to_output = new double[output_layer.length][hidden_layer.length];

        for (int i = 0; i < hidden_layer.length; i++) {
            for (int k = 0; k < input_layer.length; k++) {
                weight_input_to_hidden[i][k] = dna[i * input_layer.length + k];
            }
        }

        int offset = input_layer.length * hidden_layer.length;
        for (int i = 0; i < output_layer.length; i++) {
            for (int k = 0; k < hidden_layer.length; k++) {
                weight_hidden_to_output[i][k] = dna[offset + i * hidden_layer.length + k];
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

        for (int i = 0; i < output_layer.length; i++) {
            double total = 0;
            for (int k = 0; k < hidden_layer.length; k++) {
                total += hidden_layer[k] * weight_hidden_to_output[i][k];
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
    
    public GANN mutate(float mutationRate) {
        for (int i = 0; i < dna.length; i++) {
            if(rand.nextFloat() < mutationRate) {
                this.dna[i] = rand.nextGaussian() * 4 - 2;
            }
        }
        
        return this;
    }
}
