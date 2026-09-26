                           int cs, int cm, int cl) {

        int max = x + 100;

        int[] dp = new int[max + 1];

        // Initialize with a large value
        for (int i = 1; i <= max; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
        }

        dp[0] = 0;

        for (int i = 1; i <= max; i++) {

            if (i >= s) {
                dp[i] = Math.min(dp[i], dp[i - s] + cs);
            }

            if (i >= m) {
                dp[i] = Math.min(dp[i], dp[i - m] + cm);
            }

            if (i >= l) {
                dp[i] = Math.min(dp[i], dp[i - l] + cl);
            }
        }

        int ans = Integer.MAX_VALUE;

        // We need total area >= x
        for (int i = x; i <= max; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
}