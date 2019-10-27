public class Test {
    /**
     * The different type of neighborhoods.
     */
    private static String[] neigborhoods = new String[]{"gl", "ri", "vn", "ra"};

    /**
     * The different swarm sizes.
     */
    private static int[] swarmSizes = new int[]{16, 30, 49};

    /**
     * The different function types.
     */
    private static String[] funcs = new String[]{"rok", "ack", "ras"};

    /**
     * The number of iterations.
     */
    private static int iterations = 10000;

    /**
     * The number of experiments.
     */
    private static int experimentRuns = 20;

    /**
     * The dimensions we are working in.
     */
    private static int dimensions = 30;
    
    /**
     * Test suit for our 36 different cases.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Case 1
        System.out.println("Case 1");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Global" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case1 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case1.optimize();
        }

        // Case 2
        System.out.println("Case 2");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Global" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case2 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case2.optimize();
        }

        // Case 3
        System.out.println("Case 3");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Global" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case3 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case3.optimize();
        }

        // Case 4
        System.out.println("Case 4");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Ring" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case4 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case4.optimize();
        }

        // Case 5
        System.out.println("Case 5");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Ring" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case5 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case5.optimize();
        }

        // Case 6
        System.out.println("Case 6");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Ring" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case6 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case6.optimize();
        }

        // Case 7
        System.out.println("Case 7");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: von Neumann" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case7 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case7.optimize();
        }

        // Case 8
        System.out.println("Case 8");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: von Neumann" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case8 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case8.optimize();
        }

        // Case 9
        System.out.println("Case 9");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: von Neumann" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case9 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case9.optimize();
        }

        // Case 10
        System.out.println("Case 10");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Random" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case10 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case10.optimize();
        }

        // Case 11
        System.out.println("Case 11");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Random" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case11 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case11.optimize();
        }

        // Case 12
        System.out.println("Case 12");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Random" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case12 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case12.optimize();
        }

        // Case 13
        System.out.println("Case 13");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Global" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case13 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case13.optimize();
        }
        
        // Case 14
        System.out.println("Case 14");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Global" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case14 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case14.optimize();
        }

        // Case 15
        System.out.println("Case 15");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Global" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case15 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case15.optimize();
        }

        // Case 16
        System.out.println("Case 16");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Ring" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case16 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case16.optimize();
        }

        // Case 17
        System.out.println("Case 17");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Ring" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case17 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case17.optimize();
        }

        // Case 18
        System.out.println("Case 18");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Ring" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case18 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case18.optimize();
        }

        // Case 19
        System.out.println("Case 19");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: von Neumann" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case19 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case19.optimize();
        }

        // Case 20
        System.out.println("Case 20");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: von Neumann" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case20 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case20.optimize();
        }

        // Case 21
        System.out.println("Case 21");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: von Neumann" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case21 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case21.optimize();
        }

        //Case 22
        System.out.println("Case 22");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Random" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case22 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case22.optimize();
        }

        //Case 23
        System.out.println("Case 23");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Random" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case23 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case23.optimize();
        }

        //Case 24
        System.out.println("Case 23");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Random" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case24 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case24.optimize();
        }

        //Case 25
        System.out.println("Case 25");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Global" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case25 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case25.optimize();
        }

        //Case 26
        System.out.println("Case 26");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Global" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case26 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case26.optimize();
        }

        // Case 27
        System.out.println("Case 27");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Global" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case27 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case27.optimize();
        }

        // Case 28
        System.out.println("Case 28");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Ring" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case28 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case28.optimize();
        }

        // Case 29
        System.out.println("Case 29");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Ring" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case29 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case29.optimize();
        }

        // Case 30
        System.out.println("Case 30");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Ring" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case30 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[1]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case30.optimize();
        }

        // Case 31
        System.out.println("Case 31");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: von Neumann" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case31 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case31.optimize();
        }

        // Case 32
        System.out.println("Case 32");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: von Neumann" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case32 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case32.optimize();
        }

        // Case 33
        System.out.println("Case 33");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: von Neumann" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case33 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[2]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case33.optimize();
        }

        // Case 34
        System.out.println("Case 34");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Random" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        PSO case34 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case34.optimize();
        }

        // Case 35
        System.out.println("Case 35");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Random" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        PSO case35 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case35.optimize();
        }

        // Case 36
        System.out.println("Case 36");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Random" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        PSO case36 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[3]);
        for (int i = 0; i < experimentRuns; i++) {
            System.out.println("Experiment: " + i + 1);
            System.out.println("____________________");
            case36.optimize();
        }
    }
}