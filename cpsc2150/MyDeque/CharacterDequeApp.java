package cpsc2150.MyDeque;

import java.util.*;

public class CharacterDequeApp {
    public static void main(String args[]) {
        IDeque<Character> q;

        /*
        Prompt  the  user  to  pick  an  implementation  using  the  following
        message:  "Enter  1  for  array  implementation  or  2  for  List
        implementation"

        Your code needs to make sure that they only enter either 1 or 2.
        Re-print the message to prompt the user to enter it again. Once
        you have gotten an answer, use it to initialize q appropriately.
        */
        //create scanner object to take in user input
        Scanner scan = new Scanner(System.in);

        //prompt user for input
        System.out.println("Enter 1 for array implementation or 2 for List implementation");
        int user = scan.nextInt(); // reads user input
        scan.nextLine();

        while ((user != 1) && (user != 2))     // input validation
        {
            System.out.println("Enter 1 for array implementation or 2 for List implementation");
            user = scan.nextInt();
            scan.nextLine();
        }

        if (user == 1) // Array
        {
            q = new ArrayDeque<Character>();
        } else            // List
        {
            q = new ListDeque<Character>();
        }


        //Add  the  code  to  print  the  deque.  After  the  code  is  finished,
        //the deque should still contain all its values in order

        String userInput;
        boolean quit = false;
        do {
            // prints menu full of selections
            System.out.println("\nSelect and option:\n" +
                    "1. Add to the end of the Deque\n" +
                    "2. Add to the front of the Deque\n" +
                    "3. Remove from the front of the Deque\n" +
                    "4. Remove from the end of the Deque\n" +
                    "5. Peek from the front of the Deque\n" +
                    "6. Peek from the end of the Deque\n" +
                    "7. Insert to a position in the Deque\n" +
                    "8. Remove from a position in the Deque\n" +
                    "9. Get a position in the Deque\n" +
                    "10. Get the length of the Deque\n" +
                    "11. Clear the Deque\n" +
                    "12. Quit");
            userInput = scan.nextLine();
            char c;

            switch (Integer.parseInt(userInput)) {

                case 1://Enqueue
                    System.out.println("What character to enqueue to the end of the Deque?");
                    c = scan.next().charAt(0);
                    scan.nextLine();
                    q.enqueue(Character.valueOf(c));
                    break;

                case 2://Inject
                    System.out.println("What character to inject to the front of the Deque?");
                    c = scan.next().charAt(0);
                    scan.nextLine();
                    q.inject(Character.valueOf(c));
                    break;

                case 3://Dequeue
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                    } else {
                        System.out.println("Character at the front: " + q.dequeue());
                    }
                    break;

                case 4://Remove Last
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                    } else {
                        System.out.println("Character at the end: " + q.removeLast());
                    }
                    break;

                case 5://Peek
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                    } else {
                        System.out.println("Peek: " + q.peek());
                    }
                    break;

                case 6://End of Deque
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                    } else {
                        System.out.println("EndOfDeque: " + q.endOfDeque());
                    }
                    break;

                case 7://Insert
                    System.out.println("What character to insert to the Deque?");
                    c = scan.next().charAt(0);
                    scan.nextLine();
                    System.out.println("What position to insert in?");
                    String ui2 = scan.nextLine();
                    while (Integer.parseInt(ui2) > q.length()) {
                        System.out.println("Not a valid position in the Deque!\nWhat position to insert in?");
                        ui2 = scan.nextLine();
                    }
                    q.insert(Character.valueOf(c), Integer.parseInt(ui2));
                    break;

                case 8://Remove
                    String number;
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                    }
                    else {
                        System.out.println("What position to remove from the Deque?");
                        number = scan.nextLine();
                        while (Integer.parseInt(number) > q.length()) {
                            System.out.println("Not a valid position in the Deque!\nWhat position to remove from the Deque?");
                            number = scan.nextLine();
                        }
                        System.out.println(q.remove(Integer.parseInt(number)) + " was at position " + number + " in the Deque.");
                    }
                    break;

                case 9://Get
                    if (q.length() == 0) {
                        System.out.println("Deque is empty!");
                    }
                    else {
                        System.out.println("What position to get from the Deque?");
                        number = scan.nextLine();
                        while (Integer.parseInt(number) > q.length()) {
                            System.out.println("Not a valid position in the Deque!\nWhat position to get from the Deque?");
                            number = scan.nextLine();
                        }
                        System.out.println(q.get(Integer.parseInt(number)) + " is at position " + number + " in the Deque.");
                    }
                    break;

                case 10://Length
                    System.out.println("Length of Deque: " + q.length());
                    break;

                case 11://Clear
                    q.clear();
                    System.out.println("Deque is now empty!");
                    break;

                case 12:
                    quit = true;
                    break;
                default:
                    System.out.println("Not a valid option!");
                    break;
            }
            if (!quit) {
                System.out.println("Deque is:\n" + q.toString());
            }
        } while (!quit);
    }
}