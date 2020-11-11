import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        for(int i = 1; i <= n; i++) {
            System.out.println(String.format("Case #" + i + ": " + Solution.solve(in)));
        }
    }

    private static long solve(Scanner in) {
        int nCP = in.nextInt();
        List<Integer> cps = new ArrayList<>();
        for (int i = 0; i < nCP; i++) {
            cps.add(in.nextInt());
        }
        int result = 0;

        for (int i = 1; i < (nCP-1); i++) {
            if (cps.get(i) > cps.get(i-1) && cps.get(i) > cps.get(i+1)) {
                result += 1;
            }
        }
        return result;
    }
}
