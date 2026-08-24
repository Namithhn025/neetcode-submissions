class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for(String s:operations){
            if(s.equals("C")){
                stack.pop();
            }
            else if(s.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(s.equals("+")){
                Integer prev=stack.pop();
                Integer result=prev+stack.peek();
                stack.push(prev);
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        while (!stack.isEmpty()) {
          sum += stack.pop();
        }
     return sum;
         
    }
}