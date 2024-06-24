import java.util.LinkedList;

class StackUsingLinkedList<T>{
    private LinkedList<T> list = new LinkedList<>();
    public void push(T item){
        list.add(item);
    }

    public T pop(){
        this.isEmpty();
        return list.removeFirst();
    }

    public T peek(){
        this.isEmpty();
        return list.getFirst();
    }
    public int size(){
        return list.size();
    }
    private void isEmpty(){
        if(list.isEmpty()) throw new IllegalStateException("Stack is Empty");
    }
}   


public class Main {
    public static void main(String[] args) {
        
    }
}