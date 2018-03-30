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
      
    private PriorityItem<T> linkedList;
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
        /* Creates two array lists, one called list and another called listback,
        aswell as linkedList*/
        list = new ArrayList<PriorityItem<T>>();
        listback = new ArrayList<PriorityItem<T>>();
        linkedList = null;
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            /* returns the top item, since its sorted */
            return linkedList.getItem();
        }
    }
    
    @Override
    public void add(T item, int priority) throws QueueOverflowException 
    {
        /* Sets tainIndex to list size */
        tailIndex = list.size();
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1; 
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point, sets 1 to tainIndex */
            int i = tailIndex;
            
            /* If list size is 0, adds item to list */
            if(tailIndex == 0)
            {
                list.add(i,new PriorityItem<>(item, priority));
            }
            else
            {
                /* sets counter to 0 */
                int counter = 0;
                
                /* Adds item to list then adds adds one to counter */
                if(counter == 0){
                    list.add(i,new PriorityItem<>(item, priority));
                    counter++;
                }
                
            /* Loops while the priority in the list is less than current priority */
            while (i > 0 && (list.get(i-1)).getPriority() < priority) {
                
                /* Sets 0 in the backup list to i -1 */
                listback.add(0 ,list.get(i-1));
                /* Sets i-1 to i */
                list.set(i-1,list.get(i));
                /* Sets i to the item stored in the backup */
                list.set(i,listback.get(0));
                i = i - 1;
            }

            /* sets the i (0) to item and priority */
            list.set(i,new PriorityItem<>(item, priority));

            /* Sets i to tailIndex and sets top to null */
            i = tailIndex;
            linkedList = null;
                
                /* Loops through all items in the array list and adds them to top */
                while (i != -1) {
                    linkedList = new PriorityItem<>((list.get(i).getItem()), (list.get(i).getPriority()), linkedList);
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
            linkedList = linkedList.getNext();
            list.remove(0);
        }
    }

    @Override
    public boolean isEmpty() {
        return linkedList == null;
    }

    @Override
    public String toString() {        
        String result = "[";
        if(linkedList == null)
        {
            result = result + "]";
            return result;
        }
        else
        { 
            for (PriorityItem<T> node = linkedList; node != null; node = node.getNext()) {
                if (node != linkedList) {
                    result += ", ";
                }
                result += "(" + node.getItem() + ", " + node.getPriority() + ")";
            }
        }
        result = result + "]";
        return result;
    }
    
}
    