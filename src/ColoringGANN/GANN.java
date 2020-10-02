package ColoringGANN;

import java.util.Random;
import java.awt.Color;

public class GANN {

    public double[] dna = new double[128];

    public void randomize() {
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < dna.length; i++) {
            dna[i] = rand.nextDouble();
        }
    }

    public Color[] generateColor(int mode, Color c) {
        Color[] colors = new Color[4];

        int[] colorData = fowardPropagation(mode, c);

        for (int i = 0; i < 4; i++) {
            int h = constrain(colorData[i * 3], 0, 360);
            float s = constrain(colorData[i * 3 + 1], 0, 100) / 100.0f;
            float v = constrain(colorData[i * 3 + 2], 0, 100) / 100.0f;

            colors[i] = Color.getHSBColor(h, s, v);
        }

        return colors;
    }

    private int constrain(int value, int min, int max) {
        if (value > max) {
            return max;
        }
        if (value < min) {
            return min;
        }
        return value;
    }

    private int[] fowardPropagation(int mode, Color c) {
        int[] input_layer = new int[4];
        double[] hidden_layer = new double[8];
        int[] output_layer = new int[12];

        float[] color_hsb = new float[3];
        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), color_hsb);

        input_layer[0] = mode;
        input_layer[1] = (int) Math.floor(color_hsb[0] * 360);
        input_layer[2] = (int) Math.floor(color_hsb[1] * 100);
        input_layer[3] = (int) Math.floor(color_hsb[2] * 100);

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
            hidden_layer[i] = 1.0 / (1.0 + Math.exp(-total));
        }

        for (int i = 0; i < output_layer.length; i++) {
            double total = 0;
            for (int k = 0; k < hidden_layer.length; k++) {
                output_layer[i] += hidden_layer[k] * weight_hidden_to_output[i][k];
            }
            output_layer[i] = (int) Math.floor(total);
        }

        return output_layer;
    }

    public GANN clone() {
        GANN baru = new GANN();

        for (int i = 0; i < dna.length; i++) {
            baru.dna[i] = this.dna[i];
        }

        return baru;
    }
}
