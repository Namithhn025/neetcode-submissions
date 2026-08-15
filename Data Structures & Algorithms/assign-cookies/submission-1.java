class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int cookie=0;
        int greed=0;
        while(cookie<s.length&&greed<g.length){
            if(s[cookie]>=g[greed]){
                count++;
                  greed++;
            }
            cookie++;
            
        }
    return count;
    }
}