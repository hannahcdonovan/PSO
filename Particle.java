import java.lang.Math;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
Particle Class represents a single particle to be used in a PSO algorithm. 
Particles "roam" the domain space and are part of larger neighborhoods.
Through neighborhoods, particles "communicate" with one another in search of better solutions.
 */

public class Particle {

    /**
    Used to randomly generate scalar values uniformly between zero and phi
     */
    Random gen = new Random();

    /**
    Number of dimensions the particle's position and velocity are in.
    One less than the dimensionality of the function, because particles
    are within the domain space.
     */
    private int dimensions;

    /**
    Represents the particle's position coordinates
     */
    private double[] position;

    /**
    Represents the particle's velocity 
    */
    private double[] velocity;

    /**
    Stores the best position the particle has explored.
    Influences future behavior
     */
    private double[] personalBestPos;

    /**
    Stores the evaluation of personalBestPos according to the corresponding function
     */
    private double personalBestScore;

    /**
    This is the particle's neighborhood
     */
    private Neighborhood neighborhood;

    /**
    Represents the function that the particle is aiming to optimize
     */
    private Function func;

    /**
    Stores the score of the current position. Initialize at infinity since we are minimizing a function.
     */
    private double currentScore = Double.POSITIVE_INFINITY;

    /**
    @param dimensions - integer value represents the domain space
    @param func - The function we are aiming to optimize

    Constructor (overloaded) for Particle, creates blank arrays for position 
    and velocity since they were not specified.

     */
    public Particle(int dimensions, Function func) {

        this.dimensions = dimensions;
        this.position = new double[dimensions];
        this.velocity = new double[dimensions];
        this.personalBestPos = new double[dimensions];
        this.personalBestScore = 100000;
        List<Particle> neighborhoodList = new ArrayList<Particle>();
        this.neighborhood = new Neighborhood(neighborhoodList);
        this.func = func;

    }

    /**
    @param dimensions - integer value represents the domain space
    @param func - The function we are aiming to optimize
    @param position - array of doubles specifying the particles position in domain
    @param velocity - array of doubles specifying the particles velocity
    @param personalBestPos - array of doubles specifying the best position visited so far
    @param personaBestScore - integer storing the evaluation for the best position so far
    @param neighborhood - an instance of Neighborhood that represents the particle's neighborhood.

    Constructor (overloaded) for Particle, with all variables plugged in by user.
     */
    public Particle(int dimensions, Function func, double[] position, double[] velocity, double[] personalBestPos,
                     double personalBestScore, Neighborhood neighborhood) {

        this.dimensions = dimensions;
        this.position = position;
        this.velocity = velocity;
        this.personalBestScore = personalBestScore;
        this.personalBestPos = personalBestPos;
        this.neighborhood = neighborhood;
        this.func = func;

    }

    /**
    @return newParticle - a Particle instance
    Returns a new instance of Particle with identical data to this particle
     */
    public Particle copyParticle() {

        Particle newParticle = new Particle(this.dimensions, this.func, this.position, this.velocity, this.personalBestPos, 
                                             this.personalBestScore, this.neighborhood);
        return newParticle;
    }


    /**
    @param newNeighborhood - an instance of Neighborhood 
    Sets the neighborhood of this particle to the newNeighborhood
     */
    public void setNeighborhood(Neighborhood newNeighborhood) {
        this.neighborhood = newNeighborhood;
        //this.neighborhood.setNeighborhoodBest(newNeighborhood.getNeighborhoodList().get(0));
    }

    /**
    Generates a random position for this particle,
    with respect to the corresponding function's bounded domain.
     */
    public void generateRandomPosition() {

        double minBound = this.func.getMinPosBound();
        double maxBound = this.func.getMaxPosBound();

        double range = maxBound - minBound;

        for (int i = 0; i < this.dimensions; i++) {
            double random = (Math.random() * range) + minBound;
            this.position[i] = random;
        }

        this.personalBestPos = this.position.clone();

        double score = this.func.evaluate(this);
        this.personalBestScore = score;
    }

