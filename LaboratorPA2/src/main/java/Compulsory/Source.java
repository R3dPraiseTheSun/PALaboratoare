package Compulsory;

public class Source {
    private String name;
    private int[] capacity;
    private SourceTypes type;

    public Source(String name, SourceTypes type, int[] capacity){
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(SourceTypes type){
        this.type = type;
    }

    public void setCapacity(int[] capacity){
        this.capacity = capacity;
    }

    public String getName(){
        return this.name;
    }

    public SourceTypes getType(){
        return this.type;
    }

    public int[] getCapacity(){
        return this.capacity;
    }
}
