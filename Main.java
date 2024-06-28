import java.util.LinkedList;
import java.util.Scanner;

abstract class BaseList<T>{
    public LinkedList<T> list = new LinkedList<>();
    public abstract void add(T item);
    public T remove() {
        if(this.list.isEmpty()) return null;
        return this.list.removeFirst();
    }
    public int size(){
        return this.list.size();
    }
    public T first(){
        return this.list.getFirst();
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
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
    public T top(){
        return this.first();
    }
    // base List is abstract, thuse these functions must be replaced
    @Override
    public void add(T item) {
        this.list.addFirst(item);
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
}


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<Integer>();
        stack.push(5); 
        stack.push(3); 
        stack.size();
        stack.pop();
        stack.isEmpty();
        stack.pop();
        stack.isEmpty();
        stack.pop();
        stack.push(7); 
        stack.push(9); 
        stack.top();
        stack.push(4); 
        stack.size();
        stack.pop();
        stack.push(6); 
        stack.push(8); 
        stack.pop();;
        System.out.println("");
        // Queue
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<Integer>();
        queue.enqueue(5);
        queue.enqueue(3);
        queue.size();
        queue.dequeue();
        queue.isEmpty();
        queue.dequeue();
        queue.enqueue(7);
        queue.enqueue(9);
        queue.first();
        queue.enqueue(4); 
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