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
    
    private PriorityItem<T> top;
    ArrayList<PriorityItem<T>> list;

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
        list = new ArrayList<PriorityItem<T>>();
        top = null;
        capacity = size;
        tailIndex = -1;
    }
        

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            int i = 0;
            
            for (PriorityItem<T> node = top; node != null; node = node.getNext()) {
            i++;
            }
            
            PriorityItem<T> node = top;
            T highitem = node.getItem();
            int highpriority = node.getPriority();
            node = node.getNext();
                
            while (i > 0 ){
                i = i - 1;
                if(highpriority < node.getPriority()){     
                highitem = node.getItem();
                highpriority = node.getPriority();
            }
        }
            return highitem;
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1; 
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            
            top = new PriorityItem<>(item, priority, top);
        }
    }
    

        
    
    
    
    
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            int i = 0;
            list = null;
            
                list.add(i ,new PriorityItem<>(top.getItem(), top.getPriority()));
            for (PriorityItem<T> node = top; node != null; node = node.getNext()) {
                i++;
                list.add(i ,new PriorityItem<>(node.getItem(), node.getPriority()));
            }
            int count = i;
            PriorityItem<T> node = top;
            T highitem = node.getItem();
            int highpriority = node.getPriority();
            node = node.getNext();
            int value = 0;
            
            while (i > 0 && highpriority < top.getPriority()) {
                highitem = node.getItem();
                highpriority = node.getPriority();
                value = i;
                i = i - 1;
            }
            
            i = count;
            
            while (i > value && highpriority < top.getPriority()) {
            
            list.set(i,list.get(i-1));
            i--;
            }
            
            i = count;
            
            while (i > 0) {
                
                
                
                if(highitem == top.getItem() && highpriority == top.getPriority())
                {
                
                }
                i = i - 1;
            }
            
            
            top = top.getNext();
            }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String result = "[";
        for (PriorityItem<T> node = top; node != null; node = node.getNext()) {
            if (node != top) {
                result += ", ";
            }
            result += "(" + node.getItem() + ", " + node.getPriority() + ")";
        }

        result = result + "]";
        return result;
    }
    
}
    