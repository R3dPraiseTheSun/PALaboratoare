package pkg;

import java.util.Objects;

/**
 * <h1>Destination</h1>
 * <p><b>Destination</b> este o simpla clasa care retine numele si demandul unui oras sau al unei surse care genereaza demand!</p>
 */

public class Destination {
    private String name;
    private int demand;

    /**
     * <h3>Destination constructor</h3>
     * @param name numele orasului.
     * @param demand demandul cerul de orasul respectiv.
     */
    //constructor
    public Destination(String name, int demand){
        this.setName(name);
        this.setDemand(demand);
    }
    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setDemand(int demand){
        this.demand = demand;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public int getDemand(){
        return this.demand;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name: " + name + '\'' +
                ", demand=" + demand +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demand == that.demand && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, demand);
    }
}
