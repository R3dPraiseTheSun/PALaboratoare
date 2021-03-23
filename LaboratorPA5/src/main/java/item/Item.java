package item;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public abstract class Item implements Serializable{
    private String itemPath;
    private File itemFile;

    public void setPath(String path){
        this.itemPath = path;
    }
    public void getFile(){
        this.itemFile = new File(this.itemPath);
    }
    public void executeFile() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(this.itemFile);
    }

    public abstract String getArtist();

    @Override
    public String toString() {
        return "Item{" +
                "itemPath='" + itemPath + '\'' +
                ", itemFile=" + itemFile +
                '}';
    }


}
