import java.util.ArrayList;

public class MyQueue<E> extends ArrayList<E> {
    
    public int getSize() {
        return size();
    }
    
    public E peek() {
        return get(0);
    }
    
    public void enqueue(E o) {
        add(o);
    }
    
    public E dequeue() {
        E o = peek();
        remove(0);
        return o;
    }

    @Override
    public String toString() {
        return "MyQueue: " + super.toString();
    }
}
