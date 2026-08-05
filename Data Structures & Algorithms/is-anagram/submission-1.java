class Solution {
    public boolean isAnagram(String s, String t) {
        char[] tarr=t.toCharArray();
        char[] sarr=s.toCharArray();
        Arrays.sort(tarr);
        Arrays.sort(sarr);
        if(Arrays.equals(sarr, tarr)){
            return true ;
        }
        return false;
    }
}
