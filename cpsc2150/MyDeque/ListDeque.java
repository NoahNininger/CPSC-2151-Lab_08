package cpsc2150.MyDeque;

import java.util.*;

/**
 * Class implementation of the IDeque interface using a List
 *
 * @invariants myLength >= 0 AND myLength <= IDeque.MAX_LENGTH
 * @correspondence self = myQ(0..myLength - 1)
 */
public class ListDeque<T> extends AbsDeque<T> implements IDeque<T>{
    // this time store the deque in a list
    // myQ.get(0) is the front of the deque
    private List<T> myQ;

    /**
     * Constructor that creates an empty list
     *
     * @post myQ = [a list of integers of MAX_LENGTH]
     */
    public ListDeque()
        { myQ = new ArrayList<T>(); }

    /**
     * Adds x to the end of the deque
     *
     * @param x Integer to be added to end of queue
     * @pre myQ.size() < IDeque.MAX_LENGTH
     * @post Last element in queue = x AND myQ.size() = #myQ.size() + 1
     */
    public void enqueue(T x)
        { myQ.add(x); }

    /**
     * Removes and returns the integer at the front of the deque
     *
     * @return Integer object that returns first integer in queue
     * @pre myQ.size() > 0
     * @post myQ.size() = #myQ.size() - 1
     */
    public T dequeue()
    {
        T frontInt = myQ.get(0);      // first element in the queue
        myQ.remove(0);      // removes front element
        return frontInt;
    }

    /**
     * Adds x to the front of the deque
     *
     * @param x Integer to be added to front of queue
     * @pre myQ.size() < IDeque.MAX_LENGTH
     * @post Last element in queue = x
     */
    public void inject(T x)
        { myQ.add(0, x); }

    /**
     * Removes and returns the integer at the end of the deque
     *
     * @return Integer object that returns last integer in queue
     * @pre myQ.size() > 0
     * @post myQ.size() = #myQ.size() - 1
     */
    public T removeLast()
    {
        T endInt = myQ.get(myQ.size() - 1);   // last element in the queue
        myQ.remove(myQ.size() - 1);     // removes last integer
        return endInt;
    }

    /**
     * Returns the number of integers in the deque
     *
     * @return int size of the queue
     * @post queue = #queue
     */
    public int length()
        { return myQ.size(); }

    /**
     * Clears the entire deque
     *
     * @post queue is empty
     */
    public void clear()
        { myQ.clear(); }
}