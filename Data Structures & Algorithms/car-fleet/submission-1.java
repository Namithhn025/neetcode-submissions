class Solution {
    Deque<Double> stack = new ArrayDeque<>();

    public int carFleet(int target, int[] position, int[] speed) {

        int[][] cars = new int[position.length][2];

        // Keep position and speed together
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position: closest to target first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double ttl = 0;

        for(int i = 0; i < cars.length; i++){

            ttl = (double)(target - cars[i][0]) / cars[i][1];

            if(stack.isEmpty() || stack.peek() < ttl){
                stack.push(ttl);
            }
        }

        return stack.size();
    }
}