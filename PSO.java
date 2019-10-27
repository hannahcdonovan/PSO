public class PSO {

    int dimension;

    Function function;

    Neighborhood neighborhood;

    int numParticles;


    //swarm
    //function
    //dimensions
    //num particles
    
    public PSO(int dimension, Function function, Neighborhood neighborhood, int numParticles) {
        this.dimension = dimension;
        this.function = function;
        this.neighborhood = neighborhood;
        this.numParticles = numParticles;
    }

}