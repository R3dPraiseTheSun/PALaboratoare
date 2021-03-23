package commands;

import catalog.Catalog;

public interface List {
    static void list(Catalog catalog){
        catalog.listItems();
    }
}
