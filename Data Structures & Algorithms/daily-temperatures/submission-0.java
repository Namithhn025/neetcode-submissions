class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[temperatures.length];
        Arrays.fill(result,0);
        for(int i=0;i<temperatures.length;i++)
        {
            while(!stack.empty()&&temperatures[stack.peek()]<temperatures[i]){
                int index=stack.pop();
                result[index]=i-index;
            }
            stack.push(i);
        }
    return result;
    }
}
