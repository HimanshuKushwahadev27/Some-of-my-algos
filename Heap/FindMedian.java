package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {
    private final PriorityQueue<Integer> maxHeap; // holds the smaller half
    private final PriorityQueue<Integer> minHeap; // holds the larger half

    public FindMedian() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Always add to maxHeap first, then rebalance by moving its top to minHeap.
        // This keeps the invariant: every element in maxHeap <= every element in minHeap.
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // Maintain size balance: maxHeap should have equal or one more element than minHeap.
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
