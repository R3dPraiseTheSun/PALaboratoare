package pkg;

/**
 *<h1>Aceasta clasa este o extensie a clasei Source si defineste mai exact o fabrica care este o sursa de supply</h1>
 */
public class Factory extends Source{
    public Factory(String name,int[] capacity, int supply){
        this.setName(name);
        this.setCapacity(capacity);
        this.setSupply(supply);
    }

    public String getType(){
        return "Factory";
    }
}
