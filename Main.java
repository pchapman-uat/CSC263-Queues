import java.util.LinkedList;

class StackUsingLinkedList<T>{
    private LinkedList<T> list = new LinkedList<>();
    public void push(T item){
        list.addFirst(item);
    }

    public T pop(){
        this.throwIfEmpty();
        return list.removeFirst();
    }

    public T peek(){
        this.throwIfEmpty();
        return list.getFirst();
    }
    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    private void throwIfEmpty(){
        if(this.isEmpty()) throw new IllegalStateException("Stack is Empty");
    }
}   

class QueueUsingLinkedList<T>{
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        this.throwIfEmpty();
        return list.removeFirst();
    }

    public T peek(){
        this.throwIfEmpty();
        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    private void throwIfEmpty(){
        if(this.isEmpty()) throw new IllegalStateException("Stack is Empty");
    }

}


public class Main {
    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();
        stack.push(1);
        stack.push(10);
        stack.push(100);
        while(!stack.isEmpty()){
            System.out.println("Pop: " + stack.pop());
        }
        System.out.println("");
        QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<String>();
        queue.enqueue("Item One");
        queue.enqueue("Item Two");
        queue.enqueue("Item Three");
        while(!queue.isEmpty()){
            System.out.println("Dequeue: "+ queue.dequeue());
        }
    }
}