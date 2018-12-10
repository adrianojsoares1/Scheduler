package Utilities;

public interface IQueue<T>{
    boolean add(T element);
    T peek();
    T poll();
}