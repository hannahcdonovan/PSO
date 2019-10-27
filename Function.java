import java.lang.Math.*;

public class Function {

    private String funcName;

    private double minPosBound;

    private double maxPosBound;

    private double minVelBound;

    private double maxVelBound;

    public Function(String funcName, double minPosBound, double maxPosBound, double maxVelBound, double minVelBound) {

        this.funcName = funcName;
        this.minPosBound = minPosBound;
        this.maxPosBound = maxPosBound;
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
        return this.maxVelBound;
    }

    public String getFuncName() {
        return this.funcName;
    }

    public double evalRosenbrock(Particle particle) {
        double[] position = particle.getPosition();
        double result = 0.0;
        for (int i = 0; i < position.length - 1; i++) {
            double partOfSum = 100 * Math.pow((position[i + 1] - Math.pow(position[i], 2)), 2)
                    + Math.pow(position[i] - 1.0, 2);
            result += partOfSum;
        }
        return result;
    }

    public double evalRastrigin(Particle particle) {
        double[] position = particle.getPosition();
        int dim = particle.getDimension();
        double result = 10.0 * dim;
        for (int i = 0; i < position.length; i++) {
            double partOfSum = Math.pow(position[i], 2) - 10 * Math.cos(2 * Math.PI * position[i]);
            result += partOfSum;
        }
        return result;
    }

    public double evalAckley(Particle particle) {
        int a = 20;
        double b = 0.2;
        double c = 2 * Math.PI;
        int d = particle.getDimension();
        double inverse = 1 / d;

        double result = -a * Math.exp(-b * Math.sqrt(inverse * summingSquaresAckleyHelper(particle)))
                - Math.exp(inverse * summingCosAckleyHelper(particle, c)) + a + Math.exp(1);

        return result;

    }

    public double summingSquaresAckleyHelper(Particle particle) {
        double[] params = particle.getPosition();

        double answer = 0;

        for (int i = 0; i < particle.getDimension(); i++) {
            answer += Math.pow(params[i], 2);
        }

        return answer;
    }

    public double summingCosAckleyHelper(Particle particle, double c) {
        double[] params = particle.getPosition();

        double answer = 0;

        for (int i = 0; i < particle.getDimension(); i++) {
            answer += Math.cos(c * params[i]);
        }

        return answer;
    }

    public double evaluate(Particle particle) {
        String function = this.funcName;
        double result = 0;

        if (function.equals("Rosenbrock")) {
            result = this.evalRosenbrock(particle);
        } else if (function.equals("Ackley")) {
            result = this.evalAckley(particle);
        } else if (function.equals("Rastrigin")) {
            result = this.evalRastrigin(particle);
        } else {
            System.out.println("Oops! Something went wrong!");
        }
        particle.setCurrentScore(result);
        return result;
    }

}