class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                int prev=stack.pop();
                int prev2=stack.pop();
                stack.push(prev+prev2);

            }
            else if(s.equals("-")){
                 int prev=stack.pop();
                int prev2=stack.pop();
                stack.push(prev2-prev);

            }
            else if(s.equals("*")){
                 int prev=stack.pop();
                int prev2=stack.pop();
                stack.push(prev*prev2);

            }
            else if(s.equals("/")){
                 int prev=stack.pop();
                int prev2=stack.pop();
                stack.push(prev2/prev);

            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
