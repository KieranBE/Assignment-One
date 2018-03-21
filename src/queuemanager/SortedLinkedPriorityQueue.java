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
public class SortedLinkedPriorityQueue <T> implements PriorityQueue<T> {
    
    private final List<T> top;

    
    /**
     * @param size
     */
    public SortedLinkedPriorityQueue(int size) {
        top = null;
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

        
    }
    
    @Override
    public void remove() throws QueueUnderflowException {

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
    