import java.util.*;

class MedianFinder {

    // Stores the smaller half of the numbers.
    // Max heap → largest number is on top.
    private PriorityQueue<Integer> maxHeap;

    // Stores the larger half of the numbers.
    // Min heap → smallest number is on top.
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1:
        // Put the new number into the left half.
        maxHeap.offer(num);

        // Step 2:
        // Move the largest number from the left half
        // to the right half.
        minHeap.offer(maxHeap.poll());

        // Step 3:
        // If right half has more elements,
        // move its smallest element back to the left.
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements.
        // maxHeap contains the extra element.
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        // Even number of elements.
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}