package com.example.demo1;

import java.util.*;

import java.io.*;

public class EpreuveClinique {
    protected Test[] Testepreuve;
    protected String Observation;
    protected int ScoreTotal;
    static protected int max = 10;
    static protected int i = 0;
    Scanner sc = new Scanner(System.in);

    public EpreuveClinique(Test[] Testepreuve, String Observation, int ScoreTotal) {
        this.Testepreuve = Testepreuve;
        this.Observation = Observation;
        this.ScoreTotal = ScoreTotal;
    }

    public void RedigerObservation(String text) {
        this.Observation = text;
    }

    public void addTest() throws IOException {
        if (i >= max) {
            System.out.println("You have reached the maximum number of tests allowed.");
            return;
        }

        int choice;
        System.out.println("Choose a type of Test:");
        System.out.println("1- Exercise");
        System.out.println("2- Quiz");
        choice = sc.nextInt();

        if (choice == 1) {
            addExercise();
            i++;
        } else if (choice == 2) {
            // Add quiz logic here
            addQuestionnaire();
            i++;
        }
    }

    private void addExercise() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/Exercice.txt"))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            Random random = new Random();
            int randomIndex = random.nextInt(lines.size());
            String randomLine = lines.get(randomIndex);
            // Assuming the line format is:
            // name;score;Consigne;nomMateriel;needMateriel;CompteRdu
            String[] parts = randomLine.split(",");
            String name = parts[0];
            // int score = Integer.parseInt(parts[1]);
            String consigne = parts[1];
            boolean needMateriel = Boolean.parseBoolean(parts[2]);
            String nomMateriel = parts[3];

            Testepreuve[i] = new Exercice(name, 0, consigne, nomMateriel, needMateriel, "");
        }
    }

    private void addQuestionnaire() throws IOException {


        int[] tab = { 1, 2 };
        Question[] qst = new Question[4];
        boolean effectue;

        for (int i = 0; i < qst.length; i++) {
            qst[i] = new Libre("", false, 0, ""); // You can adjust parameters as needed
        }

        Random random1 = new Random();
        int randomIndex1 = random1.nextInt(tab.length);

        for (int k = 0; k < 4; k++) {
            effectue = true; // Reset effectue to true for each new question
            if (randomIndex1 == 1) {
                try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/QCU.txt"))) {
                    List<String> lines = new ArrayList<>();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }

                    while (effectue) {
                        Random random = new Random();
                        int randomIndex = random.nextInt(lines.size());
                        String randomLine = lines.get(randomIndex);
                        // Assuming the line format is:
                        // name;score;Consigne;nomMateriel;needMateriel;CompteRdu
                        String[] parts = randomLine.split(",");
                        String consigne = parts[0];
                        String[] answers = parts[1].split(";");
                        int answer = Integer.parseInt(parts[2]);

                        // Check if consigne already exists in qst
                        for (Question question : qst) {
                            if (question != null && question.getConsigne().equals(consigne)) {
                                effectue = false;
                                break;
                            }
                        }

                        if (effectue) {
                            qst[k] = new QCU(consigne, true,0, answers, answer);
                        }
                    }
                }
            } else if (randomIndex1 == 2) {

                try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/QCM.txt"))) {
                    List<String> lines = new ArrayList<>();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        lines.add(line);
                    }
                    Random random = new Random();
                    int randomIndex = random.nextInt(lines.size());
                    String randomLine = lines.get(randomIndex);

                    String[] parts = randomLine.split(",");

                    // int score = Integer.parseInt(parts[1]);
                    String consigne = parts[0];
                    String[] answers = parts[1].split(";");
                    String[] answerStrings = parts[2].split(";");
                    int[] answer = new int[answerStrings.length];
                    for (int j = 0; j < answerStrings.length; j++) {
                        answer[j] = Integer.parseInt(answerStrings[j]);
                    }

                    for (Question question : qst) {
                        if (question != null && question.getConsigne().equals(consigne)) {
                            effectue = false;
                            break;
                        }
                    }

                    if (effectue) {
                        qst[k] = new QCM(consigne, true,0, answers, answer);
                    }


                }
            }

            randomIndex1 = random1.nextInt(tab.length);
        }

        Testepreuve[i] = new Questionnaire("Quiz",0,"",qst);
    }

    public void score() {


        for (Test test : Testepreuve) {
            if (test instanceof Exercice) {
                // Add score of the exercise
            } else if (test instanceof Questionnaire) {
                Questionnaire questionnaire = (Questionnaire) test;
                this.ScoreTotal += questionnaire.CalculerScore(); // Add score of the questionnaire
            }
        }
    }

    public int GetScore(){
        return this.ScoreTotal;
    }

}
