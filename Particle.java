import java.lang.Math;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Particle {

    Random gen = new Random();

    private int dimensions;

    private double[] position;

    private double[] velocity;

    private double[] personalBestPos;

    private double personalBestScore;

    private Neighborhood neighborhood;

    private Function func;

    private double currentScore = 1000;

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

    public Particle copyParticle() {

        Particle newParticle = new Particle(this.dimensions, this.func, this.position, this.velocity, this.personalBestPos, 
                                             this.personalBestScore, this.neighborhood);
        return newParticle;
    }



    public void setNeighborhood(Neighborhood newNeighborhood) {
        this.neighborhood = newNeighborhood;
        //this.neighborhood.setNeighborhoodBest(newNeighborhood.getNeighborhoodList().get(0));
    }

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

    private void generateNewVelocity(double constriction, double phi1, double phi2) {

        double[] newVelo = new double[this.dimensions];

        for(int i = 0; i < this.dimensions; i++) {
            double part1 = constriction * (this.velocity[i] + gen.nextDouble()*phi1);
            double part2 = (this.personalBestPos[i] - this.position[i]) + (gen.nextDouble()*phi2);
            double part3 = (this.neighborhood.getNeighborhoodBest().personalBestPos()[i] - this.position[i]);

            newVelo[i] = part1*part2*part3;
        }
        
        this.velocity = newVelo;
    }

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


    public void updatePersonalBest() {

        double currentScore = this.func.evaluate(this);
        if(currentScore < this.personalBestScore) {
            this.personalBestScore = currentScore;
            this.personalBestPos = this.position.clone();
        }
    }
    

    public double[] getPosition() {
        return this.position;
    }

    public int getDimension() {
        return this.dimensions;
    }

    public Function getFunc() {
        return this.func;
    }

    public double[] getVelocity() {
        return this.velocity;
    }

    public Neighborhood getNeighborhood() {
        return this.neighborhood;
    }

    public double[] personalBestPos() {
        return this.personalBestPos;
    }

    public double personalBestScore() {
        return this.personalBestScore;
    }

    public void setCurrentScore(double score) {
        this.currentScore = score;
    }

    public double getCurrentScore() {
        return this.currentScore;
    }


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