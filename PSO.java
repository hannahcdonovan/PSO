public class PSO {

    int dimension;

    Function function;

    Neighborhood neighborhood;

    int numParticles;

    public PSO(int dimension, Function function, Neighborhood neighborhood, int numParticles) {
        this.dimension = dimension;
        this.function = function;
        this.neighborhood = neighborhood;
        this.numParticles = numParticles;
    }

}