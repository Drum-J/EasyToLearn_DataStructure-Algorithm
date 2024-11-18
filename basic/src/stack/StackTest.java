package stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer pop = stack.pop();
        Integer peek = stack.peek();

        System.out.println("pop = " + pop);
        System.out.println("peek = " + peek);
    }
}
