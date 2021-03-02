package pkg;

/**
 * <h1>Solution este clasa in care problema de la Laboratorul 2 este rezolvata</h1>
 */
public class Solution {
    private Source[] sources;
    private Destination[] destinations;
    private int[][] valuesMatrix;

    private class minimumValueMatrix{
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
     * <p>Acest constructor mai intai verifica daca in sources si in destinations exista dubluri prin folosirea functiei "equals" overriten in clasele respective</br>
     * dupa verificarea Source si Destination se asigneaza Source dupa sources.lentgh, la fel si in destination, </br>
     * iar dupa asignarea sursei si destinatiei matricea care retine costul este asignata.</p>
     * @param sources este un tip de data <i>'Source[]'</i> care ofera solutiei sursele de unde se poate lua supply si costul traseelor.
     * @param destinations este un tip de data <i>'Destination[]</i> care ofera solutiei numele oraselor si demandul acestora.
     */
    public Solution(Source[] sources, Destination[] destinations){
        if(!checkCorrectitude(sources)) System.out.println("[error]Sources are not different!\n");
        if(!checkCorrectitude(destinations)) System.out.println("[error]Destinations are not different!\n");
        this.sources = new Source[sources.length];
        this.sources = sources;
        this.destinations = new Destination[sources.length];
        this.destinations = destinations;
        this.valuesMatrix = new int[this.sources.length][this.destinations.length];
        assignMatrix();
    }

    /**
     * <p><b>printSources()</b> este o functie a clasei <i>'Solution'</i>, aceasta functie afiseaza pe ecran sursele din variabila 'sources' de tip Source[]</p>
     */
    public void printSources(){
        for (Source source : this.sources) System.out.println(source.toString());
    }
    /**
     * <p><b>printDestinations()</b> este o functie a clasei 'Solution', aceasta functie afiseaza pe ecran sursele din variabila 'destinations' de tip Destination[]</p>
     */
    public void printDestinations(){
        for (Destination destination : this.destinations) System.out.println(destination.toString());
    }
    /**
     * <p><b>printMatrix()</b> este o functie a clasei <i>'Solution'</i>, aceasta functie afiseaza pe ecran tabelul de Supply/Demand</p>
     */
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
     * <p><b>solveProblem()</b> este o functie a clasei <i>'Solution'</i>, aceasta functie afiseaza pe ecran in primul rand traseele pe care algoritmul le vede cele mai bune,</br>
     * apoi se afiseaza demandul ramas in total din destinatii, apoi la final cand demandul ajunge la 0 programul afiseaza pe ecran costul total acumulat din trasee.</p>
     *
     * <h3>Metoda de rezolvare</h3>
     * <p>Algoritmul folosit este unul gandit si facut de mine, acesta formeaza o matrice din care extrage minimul din matrice,</br>
     * acest numar este verificat daca are demand pe coloana demand sau mai are supply pe linia de supply,</br>
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
        minimumValueMatrix minimumVal = new minimumValueMatrix();

        while(demandSum(demand) > 0){
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
            for(int i=0;i< sources.length;i++)
                System.out.print(sources[i].getName() + ": Supply=" + supply[i] + " | " + destinations[i].getName() + ": Demand=" + demand[i] + "\n");
            System.out.print("The demand sum is " + demandSum(demand) + "!\n");
        }
        System.out.print("The total cost is: " + cost + "!");
    }

    private boolean checkCorrectitude(Source[] sources){
        for(int i=1;i<sources.length;i++){
            if(sources[i-1].equals(sources[i]))
                return false;
        }
        return true;
    }
    private boolean checkCorrectitude(Destination[] destinations){
        for(int i=1;i<destinations.length;i++){
            if(destinations[i-1].equals(destinations[i]))
                return false;
        }
        return true;
    }
    private void assignMatrix(){
        for(int i=0;i<valuesMatrix.length;i++){
            valuesMatrix[i] = sources[i].getCapacity();
        }
    }

    private int[] assignSupply(Source[] sources){
        int[] supply = new int[sources.length];
        for(int i=0;i<sources.length;i++) supply[i] = sources[i].getSupply();
        return supply;
    }
    private int[] assignDemand(Destination[] destinations){
        int[] demand = new int[destinations.length];
        for(int i=0;i<destinations.length;i++) demand[i] = destinations[i].getDemand();
        return demand;
    }
    private int demandSum(int[] demand){
        int sum = 0;
        for (int j : demand) sum += j;
        return sum;
    }
    private minimumValueMatrix getMinimumValueMatrix(int[] supply, int[] demand){
        minimumValueMatrix minima = new minimumValueMatrix();
        minima.assignValue(0,0,9999);
        for(int i=0;i< valuesMatrix.length;i++){
            for(int j=0;j< valuesMatrix[i].length;j++) {
                if(valuesMatrix[i][j] < minima.value && demand[j]>0 && supply[i]>0) minima.assignValue(i,j,valuesMatrix[i][j]);
            }
        }
        return minima;
    }
}
