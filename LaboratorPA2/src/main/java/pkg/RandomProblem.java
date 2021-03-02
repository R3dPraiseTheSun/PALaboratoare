package pkg;

import java.util.Random;

public class RandomProblem {
    private final Source[] sources;
    private final Destination[] destinations;

    public RandomProblem() {
        Random random = new Random();
        int sourcesLength = random.nextInt(10)+1;
        this.sources = new Source[sourcesLength];
        int destinationsLength = random.nextInt(10)+1;
        this.destinations = new Destination[destinationsLength];
        populateArray(sources);
        populateArray(destinations);

        //RandomProblemSolve
        Solution solution = new Solution(sources,destinations);
        solution.printSources();
        solution.printDestinations();
        solution.printMatrix();
        solution.solveProblem();
    }

    public Source[] getSource(){
        return this.sources;
    }

    public Destination[] getDestinations(){
        return this.destinations;
    }

    private void populateArray(Source[] sources){
        Random random = new Random();
        int type;
        for(int index=0;index<sources.length;index++) {
            int[] capacity = new int[this.destinations.length];
            for(int subIndex=0;subIndex<this.destinations.length;subIndex++) {
                capacity[subIndex] = random.nextInt(10) + 1;
            }
            type = random.nextInt(2);
            if(type == 0)
                sources[index] = new Factory(new StringBuilder().append("Shop").append(index+1).toString(), capacity, random.nextInt(100));
            else if(type ==1)
                sources[index] = new Warehouse(new StringBuilder().append("Shop").append(index+1).toString(), capacity, random.nextInt(150));
        }
    }
    private void populateArray(Destination[] destinations){
        Random random = new Random();
        for(int index=0;index<destinations.length;index++){
            destinations[index] = new Destination(new StringBuilder().append("Destination").append(index+1).toString(),random.nextInt(100));
        }
        int differenceSupplyDemand = random.nextInt(100);
        if((supplySum(sources.length) - demandSum(destinations.length) < 0))
            differenceSupplyDemand = -(supplySum(sources.length) - demandSum(destinations.length));
        destinations[destinations.length-1] = new Destination(new StringBuilder().append("Destination").append(destinations.length).toString(), differenceSupplyDemand);
    }

    private int supplySum(int length){
        int sum = 0;
        for(int index=0;index<length-1;index++)
            sum+=this.sources[index].getSupply();
        return sum;
    }
    private int demandSum(int length){
        int sum = 0;
        for(int index=0;index<length-1;index++)
            sum+=this.destinations[index].getDemand();
        return sum;
    }
}
