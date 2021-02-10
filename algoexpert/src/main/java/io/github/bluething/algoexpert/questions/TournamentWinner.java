package io.github.bluething.algoexpert.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        competitions.add(new ArrayList<>(Arrays.asList("HTML", "C#")));
        competitions.add(new ArrayList<>(Arrays.asList("C#", "Python")));
        competitions.add(new ArrayList<>(Arrays.asList("Python", "HTML")));
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));
        System.out.println(tournamentWinner(competitions, results));
    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> teamScores = new HashMap<>();
        ArrayList<String> match = new ArrayList<>();
        Integer result = Integer.valueOf(0);
        for (int i = 0; i < competitions.size(); i++) {
            result = results.get(i);
            match = competitions.get(i);
            if (result.equals(Integer.valueOf(1))) {
                teamScores.put(match.get(0), teamScores.getOrDefault(match.get(0), 0) + 3);
            } else {
                teamScores.put(match.get(1), teamScores.getOrDefault(match.get(1), 0) + 3);
            }
        }

        String winner = "";
        Integer maxScore = Integer.valueOf(0);
        for (Map.Entry<String, Integer> entry : teamScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                winner = entry.getKey();
                maxScore = entry.getValue();
            }
        }

        return winner;
    }
}
