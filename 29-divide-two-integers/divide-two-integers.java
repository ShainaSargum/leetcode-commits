class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        while (a >= b) {
            long temp = b;
            long multiple = 1;

            while (a >= temp + temp) {
                temp += temp;
                multiple += multiple;
            }

            a -= temp;
            quotient += multiple;
        }

        if ((dividend < 0) != (divisor < 0)) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}