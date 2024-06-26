import java.util.LinkedList;
import java.util.Scanner;

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
    private static Scanner scanner = new Scanner(System.in);
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
        System.out.println("Would you like to enter your own items? (y/n)");
        if(scanner.nextLine().equals("y")) userInput();
        else System.out.println("Goodbye");

    }
    private static void userInput(){
        System.out.println("Please enter the type of list");
        System.out.println("0: Stack");
        System.out.println("1: Queue");
        String mode = scanner.nextLine();
        BaseList<String> values;
        if(mode.equals("0")) values= new StackUsingLinkedList<String>();
        else values = new QueueUsingLinkedList<String>();
        System.out.println("Please enter a name: (Enter 'EXIT' to stop)");
        String response = scanner.nextLine();
        while(!response.equals("EXIT")) {
            values.add(response);
            System.out.println("Please enter another name (Enter 'EXIT' to stop)");
            response = scanner.nextLine();
        }
        values.removeAll("");
    }
}