import java.util.List;
import java.util.ArrayList;

public class Swarm {

    List<Particle> particleList;

    int numParticles;

    public Swarm(int numParticles) {
        this.numParticles = numParticles;
        particleList = new ArrayList<Particle>();
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