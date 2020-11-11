package ColoringGANN;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

public class GeneticTrainer {
    public float trainingtestRatio;
    public int maxPopulationSize;
    public float mutationRate;
    
    public double bestScore;
    public double bestTestScore;
    public GANN bestANNTraining;
    public GANN bestANNTest;
    
    ArrayList<GANN> population = new ArrayList<>();
    Dataset dataset_training = new Dataset();
    Dataset dataset_test = new Dataset();

    public GeneticTrainer(float trainingtestRatio, int populationSize, float mutationRate) {
        this.trainingtestRatio = trainingtestRatio;
        this.maxPopulationSize = populationSize;
        this.mutationRate = mutationRate;
        
        initialize();
    }
    
    public void initialize() {
        for(int i=0; i<maxPopulationSize; i++) {
            GANN gann = new GANN();
            gann.randomize();
            population.add(gann);
        }
    }
    
    public void loadDataset(File path) {
        dataset_training.loadDataset(path);
        
        int total_test_size = (int) (dataset_training.size() * (1-trainingtestRatio));
        
        for (int i=0; i<total_test_size; i++) {
            dataset_test.addData(dataset_training.removeRandomData());
        }
        
        bestANNTraining = population.get(0);
        bestANNTest = bestANNTraining;

        bestScore = calculateTrainingScore(bestANNTraining);
        bestTestScore = calculateTestScore(bestANNTest);
    }
    
    public boolean loadGANN(File path) {
        GANN g = new GANN();
        
        boolean isSucess = g.loadDNA(path);
        
        if(isSucess) {
            population.clear();
            population.add(g);
            
            bestANNTraining = population.get(0);
            bestANNTest = bestANNTraining;
            
            reproduction();
            
            if(dataset_training.size() + dataset_test.size() != 0) {
                bestScore = calculateTrainingScore(bestANNTraining);
                bestTestScore = calculateTestScore(bestANNTest);
            }
            
            return true;
        }
        return false;
    }
    
    public void nextGen() {
        selection();
        reproduction();
    }
    
    public void selection(){
        for (int i=1; i<population.size(); i++) {
            evaluateGANNAt(i);
        }
        
        keepBest();
    }
    
    public void reproduction() {
        while(population.size() < maxPopulationSize) {
            population.add(bestANNTraining.clone().mutate(mutationRate));
        }
    }
    
    public void evaluateGANNAt(int index) {
        GANN ann = population.get(index);
        double score = calculateTrainingScore(ann);
        if (score < bestScore) {
            bestANNTraining = ann;
            
            double testScore = calculateTestScore(ann);
            bestTestScore = testScore;
            bestANNTest = ann;
            
            bestScore = score;
        }
    }
    
    public void keepBest() {
        population.clear();
        population.add(bestANNTest);
    }
    
    private double calculateTrainingScore(GANN gann){
        double totalScore = 0;
        
        for(int i=0; i<dataset_training.size(); i++) {
            ColorData c = dataset_training.get(i);
            
            Color[] colors = gann.generateColor(c.mode, c.warnaDominan);
            
            double score = 0;
            score += compareColorDiff(colors[0], c.warnaTerang);
            score += compareColorDiff(colors[1], c.warnaMid);
            score += compareColorDiff(colors[2], c.warnaDark1);
            score += compareColorDiff(colors[3], c.warnaDark2);
            
            score *= 0.25;
            
            totalScore += score;
        }
        
        return totalScore / dataset_training.size();
    }
    
    private double calculateTestScore(GANN gann){
        double totalScore = 0;
        
        for(int i=0; i<dataset_test.size(); i++) {
            ColorData c = dataset_test.get(i);
            
            Color[] colors = gann.generateColor(c.mode, c.warnaDominan);
            
            double score = 0;
            score += compareColorDiff(colors[0], c.warnaTerang);
            score += compareColorDiff(colors[1], c.warnaMid);
            score += compareColorDiff(colors[2], c.warnaDark1);
            score += compareColorDiff(colors[3], c.warnaDark2);
            
            score *= 0.25;
            
            totalScore += score;
        }
        
        return totalScore / dataset_test.size();
    }
    
    private double compareColorDiff(Color a, Color b) {
        double total = 0;
        
        float[] a_hsb = new float[3];
        float[] b_hsb = new float[3];
        
        Color.RGBtoHSB(a.getRed(), a.getGreen(), a.getBlue(), a_hsb);
        Color.RGBtoHSB(b.getRed(), b.getGreen(), b.getBlue(), b_hsb);
        
        
        total += Math.abs(a_hsb[0] - b_hsb[0]) * 3;
        total += Math.abs(a_hsb[1] - b_hsb[1]);
        total += Math.abs(a_hsb[2] - b_hsb[2]);
        
        total /= 6;
        
        return total;
    }
}
