package ColoringGANN;

import java.util.ArrayList;

public class GeneticTrainer {
    public float trainingtestRatio;
    public int maxPopulationSize;
    public float mutationRate;
    
    public GANN bestANN;
    
    ArrayList<GANN> population = new ArrayList<>();

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
    
    public void loadDataset(String path) {
        // TODO
    }
    
    public void selection(){
        // TODO
    }
    
    public void reproduction() {
        while(population.size() < maxPopulationSize) {
            population.add(bestANN.clone().mutate(mutationRate));
        }
    }
}
