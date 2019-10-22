import java.lang.Math;

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
    
    public double evalAckley(Particle particle) {
        double[] params = particle.getPosition();

        int a = 20;
        double b = 0.2;
        double c = 2 * Math.PI;
        int d = particle.getDimension();
        double inverse = 1/d;

        double result = -a * Math.exp(-b * Math.sqrt(inverse * summingSquaresAckelyHelper(particle))) 
                        - Math.exp(inverse * summingCosAckleyHelper(particle, c)) + a + Math.exp(1);
        
        return result;

    }

    public double summingSquaresAckelyHelper(Particle particle) {
        double[] params = particle.getPosition();

        double answer = 0;

        for (int i = 0; i < particle.getDimension(); i++) {
            answer += Math.pow(params[i], 2);
        }
        
        return answer;
    }

    public double summingCosAckleyHelper(Partcile particle, double c) {
        double[] params = particles.getPosition();
        
        double answer = 0;

        for (int i = 0; i < particles.getDimension(); i++) {
            answer += Math.cos(c*params[i]);
        }

        return answer;
    }
	    
}