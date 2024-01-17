package cpsc2150.MyDeque;

/**
 * Class implementation of the IDeque interface using an array
 *
 * @invariants myLength >= 0 AND myLength <= IDeque.MAX_LENGTH
 * @correspondence self = myQ[0..myLength - 1]
 */
public class ArrayDeque<T> extends AbsDeque<T> implements IDeque<T>{
    // where the data is stored. myQ[0] is the front of the deque
    private T[] myQ;

    // tracks how many items are in the deque
    // also used to find the end of the deque
    private int myLength;

    /**
     * Constructor that creates an empty array
     *
     * @post myQ = [an integer array of MAX_LENGTH] AND myLength = 0
     */
    public ArrayDeque()
    {
        myQ = (T[]) new Object[IDeque.MAX_LENGTH];
        myLength = 0;
    }

    // Adds x to the end of the deque
    public void enqueue(T x)
    {
        myQ[myLength] = x;
        myLength++;
    }

    // removes and returns the integer at the front of the deque
    public T dequeue()
    {
        T frontInt = myQ[0];  // first element in the queue

        for(int i = 0; i < myLength - 1; i++)   // moves each element up by 1
            { myQ[i] = myQ[i + 1]; }

        myLength--; // shortens myLength

        return frontInt;
    }

    // Adds x to the front of the deque
    public void inject(T x)
    {
        for(int i = myLength; i > 0; i--)   // moves each element back by 1
            { myQ[i] = myQ[i - 1]; }

        myQ[0] = x;     // adds x at the head

        myLength++; // increases the size of myLength
    }

    // removes and returns the integer at the end of the deque
    public T removeLast()
    {
        myLength--;     // shortens myLength
        return myQ[myLength];
    }

    // returns the number of integers in the deque
    public int length()
        { return myLength; }

    //clears the entire deque
    public void clear()
        { myLength = 0; }
}