package queuemanager;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private final T item;
    private final int priority;
    private PriorityItem<T> next;

    public PriorityItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }

    public int getPriority() {
        return priority;
    }
    
    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
    
    public PriorityItem<T> getNext() {
        return next;
    }
    
  
    public PriorityItem(T item, int priority, PriorityItem<T> next) {
        this.item = item;
        this.next = next;
        this.priority = priority;
    }
}
