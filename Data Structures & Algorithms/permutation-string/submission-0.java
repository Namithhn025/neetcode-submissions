class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[] str1 = new int[26];
        int[] str2 = new int[26];

        int left = 0;

        // Frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            str1[ch - 'a']++;
        }

        // Sliding window on s2
        for (int right = 0; right < s2.length(); right++) {

            // Add current character
            char ch = s2.charAt(right);
            str2[ch - 'a']++;

            // If window becomes bigger, remove left character
            if (right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                str2[leftChar - 'a']--;
                left++;
            }

            // Check when window size is exactly s1.length()
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(str1, str2)) {
                    return true;
                }
            }
        }

        return false;
    }
}