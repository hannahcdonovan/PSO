import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
        List<List<Double>> incrementLists1 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists1.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case1 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case1.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists1.get(j).add(val);
            }
        }
        double[] medianArr1 = getMedians(incrementLists1);

        // Case 2
        System.out.println("Case 2");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Global" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        List<List<Double>> incrementLists2 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists2.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case2 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case2.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists2.get(j).add(val);
            }
        }
        double[] medianArr2 = getMedians(incrementLists2);

        // Case 3
        System.out.println("Case 3");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Global" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        List<List<Double>> incrementLists3 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists3.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case3 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case3.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists3.get(j).add(val);
            }
        }
        double[] medianArr3 = getMedians(incrementLists3);

        // Case 4
        System.out.println("Case 4");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Ring" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        List<List<Double>> incrementLists4 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists4.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case4 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case4.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists4.get(j).add(val);
            }
        }
        double[] medianArr4 = getMedians(incrementLists4);

        // Case 5
        System.out.println("Case 5");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Ring" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        List<List<Double>> incrementLists5 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists5.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case5 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case5.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists5.get(j).add(val);
            }
        }
        double[] medianArr5 = getMedians(incrementLists5);

        // Case 6
        System.out.println("Case 6");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Ring" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        List<List<Double>> incrementLists6 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists6.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case6 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case6.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists6.get(j).add(val);
            }
        }
        double[] medianArr6 = getMedians(incrementLists6);

        // Case 7
        System.out.println("Case 7");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: von Neumann" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        List<List<Double>> incrementLists7 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists7.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case7 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case7.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists7.get(j).add(val);
            }
        }
        double[] medianArr7 = getMedians(incrementLists7);

        // Case 8
        System.out.println("Case 8");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: von Neumann" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        List<List<Double>> incrementLists8 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists8.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case8 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case8.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists8.get(j).add(val);
            }
        }
        double[] medianArr8 = getMedians(incrementLists8);

        // Case 9
        System.out.println("Case 9");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: von Neumann" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        List<List<Double>> incrementLists9 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists9.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case9 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case9.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists9.get(j).add(val);
            }
        }
        double[] medianArr9 = getMedians(incrementLists9);

        // Case 10
        System.out.println("Case 10");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Random" + "\nSwarm Size: 16");
        System.out.println("_____________________");
        List<List<Double>> incrementLists10 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists10.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
        PSO case10 = new PSO(dimensions, funcs[0], swarmSizes[0], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case10.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists10.get(j).add(val);
            }
        }
        double[] medianArr10 = getMedians(incrementLists10);

        // Case 11
        System.out.println("Case 11");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Random" + "\nSwarm Size: 30");
        System.out.println("_____________________");
        List<List<Double>> incrementLists11 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists11.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
        PSO case11 = new PSO(dimensions, funcs[0], swarmSizes[1], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case11.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists11.get(j).add(val);
            }
        }
        double[] medianArr11 = getMedians(incrementLists11);

        // Case 12
        System.out.println("Case 12");
        System.out.println("_____________________");
        System.out.println("Function: Rosenbrock" + "\nTopology: Random" + "\nSwarm Size: 49");
        System.out.println("_____________________");
        List<List<Double>> incrementLists12 = new ArrayList<List<Double>>();
        for (int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists12.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case12 = new PSO(dimensions, funcs[0], swarmSizes[2], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case12.optimize();
            for (int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists12.get(j).add(val);
            }
        }
        double[] medianArr12 = getMedians(incrementLists12);

// Case 13
        System.out.println("Case 13");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Global" + "\nSwarm Size: 16");
        System.out.println("_____________________");

        List<List<Double>> incrementLists13 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists13.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case13 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults13 = case13.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults13.get(j);
                incrementLists13.get(j).add(val);
            }
        }

        double[] medianArr13 = getMedians(incrementLists13);
        
        // Case 14
        System.out.println("Case 14");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Global" + "\nSwarm Size: 30");
        System.out.println("_____________________");

        List<List<Double>> incrementLists14 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists14.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case14 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults14 = case14.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults14.get(j);
                incrementLists14.get(j).add(val);
            }
        }

        double[] medianArr14 = getMedians(incrementLists14);

        // Case 15
        System.out.println("Case 15");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Global" + "\nSwarm Size: 49");
        System.out.println("_____________________");

        List<List<Double>> incrementLists15 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists15.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case15 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults15 = case15.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults15.get(j);
                incrementLists15.get(j).add(val);
            }
        }

        double[] medianArr15 = getMedians(incrementLists15);

        // Case 16
        System.out.println("Case 16");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Ring" + "\nSwarm Size: 16");
        System.out.println("_____________________");

        List<List<Double>> incrementLists16 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists16.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case16 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults16 = case16.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults16.get(j);
                incrementLists16.get(j).add(val);
            }
        }

        double[] medianArr16 = getMedians(incrementLists16);

        // Case 17
        System.out.println("Case 17");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Ring" + "\nSwarm Size: 30");
        System.out.println("_____________________");

        List<List<Double>> incrementLists17 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists17.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case17 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults17 = case17.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults17.get(j);
                incrementLists17.get(j).add(val);
            }
        }

        double[] medianArr17 = getMedians(incrementLists17);

        // Case 18
        System.out.println("Case 18");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Ring" + "\nSwarm Size: 49");
        System.out.println("_____________________");

        List<List<Double>> incrementLists18 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists18.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case18 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults18 = case18.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults18.get(j);
                incrementLists18.get(j).add(val);
            }
        }

        double[] medianArr18 = getMedians(incrementLists18);

        // Case 19
        System.out.println("Case 19");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: von Neumann" + "\nSwarm Size: 16");
        System.out.println("_____________________");

        List<List<Double>> incrementLists19 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists19.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case19 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults19 = case19.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults19.get(j);
                incrementLists19.get(j).add(val);
            }
        }

        double[] medianArr19 = getMedians(incrementLists19);

        // Case 20
        System.out.println("Case 20");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: von Neumann" + "\nSwarm Size: 30");
        System.out.println("_____________________");

        List<List<Double>> incrementLists20 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists20.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case20 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults20 = case20.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults20.get(j);
                incrementLists20.get(j).add(val);
            }
        }

        double[] medianArr20 = getMedians(incrementLists20);

        // Case 21
        System.out.println("Case 21");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: von Neumann" + "\nSwarm Size: 49");
        System.out.println("_____________________");

        List<List<Double>> incrementLists21 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists21.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case21 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults21 = case21.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults21.get(j);
                incrementLists21.get(j).add(val);
            }
        }

        double[] medianArr21 = getMedians(incrementLists21);

        //Case 22
        System.out.println("Case 22");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Random" + "\nSwarm Size: 16");
        System.out.println("_____________________");

        List<List<Double>> incrementLists22 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists22.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case22 = new PSO(dimensions, funcs[1], swarmSizes[0], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults22 = case22.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults22.get(j);
                incrementLists22.get(j).add(val);
            }
        }

        double[] medianArr22 = getMedians(incrementLists22);

        //Case 23
        System.out.println("Case 23");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Random" + "\nSwarm Size: 30");
        System.out.println("_____________________");

        List<List<Double>> incrementLists23 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists23.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case23 = new PSO(dimensions, funcs[1], swarmSizes[1], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults23 = case23.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults23.get(j);
                incrementLists23.get(j).add(val);
            }
        }

        double[] medianArr23 = getMedians(incrementLists23);

        //Case 24
        System.out.println("Case 24");
        System.out.println("_____________________");
        System.out.println("Function: Ackley" + "\nTopology: Random" + "\nSwarm Size: 49");
        System.out.println("_____________________");

        List<List<Double>> incrementLists24 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists24.add(newList);
        }

        for (int i = 0; i < experimentRuns; i++) {
            PSO case24 = new PSO(dimensions, funcs[1], swarmSizes[2], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults24 = case24.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults24.get(j);
                incrementLists24.get(j).add(val);
            }
        }

        double[] medianArr24 = getMedians(incrementLists24);

        //Case 25
        System.out.println("Case 25");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Global" + "\nSwarm Size: 16");
        System.out.println("_____________________");


        List<List<Double>> incrementLists25 = new ArrayList<List<Double>>();
        for(int k = 0; k < 10; k++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists25.add(newList);
        }

        //PSO case25 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[0]);
        for (int i = 0; i < experimentRuns; i++) {
            PSO case25 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case25.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists25.get(j).add(val);
            }
        }
        double[] medianArr25 = getMedians(incrementLists25);


        //Case 26
        System.out.println("Case 26");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Global" + "\nSwarm Size: 30");
        System.out.println("_____________________");


        List<List<Double>> incrementLists26 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists26.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case26 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case26.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists26.get(j).add(val);
            }
        }
        double[] medianArr26 = getMedians(incrementLists26);


        // Case 27
        System.out.println("Case 27");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Global" + "\nSwarm Size: 49");
        System.out.println("_____________________");


        List<List<Double>> incrementLists27 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists27.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case27 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[0]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case27.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists27.get(j).add(val);
            }
        }
        double[] medianArr27 = getMedians(incrementLists27);


        // Case 28
        System.out.println("Case 28");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Ring" + "\nSwarm Size: 16");
        System.out.println("_____________________");


        List<List<Double>> incrementLists28 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists28.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case28 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case28.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists28.get(j).add(val);
            }
        }
        double[] medianArr28 = getMedians(incrementLists28);


        // Case 29
        System.out.println("Case 29");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Ring" + "\nSwarm Size: 30");
        System.out.println("_____________________");


        List<List<Double>> incrementLists29 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists29.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case29 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case29.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists29.get(j).add(val);
            }
        }
        double[] medianArr29 = getMedians(incrementLists29);


        // Case 30
        System.out.println("Case 30");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Ring" + "\nSwarm Size: 49");
        System.out.println("_____________________");


        List<List<Double>> incrementLists30 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists30.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case30 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[1]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case30.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists30.get(j).add(val);
            }
        }
        double[] medianArr30 = getMedians(incrementLists30);


        // Case 31
        System.out.println("Case 31");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: von Neumann" + "\nSwarm Size: 16");
        System.out.println("_____________________");


        List<List<Double>> incrementLists31 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists31.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case31 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case31.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists31.get(j).add(val);
            }
        }
        double[] medianArr31 = getMedians(incrementLists31);


        // Case 32
        System.out.println("Case 32");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: von Neumann" + "\nSwarm Size: 30");
        System.out.println("_____________________");


        List<List<Double>> incrementLists32 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists32.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case32 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case32.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists32.get(j).add(val);
            }
        }
        double[] medianArr32 = getMedians(incrementLists32);


        // Case 33
        System.out.println("Case 33");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: von Neumann" + "\nSwarm Size: 49");
        System.out.println("_____________________");


        List<List<Double>> incrementLists33 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists33.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case33 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[2]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case33.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists33.get(j).add(val);
            }
        }
        double[] medianArr33 = getMedians(incrementLists33);


        // Case 34
        System.out.println("Case 34");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Random" + "\nSwarm Size: 16");
        System.out.println("_____________________");


        List<List<Double>> incrementLists34 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists34.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case34 = new PSO(dimensions, funcs[2], swarmSizes[0], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case34.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists34.get(j).add(val);
            }
        }
        double[] medianArr34 = getMedians(incrementLists34);


        // Case 35
        System.out.println("Case 35");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Random" + "\nSwarm Size: 30");
        System.out.println("_____________________");


        List<List<Double>> incrementLists35 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists35.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case35 = new PSO(dimensions, funcs[2], swarmSizes[1], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case35.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists35.get(j).add(val);
            }
        }
        double[] medianArr35 = getMedians(incrementLists35);


        // Case 36
        System.out.println("Case 36");
        System.out.println("_____________________");
        System.out.println("Function: Rastrigin" + "\nTopology: Random" + "\nSwarm Size: 49");
        System.out.println("_____________________");

        List<List<Double>> incrementLists36 = new ArrayList<List<Double>>();
        for(int i = 0; i < 10; i++) {
            List<Double> newList = new ArrayList<Double>();
            incrementLists36.add(newList);
        }
        for (int i = 0; i < experimentRuns; i++) {
            PSO case36 = new PSO(dimensions, funcs[2], swarmSizes[2], iterations, neigborhoods[3]);
            System.out.println("Experiment: " + (i + 1));
            System.out.println("____________________");
            List<Double> testResults = case36.optimize();
            for(int j = 0; j < 10; j++) {
                double val = testResults.get(j);
                incrementLists36.get(j).add(val);
            }
        }
        double[] medianArr36 = getMedians(incrementLists36);

    }



    public static double[] getMedians(List<List<Double>> incrementLists) {
        double[] medianArr = new double[10];
        for(int i = 0; i < 10; i++) {
            Collections.sort(incrementLists.get(i));
            double ninth = incrementLists.get(i).get(9);
            double tenth = incrementLists.get(i).get(10);
            double average = (ninth + tenth) / 2.0;
            medianArr[i] = average;
            System.out.println((i + 1) + " thousand median: " + average);
        }
        return medianArr;
    }
}