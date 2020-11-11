//To remember: The use of BigInteger

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t= in.nextInt();
        in.nextLine(); //Move scanner to next line
        for(int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + Solution.solve(in));
        }
    }

    private static String solve(Scanner in) {
        String input = in.nextLine();
        int x = 1;
        int y = 1;

        BigInteger bfactor = new BigInteger("1");
        BigInteger max1 = new BigInteger("1000000000");
        int max = 1000000000;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);

            BigInteger factor1 = bfactor.mod(max1);
            int factor2 = factor1.intValue();

            switch (a) {
                case 'S':
                    y += factor2;
                    y = (y % max + max) % max;
                    break;
                case 'E':
                    x += factor2;
                    x = (x % max + max) % max;
                    break;
                case 'N':
                    y -= factor2;
                    y = (y % max + max) % max;
                    break;
                case 'W':
                    x -= factor2;
                    x = (x % max + max) % max;
                    break;
                case ')':
                    int c = stack.pop();
                    BigInteger c2 = new BigInteger(String.valueOf(c));
                    bfactor = bfactor.divide(c2);
                    break;
                case '(':
                    //do nothing:
                    break;
                default:
                    int b = Character.getNumericValue(a);
                    stack.push(b);
                    BigInteger b2 = new BigInteger(String.valueOf(b));
                    bfactor = bfactor.multiply(b2);
            }
        }

        if (x == 0) {
            x = max;
        }

        if (y == 0) {
            y = max;
        }

        return x + " " + y;
    }
}
