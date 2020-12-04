package RoadTo1K;

public class lt552checkRecord {
/*
return the number of all possible attendance records with length n, which will be regarded as rewardable.
contain more than one 'A' (absent) or more than two continuous 'L' (late).

dp[i]: the number of all possible attendance records with length i, which will be regarded as rewardable
if remeber the i-1 status, will run out of memeory

1. P, L, A
2. PP, PL, PA
LP, LL, LA
AL, AP
= 8
3. P+8
L+4
A+4
发现好像不能直到之前的状态
那么换种思路:
我们只要关心前面有几个A了，或者几个连续的L
dp0[i]: S[0:i] never A appear
dp1[i]: S[0:i] A appear once

x x x x x x i
dp0[0]: 1 给0个字符a出现了0次,空字符串一种
dp1[0]: 0 给0个字符a出现了1次

for(int i = 1; i <= n ; i++){
dp0[i] = dp0[i-1] * 2       A没出现过。那么我们只能是i-1的时候A也没出现过，i的时候我们可以放入L或者P，我们乘2
dp1[i] = dp1[i-1] * 2 + dp0[i-1] 到i的时候，A要出现，1.我们前面可以是A出现过了我们现在选L或者P，或者到i-1的时候已经还没出现，我们只能选A
}
return dp0[n]+dp1[n]    这是所有A的可能

dp0L[0]: 1 空字符串一种
dp0L[1]: 0
dp0L[2]: 0

x x x x x x i
for(int i = 1; i <= n; i++){
dp0L[i] = (dp0L[i-1] + dp1[i-1] + dp2[i-1] ) * 2 到i的时候没有L出现在尾巴，我们可以是到i-1，l出现0，1，2次都行，我们在i选L或者P
dp1L[i] = dp0L[i-1]*1  结尾i的时候要1个L，我们需要前面没有L的i-1
dp2L[i] = dp1l[i-1]*1  结尾i的时候要2个L，我们需要结果有1个L的i-1
}
return dp0[n]+dp1l[n]+dp2[n]


2*3 = 6种状态,对应A跟L的组合
dp00[i]: for S[0:i] never A appeared, end with 0 L
dp01[i]: for S[0:i] never A appeared, end with 1 L
dp02[i]: for S[0:i] never A appeared, end with 2 L
dp10[i]: for S[0:i] A once appeared, end with 0 L
dp11[i]: for S[0:i] A once appeared, end with 1 L
dp12[i]: for S[0:i] A once appeared, end with 2 L

dp00[0]: 1 空字符
dp01[i]: 0
dp02[i]: 0
dp10[i]: 0
dp11[i]: 0
dp12[i]: 0

for(int i = 1; i <= n; i++){
i-1是0A0L我们加个p得到0A0L的i, i-1是0A1L我们加个p得到0A0L的i, i-1是0A2L我们加个p得到0A0L的i,
0A0L dp00[i] = dp00[i-1] * P + dp01[i-1] * P + dp02[i-1]*p
0A1L dp01[i] = dp00[i-1]*L i-1的时候没有A，没有L，我们才能得到0A1L
0A2L dp02[i] = dp01[i-1]*L i-1的时候没有A，要有一个L，我们才能得到0A2L
0A0L + A得到1A0L,0A1L + A得到1A1L，0A2L + A得到1A2L, 1A0L + P得到1A0L，1A1L + P得到1A0L， 1A2l + P得到1A0L
1A0L dp10[i] = dp00[i-1]*A + dp01[i-1]*A+dp02[i-1]*A+dp10[i-1]*P + dp11[i-1]*P + dp12[i-1] * P
1A1L dp11[i] = dp10[i-1]*L 前面A要出现过，i-1的位置不是L，我们才能在i的时候加L得到1A1L
1A2L dp12[i] = dp11[i-1]*L 前面A要出现过，i-1的位置要L，我们才能在i的时候就加L得到1A2L
}
return dp00[i]+dp01[i]+dp02[i]+dp10[i]+dp11[i]+dp12[i]
*/

    class Solution {
        public int checkRecord(int n) {
            //这里其实可以用六个变量来做就好，因为i只跟i-1有关
            long[] dp00 = new long[n + 1];
            long[] dp01 = new long[n + 1];
            long[] dp02 = new long[n + 1];
            long[] dp10 = new long[n + 1];
            long[] dp11 = new long[n + 1];
            long[] dp12 = new long[n + 1];
            dp00[0] = 1;

            int mod = (int)1e9 + 7;
            for(int i = 1; i <= n; i++){
                dp00[i] = (dp00[i-1] + dp01[i-1] + dp02[i-1]) % mod;
                dp01[i] = dp00[i-1] % mod;
                dp02[i] = dp01[i-1] % mod;
                dp10[i] = (dp00[i-1] + dp01[i-1] + dp02[i-1] + dp10[i-1] + dp11[i-1] + dp12[i-1]) % mod;
                dp11[i] = dp10[i-1] % mod;
                dp12[i] = dp11[i-1] % mod;
            }
            int res = (int)((dp00[n]+dp01[n]+dp02[n]+dp10[n]+dp11[n]+dp12[n]) % mod);
            return res;
        }
    }

}
