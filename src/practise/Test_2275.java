package practise;   

import java.util.Arrays;

class Test_2275 {
    public int largestCombination(int[] candidates) {
        int mx = 0;
        for (int candidate : candidates) {
            mx = Math.max(candidate, mx);
        }
        int m = Integer.numberOfLeadingZeros(mx);
        int[] bits = new int[32];
        for (int candidate : candidates) {
            for (int i = 0; i < m; i++) {
                if ((candidate & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }
        return Arrays.stream(bits).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        Test_2275 solution = new Test_2275();
        System.out.println(solution.largestCombination(candidates));
    }
}