package Utilities;
import java.util.LinkedList;
public class Queue<T> implements IQueue<T>{

    private LinkedList<T> elements = new LinkedList<>();

    @Override
    public boolean add(T element) {
        return elements.add(element);
    }

    @Override
    public T peek() {
        return elements.peek();
    }

    @Override
    public T poll() {
        return elements.poll();
    }
}