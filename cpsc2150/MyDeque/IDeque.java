
/* Noah Nininger & Keenan Grant
   CPSC 2151
   02/16/23
 */

package cpsc2150.MyDeque;

/**
 * A deque containing integers.
 * A deque is a double-ended queue data structure that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 *
 * Initialization Insures:
 *      Queue is empty when initialized
 */
public interface IDeque<T> {
    public static final int MAX_LENGTH = 100;

    /**
     * Adds x to the end of the deque
     *
     * @param x Integer to be added to end of queue
     * @pre Length of queue < MAX_LENGTH
     * @post Last element in queue = x
     */
    public void enqueue(T x);


    /**
     * Removes and returns the integer at the front of the deque
     *
     * @return Integer object that returns first integer in queue
     * @pre Length of queue > 0
     * @post Length of queue = #Length() - 1
     */
    public T dequeue();

    /**
     * Adds x to the front of the deque
     *
     * @param x Integer to be added to front of queue
     * @pre Length of queue < MAX_LENGTH
     * @post Last element in queue = x
     */
    public void inject(T x);

    /**
     * Removes and returns the integer at the end of the deque
     *
     * @return Integer object that returns last integer in queue
     * @pre Length if queue > 0
     * @post Length of queue = #Length of queue - 1
     */
    public T removeLast();

    /**
     * Returns the number of integers in the deque
     *
     * @return int size of the queue
     * @post queue = #queue
     */
    public int length();

    /**
     * Clears the entire deque
     *
     * @post queue is empty
     */
    public void clear();

    /**
     * returns the integer number at the front of the deque without removal
     *
     * @return head of the deque
     * @pre Length of queue > 0
     * @post Length of queue = #Length() - 1 AND the final state of the deque
     *                                           is equivalent to the deque's initial state
     */
    default T peek() {
        T frontInt = dequeue();
        inject(frontInt);
        return frontInt;
    }


    /**
     * returns the integer number at the end of the deque without removal
     *
     * @return last element in deque
     * @pre Length if queue > 0
     * @post Length of queue = #Length of queue - 1
     */
    default T endOfDeque() {
        T endInt = removeLast();
        enqueue(endInt);
        return endInt;
    }

    /**
     * inserts x at position pos in the deque
     *
     * @param x element to insert
     * @param pos for position
     * @pre pos index starts at 1, so the item at the very front of the deque is pos 1 AND
     *      Length of queue < MAX_LENGTH
     * @post Chosen position in queue = x
     */
    default public void insert(T x, int pos) {
        T values[] = (T[]) new Object[pos];

        //Dequeues the values up until the desired position
        for (int i = 0; i <= pos-2; i++) {
            values[i] = dequeue();
        }

        //Injects the new value into the deque
        inject(x);

        //Injects the dequeued values back into the deque in the right order
        for (int i = pos - 2; i >= 0; i--) {
            inject(values[i]);
        }
    }

    /**
     * removes whatever integer number was in position pos in the deque
     *
     * @param pos for position
     * @return element at position pos
     * @pre pos index starts at 1, so the item at the very front of the deque is pos 1 AND
     *      Length if queue > 0
     * @post Length of queue = #Length of queue - 1 AND element at pos is removed and returned
     */
    default public T remove(int pos) {
        T values[] = (T[]) new Object[pos];

        //Dequeues the values up until the desired position
        for (int i = 0; i < pos; i++) {
            values[i] = dequeue();
        }

        //Injects the dequeued values back into the deque in the right order ignoring the removed value
        for (int i = pos - 2; i >= 0; i--) {
            inject(values[i]);
        }
        return values[pos - 1];
    }

    /**
     * returns whatever integer number was in position pos in the deque without removal
     *
     * @param pos for position
     * @return element at position pos
     * @pre pos index starts at 1, so the item at the very front of the deque is pos 1 AND
     *      Length if queue > 0
     * @post Length of queue = #Length of queue - 1 AND element at pos is returned
     */
    default T get(int pos) {
        T values[] = (T[]) new Object[pos];

        //Dequeues the values up until the desired position
        for (int i = 0; i < pos; i++) {
            values[i] = dequeue();
        }

        //Injects the dequeued values back into the deque in the right order
        for (int i = pos - 1; i >= 0; i--) {
            inject(values[i]);
        }
        return values[pos - 1];
    }
}