package commands;

import catalog.Catalog;
import item.Item;

public interface Add {
    static void add(Catalog catalog, Item item){
        catalog.addItem(item);
    }
}
