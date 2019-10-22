import java.lang.Math.*;

public class Function {

	private double minPosBound;

	private double maxPosBound;

	private double minVelBound;

	private double maxVelBound;

	public Function(double minPosBound, double maxPosBound, double maxVelBound, double minVelBound) {

		this.minBound = minBound;
		this.maxBound = maxBound;
		this.minVelBound = minVelBound;
		this.maxVelBound = maxVelBound;
	}


	public double getMinPosBound() {
		return this.minPosBound;
	}

	public double getMaxPosBound() {
		return this.maxPosBound;
	}

	public double getMinVelBound() {
		return this.minVelBound;
	}

	public double getMaxVelBound() {
		return this.minVelBound;
	}

    public double evalRosenbrock(Particle particle) {
        double[] position = particle.getPos();
        double result = 0.0;
        for(int i = 0; i < position.length - 1; i++ ) {
            double partOfSum = 100*Math.pow((position[i+1] - Math.pow(position[i],2)),2) + Math.pow(position[i] - 1.0, 2);
            result += partOfSum;
        }
        return result
    }

    public double evalRastrigin(Particle particle) {
        double[] position = particle.getPos();
        int dim = particle.getDim();
        double result = 10.0 * dim;
        for(int i = 0; i < position.length; i++ ) {
            double partOfSum = Math.pow(position[i], 2) - 10*Math.cos(2*Math.PI*position[i]);
            result += partOfSum;
        }
        return result
    }


}