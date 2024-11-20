import java.util.ArrayList;

public class Apasheap {
    private ArrayList<Integer> heap;
    private boolean isMinHeap;
    public Apasheap(boolean isMinHeap) {
        this.heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

   
    private int leftChild(int index) {
        return 2 * index + 1;
    }

   
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private boolean compare(int first, int second) {
        if (isMinHeap) {
            return first < second; 
        } else {
            return first > second; 
        }
    }

   
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

    
        while (current > 0 && compare(heap.get(current), heap.get(parent(current)))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

   
    public int removeRoot() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

      
        heapify(0);

        return root;
    }

    
    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallestOrLargest = index;

        if (left < heap.size() && compare(heap.get(left), heap.get(smallestOrLargest))) {
            smallestOrLargest = left;
        }

        if (right < heap.size() && compare(heap.get(right), heap.get(smallestOrLargest))) {
            smallestOrLargest = right;
        }

        if (smallestOrLargest != index) {
            swap(index, smallestOrLargest);
            heapify(smallestOrLargest);
        }
    }

    
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void displayHeap() {
        System.out.println(heap);
    }

    
    public static void main(String[] args) {
        
        Apasheap minHeap = new Apasheap(true);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(1);
        minHeap.insert(8);

        System.out.println("Min-Heap:");
        minHeap.displayHeap();
        System.out.println("Removed Root: " + minHeap.removeRoot());
        minHeap.displayHeap();

       
        Apasheap maxHeap = new Apasheap(false);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(8);

        System.out.println("\nMax-Heap:");
        maxHeap.displayHeap();
        System.out.println("Removed Root: " + maxHeap.removeRoot());
        maxHeap.displayHeap();
    }
}

          
