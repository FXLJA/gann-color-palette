package ColoringGANN;

import java.util.Random;
import java.awt.Color;

public class GANN {
    private static Random rand = new Random(System.currentTimeMillis());
    double[] input_layer = new double[3];
    double[] hidden_layer = new double[6];
    double[] output_layer = new double[12];
    public double[] dna = new double[input_layer.length * hidden_layer.length + hidden_layer.length * output_layer.length];

    public void randomize() {
        for (int i = 0; i < dna.length; i++) {
            dna[i] = rand.nextGaussian() * 2 - 1;
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

        input_layer[0] = color_hsb[0];
        input_layer[1] = color_hsb[1];
        input_layer[2] = color_hsb[2];

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
