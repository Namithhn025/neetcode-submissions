class Solution {
    public int[] getConcatenation(int[] nums) {
       int N=nums.length;
       int[] result=new int[N*2];
       for(int i=0;i<N;i++){
        result[i]=nums[i];
        result[N+i]=nums[i];
       }
       return result;
    }
}