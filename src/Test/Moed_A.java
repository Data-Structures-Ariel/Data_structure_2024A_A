package Test;

import L09.Node;

import java.util.*;

public class Moed_A {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    public static void main(String[] args) {
        int ans;
        boolean bool;

        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            System.out.println("------------------------------------------");
            switch (num) {
                case 1:
                    //O(n)
                    //O(n^2)
                    //O(nlogn)
                    //O(inf)
                    break;
                case 2:
                    Stack<Integer> st1 = new Stack<>() {{
                        add(7);
                        add(6);
                        add(14);
                        add(8);
                        add(12);
                        add(9);
                        add(7);
                    }};
                    Stack<Integer> st2 = new Stack<>() {{
                        add(11);
                        add(9);
                        add(1);
                        add(4);
                        add(13);
                        add(4);
                        add(8);
                        add(2);
                    }};
                    int sum = maxSum(st1, st2);
                    System.out.println("sum -> " + sum);
                    break;
                case 3:
                    Node<Integer> chain = new Node<>(1, new Node<>(2, new Node<>(5, new Node<>(6, new Node<>(13, new Node<>(22, new Node<>(27, new Node<>(37, new Node<>(40)))))))));
                    print(chain);
                    bool = isParamedic(chain);
                    System.out.println("isParamedic -> " + bool);
                    break;
                case 4:
                    Queue<Integer> myQueue = new LinkedList<>() {{
                        add(4);
                        add(3);
                        add(1);
                        add(8);
                        add(9);
                    }};
                    int res = sod1(myQueue);
                    System.out.println(res);
                    System.out.println(myQueue);

                    break;
                case 5:
                    Queue<Integer> qu = new LinkedList<>() {{
                        add(4);
                        add(3);
                        add(1);
                        add(8);
                        add(9);
                    }};
                    Queue<Integer> qu2 = new LinkedList<>() {{
                        add(74);
                        add(32);
                        add(12);
                        add(16);
                        add(100);
                    }};
                    System.out.println(qu);
                    int index = bigEvenIndex(qu);
                    System.out.println("Index -> " + index);
                    System.out.println(qu);
                    index = bigEvenIndex(qu2);
                    System.out.println("Index -> " + index);
                    break;
                case 6:
                    Stack<Integer> st = new Stack<>() {{
                        add(1);
                        add(0);
                        add(4);
                        add(6);
                        add(8);
                        add(1);
                        add(1);
                        add(9);
                    }};
                    System.out.println(st);
                    int sumD = sumDigit(st);
                    System.out.println("sum digits -> " + sumD);
                    System.out.println(st);
                    break;
                case 7:
                    break;
                case 8:
                    Queue<Integer> queue = new LinkedList<>() {{
                        add(12);
                        add(13);
                        add(14);
                        add(15);
                        add(10);
                        add(9);
                        add(8);
                        add(7);
                    }};
                    int size = sizeQ(queue);
                    System.out.println(size);
                    System.out.println(queue);
                    Queue<Integer> copy = copyQ(queue);
                    System.out.println(queue);
                    System.out.println(copy);
                    bool = SerialQueue(queue);
                    System.out.println(bool);
                case -1:
                    return;

            }

        }
    }

    private static boolean SerialQueue(Queue<Integer> queue) {
        if (queue == null)
            return true;

        int size = sizeQ(queue);
        if (size % 2 != 0)
            return false;
        Queue<Integer> copy = copyQ(queue);
        for (int i = 1; i < size/2; i++) {
            if(copy.poll()> copy.peek())
                return false;
        }
        copy.poll();
        for (int i = 1; i < size/2; i++) {
            if(copy.poll()< copy.peek())
                return false;
        }
        return true;
    }

    private static Queue<Integer> copyQ(Queue<Integer> queue) {
        if (queue == null)
            return null;

        Queue<Integer> copy = new LinkedList<>();
        int size = sizeQ(queue);
        for (int i = 0; i < size; i++) {
            copy.add(queue.peek());
            queue.add(queue.poll());
        }

        return copy;
    }

    private static int sizeQ(Queue<Integer> queue) {
        if (queue == null)
            return 0;
        Queue<Integer> temp = new LinkedList<>();
        int size = 0;
        while (!queue.isEmpty()) {
            size++;
            temp.add(queue.poll());
        }

        while (!temp.isEmpty())
            queue.add(temp.poll());

        return size;
    }

    public static int sumDigit(Stack<Integer> st) {
        if (st == null)
            return -1;
        int sum = 0;
        while (!st.isEmpty())
            sum += st.pop();
        int temp = sum;
        do
            st.push(temp % 10);
        while ((temp /= 10) > 0);

        return sum;

    }

    public static int bigEvenIndex(Queue<Integer> qu) {
        if (qu == null)
            return -1;
        int largestOdd = Integer.MIN_VALUE;
        int smallestEven = Integer.MAX_VALUE;
        int positionOdd = -1;
        int positionEven = -1;
        int currentPosition = 0;
        Queue<Integer> temp = new LinkedList<>();

        while (!qu.isEmpty()) {
            int current = qu.poll();
            temp.add(current);
            if (current % 2 != 0 && current > largestOdd) {
                largestOdd = current;
                positionOdd = currentPosition;
            } else if (current % 2 == 0 && current < smallestEven) {
                smallestEven = current;
                positionEven = currentPosition;
            }
            currentPosition++;
        }
        while ((!temp.isEmpty()))
            qu.add(temp.poll());
        return (positionOdd != -1) ? positionOdd : positionEven;
    }


    private static void print(Node<Integer> chain) {
        while (chain != null) {
            System.out.print(chain.getValue() + " -> ");
            chain = chain.getNext();
        }
        System.out.println("null");
    }

    private static int maxSum(Stack<Integer> st1, Stack<Integer> st2) {
        if (st1 == null && st2 == null)
            return -1;
        int sumSt1 = 0;
        int sumSt2 = 0;
        Stack<Integer> sTemp1 = new Stack<>();
        Stack<Integer> sTemp2 = new Stack<>();
        while (!st1.isEmpty()) {
            sumSt1 += st1.peek();
            sTemp1.push(st1.pop());
        }
        while (!st2.isEmpty()) {
            sumSt2 += st2.peek();
            sTemp2.push(st2.pop());
        }
        while (!sTemp1.isEmpty())
            st1.push(sTemp1.pop());
        while (!sTemp2.isEmpty())
            st2.push(sTemp2.pop());

        return Math.max(sumSt1, sumSt2);
    }

    public static boolean isParamedic(Node<Integer> chain) {
        if (chain == null)
            return true;

        Node<Integer> temp = chain;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        int max = chain.getValue();
        for (int i = 0; i < size / 2; i++) {
            if (max < chain.getValue())
                max = chain.getValue();
            chain = chain.getNext();
        }
        if (chain.getValue() < max)
            return false;
        max = chain.getValue();
        while ((chain = chain.getNext()) != null)
            if (max > chain.getValue())
                return false;
        return true;
    }

    public static int sod1(Queue<Integer> qu) {
        if (qu == null || qu.isEmpty())
            return 0;

        int x = qu.remove();
        int y = sod1(qu);
        qu.add(x + y);

        return x + y;
    }

}
