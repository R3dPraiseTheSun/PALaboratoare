package itemtypes;

import item.Item;

public class Song extends Item {
    private String artist;

    public Song(String artistName, String path){
        this.artist = artistName;
        setPath(path);
        getFile();
    }

    @Override
    public String getArtist(){
        return this.artist;
    }

}
