package pkg;

/**
 *<h1>Aceasta clasa este o extensie a clasei Source si defineste mai exact o fabrica care este o sursa de supply</h1>
 */
public class Factory extends Source{
    /**
     *<h1>Constructorul Factory</h1>
     * <p>Acest constructor este folosit pentru crearea in memorie al obiectului de tip abstract Source pe nume Factory</p>
     * @param name numele fabricii.
     * @param capacity capacitatea fabricii.
     * @param supply supply.ul fabricii.
     */
    public Factory(String name,int[] capacity, int supply){
        this.setName(name);
        this.setCapacity(capacity);
        this.setSupply(supply);
    }

    /**
     *<h1>getType</h1>
     * @return returneaza tipul acestei surse
     */
    public String getType(){
        return "Factory";
    }
}
