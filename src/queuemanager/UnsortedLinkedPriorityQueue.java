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
public class UnsortedLinkedPriorityQueue <T> implements PriorityQueue<T> {
    
    private final Object[] storage;
    ArrayList<T> listItem;
    ArrayList<Integer> listInt;

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
    public UnsortedLinkedPriorityQueue(int size) {
        storage = new Object[size];
        listItem = new ArrayList<T>();
        listInt = new ArrayList<Integer>();
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int i = listItem.size();
            
            int value = i;
            while (i > 0 ){
                i = i - 1;
                if(listInt.get(value) < listInt.get(i)){
                    value = i;
                }
            }
            
            return listItem.get(i);
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
    tailIndex = listItem.size() + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;

            listItem.set(i,item);
            listInt.set(i,priority);
     
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int i = listItem.size();
            
            int value = i;
            while (i > 0 ){
                i = i - 1;
                if(listInt.get(value) < listInt.get(i)){
                    value = i;
                }
            }
            
            for (i = value; i < listItem.size(); i++) {
                listItem.set(i,listItem.get(i+1));
                listInt.set(i,listInt.get(i+1));
            }
            
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
    