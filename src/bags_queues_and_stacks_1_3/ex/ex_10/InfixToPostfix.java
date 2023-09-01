package bags_queues_and_stacks_1_3.ex.ex_10;

import java.util.Stack;

/**
 * Write a filter Program InfixToPostfix.java that converts 
 * an arithmetic expression from infix to postfix.
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        assert "1 3 - 7 2 / +".equals(infixToPostfix("( ( 1 - 3 ) + ( 7 / 2 ) )"));

    }

    public static String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = s.split("\\s");

        Stack<String> operators = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("+")
                    || token.equals("-")
                    || token.equals("*")
                    || token.equals("/"))
                operators.push(token);

            else if (token.equals(")"))
                sb.append(operators.pop()).append(" ");
            else if (token.equals("("))
                continue;
            else sb.append(token).append(" ");

        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());

        return sb.toString();
    }
}
