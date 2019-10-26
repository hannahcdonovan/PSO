import java.util.List;
import java.util.ArrayList;

public class Neighborhood {

    private List<Particle> neighbors;

    private Particle nbest;

    public Neighborhood(List<Particle> neighborList) {
        this.neighbors = neighborList;
    }

    public List<Particle> getNeighborhoodList() {
        return neighbors;
    }

    public void setNeighborhoodBest(Particle currBest) {
        nbest = currBest.copyParticle();
    }

    public void updateBest() {

        Particle currBest = neighbors.get(0);
        Function func = neighbors.get(0).getFunc();
        System.out.println("(1) Curr best is: " + func.evaluate(currBest));
        for (int i = 1; i < neighbors.size(); i++) {
            Particle comparison = neighbors.get(i);
            System.out.println("Comparison is: " + func.evaluate(comparison));
            if (func.evaluate(comparison) < func.evaluate(currBest)) {
                currBest = comparison;
            }
        }
        if(func.evaluate(currBest) < func.evaluate(this.nbest)) {
        	this.setNeighborhoodBest(currBest);
        }
    }

    public Particle getNeighborhoodBest() {
        return this.nbest;
    }
    
    // public String printNeighborhoodBestVal() {
    //     String neighborhoodBest = "";
    //     for (int i = 0; i < neighbors.size(); i++) {
    //         Function func = neighbors.get(i).getFunc();
    //         neighborhoodBest += func.evaluate(this.nbest);
    //     }
    //     return neighborhoodBest;
    // }

    public static void main(String[] args) {
        Swarm swarm = new Swarm(16);
        int dimensions = 1;
        Function func = new Function("Ackley", 15.0, 30.0, 2.0, -2.0);

        swarm.initialize(dimensions, func);

        // System.out.println(swarm.toString());

        swarm.makeVonNeumannNeighborhood();

        System.out.println(swarm.getNeighborhoods());
        swarm.updateNeighborhoodBestList();

        for (int i = 0; i < swarm.getNeighborhoods().size(); i++) {
            System.out.println("Neighborhood best is: " + swarm.getNeighborhoods().get(i).getNeighborhoodBest());
        }
    }

}