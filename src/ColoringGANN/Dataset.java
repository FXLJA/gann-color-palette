package ColoringGANN;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dataset {
    private ArrayList<ColorData> dataList = new ArrayList<ColorData>();
    private static Random rand = new Random(System.currentTimeMillis());
    
    public void loadDataset(File path) {
        try {
            Scanner sc = new Scanner(path);
            sc.useDelimiter(",|\\r\\n");
            while (sc.hasNext()) {
                ColorData c = new ColorData();
                
                c.mode = modeToIndex(sc.next().trim());
                c.warnaDominan = Color.decode(sc.next().trim());
                c.warnaTerang = Color.decode(sc.next().trim());
                c.warnaMid = Color.decode(sc.next().trim());
                c.warnaDark1 = Color.decode(sc.next().trim());
                c.warnaDark2 = Color.decode(sc.next().trim());
                
                dataList.add(c);
            }  
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private int modeToIndex(String mode){
        switch(mode) {
            case "p":
                return 0;
            case "c":
                return 1;
            case "m":
                return 2;
        }
        System.out.println("Error: Couldn't parse " + mode + "into index");
        return -1;
    }
    
    public ColorData get(int index) {
        return dataList.get(index);
    }
    
    public void addData(ColorData data) {
        dataList.add(data);
    }
    
    public ColorData removeRandomData() {
        return dataList.remove(rand.nextInt(dataList.size()));
    }
    
    public int size() {
        return dataList.size();
    }
}
