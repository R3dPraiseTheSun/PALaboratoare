package pkg;

import java.util.Arrays;
import java.util.Objects;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int[] capacity) {
        this.capacity = capacity;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public String getName() {
        return this.name;
    }

    public int[] getCapacity() {
        return this.capacity;
    }

    public int getSupply() {
        return this.supply;
    }


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && Objects.equals(name, source.name) && Arrays.equals(capacity, source.capacity) && Objects.equals(type, source.type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, type, supply);
        result = 31 * result + Arrays.hashCode(capacity);
        return result;
    }
}
