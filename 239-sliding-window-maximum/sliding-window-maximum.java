class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        int[] maxWindow = new int[l - k + 1];
        Deque<Integer> maxQ = new ArrayDeque<>();
        
        
        for (int i = 0; i < k; i++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i])
                maxQ.removeLast();
            
            
            maxQ.addLast(i);
        }
        
        
        maxWindow[0] = nums[maxQ.peekFirst()];
        
        
        for (int windowEnd = k; windowEnd < l; windowEnd++) {
            int windowStart = windowEnd - k + 1;
            
            
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[windowEnd])
                maxQ.removeLast();
            
            
            maxQ.addLast(windowEnd);
            
            
            while (maxQ.peekFirst() < windowStart)
                maxQ.removeFirst();
            
            
            maxWindow[windowStart] = nums[maxQ.peekFirst()];
        }
        
        
        return maxWindow;
    }
}