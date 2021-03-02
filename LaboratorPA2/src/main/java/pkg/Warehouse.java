package pkg;

/**
 *<h1>Aceasta clasa este o extensie a clasei Source si defineste mai exact un depozit care este o sursa de supply</h1>
 */
public class Warehouse extends Source{
    /**
     *<h1>Constructorul Warehouse</h1>
     * <p>Acest constructor este folosit pentru crearea in memorie al obiectului de tip abstract Source pe nume Factory</p>
     * @param name numele depozitului.
     * @param capacity capacitatea depozitului.
     * @param supply supply.ul depozitului.
     */
    public Warehouse(String name,int[] capacity, int supply){
        this.setName(name);
        this.setCapacity(capacity);
        this.setSupply(supply);
    }

    public String getType(){
        return "Warehouse";
    }
}
