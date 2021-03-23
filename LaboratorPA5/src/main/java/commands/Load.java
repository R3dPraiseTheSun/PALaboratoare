package commands;

import catalog.Catalog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public interface Load extends Serializable {
    static Catalog load(String path) throws IOException, ClassNotFoundException {
        Catalog loadedCatalog;
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        loadedCatalog = (Catalog) objectIn.readObject();
        objectIn.close();
        fileIn.close();
        System.out.println("Serialized data loaded from " + path);
        return loadedCatalog;
    }
}
