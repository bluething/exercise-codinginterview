package io.github.bluething.algoexpert.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    private static Integer HOME_TEAM_WON = Integer.valueOf(1);

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
        String champion = "";
        Map<String, Integer> teamScores = new HashMap<>();
        teamScores.put(champion, 0);
        String winner = "";
        String homeTeam = "";
        String awayTeam = "";
        ArrayList<String> match = new ArrayList<>();
        for (int i = 0; i < competitions.size(); i++) {
            match = competitions.get(i);
            homeTeam = match.get(0);
            awayTeam = match.get(1);
            winner = results.get(i).equals(HOME_TEAM_WON) ? homeTeam : awayTeam;

            teamScores.put(winner, teamScores.getOrDefault(winner, 0) + 3);
            if (teamScores.get(winner) > teamScores.get(champion)) {
                champion = winner;
            }
        }

        return champion;
    }
}
