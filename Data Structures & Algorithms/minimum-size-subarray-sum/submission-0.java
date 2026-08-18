class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int minCount=Integer.MAX_VALUE;;
        for(int right=0;right<nums.length;right++)
        {
             sum+=nums[right];
            while(sum>=target)
            {
                minCount=Math.min(minCount,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        if(minCount==Integer.MAX_VALUE){
            return 0;
        }
    return minCount;
    }
}