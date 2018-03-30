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
    
    PriorityItem<T> linkedList;

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
        linkedList = null;
        capacity = size;
        tailIndex = -1;
    }
        

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            int i = 0;
            
            /* Loops for the amount of items in the linkedList */
            for (PriorityItem<T> node = linkedList; node != null; node = node.getNext()) {
            i++;
            }
            
            /* Resets node as Linked List */
            PriorityItem<T> node = linkedList;
            /* Sets the first node to highest item and priority */
            T highitem = node.getItem();
            int highpriority = node.getPriority();
            node = node.getNext();
              
                if(i == 1)
                {
                /* If the list has only one item then it returns that item */
                return highitem;
                }
            
                /* If its bigger than 1 it does this */
            while (i > 0 ){
                /* removes one from i */
                i = i - 1;
                
                if(node == null)
                {
                    /* Returns if the node is null */
                    return highitem;
                }
                else
                {
                    /* Checks if the highest priority is less than the node priority */
                if(highpriority < node.getPriority()){     
                highitem = node.getItem();
                highpriority = node.getPriority();
                }
            }
            node=node.getNext();
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
            int i = tailIndex;
            /* Adds item and priority to the list */
            linkedList = new PriorityItem<>(item, priority, linkedList);
        }
    }
    
    
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {          

            int i = 0;
            
            /* Counts the amount in the node, which equals linkedList */
            for (PriorityItem<T> node = linkedList; node != null; node = node.getNext()) {
            i++;
            }
            
            /* Resets the node to linkedList */
            PriorityItem<T> node = linkedList;
            /* Sets the first point to the highest */
            T highitem = node.getItem();
            int highpriority = node.getPriority();
            node = node.getNext();
            if(i == 1){
            }
            else
            {
                while (i > 0 ){
                    i = i - 1;
                    if(node == null){}
                    else{
                    /* Checks if the highpriority is less than the current node priority */
                    if(highpriority < node.getPriority()){     
                        /* If so then sets highitem to node item and highpriority
                        to node priority*/
                        highitem = node.getItem();
                        highpriority = node.getPriority();
                }
                node = node.getNext();
            }
            }
        }
            
            /* Creates backupLink, currentLink and previousLink */
            PriorityItem<T> backupLink; 
            backupLink = null;
            /* sets current and previous link to first point */
            PriorityItem<T> currentLink = linkedList;
            PriorityItem<T> previousLink = linkedList;
            
            /* Sets amount to zero */
            int amount = 0;
            
            /* checks if the current item and priorty is not equal to the high item and priority */
            while(currentLink.getItem() != highitem && 
            currentLink.getPriority() != highpriority){
                /* counts how many items are before the highest */
                amount++;
                previousLink = currentLink;
                currentLink = currentLink.getNext();         
            }
            
            if(currentLink == linkedList){
            
                /* If the first item is the highest, sets backup to the next item in list */
                backupLink = linkedList.getNext();
            
            }else
            {
                /* sets preivous link to next, then sets that previous next 
                to current next */
                previousLink = previousLink.getNext();
                previousLink = currentLink.getNext();          
            }
            
            i = 0;
            int count = 0;
            
            while(i < amount){
            if(count == 0){    
                /* Adds to backup with items for each item before the highest, 
                includes previous link if count equals zero */
                backupLink = new PriorityItem<>(linkedList.getItem(), linkedList.getPriority(), previousLink);
                count++;
                /* Adds one to count  */
            }else
            {
                /* Then adds backupLink with the next linked list if count
                is higher than zero */
                backupLink = new PriorityItem<>(linkedList.getItem(), linkedList.getPriority(), backupLink);
            }
            /* Adds one to i then sets linkedList to linkedList next point */
            i++;
            linkedList = linkedList.getNext();
            }
            /* Sets linkedList to backupLink */
            linkedList = backupLink;        
        }        

    }

    @Override
    public boolean isEmpty() {
        /* Return if linkedList is null */
        return linkedList == null;
    }

    @Override
    public String toString() {
        /* Sets the string result */
        String result = "[";
        if(linkedList == null)
            {
                /* If empty finishes result strings */
                result = result + "]";
                return result;
            }
            else
            { 
                /* Loops through all items and adds them to the string */
                for (PriorityItem<T> node = linkedList; node != null; node = node.getNext()) {
                    if (node != linkedList) {
                        result += ", ";
                    }
                    result += "(" + node.getItem() + ", " + node.getPriority() + ")";
                }
            }
        result = result + "]";
        /* Returns result */
        return result;
    }
    
}
    