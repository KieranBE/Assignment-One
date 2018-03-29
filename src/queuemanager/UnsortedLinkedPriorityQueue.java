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
        tailIndex = list.size();
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1; 
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
            list.add(i,new PriorityItem<>(item, priority));
            top = new PriorityItem<>(item, priority, top);
            System.out.println(list.get(i).getPriority());
        }
    }
    
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {          
            int i = list.size();
            i--;

            int value = i;
            while (i > 1 ){
                i--;
                if((list.get(value).getPriority()) < (list.get(i).getPriority())){
                    value = i;
                }
            }
            list.remove(value);

            tailIndex = tailIndex - 1;
            
            top = null;
            
            i = 0;
            
            
            while (i < tailIndex + 1) {
                System.out.println(i);
                top = new PriorityItem<>((list.get(i).getItem()), (list.get(i).getPriority()), top);
                i = i + 1;
            }
            
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
    