    /**
    Generates a random velocity for this particle,
    with respect to the corresponding function's bounded domain.
     */
    public void generateRandomVelocity() {

        double negRange = this.func.getMinVelBound();
        double posRange = this.func.getMaxVelBound();

        Random rand = new Random();

        for (int i = 0; i < this.dimensions; i++) {
            double random = 0.0;
            double negRand = (rand.nextDouble() * negRange);
            double posRand = (rand.nextDouble() * posRange);
            int chooser = rand.nextInt(2);
            if (chooser == 0) {
                random = negRand;
            } else if (chooser == 1) {
                random = posRand;
            }
            this.velocity[i] = random;
        }
    }

    /**
    @param constriction - a constant that may change with the problem. Set in PSO.
    @param phi1 - a parameter that dictates how strong the random scaling is. Can be changed in PSO
    @param phi2 - a parameter that dictates how strong the random scaling is. Can be changed in PSO

    Generates a new velocity vector and sets it to the instance variable velocity.
    Private, as it is called by the public method generateNewPositionAndVelocity
     */
    private void generateNewVelocity(double constriction, double phi1, double phi2) {

        double[] newVelo = new double[this.dimensions];

        for(int i = 0; i < this.dimensions; i++) {
            double partial = this.velocity[i] + (gen.nextDouble()* phi1 * (this.personalBestPos[i] - this.position[i])) + 
                ((gen.nextDouble()*phi2) * (this.neighborhood.getNeighborhoodBest().personalBestPos()[i] - this.position[i]));

            newVelo[i] = constriction*partial;
        }
        
        this.velocity = newVelo;
    }

    /**
    @param constriction - a constant that may change with the problem. Set in PSO.
    @param phi1 - a parameter that dictates how strong the random scaling is. Can be changed in PSO
    @param phi2 - a parameter that dictates how strong the random scaling is. Can be changed in PSO

    Calls generateNewVelocity and uses that new velocity to move this particle to a new position
    Updates best as necessary
     */
    public void generateNewPositionAndVelocity(double constriction, double phi1, double phi2) {
        this.generateNewVelocity(constriction, phi1, phi2);
        //newPos = this.velocity + this.position;

        double[] newPos = new double[this.velocity.length];
        Arrays.setAll(newPos, i -> this.velocity[i] + this.position[i]);
        this.position = newPos;

        double score = this.func.evaluate(this);
        if(score < this.personalBestScore) {
            this.personalBestPos = this.position.clone();
            this.personalBestScore = score;
        }
    }

    /**
    Checks if the currentScore is better than the stored best,
    updates as necessary
     */
    public void updatePersonalBest() {

        double currentScore = this.func.evaluate(this);
        if(currentScore < this.personalBestScore) {
            this.personalBestScore = currentScore;
            this.personalBestPos = this.position.clone();
        }
    }
    
    /**
    @return this.position - an array of doubles
    returns the position of this particle 
     */
    public double[] getPosition() {
        return this.position;
    }

    /**
    @return this.dimensions - an integer
    A getter method for the number of dimensions
     */
    public int getDimension() {
        return this.dimensions;
    }

    /**
    @return this.func - a Function
    A getter method for the function that this particle is aiming to optimize
     */
    public Function getFunc() {
        return this.func;
    }

    /**
    @return this.velocity - an array of doubles
    A getter method for the velocity
     */
    public double[] getVelocity() {
        return this.velocity;
    }

    /**
    @return this.neighborhood - a Neighborhood class
    A getter method the particle's neighborhood
     */
    public Neighborhood getNeighborhood() {
        return this.neighborhood;
    }

    /**
    @return this.personalBestPos - an array of doubles
    A getter method for the best position visited so far
     */
    public double[] personalBestPos() {
        return this.personalBestPos;
    }

    /**
    @return this.personalBestScore - a double
    A getter method for the best score so far
     */
    public double personalBestScore() {
        return this.personalBestScore;
    }

    /** 
    @param double - score
    Sets the score for this particle
    */
    public void setCurrentScore(double score) {
        this.currentScore = score;
    }

    /**
    @return this.currentScore - a double
    A getter method for the current score
     */
    public double getCurrentScore() {
        return this.currentScore;
    }

    /**
    @return String
    A custom toString method for Particle
     */
    public String toString() {
        String position = "";
        String velocity = "";

        // for (int i = 0; i < this.dimensions; i++) {
        //     position += this.position[i] + " ";
        //     velocity += this.velocity[i] + " ";
        // }

        String score = Double.toString(this.func.evaluate(this));


        //String answer = position;
        // "\n--------------------------------------------------------------";
        return score;
    }

}