package ColoringGANN;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataset {
    private ArrayList<ColorData> dataList = new ArrayList<ColorData>();
    
    public void loadDataset(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                ColorData c = new ColorData();
                
                c.mode = modeToIndex(sc.next());
                c.warnaDominan = Color.decode(sc.next());
                c.warnaTerang = Color.decode(sc.next());
                c.warnaMid = Color.decode(sc.next());
                c.warnaDark1 = Color.decode(sc.next());
                c.warnaDark2 = Color.decode(sc.next());
                
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
    
    public int size() {
        return dataList.size();
    }
}
