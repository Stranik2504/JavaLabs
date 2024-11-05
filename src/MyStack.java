import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<>();
    
    public int getSize() {
        return list.size();
    }
    
    public Object peek() {
        return list.get(getSize() - 1);
    }
    
    public void push(Object o) {
        list.add(o);
    }
    
    public Object pop() {
        Object o = peek();
        
        list.remove(getSize() - 1);
        
        return o;
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public String toString() {
        return "MyStack: " + list.toString();
    }
    
    public Object clone() {
        try {
            // Сделать поверхностную копию
            MyStack myStack = (MyStack)super.clone();
            
            // Сделать глубокую копию list
            var newList = new ArrayList<>(Arrays.asList(new Object[list.size()]));
            Collections.copy(newList, list);
            
            myStack.list = newList;
            return myStack;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
