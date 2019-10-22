import java.lang.Math.*;



public class Function {



	private double minBound;

	private double maxBound;



	public Function(double minBound, double maxBound) {

		this.minBound = minBound;
		this.maxBound = maxBound;


	}


	public double getMinBound() {

		return this.minBound;
	}

	public double getMaxBoud() {

		return this.maxBound;
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