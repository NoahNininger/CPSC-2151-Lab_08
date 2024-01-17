
/* Noah Nininger & Keenan Grant
   CPSC 2151
   02/16/23
 */

package cpsc2150.MyDeque;

/**
 * Implements  IDeque  but  will  contain  no
 * actual  private  data.  AbsDeque  will  override  the  toString  method  inherited  from  the
 * Object class to create a string representation of the values in the deque
 */
abstract public class AbsDeque<T> implements IDeque<T> {
    /**
     * overrides the toString method inherited from the Object class
     *
     * @return string representation of the values in the deque
     */
    @Override
    public String toString() {
        String str = "<";       // creates the string to be returned

        T currentInt;     // stores current element

        for (int i = 0; i < length(); i++) {
            currentInt = (T) dequeue();     // stores the current element to the front

            if (i == 0)
            { str += currentInt; }
            else
            { str += ", " + currentInt; }
            enqueue(currentInt);    // adds final element
        }

        str += ">";

        return str;
    }
}