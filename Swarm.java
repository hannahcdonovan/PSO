import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Swarm {

    private List<Particle> particleList;

    private int numParticles;

    private List<Neighborhood> neighborhoods;

    public Swarm(int numParticles) {
        this.numParticles = numParticles;
        particleList = new ArrayList<Particle>();
        neighborhoods = new ArrayList<Neighborhood>();
    }


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

        // for(int i = 0; i < numRows; i++) {
        // for(int j = 0; j < numColumns; j++) {
        // System.out.println("[" + i+ "][" + j + "]" + neumannArray[i][j]);
        // }
        // }

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
                // System.out.println("Current one is " + neumannArray[i][j]);
                //System.out.println(neighborhoodList);
                neumannArray[i][j].setNeighborhood(newNeighborhood);
                neighborhoods.add(newNeighborhood);
            }
        }
    }

    public void makeGlobalNeighborhood() {

        Neighborhood globalNeighborhood = new Neighborhood(this.particleList);
        for (int i = 0; i < this.particleList.size(); i++) {
            this.particleList.get(i).setNeighborhood(globalNeighborhood);
        }

        neighborhoods.add(globalNeighborhood);
    }

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

    public void initialize(int dimensions, Function func) {
        Particle randParticle;
        for (int i = 0; i < this.numParticles; i++) {
            randParticle = new Particle(dimensions, func);
            randParticle.generateRandomPosition();
            randParticle.generateRandomVelocity();
            particleList.add(randParticle);
        }
    }

    public List<Neighborhood> getNeighborhoods() {
        return this.neighborhoods;
    }

    public List<Particle> getParticles() {
        return this.particleList;
    }

    public void updateNeighborhoodBestList() {
        for (int i = 0; i < neighborhoods.size(); i++) {
            neighborhoods.get(i).updateBest();
        }
    }

    public String toString() {
        String swarm = "";
        for (int i = 0; i < particleList.size(); i++) {
            swarm += particleList.get(i).toString() + "\n";
        }
        return swarm;
    }

    public static void main(String[] args) {
        Swarm swarm = new Swarm(16);
        int dimensions = 1;
        Function func = new Function("Ackley", 15.0, 30.0, 2.0, -2.0);

        swarm.initialize(dimensions, func);

        // System.out.println(swarm.toString());

        swarm.makeVonNeumannNeighborhood();

        swarm.updateNeighborhoodBestList();

        for (Neighborhood n : swarm.getNeighborhoods()) {
            //System.out.println(n.printNeighborhoodBestVal());
        }

    }

}