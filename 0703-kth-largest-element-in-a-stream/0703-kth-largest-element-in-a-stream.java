import java.util.PriorityQueue;

class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {

        this.k = k;

        // Min Heap
        minHeap = new PriorityQueue<>();

        // Add initial numbers
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        // Add new number
        minHeap.add(val);

        // Keep only k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Smallest among k largest = kth largest
        return minHeap.peek();
    }
}