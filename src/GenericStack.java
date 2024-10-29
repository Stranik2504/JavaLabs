import java.util.List;

public class GenericStack<E> {
    private E[] array = (E[])new Object[0];
    private int _length = 0;
    
    public int getSize() {
        return _length;
    }
    
    public E peek() {
        if (_length == 0)
            return null;
        
        return array[_length - 1];
    }
    
    public void push(E o) {
        if (_length == 0) {
            array = List.of(o).toArray(array);
            _length++;
            return;
        }
        
        if (_length == array.length) {
            var arrs = (E[])new Object[array.length * 2];
            
            for (var i = 0; i < array.length; i++)
                arrs[i] = array[i];
            
            array = arrs;
        }
        
        array[_length] = o;
        _length++;
    }
    
    public E pop() {
        E o = peek();
        
        array[_length - 1] = null;
        _length--;
        
        return o;
    }
    
    public boolean isEmpty() {
        return _length == 0;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("стек: [");
        
        for (var i = 0; i < _length; i++) {
            result.append(array[i].toString());

            if (i + 1 < _length)
                result.append(", ");
        }
        
        result.append("]");
        
        return result.toString();
    }
}
