package cpsc2150.MyDeque;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque {
    private IDeque<Integer> MakeADeque() {
        IDeque<Integer> obj;
        obj = new ArrayDeque<>();
        return obj;
    }

    //Testing the enqueue() method
    @Test
    public void test_enqueue_one_int() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        String sample = "<1>";

        assertEquals(obj.toString(), sample);
    }
    @Test
    public void test_enqueue_two_int() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        String sample = "<1, 2>";

        assertEquals(obj.toString(), sample);
    }
    @Test
    public void test_enqueue_three_int() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        String sample = "<1, 2, 3>";

        assertEquals(obj.toString(), sample);
    }

    //Testing the deque() method
    @Test
    public void test_dequeue_two_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        Integer x = obj.dequeue();
        String sample = "<2>";

        assertTrue(x.equals(1) && obj.toString().equals(sample));
    }
    @Test
    public void test_dequeue_three_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        Integer x = obj.dequeue();
        String sample = "<2, 3>";

        assertTrue(x.equals(1) && obj.toString().equals(sample));
    }
    @Test
    public void test_dequeue_four_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        Integer x = obj.dequeue();
        String sample = "<2, 3, 4>";

        assertTrue(x.equals(1) && obj.toString().equals(sample));
    }

    //Testing the inject method
    @Test
    public void test_inject_one_int() {
        IDeque<Integer> obj = MakeADeque();

        obj.inject(1);
        String sample = "<1>";

        assertEquals(obj.toString(), sample);
    }
    @Test
    public void test_inject_two_int() {
        IDeque<Integer> obj = MakeADeque();

        obj.inject(1);
        obj.inject(2);
        String sample = "<2, 1>";

        assertEquals(obj.toString(), sample);
    }
    @Test
    public void test_inject_three_int() {
        IDeque<Integer> obj = MakeADeque();

        obj.inject(1);
        obj.inject(2);
        obj.inject(3);
        String sample = "<3, 2, 1>";

        assertEquals(obj.toString(), sample);
    }

    //Testing the removeLast() method
    @Test
    public void test_removeLast_two_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        Integer x = obj.removeLast();
        String sample = "<1>";

        assertTrue(x.equals(2) && obj.toString().equals(sample));
    }
    @Test
    public void test_removeLast_three_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        Integer x = obj.removeLast();
        String sample = "<1, 2>";

        assertTrue(x.equals(3) && obj.toString().equals(sample));
    }
    @Test
    public void test_removeLast_four_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        Integer x = obj.removeLast();
        String sample = "<1, 2, 3>";

        assertTrue(x.equals(4) && obj.toString().equals(sample));
    }

    //Testing the clear() method
    @Test
    public void test_clear_one_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.clear();
        String sample = "<>";

        assertEquals(obj.toString(), sample);
    }
    @Test
    public void test_clear_two_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.clear();
        String sample = "<>";

        assertEquals(obj.toString(), sample);
    }
    @Test
    public void test_clear_three_deque() {
        IDeque<Integer> obj = MakeADeque();

        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.clear();
        String sample = "<>";

        assertEquals(obj.toString(), sample);
    }

    //Testing the get() method
    @Test
    public void testGetMiddle() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.get(3);
        String one = obj.toString();
        String two = "<0, 1, 2, 3, 4>";
        assertTrue(test.equals(2) && one.equals(two));
    }
    @Test
    public void testGetBeginning() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.get(1);
        String one = obj.toString();
        String two = "<0, 1, 2, 3, 4>";
        assertTrue(test.equals(0) && one.equals(two));
    }
    @Test
    public void testGetEnd() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.get(5);
        String one = obj.toString();
        String two = "<0, 1, 2, 3, 4>";
        assertTrue(test.equals(4) && one.equals(two));
    }

    //Testing the remove() method
    @Test
    public void testRemoveMiddle() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.remove(3);
        String one = obj.toString();
        String two = "<0, 1, 3, 4>";
        assertTrue(test.equals(2) && one.equals(two));
    }
    @Test
    public void testRemoveBeginning() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.remove(1);
        String one = obj.toString();
        String two = "<1, 2, 3, 4>";
        assertTrue(test.equals(0) && one.equals(two));
    }
    @Test
    public void testRemoveEnd() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.remove(5);
        String one = obj.toString();
        String two = "<0, 1, 2, 3>";
        assertTrue(test.equals(4) && one.equals(two));
    }

    //Testing the insert() method
    @Test
    public void testInsertMiddle() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        obj.insert(9, 3);
        String one = obj.toString();
        String two = "<0, 1, 9, 2, 3, 4>";
        assertTrue(one.equals(two));
    }
    @Test
    public void testInsertBeginning() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        obj.insert(9, 1);
        String one = obj.toString();
        String two = "<9, 0, 1, 2, 3, 4>";
        assertTrue(one.equals(two));
    }
    @Test
    public void testInsertEnd() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        obj.insert(9, 5);
        String one = obj.toString();
        String two = "<0, 1, 2, 3, 9, 4>";
        assertTrue(one.equals(two));
    }

    //Testing the endOfDeque() method
    @Test
    public void testEOD1() {
        IDeque<Integer> obj = MakeADeque();
        obj.enqueue(1);
        Object test = obj.endOfDeque();
        String one = obj.toString();
        String two = "<1>";
        assertTrue(test.equals(1) && one.equals(two));
    }
    @Test
    public void testEOD5() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.endOfDeque();
        String one = obj.toString();
        String two = "<0, 1, 2, 3, 4>";
        assertTrue(test.equals(4) && one.equals(two));
    }
    @Test
    public void testEODSame() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(1);
        }
        obj.enqueue(5);
        Object test = obj.endOfDeque();
        String one = obj.toString();
        String two = "<1, 1, 1, 1, 1, 5>";
        assertTrue(test.equals(5) && one.equals(two));
    }

    //Testing the peek() method
    @Test
    public void testPeek1() {
        IDeque<Integer> obj = MakeADeque();
        obj.enqueue(10);
        Object test = obj.peek();
        String one = obj.toString();
        String two = "<10>";
        assertTrue(test.equals(10) && one.equals(two));
    }
    @Test
    public void testPeek5() {
        IDeque<Integer> obj = MakeADeque();
        for (int i = 0; i < 5; i++) {
            obj.enqueue(i);
        }
        Object test = obj.peek();
        String one = obj.toString();
        String two = "<0, 1, 2, 3, 4>";
        assertTrue(test.equals(0) && one.equals(two));
    }
    @Test
    public void testPeekSame() {
        IDeque<Integer> obj = MakeADeque();
        obj.enqueue(5);
        for (int i = 0; i < 5; i++) {
            obj.enqueue(1);
        }
        Object test = obj.peek();
        String one = obj.toString();
        String two = "<5, 1, 1, 1, 1, 1>";
        assertTrue(test.equals(5) && one.equals(two));
    }
}