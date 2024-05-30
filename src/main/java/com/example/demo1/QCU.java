package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QCU extends Question {
    private String [] proposition;
    private int answer;

    public QCU(String Enonce, boolean Effectue,int score, String [] proposition, int answer) {
        super(Enonce, Effectue,score);
        this.proposition=proposition;
        this.answer=answer;
        //TODO Auto-generated constructor stub
    }


    public String getEnonce() {
        String enonce = "";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/com/example/demo1/QCU.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                String randomLine = lines.get(randomIndex);

                // Split the random line at the first comma and take the first part as the enonce
                enonce = randomLine.split(",")[0];
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return enonce;
    }

    public int getAnswer(){
        int answer=0;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/QCU.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                String randomLine = lines.get(randomIndex);

                // Split the random line at the first comma and take the first part as the enonce
                answer = Integer.parseInt(randomLine.split(",")[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return answer;
    }

    public String[] getProposition() {


        return this.proposition;
    }

    public static QCU getRandomQCU() {
        String enonce = "";
        String[] propositions = new String[0];
        int answer = 0;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/com/example/demo1/QCU.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                String randomLine = lines.get(randomIndex);

                // Split the random line to get enonce, propositions, and answer
                String[] parts = randomLine.split(",");
                enonce = parts[0];
                propositions = parts[1].split(";");
                answer = Integer.parseInt(parts[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return new QCU(enonce, true, 0, propositions, answer);
    }


    public void SetScore(int score) {

        this.score=score;
    }

    public int GetAnser() {

        return this.answer;
    }
}
