class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // Check if a common divisor string is possible
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int k = gcd(str1.length(), str2.length());

        return str1.substring(0, k);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}