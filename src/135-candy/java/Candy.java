import java.util.Arrays;

public class Candy {
    //O(n) time O(1) space solution
    public int candy(int[] ratings) {
        int ratingLen = ratings.length, candy = ratingLen, i=1;
        while(i < ratingLen){
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }
            
            int peak = 0;
            while(ratings[i] > ratings [i-1]){
                peak++;
                candy += peak;
                i++;
                if(i == ratingLen) return candy;
            }
            
            int valley = 0;
            while(i < ratingLen && ratings[i] < ratings[i-1]){
                valley++;
                candy += valley;
                i++;
            }
            candy -= Math.min(peak, valley);
        }
        return candy;
    }

    //Greedy Algo
    public int candyGreedy(int[] ratings) {
        int ratingLen = ratings.length;
        int[] candies = new int[ratingLen];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratingLen; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        for (int i = ratingLen - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }

        int totalCandies = 0;
        for (int candy : candies) totalCandies += candy;

        return totalCandies;
    }
}
