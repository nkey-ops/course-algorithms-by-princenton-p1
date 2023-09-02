package bags_queues_and_stacks_1_3.ex.ex_11;

import java.util.Stack;

/**
 *  Write a program EvaluatePostfix.java that that takes 
 *  a postfix expression from standard input, evaluates it, 
 *  and prints the value. 
 *
 */
public class EvaluatePostfix {

    public static void main(String[] args) {
        assert 5 == evaluate("2 3 +"); 
        assert 27 == evaluate("3 4 5 + * "); 
        assert 277 == evaluate("1 2 3 4 5 * + 6 * * +"); 
        assert 30001== evaluate("7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +"); 
        assert 30001== evaluate("7 16 * 5 + 16 * 3 + 16 * 1 +"); 

    }

    public static int evaluate(String s) {
        String[] tokens = s.split("\\s");
        Stack<Integer> operands = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("+"))
                    operands.push(add(operands));
            else if(token.equals("-"))
                    operands.push(subtract(operands));
            else if(token.equals("*"))
                    operands.push(multiply(operands));
            else if(token.equals("/"))
                    operands.push(divide(operands));
            else 
                operands.push(Integer.parseInt(token));
        }


        return operands.pop();
    }

    private static Integer divide(Stack<Integer> stack) {
        int a = stack.pop();
        int b = stack.pop();

        return  b / a;
    }

    private static Integer multiply(Stack<Integer> stack) {
        return  stack.pop() * stack.pop();
    }

    private static Integer subtract(Stack<Integer> stack) {
        int a = stack.pop();
        int b = stack.pop();

        return  b - a;
    }


    public static int add(Stack<Integer> stack){
        return  stack.pop() + stack.pop();
    }

}
