package pkg;

import java.util.Arrays;

/**
 * <h1>Clasa abstracta Source</h1>
 * <p>Aceasta clasa retine valorile generale ale diferitelor surse existente cum ar fi numele unui depozit sau numele unei fabrici
 * pe langa un nume aceasta clasa va salva si capacitatea unui depozit sau fabrici iar in final avem variabila supply care retine supply.ul existent in fabrica</p>
 */
public abstract class Source {
    private String name;
    private int[] capacity;
    private String type;
    private int supply;

    public Source() {
        this.type = getType();
    }

    /**
     * <h3>setName</h3>
     * <p>Acesta este setterul numelui din clasa Source.</p>
     *
     * @param name numele companiei.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <h3>setCapacity</h3>
     * <p>seteaza capacitatea fabricii/depozitului.</p>
     *
     * @param capacity capacitatea fabricii/depozitului.
     */
    public void setCapacity(int[] capacity) {
        this.capacity = capacity;
    }

    /**
     * <h3>setSupply</h3>
     * <p>seteaza supply.ul unei fabrici/depozit.</p>
     *
     * @param supply supply.ul fabricii/depozitului.
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }

    /**
     * <h3>getName</h3>
     *
     * @return numele fabricii/depozitului.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <h3>getCapacity</h3>
     *
     * @return capacitatea fabricii/depozitului.
     */
    public int[] getCapacity() {
        return this.capacity;
    }

    /**
     * <h3>getSupply</h3>
     *
     * @return supply.ul fabricii/depozitului.
     */
    public int getSupply() {
        return this.supply;
    }

    /**
     * <h3>getType</h3>
     * <p>Aceasta este functia abstracta care se regaseste in extensiile clasei Source</p>
     * @return returneaza tipul de sursa de supply.
     */
    public abstract String getType();

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", capacity=" + Arrays.toString(capacity) +
                ", supply=" + supply +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
