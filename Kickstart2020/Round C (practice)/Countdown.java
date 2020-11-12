//~10 minutes

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t= in.nextInt();
        for(int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + Solution.solve(in));
        }
    }

    private static int solve(Scanner in) {
        int numbers = in.nextInt();
        int k = in.nextInt();
        int result = 0;
        int count = 0;
        boolean sequence = false;

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < numbers; i++) {
            input.add(in.nextInt());
        }

        input.add(0);

        for (int i = input.size()-2; i >= 0; i--) {
            if (input.get(i) == 1) {
                count = 1;
                sequence = true;
            }
            else if (input.get(i) - 1 == input.get(i+1) && sequence) {
                count++;
            }
            else {
                sequence = false;
            }

            if (count == k) {
                result++;
                count = 0;
            }
        }
        return result;
    }
}
