import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i <= t; i++) {
            System.out.println(String.format("Case #" + i + ": " + Solution.solve(in)));
        }
    }

    private static int solve(Scanner in) {
        int amount = in.nextInt();
        int budget = in.nextInt();
        List<Integer> prices = new ArrayList<>();
        while (amount > 0) {
            prices.add(in.nextInt());
            amount--;
        }
        int counter = 0;
        Collections.sort(prices);
        while (prices.get(counter) <= budget) {
            budget -= prices.get(counter);
            counter++;

            if (counter == prices.size()) {
                break;
            }
        }
        return counter;
    }
}
