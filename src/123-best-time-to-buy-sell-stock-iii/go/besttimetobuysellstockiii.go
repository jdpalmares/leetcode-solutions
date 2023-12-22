//state machine solution
func maxProfit(prices []int) int {
    bought, sold := [2]int{math.MinInt32, math.MinInt32}, [2]int{math.MinInt32, math.MinInt32}
    prevBought, prevSold := [2]int{}, [2]int{}
    
    for _, price := range prices {
        prevBought, prevSold = bought, sold
        
        bought[0] = max(prevBought[0], -price)
        sold[0] = max(sold[0], prevBought[0]+price)
        
        bought[1] = max(bought[1], prevSold[0]-price)
        sold[1] = max(sold[1], prevBought[1]+price)
    }
    
    return max(0, max(sold[0], sold[1]))
}

func max(i, j int) int {
    if i > j {
        return i
    }
    return j
}

//memoization
func maxProfit(prices []int) int {
    max_ahead := make([]int, len(prices))
    max_seen := 0
    for i := len(prices)-1; i >= 0; i-- {
        max_ahead[i] = max_seen
        if prices[i] > max_seen {
            max_seen = prices[i]
        }
    }

    max_profit_of_array_starting_at := make([]int, len(prices))
    for start_idx := len(prices)-2; start_idx >= 0; start_idx-- {
        max_profit_of_array_starting_at[start_idx] = max_profit_of_array_starting_at[start_idx+1]
        if max_ahead[start_idx] - prices[start_idx] > max_profit_of_array_starting_at[start_idx] {
            max_profit_of_array_starting_at[start_idx] = max_ahead[start_idx] - prices[start_idx]
        }
    }

    min_behind := make([]int, len(prices))
    min_behind[0] = prices[0]

    max_t1_profit := 0
    if len(prices) > 1 {
        max_t1_profit = prices[1] - prices[0]
    }

    max_profit_with_one_or_two_transactions := max_profit_of_array_starting_at[0]
    for t1_range_end := 1; t1_range_end < len(prices)-2; t1_range_end++ {
        min_behind[t1_range_end] = min_behind[t1_range_end-1]
        if prices[t1_range_end-1] < min_behind[t1_range_end-1] {
            min_behind[t1_range_end] = prices[t1_range_end-1]
        }

        if prices[t1_range_end] - min_behind[t1_range_end] > max_t1_profit {
            max_t1_profit = prices[t1_range_end] - min_behind[t1_range_end]
        }

        max_t2_profit := max_profit_of_array_starting_at[t1_range_end+1]

        if max_t1_profit + max_t2_profit > max_profit_with_one_or_two_transactions {
            max_profit_with_one_or_two_transactions = max_t1_profit + max_t2_profit
        }
    }

    return max_profit_with_one_or_two_transactions
}

//dynamic programming
func maxProfit(prices []int) int {
    if len(prices) == 0 {
        return 0
    }
    n := len(prices)
    dp := make([][]int, 3)
    for i := 0; i < 3; i++ {
        dp[i] = make([]int, n+1)
    }
    
    for k := 1; k < 3; k++ {
        min_price := prices[0]
        for i := 1; i < n+1; i++ {
            min_price = Min(min_price, prices[i-1]-dp[k-1][i-1])
            dp[k][i] = Max(dp[k][i-1], prices[i-1]-min_price)
        }
    }
    
    return dp[2][n]
}

func Min(x, y int) int {
    if x < y {
        return x
    }
    return y
}

func Max(x, y int) int {
    if x > y {
        return x
    }
    return y
}