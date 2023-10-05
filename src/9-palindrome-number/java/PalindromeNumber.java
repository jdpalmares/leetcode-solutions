
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x!=0 && x%10==0))
            return false;
        int numReverse = 0;
        while ( x>numReverse ){
            numReverse = numReverse*10 + x%10;
            x = x/10;
        }
        return (x == numReverse || x == numReverse/10 );
    }
}