package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Libre extends Question implements Serializable {

    private String answer;
    private static final long serialVersionUID = 6264016623953139405L;

    public Libre(String Enonce, boolean Effectue, int score, String answer) {
        super(Enonce, Effectue, score);
        this.answer = answer;
    }

    public void SetEnonce(String txt){
        this.Enonce=txt;
    }

    public void SetEffectue(boolean bool){
        this.Effectue=bool;
    }

    public void SetScore(int score){
        this.score=score;
    }

    public void SetAnswer(String answer){
        this.answer=answer;
    }

    public String getEnonce() {
        String enonce = "";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/com/example/demo1/Libre.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                enonce = lines.get(randomIndex);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return enonce;
    }
}
