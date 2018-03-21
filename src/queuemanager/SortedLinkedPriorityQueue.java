/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import java.util.ArrayList;

/**
 *
 * @author Kieran
 * @param <T>
 */
public class SortedLinkedPriorityQueue <T> implements PriorityQueue<T> {
    
    ArrayList<PriorityItem> list;
    
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public SortedLinkedPriorityQueue(int size) {
        storage = new Object[size];
        list = new ArrayList<PriorityItem>();
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            tailIndex = list.size();
            return list.get(0);
            return ((PriorityItem<T>) storage[0]).getItem();
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        tailIndex = list.size();
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
            while (i > 0 && (list.get(i).getPriority()) < priority) {
                list.set(i,new PriorityItem()) = list.get(i-1, PriorityItem);
                i = i - 1;
            }
            list.set(i, new PriorityItem(item, priority));
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
    if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        else
        {
        list.remove(tailIndex);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        String result = "[";
        int counter = 1;
        for (int i = 0; i <= counter; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result;
        }
        result = result + "]";
        return result;
    }
    
}
    