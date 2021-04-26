// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3721/

class Solution {
    public int furthestBuilding(int[] A, int bricks, int ladders) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < A.length - 1; i++) {
        int d = A[i + 1] - A[i];
        if (d > 0)
            pq.add(d);
        if (pq.size() > ladders)
            bricks -= pq.poll();
        if (bricks < 0)
            return i;
    }
    return A.length - 1;
}
    public int tryFurthestBuilding(int[] heights, int bricks, int ladders, int currentIndex, HashMap<String, Integer> destinationMap) {
        String key = currentIndex + "-" + bricks + "-" + ladders;
        // We've already calculated this case before
        if (destinationMap.containsKey(key)) {
            return destinationMap.get(key);
        }
        
        // It's already the last building.
        if (currentIndex == heights.length - 1) {
            destinationMap.put(key, currentIndex);
            return currentIndex;
        }
        
        int heightDiff = heights[currentIndex + 1] - heights[currentIndex];
        // We can always move to the next building without using any ladder or brick.
        if (heightDiff < 0) {
            int result = tryFurthestBuilding(heights, bricks, ladders, currentIndex + 1, destinationMap);
            destinationMap.put(key, result);
            return result;
        }
        
        // Try to use ladder and bricks to move, and get the optimal result
        int useLadder = ladders > 0 
            ? tryFurthestBuilding(heights, bricks, ladders - 1, currentIndex + 1, destinationMap) 
            : currentIndex;
        int useBricks = bricks > heightDiff ? 
            tryFurthestBuilding(heights, bricks - heightDiff, ladders, currentIndex + 1, destinationMap) 
            : currentIndex;
        destinationMap.put(key, Math.max(useLadder, useBricks));
        return Math.max(useLadder, useBricks);
    }
}
