public class PSO {

    int dimensions;

    Function function;

    int numParticles;

    Swarm swarm;

    int iterations;

    String neighborhoodType;

    String funcName;

    final int NEIGHBORHOOD_SIZE = 6;

    final double CONSTRICTION_CONSTANT = 0.7298;

    final double PHI_ONE = 2.05;

    final double PHI_TWO = 2.05;



    public PSO(int dimensions, String funcName, int numParticles, int iterations, String neighborhoodType) {
        
        this.dimensions = dimensions;
        this.numParticles = numParticles;
        this.iterations = iterations;
        this.neighborhoodType = neighborhoodType;
        this.funcName = funcName;



        if(funcName.equals("rock")) {
            this.function = new Function("Rosenbrock", 15.0, 30.0, 2.0, -2.0);

        } else if(funcName.equals("ack")) {
            this.function = new Function("Ackley", 16.0, 32.0, 4.0, -2.0);

        } else if(funcName.equals("ras")) {
            this.function = new Function("Rastrigin", 2.56, 5.12, 4.0, -2.0);

        } else {
            this.function = new Function("Rosenbrock", 15.0, 30.0, 2.0, -2.0);
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



    public void optimize() {

        System.out.println("START OF THE OPTIMIZATION");

        for(int i = 0; i < this.iterations; i++) {

            System.out.println("_________________________________");

            for(Neighborhood n: this.swarm.getNeighborhoods()) {
                n.updateBest();
                System.out.println(n.getNeighborhoodBest());
            }

            for(Particle p: this.swarm.getParticles()) {
                p.generateNewPositionAndVelocity(CONSTRICTION_CONSTANT, PHI_ONE, PHI_TWO );
            }

            System.out.println("__________________________________");
        }
    }


    public static void main(String[] args) {

        PSO pso = new PSO(3, "rock", 10, 10, "gl");
        pso.optimize();
    }
}