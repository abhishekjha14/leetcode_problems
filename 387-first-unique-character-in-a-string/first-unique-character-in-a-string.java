class Solution {
    public int firstUniqChar(String s) {
        // Array acts as our frequency map for the 26 lowercase letters
        int[] count = new int[26];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 1. Update the character's frequency
            count[c - 'a']++;
            
            // 2. Add to queue ONLY if it's the first time we see it
            // This prevents the queue from growing to O(n) and keeps it at max 26 elements
            if (count[c - 'a'] == 1) {
                queue.offer(i);
            }
            
            // 3. Clean up the queue from the front
            // If the index at the front belongs to a character seen > 1 time, poll it
            while (!queue.isEmpty() && count[s.charAt(queue.peek()) - 'a'] > 1) {
                queue.poll();
            }
        }
        
        // If the queue is not empty, the front element is the index of the first unique character
        return queue.isEmpty() ? -1 : queue.peek();
    }
}