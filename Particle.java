import java.lang.Math;
import java.util.Random;

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

    	double negRange = this.func.getMinVelBound();
        double posRange = this.func.getMaxVelBound();

        Random rand = new Random();

    	for(int i = 0; i < this.dimensions; i++) {
            double random = 0.0;
            double negRand = (rand.nextDouble() * negRange);
            double posRand = (rand.nextDouble() * posRange);
            int chooser = rand.nextInt(2);
            if (chooser == 0) {
                random = negRand; 
            }
            else if (chooser == 1) {
                random = posRand;
            }
    		this.velocity[i] = random;
    	}
    }

    public double[] getPosition() {
    	return this.position;
    }

    public int getDimension() {
    	return this.dimensions;
    }

    public String toString() {
        String position = "";
        String velocity = "";

        for (int i = 0; i < this.dimensions; i++) {
            position += this.position[i] + " ";
            velocity += this.velocity[i] + " ";
        }
        
        String answer = "The position vector is : " + position + "\nThe velocity vector is: " + velocity + 
                        "\n--------------------------------------------------------------";
        return answer;
    }

}