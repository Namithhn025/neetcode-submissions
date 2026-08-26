class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (!stack.empty() && asteroids[i] < 0) {
                while (
                    !stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                if (stack.empty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }
            } else {
                stack.push(asteroids[i]);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
