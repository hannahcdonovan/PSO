import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Swarm {

    List<Particle> particleList;

    int numParticles;

    public Swarm(int numParticles) {
        this.numParticles = numParticles;
        particleList = new ArrayList<Particle>();
    }


    public void makeRingNeighborhood() {

        if(numParticles > 2) {
            Particle first = this.particleList.get(0);
            Particle second = this.particleList.get(1);
            Particle last = this.particleList.get(this.numParticles - 1);
            Particle secondToLast = this.particleList.get(this.numParticles - 2);

            List<Particle> firstList = new ArrayListList<Particle>();
            firstList.add(second);
            firstList.add(last);
            Neighborhood firstNeighborhood = new Neighborhood(firstList);
            first.setNeighborhood(firstNeighborhood);

            List<Particle> lastList = new ArrayList<Particle>();
            lastList.add(first);
            lastList.add(secondToLast);
            Neighborhood lastNeighborhood = new Neighborhood(lastList);
            last.setNeighborhood(lastNeighborhood);

            for(int i = 1; i < this.numParticles - 1; i++) {
                Particle before = this.particleList.get(i - 1);
                Particle after = this.particleList.get(i - 2);

                List<Particle> neighborhoodList = new ArrayList<Particle>();
                neighborhoodList.add(before);
                neighborhoodList.add(after);
                Neighborhood newNeighborhood = new Neighborhood(neighborhoodList);
                this.particleList.get(i).setNeighborhood(newNeighborhood);
            }
        } else {
            System.out.println("size smaller than two")
        }
    }


    public void makeGlobalNeighborhood() {

        Neighborhood globalNeighborhood = new Neighborhood(this.particleList);
        for(int i = 0; i < this.particleList.size(); i++) {
            this.particleList.get(i).setNeighborhood(globalNeighborhood);
        }
    }


    public void makeRandomNeighborhood(int k) {
        Random rand = new Random();
        Set<Integer> numSet = new HashSet<Integer>();

        for(int i = 0; i < this.particleList.size(); i++) {
            List<Particle> neighborhoodList = new ArrayList<Particle>();
            numSet.clear();
            for(int j = 0; j < k; j++) {
                int randNum = rand.nextInt(this.particleList.size());
                while(numSet.contains(randNum)){
                    int randNum = rand.nextInt(this.particleList.size());
                }
                numSet.add(randNum);
                neighborhoodList.add(this.particleList.get(randNum));
            }
            Neighborhood newNeighborhood = new Neighborhood(neighborhoodList);
            this.particleList.get(i).setNeighborhood(newNeighborhood);
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


    public String toString() {
        String swarm = "";
        for (int i = 0; i < particleList.size(); i++) {
            swarm += particleList.get(i).toString() + "\n";
        }
        return swarm;
    }


    public static void main(String[] args) {
        Swarm swarm = new Swarm(10);
        int dimensions = 5;
        Function func = new Function(15.0, 30.0, 2.0, -2.0);

        swarm.initialize(dimensions, func);

        System.out.println(swarm.toString());
    }
}