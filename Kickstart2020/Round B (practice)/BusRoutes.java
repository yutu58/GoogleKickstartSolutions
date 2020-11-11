//~20 minutes
//Got a TLE at first for the 2nd test set, turned out the day could've been calculated faster.

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
        int busses = in.nextInt();
        long arriveDay = in.nextLong();
        List<Long> frequencies = new ArrayList<>();

        for (int i = 0; i < busses; i++) {
            frequencies.add(in.nextLong());
        }

        long day = arriveDay;
        int i = busses - 1;
        while (i >= 0) {
            day = day -day % frequencies.get(i);
        i--;
        }
        return day;
    }
}
