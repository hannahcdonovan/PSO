import java.util.List;
import java.util.ArrayList;

public class PSO {


    /*
     * The number of dimensions of each Particle in the Swarm
     */
    int dimensions;


    /*
     * The specific function that is being optimized by the Swarm
     */
    Function function;


    /*
     * The number of particles in the Swarm
     */
    int numParticles;


    /*
     * The Swarm being used to optimize the function 
     */
    Swarm swarm;


    /*
     * The number of iterations being executed in the optimization
     */
    int iterations;


    /*
     * The String name of the type of neighborhood toplogy being used
     */
    String neighborhoodType;


    /*
     * The String name of the function that is being optimized 
     */
    String funcName;


    /*
     * the size of the random neighborhoods in the random neighborhood topology
     */
    final int NEIGHBORHOOD_SIZE = 5;


    /*
     * the constriction constant being applied to velocity
     */
    final double CONSTRICTION_CONSTANT = 0.7298;


    /*
     * phi being used in new velocity generation
     */
    final double PHI_ONE = 2.05;


    /*
     * phi being used in new velocity generation
     */
    final double PHI_TWO = 2.05;



    /*
     * Creates a new instance of the PSO (Particle Swarm Optimization) algorithm according to the specifications. 
     * @param dimensions - the number of dimensions for each Particle in the Swarm
     * @param funcName - the String name of the function being optmimized
     * @param numParticles - the number of Particles in the Swarm
     * @param iterations - the number of iterations being run in the optimization
     * @param neighborhoodType - the String name of the neighborhood toplogy being used 
     */
    public PSO(int dimensions, String funcName, int numParticles, int iterations, String neighborhoodType) {
        
        this.dimensions = dimensions;
        this.numParticles = numParticles;
        this.iterations = iterations;
        this.neighborhoodType = neighborhoodType;
        this.funcName = funcName;

        if(funcName.equals("rok")) {
            this.function = new Function("rok", 15.0, 30.0, 2.0, -2.0);

        } else if(funcName.equals("ack")) {
            this.function = new Function("ack", 16.0, 32.0, 4.0, -2.0);

        } else if(funcName.equals("ras")) {
            this.function = new Function("ras", 2.56, 5.12, 4.0, -2.0);

        } else {
            this.function = new Function("rock", 15.0, 30.0, 2.0, -2.0);
            System.out.println("made rosenbrock by default, something went wrong with funcName");
        }

        Swarm newSwarm = new Swarm(numParticles);
        newSwarm.initialize(this.dimensions, this.function);

        if(neighborhoodType.equals("gl")){
            newSwarm.makeGlobalNeighborhood();

        } else if (neighborhoodType.equals("ri")) {
            newSwarm.makeRingNeighborhood();

        } else if (neighborhoodType.equals("vn")) {
            newSwarm.makeVonNeumannNeighborhood();

        } else if (neighborhoodType.equals("ra")) {
            newSwarm.makeRandomNeighborhood(NEIGHBORHOOD_SIZE);

        } else  {
            newSwarm.makeGlobalNeighborhood();
            System.out.println("made global neighborhood by default, something was wrong with neighborhood type name");
        }

        this.swarm = newSwarm;
    }


    /*
     * The method that is being called to execute the optimization using this PSO instance
     */
    public List<Double> optimize() {

        List<Double> optResults = new ArrayList<Double>();

        double bestScore = Double.POSITIVE_INFINITY;

        System.out.println("START OF THE OPTIMIZATION");


        for(int i = 0; i < this.iterations; i++) {

            double iterBestScore = Double.POSITIVE_INFINITY;
            for(Neighborhood n: this.swarm.getNeighborhoods()) {
                n.updateBest();
                double nBestScore = n.getNeighborhoodBest().getCurrentScore();
                if(nBestScore < iterBestScore) {
                    iterBestScore = nBestScore;
                }
            }
            for(Particle p: this.swarm.getParticles()) {
                p.generateNewPositionAndVelocity(CONSTRICTION_CONSTANT, PHI_ONE, PHI_TWO );
            }

            if(iterBestScore < bestScore) {
                bestScore = iterBestScore;
            }

            if((i + 1) % 1000 == 0) {
                optResults.add(bestScore);
            }
        }
        return optResults;
    }

    public static void main(String[] args) {

        PSO pso = new PSO(30, "rok", 16, 10000, "ra");
        List<Double> opt = pso.optimize();
        for(int i = 0; i < opt.size(); i++) {
            System.out.println(opt.get(i));
        }
    }
}