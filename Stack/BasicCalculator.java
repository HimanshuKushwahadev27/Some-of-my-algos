import java.util.Stack;

public class BasicCalculator{
      public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the current result and sign onto the stack before
                // starting fresh for the sub-expression inside the parentheses.
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;

                // Pop the sign that was in effect before this parenthesis,
                // and the result accumulated before entering it.
                result *= stack.pop(); // sign before '('
                result += stack.pop(); // result before '('
            }
            // spaces are simply ignored
        }

        result += sign * number;
        return result;
}


}