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
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
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
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            int i = tailIndex;
            
            int value = i;
            while (i > 0 ){
                i = i - 1;
                if(((PriorityItem<T>)storage[value]).getPriority() 
                    <((PriorityItem<T>)storage[i]).getPriority()){
                    value = i;
                }
            }
            return ((PriorityItem<T>) storage[value]).getItem();
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
    tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Creates new item at top of list */
            int i = tailIndex;
            storage[i] = new PriorityItem<>(item, priority);
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            int i = tailIndex;
            
            int value = i;
            while (i > 0 ){
                i = i - 1;
                if(((PriorityItem<T>)storage[value]).getPriority() 
                    <((PriorityItem<T>)storage[i]).getPriority()){
                    value = i;
                }
            }
            
            for (i = value; i < tailIndex; i++) {
                storage[i] = storage[i + 1];
            }
            tailIndex = tailIndex - 1;
   
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
    