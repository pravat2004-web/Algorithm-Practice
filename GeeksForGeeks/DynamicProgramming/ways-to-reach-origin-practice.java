class Solution {
    static final int MOD = 1000000007;
    static long[] fact = new long[1001]; // since x,y ≤ 500 → x+y ≤ 1000

    // Precompute factorials up to 1000
    static void computeFactorials() {
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }

    // Fast exponentiation for modular inverse
    static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    // Compute nCr % MOD
    static long nCr(int n, int r) {
        if (r > n) return 0;
        long numerator = fact[n];
        long denominator = (fact[r] * fact[n - r]) % MOD;
        return (numerator * modPow(denominator, MOD - 2)) % MOD;
    }

    public int ways(int x, int y) {
        computeFactorials();
        return (int) nCr(x + y, x);
    }
}
