package reverse_integer;

public class Solution_reverseInteger {
    public int reverse(int x) {
        long k = x;
        int result;
        int prefix = 0;
        if (k < 0) {
            k = 0 - k;
            prefix = 1;
        }

        String s = String.valueOf(k);
        String reverse = new StringBuffer(s).reverse().toString();
        k = Long.valueOf(reverse).longValue();
        if (k > Integer.MAX_VALUE) {
            return 0;
        }
        if (prefix == 1) {
            result = 0 - (int) k;
            return result;
        } else {
            result = (int) k;
            return result;
        }
    }
}
