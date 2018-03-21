package queuemanager;

public class List<T> {
    private T item;
    private List<T> next;
    
    public List(T item, List<T> next) {
        this.item = item;
        this.next = next;
    }
    
    public T getItem() {
        return item;
    }
    
    public List<T> getNext() {
        return next;
    }
}
