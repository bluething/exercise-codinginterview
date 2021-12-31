package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// HackerLand University has the following grading policy:
//
//Every student receives a grade in the inclusive range from 0 to 100.
//Any grade less than 40 is a failing grade.
//Sam is a professor at the university and likes to round each student's grade according to these rules:
//
//If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
//If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
public class GradingStudentsTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(85, 29, 57), gradingStudents(Arrays.asList(84, 29, 57)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(75, 67, 40, 33), gradingStudents(Arrays.asList(73, 67, 38, 33)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(Arrays.asList(85, 29, 57), gradingStudents2(Arrays.asList(84, 29, 57)));
    }

    @Test
    public void case04() {
        Assertions.assertEquals(Arrays.asList(75, 67, 40, 33), gradingStudents2(Arrays.asList(73, 67, 38, 33)));
    }

    private List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        int expectedRoundedGrade = 0;
        int roundedGrade = 0;
        for (Integer grade : grades) {
            expectedRoundedGrade = (grade - (grade % 5)) + 5;
            if (expectedRoundedGrade < 40) {
                roundedGrade = grade;
            } else {
                if (expectedRoundedGrade - grade < 3) {
                    roundedGrade = expectedRoundedGrade;
                } else {
                    roundedGrade = grade;
                }
            }

            roundedGrades.add(roundedGrade);
        }

        return roundedGrades;
    }

    private List<Integer> gradingStudents2(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        int difference = 0;
        for (Integer grade : grades) {
            difference = grade % 5;
            if (grade < 38 || difference < 3) {
                roundedGrades.add(grade);
            } else {
                roundedGrades.add(grade - difference + 5);
            }
        }

        return roundedGrades;
    }
}
