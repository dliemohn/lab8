import java.util.*;

class MyPriorityQueue<E> implements PriorityQueueADT<E> {

    // you can use either of the following declarations for your heap
    ArrayList<E> heap;
    // E[] heap;
    int iter;

    Comparator<E> comparator;

    MyPriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<E>();
        // or
        // heap = (E[]) new Object[/* initial length */];
        iter = 0;
    }

    public boolean add(E item) {
        heap.add(item);
        siftUp(iter++);
        return true;
    }

    public E remove() {
        E result = heap.remove(0);
        heap.add(0,heap.remove(heap.size()-1));
        iter--;
        siftDown(0);
        return result;
    }

    public boolean isEmpty() {
        if (heap.isEmpty())
            return true;

        return false;
    }

    public int size() {
        return heap.size();
    }

    public void clear() {
        heap.clear();
    }

    public String toString() {
        String result = "";
        for(E dummy: heap) {
            result += dummy + " ";
        }
        return result;
    }

    private void siftUp(int pos) {
        E node = heap.get(pos);
        int par = parent(pos);
        if (par != -1) {
            E parent =  heap.get(par);
            if (comparator.compare(node, parent) > 0) {
                heap.set(pos, parent);
                heap.set(par, node);
                System.out.println("shifted " + node);
                siftUp(par);
            }
        }
    }

    private void siftDown(int pos) {
        E node = heap.get(pos);
        int lef = leftChild(pos);
        int rite = rightChild(pos);
        if (lef != -1 && rite != -1) {
            E left = heap.get(lef);
            E right = heap.get(rite);
            if (comparator.compare(left, right) > 0) {
                if (comparator.compare(node, left) <= 0) {
                    heap.set(pos, left);
                    heap.set(lef, node);
                    siftDown(lef);
                }
            } else {
                if (comparator.compare(node, right) <= 0) {
                    heap.set(pos, right);
                    heap.set(rite, node);
                    siftDown(rite);
                }
            }
        }
    }

    private int parent(int x) {
        if (x <= 0)
            return -1;
        return (x - 1) / 2;
    }

    private int leftChild(int x) {
        int child = (2 * x + 1);
        if (child >= size())
            return -1;
        return child;
    }

    private int rightChild(int x) {
        int child = (2 * x + 2);
        if (child >= size())
            return -1;
        return child;
    }

}