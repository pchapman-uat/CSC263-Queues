import java.util.LinkedList;

class StackUsingLinkedList<T>{
    private LinkedList<T> list = new LinkedList<>();
    public void push(T item){
        list.addFirst(item);
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

class QueueUsingLinkedList<T>{
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        this.isEmpty();
        return list.removeFirst();
    }

    public T peek(){
        this.isEmpty();
        return list.getFirst();
    }

    private void isEmpty(){
        if(list.isEmpty()) throw new IllegalStateException("Queue is Empty");
    }
}


public class Main {
    public static void main(String[] args) {
        
    }
}