package catalog;

import commands.Commands;
import exceptions.InvalidCatalogException;
import item.Item;

import java.util.ArrayList;
import java.util.List;

public class Catalog implements Commands{
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog(){

    }
    public Catalog(String name, String path) throws InvalidCatalogException {
        this.name = name;
        if(path == null)
            throw new InvalidCatalogException("The path given is null");
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
    public List<Item> getItemList(){
        return this.items;
    }
    public Item getItemByID(int id){
        return items.get(id);
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPath(String path){
        this.path = path;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void listItems(){
        for(Item item : this.items)
            System.out.println(item.toString());
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", items=" + items +
                '}';
    }

}
