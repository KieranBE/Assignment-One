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
      
    private PriorityItem<T> top;
    ArrayList<PriorityItem<T>> list;
    ArrayList<PriorityItem<T>> listback;
    
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
        listback = new ArrayList<PriorityItem<T>>();
        top = null;
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return top.getItem();
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
                int counter = 0;
                
            while (i > 0 && (list.get(i-1)).getPriority() < priority) {
                
                if(counter == 0){
                list.add(i,new PriorityItem<>(item, priority));
                counter++;
                }
                listback.add(0 ,list.get(i-1));
                list.set(i-1,list.get(i));
                list.set(i,listback.get(0));
                i = i - 1;
            }
            list.set(i,new PriorityItem<>(item, priority));

            i = tailIndex;
            top = null;
                
            while (i != -1) {
                top = new PriorityItem<>((list.get(i).getItem()), (list.get(i).getPriority()), top);
                i = i - 1;
            }
            
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
        top = top.getNext();
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
        if(top == null)
        {
        result = result + "]";
        return result;
        }
        else
        { 
        for (PriorityItem<T> node = top; node != null; node = node.getNext()) {
            if (node != top) {
                result += ", ";
            }
            result += "(" + node.getItem() + ", " + node.getPriority() + ")";
        }
        }
        result = result + "]";
        return result;
    }
    
}
    