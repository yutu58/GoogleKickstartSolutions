//Note: This only passed the 1st test set (and not the second) because of time. Will try to get the 2nd test set working later.

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

    private static int solve(Scanner in) {
        int sessions = in.nextInt();
        int upto = in.nextInt();
        List<Integer> mSessions = new ArrayList<>();
        List<Integer> addedValues = new ArrayList<>();

        for (int i = 0; i < sessions; i++) {
            mSessions.add(in.nextInt());
        }


        while (upto > 0) {
            int upperIndex = indexMaxDifference(mSessions);
            if (upperIndex == -1) {
                return 1;
            }
            if (upperIndex == -2) {
                return 0;
            }
            while (addedValues.contains(mSessions.get(upperIndex))) {
                addedValues.remove(mSessions.get(upperIndex));
                upperIndex++;
            }

            int lowerIndex = upperIndex -1;
            while (addedValues.contains(mSessions.get(lowerIndex))) {
                addedValues.remove(mSessions.get(lowerIndex));
                lowerIndex--;
            }

            int lowestIndexAmount = mSessions.get(lowerIndex);
            int difference = mSessions.get(upperIndex) - lowestIndexAmount;
            int total = upperIndex - lowerIndex + 1;
            int count = 1;

            lowerIndex++;
            while (lowerIndex < upperIndex) {
                int a = difference * count / (total) + lowestIndexAmount;
                mSessions.set(lowerIndex, a);
                addedValues.add(a);
                count++;
                lowerIndex++;
            }

            int toAdd = (mSessions.get(upperIndex) + mSessions.get(upperIndex-1)) / 2;
                mSessions.add(upperIndex, toAdd);
                addedValues.add(toAdd);
            upto--;
        }
        return mSessions.get(indexMaxDifference(mSessions)) - mSessions.get(indexMaxDifference(mSessions) - 1);
    }

    static int indexMaxDifference(List<Integer> a) {
        int max = 0;
        int index = 0;
        for (int i = 1; i < a.size(); i++){
            int number = a.get(i);
            int difference = number - a.get(i-1);

            if (difference >= max) {
                max = difference;
                index = i;
            }
        }

        if (max ==1){
            return -1;
        }

        if (max == 0) {
            return -2;
        }

        return index;

    }
}
