class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int m = word1.length();
        int n = word2.length();

        if (m < n) {

            for (int i = 0; i < m; i++) {
                result.append(word1.charAt(i));
                result.append(word2.charAt(i));
            }

            for (int j = m; j < n; j++) {
                result.append(word2.charAt(j));
            }

        } else {

            for (int i = 0; i < n; i++) {
                result.append(word1.charAt(i));
                result.append(word2.charAt(i));
            }

            for (int j = n; j < m; j++) {
                result.append(word1.charAt(j));
            }
        }

        return result.toString();
    }
}