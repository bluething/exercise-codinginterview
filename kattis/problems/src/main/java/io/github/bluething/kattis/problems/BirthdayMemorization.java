package io.github.bluething.kattis.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// The problem https://open.kattis.com/problems/fodelsedagsmemorisering
public class BirthdayMemorization {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
        int numOfFriend = Integer.parseInt(bufferedReader.readLine());

        String[] input = new String[3];
        String name = "";
        int likeScore = 0;
        String birthDate = "";
        Friend krarklFriend = null;
        Map<String, Friend> rememberFriend = new HashMap<>();

        for (int i = 1; i <= numOfFriend; i++) {
            input = bufferedReader.readLine().split("\\s+");

            name = input[0];
            likeScore = Integer.parseInt(input[1]);
            birthDate = input[2];

            krarklFriend = rememberFriend.get(birthDate);

            if (krarklFriend != null) {
                if (krarklFriend.getLikeScore() < likeScore) {
                    rememberFriend.put(input[2], new Friend(name, likeScore, birthDate));
                }
            } else {
                rememberFriend.put(input[2], new Friend(name, likeScore, birthDate));
            }

        }

        List<Friend> sortedFriend = new ArrayList<>(rememberFriend.values());
        Collections.sort(sortedFriend, Comparator.comparing(Friend::getName));

        System.out.println(sortedFriend.size());
        for (Friend friend: sortedFriend) {
            System.out.println(friend.getName());
        }

         bufferedReader.close();
    }

    //clue
    // only remember the birthday of the friend he likes the most in case of a collision
    // A higher value of Ci means that Krarkl likes that friend more.
    // output name in lexicographical order
}

class Friend {

    private final String name;
    private final int likeScore;
    private final String birthDate;

    public Friend(String name, int likeScore, String birthDate) {
        this.name = name;
        this.likeScore = likeScore;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getLikeScore() {
        return likeScore;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
