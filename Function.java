import java.lang.Math.*;

public class Function {

    /**
     * The string indicating the function to be used.
     */
    private String funcName;

    /**
     * The minimum position bound. Different for each function. 
     */
    private double minPosBound;

    /**
     * The maximum position bound. Different for each function.
     */
    private double maxPosBound;

    /**
     * The minimum velocity bound. Different for each function.
     */
    private double minVelBound;

    /**
     * The maximum velocity bound. Different for each function.
     */
    private double maxVelBound;

    /**
     * Constructor for Function object. Instantiates each instance variable for the Function.
     * @param funcName String representing the function name.
     * @param minPosBound The minimum position bound for each particle.
     * @param maxPosBound The maximum position bound for each particle.
     * @param maxVelBound The maxmimum velocity bound for each particle.
     * @param minVelBound The minimum velocity bound for each particle.
     */
    public Function(String funcName, double minPosBound, double maxPosBound, double maxVelBound, double minVelBound) {

        this.funcName = funcName;
        this.minPosBound = minPosBound;
        this.maxPosBound = maxPosBound;
        this.minVelBound = minVelBound;
        this.maxVelBound = maxVelBound;
    }

    /**
     * Getter for the minimum position bound.
     * @return Minimum position given for particular function.
     */
    public double getMinPosBound() {
        return this.minPosBound;
    }

    /**
     * Getter for the maximum position bound.
     * @return Maximum position given for a particular function.
     */
    public double getMaxPosBound() {
        return this.maxPosBound;
    }

    /**
     * Getter for the minimum velocity bound.
     * @return Minimum velocity bound for a particular function.
     */
    public double getMinVelBound() {
        return this.minVelBound;
    }

    /**
     * Getter for the maximum velocity bound.
     * @return Maximum velocity bound for a particular function.
     */
    public double getMaxVelBound() {
        return this.maxVelBound;
    }

    /**
     * Getter that returns the string representing the name of the function.
     * Rosenbrock - rok
     * Ackley - ack
     * Rastrigin - ras
     * @return String representing the name of the function.
     */
    public String getFuncName() {
        return this.funcName;
    }

    /**
     * Evaluataion of a particular particle using Rosenbrock function.
     * @param particle The particle we are looking to evaluate.
     * @return Double which is the evaluation of particle using Rosenbrock.
     */
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

    /**
     * Evaluation of a particle using Rastrigin function.
     * @param particle The particle we are looking to evaluate.
     * @return Double which is the evaluation of the particle using Rastrigin.
     */
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

    /**
     * Evaluation of a particle using Ackley function.
     * @param particle The particle we are looking to evaluate.
     * @return Double which is the evaluation of the particle using Ackley.
     */
    public double evalAckley(Particle particle) {
        int a = 20;
        double b = 0.2;
        double c = 2 * Math.PI;
        int d = particle.getDimension();
        double inverse = 1.0 / d;

        double result = -a * Math.exp(-b * Math.sqrt(inverse * summingSquaresAckleyHelper(particle)))
                - Math.exp(inverse * summingCosAckleyHelper(particle, c)) + a + Math.exp(1);

        return result;

    }

    /**
     * Helper function to perform a summation as specified in the Ackley function.
     * @param particle Particle we are looking to evaluate.
     * @return Double, which is the summation from 1 to d (dimension) of each position value of particle squared.
     */
    public double summingSquaresAckleyHelper(Particle particle) {
        double[] params = particle.getPosition();

        double answer = 0;

        for (int i = 0; i < particle.getDimension(); i++) {
            answer += Math.pow(params[i], 2);
        }

        return answer;
    }

    /**
     * Helper function to perform a summation as specified in the Ackley function.
     * @param particle Particle we are looking to evaluate.
     * @param c A constant (2pi)
     * @return Double, which is the summation from 1 to d (demnsion) of the cos of c * each position in particle.
     */
    public double summingCosAckleyHelper(Particle particle, double c) {
        double[] params = particle.getPosition();

        double answer = 0;

        for (int i = 0; i < particle.getDimension(); i++) {
            answer += Math.cos(c * params[i]);
        }

        return answer;
    }

    /**
     * Evaluates an instance of a Function object given the Function object's funcName.
     * @param particle The particle we are looking to evaluate.
     * @return The necessary evaluation (Rosenbrock, Rastrigin, or Ackley) for the particle Function object.
     *         Also, setting the current score when we evaluate the particle.
     */
    public double evaluate(Particle particle) {
        String function = this.funcName;
        double result = 0;

        if (function.equals("rok")) {
            result = this.evalRosenbrock(particle);
        } else if (function.equals("ack")) {
            result = this.evalAckley(particle);
        } else if (function.equals("ras")) {
            result = this.evalRastrigin(particle);
        } else {
            System.out.println("Oops! Something went wrong!");
        }
        particle.setCurrentScore(result);
        return result;
    }

}