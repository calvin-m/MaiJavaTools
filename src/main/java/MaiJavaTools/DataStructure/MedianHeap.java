package MaiJavaTools.DataStructure;



import java.util.*;
import java.lang.*;
import java.io.*;

public class MedianHeap {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void print(PriorityQueue<Integer> heap) {
        Iterator<Integer> it = heap.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");
    }

    public void insert(int d) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.peek() != null && maxHeap.peek() > d) {
                int tmp = maxHeap.peek();
                maxHeap.remove();
                maxHeap.add(d);
                minHeap.add(tmp);
            } else {
                minHeap.add(d);
            }
        } else {
            if (minHeap.peek() > d) {
                maxHeap.add(d);
            } else {
                int tmp = minHeap.peek();
                minHeap.remove();
                maxHeap.add(tmp);
                minHeap.add(d);
            }
        }
    }

    public int getMedian() {
            /*System.out.print("Max Heap: ");
            print(maxHeap);
            System.out.print("Min Heap: ");
            print(minHeap);*/
        if (maxHeap.size() == minHeap.size()) {
            return (int) Math.floor((maxHeap.peek() + minHeap.peek()) / 2);
        } else {
            return minHeap.peek();
        }
    }
}
/*
        public static void main (String[] args) {
            GFG g = new GFG();
            GFG.MedianHeap heap = g.new MedianHeap();
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            for(int i=0;i<n;i++) {
                int v = scan.nextInt();
                heap.insert(v);
                System.out.println(heap.getMedian());
            }
        }
        */


