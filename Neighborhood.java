import java.util.List;
import java.util.ArrayList;

public class Neighborhood {

    /**
     * A list of particles representing a neighborhood.
     */
    private List<Particle> neighbors;

    /**
     * Value representing the neighborhood best.
     */
    private Particle nbest;

    /**
     * Constructor for the Neighborhood object. Essentially a wrapper for a list of Particles that
     * represent a neighborhood.
     * @param neighborList List used to instantiate Neighborhood object.
     */
    public Neighborhood(List<Particle> neighborList) {
        this.neighbors = neighborList;
    }

    /**
     * Sets the neighborhood best to a copy of the particle's (because the particle is changing over time)
     * position and calling evaluate on particle because .evaluate sets the current score of the particle. 
     * @param currBest A particle representing the iteration's new best.
     */
    public void setNeighborhoodBest(Particle newBest) {
        this.nbest = newBest.copyParticle();
        this.nbest.getFunc().evaluate(nbest);

    }

    /**
     * Updates the neighborhood best for each particle's neighborhood on each iteration. 
     */
    public void updateBest() {

        Particle currBest = neighbors.get(0).copyParticle();
        Function func = neighbors.get(0).getFunc();
        double currBestScore = func.evaluate(currBest);
        //System.out.println("(0) Curr best is: " + func.evaluate(currBest));
        for (int i = 1; i < neighbors.size(); i++) {
            Particle comparison = neighbors.get(i);
            double score = func.evaluate(comparison);
           //System.out.println("(" + i + ") Comparison is:" + score + " vs " + currBestScore);
            //System.out.println(score < currBestScore);
            if (score < currBestScore) {
                currBest = comparison.copyParticle();
                currBestScore = score;
                //System.out.println("changed!");
            }
        }
        if(this.nbest == null || func.evaluate(currBest) < func.evaluate(this.nbest)) {
        	this.setNeighborhoodBest(currBest);
        }
    }

    /**
     * Getter that returns the nbest for a given Neighborhood object.
     * @return Particle, which is the best particle in the neighborhood.
     */
    public Particle getNeighborhoodBest() {
        return this.nbest;
    }

}