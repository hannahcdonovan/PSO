public class Particle {


	private int dimensions;

    private double[] position;

   	private double[] velocity;

    private double[] personalBest;

    private double[] neighborhoodBest;

    private Neighborhood neighborhood;

    private Function func;

    public Particle(int dimensions, Function func) {
        
        this.dimensions = dimensions;
        this.position = new double[dimensions];
        this.velocity = new double[dimensions];
        this.personalBest = new double[dimensions];
        this.neighborhoodBest = new double[dimensions];
        this.func = func;

    }


    public void generateRandomPosition() {

    	double minBound = this.func.getMinBound();
    	double maxBound = this.func.getMaxBound();

    	

    }
}