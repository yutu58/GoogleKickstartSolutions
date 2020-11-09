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

    //Disclaimer: I did not completely figure out this solution on my own (sadly D:)
    private static int solve(Scanner in) {
        int nStacks = in.nextInt();
        int nPlatesPerStack = in.nextInt();
        int nPick = in.nextInt();
        List<List<Integer>> sumstacks = new ArrayList<>();
        sumstacks.add(null); //Make it such that sumstacks[i] will be the sums of the i-th stack, for later purpose

        //Fill sumstacks
        for (int i = 0; i < nStacks; i++) {
            List<Integer> sumScore = new ArrayList<>();
            sumScore.add(0);
            int sum = 0;
            for (int j = 0; j < nPlatesPerStack; j++) {
                sum += in.nextInt();
                sumScore.add(sum);
            }
            sumstacks.add(sumScore);
        }

        //Make an array of arrays, with the first row completely being 0;
        //MaxSum[a][b] will be the maximum sum possible when you consider the first a stacks and b plates to be taken.

        int maxSum[][] = new int[nStacks+1][nPick+1];
        for (int j = 0; j <= nPick; j++) {
            maxSum[0][j] = 0;
        }

        //Loop through all stacks
        for (int i = 1; i <= nStacks; i++) {

            //Loop the amount of times of the number of plates the guy wants to pick
            for (int j = 0; j <= nPick; j++) {

                //Set the initial value to zero
                maxSum[i][j] = 0;

                //
                for (int x = 0; x <= Math.min(j, nPlatesPerStack); x++) {
                    //Compare the current maximum sum with a possible better maximum sum
                    //The possible better maximum sum is

                    //x is the amount of plates the guy takes from this stack
                    maxSum[i][j] = Math.max(maxSum[i][j], sumstacks.get(i).get(x) + maxSum[i-1][j-x]);
                }
            }
        }

        return maxSum[nStacks][nPick];
    }
}
