package Citadel;

public class consecutiveNumberSum {

    public int consecutiveNumbersSumSqrt(int N) {
        int ans = 0;
        for (int i = 1; i * (i - 1) / 2 < N; ++i)
            if ((N - i * (i - 1) / 2) % i == 0)
                ++ans;
        return ans;
    }

    public int consecutiveNumbersSum(int N) {
        int res = 1, count;
        while (N % 2 == 0) N /= 2;
        for (int i = 3; i * i <= N; i += 2) {
            count = 0;
            while (N % i == 0) {
                N /= i;
                count++;
            }
            res *= count + 1;
        }
        return N == 1 ? res : res * 2;
    }
}
