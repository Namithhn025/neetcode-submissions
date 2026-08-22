class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int i=0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        int res=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canBeShipped(weights,mid)<=days){
                high=mid-1;
                res=mid;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    private int canBeShipped(int[] weights,int mid){
        int ships=1,currentWeight=0;
        for(int weight:weights){
            if(weight+currentWeight>mid)
            {
                ships++;
                currentWeight=weight;
            }
            else{
                currentWeight+=weight;
            }
        }
        return ships;

    }
}