
import java.lang.Math;

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

    	double minBound = this.func.getMinPosBound();
    	double maxBound = this.func.getMaxPosBound();

    	double range = maxBound - minBound;

    	for(int i = 0; i < this.dimensions; i++) {
    		double random = (Math.random() * range) + minBound;
    		this.position[i] = random;
    	}
    }


    public void generateRandomVelocity() {

    	double minBound = this.func.getMinVelBound();
    	double maxBound = this.func.getMaxVelBound();

    	double range = maxBound - minBound;

    	for(int i = 0; i < this.dimensions; i++) {
    		double random = (Math.random() * range) + mindBound;
    		this.velocity[i] = random;
    	}
    }


    public double[] getPosition() {
    	return this.position;
    }

    public int getDimension() {
    	return this.dimensions;
    }
}