package itemtypes;

import item.Item;

public class Movie extends Item {
    private String artist;

    public Movie(String artistName, String path){
        this.artist = artistName;
        setPath(path);
        getFile();
    }

    @Override
    public String getArtist(){
        return this.artist;
    }
}
