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
