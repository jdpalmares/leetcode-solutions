public class HappyNumber {
    // intuition answer
    // public boolean isHappy(int n) {
    // if (n == 1)
    // return true;
    // if (n == 2)
    // return false;
    // Map<Integer, Integer> numMap = new HashMap<>();
    // int curNum = n;
    // while (true) {
    // if (numMap.containsKey(curNum))
    // return false;
    // String digitStr = String.valueOf(curNum);
    // int subTotal = 0;
    // for (int i = 0; i < digitStr.length(); i++) {
    // int digitInt = digitStr.charAt(i) - '0';
    // subTotal += digitInt * digitInt;
    // }

    // if (subTotal == 1)
    // return true;
    // else
    // numMap.put(curNum, subTotal);
    // curNum = subTotal;
    // }
    // }

    // alternative answer using hashset
    // public boolean isHappy(int n) {
    // Set<Integer> numSet = new HashSet<>();

    // while (n != 1 && n != 2 && !numSet.contains(n)) {
    // numSet.add(n);
    // int sum = 0;
    // while (n != 0) {
    // int digit = n % 10;
    // sum += digit * digit;
    // n /= 10;
    // }
    // n = sum;
    // }
    // return n == 1;
    // }

    // same time but O(1) space solution using floyd's tortoise and hare algo
    public boolean isHappy(int n) {
        int slow = n, fast = n; // slow , fast

        do {
            slow = getSquare(slow); // slow computes only once
            fast = getSquare(getSquare(fast)); // fast computes 2 times
            if (slow == 1)
                return true; // if we found 1 then happy indeed !!!
        } while (slow != fast); // else at some point they will meet in the cycle

        return false; // it's a cycle , not happy at all !!!
    }

    private int getSquare(int n) {
        int subTotal = 0;
        while (n != 0) {
            subTotal += (n % 10) * (n % 10);
            n = n / 10;
        }
        return subTotal;
    }
}
