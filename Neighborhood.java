import java.util.List;
import java.util.ArrayList;

public class Neighborhood {

    private List<Particle> neighbors;

    public Neighborhood(List<Particle> neighborList) {

        neighbors = neighborList;
    }

    public List<Particle> getNeighborhoodList() {
        return neighbors;
    }

}