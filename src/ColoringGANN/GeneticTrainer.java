package ColoringGANN;

import java.awt.Color;
import java.util.ArrayList;

public class GeneticTrainer {
    public float trainingtestRatio;
    public int maxPopulationSize;
    public float mutationRate;
    
    public double bestScore;
    public GANN bestANN;
    
    ArrayList<GANN> population = new ArrayList<>();
    Dataset dataset = new Dataset();

    public GeneticTrainer(float trainingtestRatio, int populationSize, float mutationRate) {
        this.trainingtestRatio = trainingtestRatio;
        this.maxPopulationSize = populationSize;
        this.mutationRate = mutationRate;
    }
    
    public void initialize() {
        for(int i=0; i<maxPopulationSize; i++) {
            GANN gann = new GANN();
            gann.randomize();
            population.add(gann);
        }
    }
    
    public void selection(){
        if (bestANN == null) {
            bestANN = population.get(0);
            bestScore = calculateScore(bestANN);
        }
        
        for (int i=1; i<population.size(); i++) {
            GANN ann = population.get(i);
            double score = calculateScore(ann);
            if (score < bestScore) {
                bestANN = ann;
                bestScore = score;
            }
        }
        
        population.clear();
        population.add(bestANN);
    }
    
    private double calculateScore(GANN gann){
        double totalScore = 0;
        
        for(int i=0; i<dataset.size(); i++) {
            ColorData c = dataset.get(i);
            
            Color[] colors = gann.generateColor(c.mode, c.warnaDominan);
            
            totalScore += compareColorDiff(colors[0], c.warnaTerang);
            totalScore += compareColorDiff(colors[1], c.warnaMid);
            totalScore += compareColorDiff(colors[2], c.warnaDark1);
            totalScore += compareColorDiff(colors[3], c.warnaDark2);
        }
        
        return totalScore;
    }
    
    private double compareColorDiff(Color a, Color b) {
        double total = 0;
        
        float[] a_hsb = new float[3];
        float[] b_hsb = new float[3];
        
        Color.RGBtoHSB(a.getRed(), a.getBlue(), a.getGreen(), a_hsb);
        Color.RGBtoHSB(b.getRed(), b.getBlue(), b.getGreen(), b_hsb);
        
        for(int i=0; i<3; i++){
            total += Math.abs(a_hsb[i] - b_hsb[i]);
        }
        
        return total;
    }
    
    public void reproduction() {
        while(population.size() < maxPopulationSize) {
            population.add(bestANN.clone().mutate(mutationRate));
        }
    }
}
