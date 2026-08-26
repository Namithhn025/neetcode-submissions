class MinStack {
    Stack<Pair> stack;
    class Pair{
        int min;
        int value;
        Pair(int min,int value){
            this.min=min;
            this.value=value;
        }
    }

    public MinStack() {
        this.stack=new Stack<Pair>();
    }
    
    public void push(int val) {
        if(stack.empty()){
            stack.push(new Pair(val,val));
        }
        else{
            if(stack.peek().min>=val){
                stack.push(new Pair(val,val));
            }
            else{
                stack.push(new Pair(stack.peek().min,val));
            }
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
           return   stack.peek().min;

    }
}
