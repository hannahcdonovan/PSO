import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Swarm {


    /*
     * List containing all of the Particles in the Swarm
     */
    private List<Particle> particleList;


    /*
     * The number of particles in the Swarm
     */
    private int numParticles; 


    /*
     * List containing all of the Neighborhoods that comprise the Swarm
     */
    private List<Neighborhood> neighborhoods;


    private final double NEIGHBORHOOD_CHANGE_PROB = 0.2;

    final int NEIGHBORHOOD_SIZE = 5;



    /*  
     *   Constructor which creates a Swarm with numParticles number of particles. 
     *
     *   @param numParticles - the number of Particles in the Swarm
     */
    public Swarm(int numParticles) {
        this.numParticles = numParticles;
        particleList = new ArrayList<Particle>();
        neighborhoods = new ArrayList<Neighborhood>();
    }


    /*
     * Creates neighborhoods that conform to a ring topology. This means that the particles 
     * are imagined to be in a ring and each particle's neighborhood is comprised of the 
     * particle to its left, the particle to its right, and itself. This method will create a 
     * neighborhood for each particle in the Swarm and add it to neighborhoods
     */    
    public void makeRingNeighborhood() {

        if (numParticles > 2) {
            for (int i = 0; i < this.numParticles; i++) {

                int beforeIndex = (i - 1) % this.particleList.size();
                int afterIndex = (i + 1) % this.particleList.size();

                if (beforeIndex == -1) {
                    beforeIndex = this.particleList.size() - 1;
                }

                Particle before = this.particleList.get(beforeIndex);
                Particle after = this.particleList.get(afterIndex);

                List<Particle> neighborhoodList = new ArrayList<Particle>();
                neighborhoodList.add(before);
                neighborhoodList.add(after);
                neighborhoodList.add(this.particleList.get(i));

                Neighborhood newNeighborhood = new Neighborhood(neighborhoodList);
                this.particleList.get(i).setNeighborhood(newNeighborhood);
                neighborhoods.add(newNeighborhood);
            }

        } else {
            System.out.println("size smaller than two");
        }
    }


    /*
     * Creates neighborhoods for the Swarm which conform to the Von Neumann topology. This means that
     * the particles can be imagined as arranged in a grid. Each particle's neighborhood is comprised
     * of the particle to its left, the particle to its right, the particle above it, the particle below
     * it, and itself. This grid is imagined as wrapped around, where the particle "above" a particle in the 
     * top row is the particle in the same column in the bottom row. Similarly, the particle to the "right" of 
     * a particle in the rightmost column is the particle on the leftmost column of this same row. A
     * neighborhood is created for each particle and added to neighborhoods. 
     */
    public void makeVonNeumannNeighborhood() {

        int numRows = 0;
        int numColumns = 0;

        double sizeRoot = Math.sqrt(this.numParticles);
        int roundedRoot = (int) Math.round(sizeRoot);

        numRows = this.numParticles / roundedRoot;
        numColumns = roundedRoot;

        Particle[][] neumannArray = new Particle[numRows][numColumns];

        int counter = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (counter < this.numParticles) {
                    neumannArray[i][j] = this.particleList.get(counter);
                    counter++;
                }
            }
        }


        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                List<Particle> neighborhoodList = new ArrayList<Particle>();
                int aboveIndex = (i - 1) % numRows;
                int belowIndex = (i + 1) % numRows;
                int leftIndex = (j - 1) % numColumns;
                int rightIndex = (j + 1) % numColumns;

                if (aboveIndex == -1) {
                    aboveIndex = numRows - 1;
                }
                if (leftIndex == -1) {
                    leftIndex = numColumns - 1;
                }

                Particle above = neumannArray[aboveIndex][j];
                Particle below = neumannArray[belowIndex][j];
                Particle left = neumannArray[i][leftIndex];
                Particle right = neumannArray[i][rightIndex];

                neighborhoodList.add(above);
                neighborhoodList.add(below);
                neighborhoodList.add(left);
                neighborhoodList.add(right);
                neighborhoodList.add(neumannArray[i][j]);

                Neighborhood newNeighborhood = new Neighborhood(neighborhoodList);
                neumannArray[i][j].setNeighborhood(newNeighborhood);
                neighborhoods.add(newNeighborhood);
            }
        }
    }


    /*
     * Creates a Neighborhood for each Particle according to global topology. This means that each
     * particle's neighborhood is every Particle in the Swarm, including itself Therefore, each 
     * Particle has the same Neighborhood. 
     */
    public void makeGlobalNeighborhood() {

        Neighborhood globalNeighborhood = new Neighborhood(this.particleList);
        for (int i = 0; i < this.particleList.size(); i++) {
            this.particleList.get(i).setNeighborhood(globalNeighborhood);
        }

        neighborhoods.add(globalNeighborhood);
    }


    /*
     * This creates a Neighborhood for each Particle in the Swarm according to a random topology. This 
     * means that each Particle has a Neighborhood comprised of k random other unique Particles in the 
     * Swarm. A Neighborhood is created for each Particle and added to neighborhoods
     * 
     */
    public void makeRandomNeighborhood(int k) {
        Random rand = new Random();
        Set<Integer> numSet = new HashSet<Integer>();

        for (int i = 0; i < this.particleList.size(); i++) {
            List<Particle> neighborhoodList = new ArrayList<Particle>();
            neighborhoodList.add(this.particleList.get(i));
            numSet.clear();

            for (int j = 0; j < k; j++) {
                int randNum = rand.nextInt(this.particleList.size());

                while (numSet.contains(randNum)) {
                    randNum = rand.nextInt(this.particleList.size());
                }

                numSet.add(randNum);
                neighborhoodList.add(this.particleList.get(randNum));
            }

            Neighborhood newNeighborhood = new Neighborhood(neighborhoodList);
            this.particleList.get(i).setNeighborhood(newNeighborhood);
            neighborhoods.add(newNeighborhood);
        }
    }


    /*
     * This method populates the Swarm with particles with random positions and velocities that
     * are within the suggested bounds for the specific function. Each Particle that is made is 
     * added to particleList. This method makes numParticles Particles. 
     * 
     * @param dimensions - integer repreresenting the dimension of each Particle
     * @param func - Function that is the instance of the particular function used to evaluate each Particle
     */
    public void initialize(int dimensions, Function func) {
        Particle randParticle;
        for (int i = 0; i < this.numParticles; i++) {
            randParticle = new Particle(dimensions, func);
            randParticle.generateRandomPosition();
            randParticle.generateRandomVelocity();
            particleList.add(randParticle);
        }
    }

    public void randomizeNeighborhoods() {
        Random gen = new Random();
        for(int i = 0; i < this.particleList.size(); i++) {
            double probabiltyPicker = gen.nextDouble();
            if(probabiltyPicker < NEIGHBORHOOD_CHANGE_PROB) {
                Neighborhood newNeighborhood = this.pickRandomNeighborhood(this.particleList.get(i), NEIGHBORHOOD_SIZE);
                Neighborhood oldNeighborhood = this.particleList.get(i).getNeighborhood();
                this.neighborhoods.remove(oldNeighborhood);
                this.particleList.get(i).setNeighborhood(newNeighborhood);
                neighborhoods.add(newNeighborhood);
            }
        }
    }

    public Neighborhood pickRandomNeighborhood(Particle p, int k) {
        Random rand = new Random();
        List<Particle> neighborhoodList = new ArrayList<Particle>();
        Set<Integer> numSet = new HashSet<Integer>();

            neighborhoodList.add(p);
            numSet.clear();

            for (int j = 0; j < k; j++) {
                int randNum = rand.nextInt(this.particleList.size());

                while (numSet.contains(randNum)) {
                    randNum = rand.nextInt(this.particleList.size());
                }

                numSet.add(randNum);
                neighborhoodList.add(this.particleList.get(randNum));
            }

        Neighborhood newNeighborhood = new Neighborhood(neighborhoodList);
        return newNeighborhood;
    }


    /*
     * This returns the List of Neighborhoods that comprise the Swarm
     */
    public List<Neighborhood> getNeighborhoods() {
        return this.neighborhoods;
    }


    /*
     * This return the List of Particles that comprise the Swarm
     */
    public List<Particle> getParticles() {
        return this.particleList;
    }

    /*
     * This updates the best of each Neighborhood in neighborhoods
     */
    public void updateNeighborhoodBestList() {
        for (int i = 0; i < neighborhoods.size(); i++) {
            neighborhoods.get(i).updateBest();
        }
    }

    /*
     * Prints the String representation of each Particle in the Swarm
     */
    public String toString() {
        String swarm = "";
        for (int i = 0; i < particleList.size(); i++) {
            swarm += particleList.get(i).toString() + "\n";
        }
        return swarm;
    }
}