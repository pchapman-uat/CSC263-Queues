import java.util.LinkedList;

class StackUsingLinkedList<T>{
    private LinkedList<T> list = new LinkedList<>();
    public void push(T item){
        list.add(item);
    }
    public T pop(){
        if(list.isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        } return list.removeFirst();
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}