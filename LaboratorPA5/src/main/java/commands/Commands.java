package commands;

import catalog.Catalog;

import java.io.*;

public interface Commands extends Load, Save, Add, List, Play, Report{
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
    static void save(Catalog catalog) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(catalog.getPath());
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(catalog);
        objectOut.close();
        fileOut.close();
        System.out.println("Serialized data is saved in " + catalog.getPath());
    }
}
