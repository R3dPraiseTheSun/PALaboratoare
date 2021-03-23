package itemtypes;

import item.Item;

public class Book extends Item {
    private String artist;

    public Book(String artistName, String path){
        this.artist = artistName;
        setPath(path);
        getFile();
    }

    @Override
    public String getArtist(){
        return this.artist;
    }
}
