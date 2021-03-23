package commands;

import catalog.Catalog;

import java.io.IOException;

public interface Play {
    static void play(Catalog catalog, int id) throws IOException {
        catalog.getItemByID(id).executeFile();
    }
}
