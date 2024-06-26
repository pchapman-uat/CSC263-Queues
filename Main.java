import java.util.LinkedList;

abstract class BaseList<T>{
    public LinkedList<T> list = new LinkedList<>();
    public abstract void add(T item);
    public abstract T remove();
    public int size(){
        return this.list.size();
    }
    public T peek(){
        return this.list.getFirst();
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
    public void throwIfEmpty(){
        if(this.isEmpty()) throw new IllegalStateException("Stack is Empty");
    }
    public void removeAll(String prefix){
        while(!this.list.isEmpty()) System.out.println(prefix+": "+this.remove());
    }
}
class  StackUsingLinkedList<T> extends BaseList<T>{
    // Alias for base functions
    public void push(T item){
        this.add(item);
    }
    public T pop(){
        return this.remove();
    }

    // base List is abstract, thuse these functions must be replaced
    @Override
    public void add(T item) {
        this.list.addFirst(item);
    }

    @Override
    public T remove() {
        this.throwIfEmpty();
        return this.list.removeFirst();
    }
}   

class QueueUsingLinkedList<T> extends BaseList<T>{
    public void enqueue(T item){
        this.add(item);
    }

    public T dequeue(){
        return this.remove();
    }


    @Override
    public void add(T item) {
        this.list.addLast(item);
    }

    @Override
    public T remove() {
        this.throwIfEmpty();
        return this.list.removeFirst();
    }

}


public class Main {
    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.removeAll("Pop");
        System.out.println("");
        QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<String>();
        queue.enqueue("Item One");
        queue.enqueue("Item Two");
        queue.enqueue("Item Three");
        queue.removeAll("Dequeue");
    }
}