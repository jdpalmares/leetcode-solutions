
public class AddBinary {
    //reverse method solution
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int firstNumLen = a.length() - 1, secondNumLen = b.length() - 1, carry = 0;
        
        while (firstNumLen >= 0 || secondNumLen >= 0) {
            int sum = carry;
            if (secondNumLen >= 0)
                sum += b.charAt(secondNumLen--) - '0';
            if (firstNumLen >= 0)
                sum += a.charAt(firstNumLen--) - '0';
            ans.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) ans.append(carry);
        return ans.reverse().toString();
    }

    //one line solution using big integer
    // public String addBinary(String a, String b) {
    //     return new java.math.BigInteger(a, 2).add(new java.math.BigInteger(b, 2)).toString(2);
    // }
}
