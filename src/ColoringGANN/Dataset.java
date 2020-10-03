package ColoringGANN;

import java.util.ArrayList;

public class Dataset {
    private ArrayList<ColorData> dataList = new ArrayList<ColorData>();
    
    public void loadDataset(String path) {
        // TODO
    }
    
    public ColorData get(int index) {
        return dataList.get(index);
    }
    
    public int size() {
        return dataList.size();
    }
}
