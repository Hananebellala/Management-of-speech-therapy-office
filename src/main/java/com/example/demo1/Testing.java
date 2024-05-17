package com.example.demo1;

public class Testing {
    public static void main(String[] args) throws Exception {
        // Create an array to hold tests
        Test[] tests = new Test[10]; // Assuming maximum 10 tests

        // Create an instance of EpreuveClinique
        EpreuveClinique epr = new EpreuveClinique(tests, "Observation", 0);

        // Add tests to EpreuveClinique
        for (int i = 0; i < 5; i++) {
            epr.addTest();
        }

        // Calculate and display the total score
        epr.score();
        System.out.println("Total Score: " + epr.GetScore());
    }
}
