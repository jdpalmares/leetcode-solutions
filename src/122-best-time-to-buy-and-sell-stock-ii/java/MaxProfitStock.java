class MaxProfitStock {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int curStock = prices[i], prevStock = prices[i - 1];
            if (curStock > prevStock) {
                totalProfit += (curStock - prevStock);
            }
        }
        return totalProfit;
    }

    // Other Solutions
    // recursive
    // public int maxProfitRecursive(int[] prices, int index, int buy){
    // // Base Case
    // if(index == prices.length) return 0;
    // int totalProfit = 0;
    // if(buy == 1){
    // int buyKaro = -prices[index] + maxProfitRecursive(prices, index + 1, 0);
    // int skipKaro = maxProfitRecursive(prices, index + 1, 1);
    // totalProfit = Math.max(buyKaro, skipKaro);
    // }else{
    // int sellKaro = prices[index] + maxProfitRecursive(prices, index + 1, 1);
    // int skipKaro = maxProfitRecursive(prices, index + 1, 0);
    // totalProfit = Math.max(sellKaro, skipKaro);
    // }
    // return totalProfit;
    // }

    // Memoization
    // public int maxProfitMemoization(int[] prices, int index, int buy, int[][]
    // dp){
    // // Base Case
    // if(index == prices.length) return 0;
    // if(dp[index][buy] != -1) return dp[index][buy];
    // int totalProfit = 0;
    // if(buy == 1){
    // int buyKaro = -prices[index] + maxProfitMemoization(prices, index + 1, 0,
    // dp);
    // int skipKaro = maxProfitMemoization(prices, index + 1, 1, dp);
    // totalProfit = Math.max(buyKaro, skipKaro);
    // }else{
    // int sellKaro = prices[index] + maxProfitMemoization(prices, index + 1, 1,
    // dp);
    // int skipKaro = maxProfitMemoization(prices, index + 1, 0, dp);
    // totalProfit = Math.max(sellKaro, skipKaro);
    // }
    // return dp[index][buy] = totalProfit;
    // }

    // Tabulation
    // public int maxProfitTabulation(int[] prices){
    // int[][] dp = new int[prices.length + 1][2];
    // for(int[] row : dp) Arrays.fill(row, 0);

    // for(int index = prices.length - 1; index >= 0; index--){
    // for(int buy = 0; buy < 2; buy++){
    // int totalProfit = 0;
    // if(buy == 1){
    // int buyKaro = -prices[index] + dp[index + 1][0];
    // int skipKaro = dp[index + 1][1];
    // totalProfit = Math.max(buyKaro, skipKaro);
    // }else{
    // int sellKaro = prices[index] + dp[index + 1][1];
    // int skipKaro = dp[index + 1][0];
    // totalProfit = Math.max(sellKaro, skipKaro);
    // }
    // dp[index][buy] = totalProfit;
    // }
    // }
    // return dp[0][1];
    // }

    // Space Optimization
    // public int maxProfitSpaceOptimization(int[] prices){
    // int[] curr = new int[2];
    // int[] next = new int[2];
    // Arrays.fill(curr, 0);
    // Arrays.fill(next, 0);

    // for(int index = prices.length - 1; index >= 0; index--){
    // for(int buy = 0; buy < 2; buy++){
    // int totalProfit = 0;
    // if(buy == 1){
    // int buyKaro = -prices[index] + next[0];
    // int skipKaro = next[1];
    // totalProfit = Math.max(buyKaro, skipKaro);
    // }else{
    // int sellKaro = prices[index] + next[1];
    // int skipKaro = next[0];
    // totalProfit = Math.max(sellKaro, skipKaro);
    // }
    // curr[buy] = totalProfit;
    // }
    // next = curr.clone();
    // }
    // return next[1];
    // }
}
