/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author Kieran
 * @param <T>
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T> {
    
    private PriorityItem<T>[] heap;
    
    private PriorityItem<T>[] array;

    private final int capacity = 2;

    private int tailIndex;

    /**
     * @param size
     */
    public HeapPriorityQueue(int size) {
        heap = (PriorityItem<T>[])new Comparable[capacity];
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return (heap[0]).getItem();
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
    tailIndex = heap.length + 1;
        if (tailIndex >= heap.length + 2) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
            
            heap[i] = new PriorityItem<>(item, priority);
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int i = heap.length;
            heap[0] = heap[i--];
        }
    }
    
    public void sortHeap(){
      tailIndex = heap.length;
      heap = (PriorityItem[]) new Comparable[tailIndex+1];
      System.arraycopy(array, 0, heap, 1, tailIndex);
      buildHeap();

      for (int i = tailIndex; i > 0; i--)
      {
         PriorityItem<T> tmp = heap[i]; //move top item to the end of the heap array
         heap[i] = heap[1];
         heap[1] = tmp;
         tailIndex--;
         percolatingDown(1);
      }
      for(int k = 0; k < heap.length-1; k++)
         array[k] = heap[heap.length - 1 - k];
   }
    
    public void buildHeap() 
    {   
        tailIndex = heap.length;
        for (int k = tailIndex/2; k > 0; k--)
        {
        percolatingDown(k);
        }
    }

    private void percolatingDown(int k)
    {
    PriorityItem<T> tmp = heap[k];
    int tmpInt = heap[k].getPriority();
    int child;
    
    tailIndex = heap.length;
    for(; 2*k <= tailIndex; k = child)
    {
    child = 2*k;

    if(child != tailIndex &&
    ((heap[child]).getPriority()) < ((heap[child + 1]).getPriority())) child++;

    if(tmpInt < (heap[child].getPriority()))  
        heap[k] = heap[child];
    else
        break;
    }
    heap[k] = tmp;
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= heap.length; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + heap[i];
        }
        result = result + "]";
        return result;
    }
    
}
