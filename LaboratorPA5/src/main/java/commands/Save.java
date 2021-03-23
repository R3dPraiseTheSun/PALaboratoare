package commands;

import catalog.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface Save extends Serializable {
    static void save(Catalog catalog) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(catalog.getPath());
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(catalog);
        objectOut.close();
        fileOut.close();
        System.out.println("Serialized data is saved in " + catalog.getPath());
    }
}
