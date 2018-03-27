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
      
    ArrayList<PriorityItem<T>> list;
    private PriorityItem<T> top;

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
        list = new ArrayList<PriorityItem<T>>();
        top = null;
        tailIndex = -1;
        capacity = size;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return (list.get(0)).getItem();
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
            if(tailIndex == 0)
            {
            list.add(i,new PriorityItem<>(item, priority));
            }
            else
            {
                i--;
                list.add(i,new PriorityItem<>(item, priority));
            while (i > 0 && (list.get(i)).getPriority() < priority) {
                list.set(i,list.get(i-1));
                i = i - 1;
            }
            list.set(i,new PriorityItem<>(item, priority));
        }
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
    if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        else
        {
        list.remove(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String result = "[";
        int counter = 1;
        for (int i = 0; i <= counter; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + list.get(i);
        }
        result = result + "]";
        return result;
    }
    
}
    