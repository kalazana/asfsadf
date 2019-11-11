package a2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class A2Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number n (n > 0):");
        String input = inputReader.readLine();

        try {
            int n = Integer.parseInt(input);
            if (n == 0) {
                System.out.println("n = 0 not allowed");
            } else {
                A2Main.a2(n);
            }
        } catch (NumberFormatException e) {
            System.out.println("Number could not be parsed");
        }
    }

    private static void a2(int n) {
        int start = 1;
        int end = n > 1 ? n - 1 : 1;
        double[] sqrtArr = new double[end - start + 1];

        for (int i = start; i <= end; i++) {
            double sqrt = Math.sqrt(i);
            sqrtArr[i - 1] = sqrt;
        }

        double sqrtSum = 0;

        for (double sqrt : sqrtArr) {
            sqrtSum += sqrt;
        }

        double rootsAvg = sqrtSum / sqrtArr.length;

        System.out.printf("Average sqrt of %d number(s) from %d to %d is: %f", sqrtArr.length, start, end, rootsAvg);
    }
}
