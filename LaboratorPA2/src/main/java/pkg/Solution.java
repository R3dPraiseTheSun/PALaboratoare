package pkg;

/**
 * <h1>Solution este clasa in care problema de la Laboratorul 2 este rezolvata</h1>
 */
public class Solution {
    private Source[] sources;
    private Destination[] destinations;
    private int[][] valuesMatrix;

    private static class minimumValueMatrix{
        int iPos,jPos;
        int value;

        private minimumValueMatrix(){

        }

        private void assignValue(int i, int j, int value){
            this.iPos=i;
            this.jPos=j;
            this.value=value;
        }
    }

    /**
     * <h3>Constructorul <b>Solution</b></h3>
     * <p>Acest constructor mai intai verifica daca in sources si in destinations exista dubluri prin folosirea functiei "equals" overriten in clasele respective
     * dupa verificarea Source si Destination se asigneaza Source dupa sources.lentgh, la fel si in destination,
     * iar dupa asignarea sursei si destinatiei matricea care retine costul este asignata.</p>
     * @param sources este un tip de data <i>'Source[]'</i> care ofera solutiei sursele de unde se poate lua supply si costul traseelor.
     * @param destinations este un tip de data <i>'Destination[]</i> care ofera solutiei numele oraselor si demandul acestora.
     */
    public Solution(Source[] sources, Destination[] destinations){
        if(!checkCorrectitude(sources)) {System.out.println("[error]Sources are not different!\n"); return;}
        if(!checkCorrectitude(destinations)) {System.out.println("[error]Destinations are not different!\n"); return;}
        this.sources = new Source[sources.length];
        this.sources = sources;
        this.destinations = new Destination[sources.length];
        this.destinations = destinations;
        this.valuesMatrix = new int[this.sources.length][this.destinations.length];
        assignMatrix();
    }
    public void printSources(){
        for (Source source : this.sources) System.out.println(source.toString());
    }

    public void printDestinations(){
        for (Destination destination : this.destinations) System.out.println(destination.toString());
    }

    public void printMatrix(){
        //header
        System.out.format("%6s","X|");
        for (Destination value : destinations) System.out.format("%15s|", value.getName());
        System.out.format("%8s%s","","Supply|\n");

        //content
        for (Source source : sources) {
            int[] sourcecapacity = source.getCapacity();
            System.out.format("%6s|", source.getName());
            for (int i : sourcecapacity) System.out.format("%15s|", i);
            System.out.format("%8s%s|\n", "", source.getSupply());
        }

        //footer
        System.out.format("%6s","Demand|");
        for (Destination destination : destinations) System.out.format("%15s|", destination.getDemand());
        System.out.format("%8s%s","","X|\n");
    }

    /**
     * <p><b>solveProblem()</b> este o functie a clasei <i>'Solution'</i>, aceasta functie afiseaza pe ecran in primul rand traseele pe care algoritmul le vede cele mai bune,
     * apoi se afiseaza demandul ramas in total din destinatii, apoi la final cand demandul ajunge la 0 programul afiseaza pe ecran costul total acumulat din trasee.</p>
     *
     * <h3>Metoda de rezolvare</h3>
     * <p>Algoritmul folosit este unul gandit si facut de mine, acesta formeaza o matrice din care extrage minimul din matrice,
     * acest numar este verificat daca are demand pe coloana demand sau mai are supply pe linia de supply,
     * si daca aceste 2 conditii sunt trecute se scade din supply si din demand supply.ul necesar pentru a zeroriza demandul</p>
     *
     * <h3>De ce aceasta metoda de rezolvare?</h3>
     * <p>Aceasta metoda de rezolvare gaseste un cost minim in orice input ar primi!</p>
     * <p>Aceasta metoda de rezolvare este gandita de mine si mi se pare optima din punct de vedere al gandirii!</p>
     *
     */
    public void solveProblem(){
        int cost = 0;
        int[] demand = assignDemand(this.destinations);
        int[] supply = assignSupply(this.sources);
        minimumValueMatrix minimumVal;

        while(demandSum(demand) > 0 && supplySum(supply) > 0){
            minimumVal = getMinimumValueMatrix(supply,demand);

            int supplyNow = supply[minimumVal.iPos];
            if(supplyNow > demand[minimumVal.jPos]) supplyNow = demand[minimumVal.jPos];
            System.out.print(sources[minimumVal.iPos].getName() +
                    "->" + destinations[minimumVal.jPos].getName() +
                    "| cost " + minimumVal.value +
                    " * unit " + supplyNow +
                    "| cost here=" + minimumVal.value * supplyNow + "\n"
            );
            cost += minimumVal.value * supplyNow;
            demand[minimumVal.jPos] -= supplyNow;
            supply[minimumVal.iPos] -= supplyNow;
            for(int index=0,subIndex=0;index< sources.length && subIndex<destinations.length;index++,subIndex++)
                System.out.print(sources[index].getName() +
                        ": Supply=" + supply[index] +
                        " | " + destinations[subIndex].getName() +
                        ": Demand=" + demand[subIndex] +
                        "\n");
            for(int index=0;index< sources.length;index++)
                System.out.print(sources[index].getName() +
                        ": Supply=" + supply[index] +
                        "\n");
            for(int subIndex=0;subIndex< destinations.length;subIndex++)
                System.out.print(destinations[subIndex].getName() +
                        ": Demand=" + demand[subIndex] +
                        "\n");
            System.out.print("The demand sum is " + demandSum(demand) + "!\n");
        }
        System.out.print("The total cost is: " + cost + "!");
    }

    private boolean checkCorrectitude(Source[] sources){
        for(int index=1;index<sources.length;index++){
            if(sources[index-1].equals(sources[index]))
                return false;
        }
        return true;
    }
    private boolean checkCorrectitude(Destination[] destinations){
        for(int index=1;index<destinations.length;index++){
            if(destinations[index-1].equals(destinations[index]))
                return false;
        }
        return true;
    }
    private void assignMatrix(){
        for(int index=0;index<valuesMatrix.length;index++){
            valuesMatrix[index] = sources[index].getCapacity();
        }
    }

    private int[] assignSupply(Source[] sources){
        int[] supply = new int[sources.length];
        for(int index=0;index<sources.length;index++) supply[index] = sources[index].getSupply();
        return supply;
    }
    private int[] assignDemand(Destination[] destinations){
        int[] demand = new int[destinations.length];
        for(int index=0;index<destinations.length;index++) demand[index] = destinations[index].getDemand();
        return demand;
    }
    private int demandSum(int[] demand){
        int sum = 0;
        for (int index : demand) sum += index;
        return sum;
    }

    private int supplySum(int[] supply){
        int sum=0;
        for(int index: supply) sum+= index;
        return sum;
    }
    private minimumValueMatrix getMinimumValueMatrix(int[] supply, int[] demand){
        minimumValueMatrix minima = new minimumValueMatrix();
        minima.assignValue(0,0,9999);
        for(int index=0;index< valuesMatrix.length;index++){
            for(int subIndex=0;subIndex< valuesMatrix[index].length;subIndex++) {
                if(valuesMatrix[index][subIndex] < minima.value && demand[subIndex]>0 && supply[index]>0) minima.assignValue(index,subIndex,valuesMatrix[index][subIndex]);
            }
        }
        return minima;
    }
}
