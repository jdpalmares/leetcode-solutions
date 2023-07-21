function maxProfit(prices: number[]): number {
    // intuition answer but performance is bad
    // let maxProfit:number = 0;
    // for (let i = 0; i < prices.length - 1; i++ ){
    //     for (let j = i + 1; j < prices.length; j++) {
    //         if (prices[i] < prices[j]) {
    //             let tempAns = prices[j] - prices[i];
    //             if(tempAns > maxProfit){
    //                 maxProfit = tempAns;
    //             }
    //         }
    //     }
    // }
    // return maxProfit;

    //O(n) time and O(1) space solution
    let maxProfit = 0, minStock = prices[0];
    for( let i = 1; i < prices.length; i++ ) {
        if ( prices[i] < minStock ) {
            minStock = prices[i];
        } else {
            maxProfit = Math.max( prices[i] - minStock, maxProfit);
        }
    }
    return maxProfit;
};