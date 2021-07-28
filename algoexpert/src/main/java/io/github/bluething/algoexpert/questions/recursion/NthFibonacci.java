package io.github.bluething.algoexpert.questions.recursion;

public class NthFibonacci {
    public static void main(String[] args) {
        System.out.println("case 01: " + getNthFib(2));
        System.out.println("case 02: " + getNthFib(6));
        System.out.println("case 03: " + getNthFib(8));
    }

    private static int getNthFib(int n) {
        if (n == 2) {
            return 1;
        }
        if (n <= 1) {
            return 0;
        }

        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    // pay attention
    // Fibo sequence start with F0 (0) and F1(1)
    // So getNthFibo(1) means F0, getNthFibo(2) means F1 and so on
    // this impact the base case
}
