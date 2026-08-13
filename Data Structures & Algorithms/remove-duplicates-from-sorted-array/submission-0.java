class Solution {
    public int removeDuplicates(int[] nums) {
       
        int j=0,i=0;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }
            j++;
        }
        return i+1;
    }
}