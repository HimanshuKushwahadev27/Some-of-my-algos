package Stack;

import java.util.Stack;

public class RPT {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<>();

        for(String s : tokens){
            
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){

                int num2 = 0 ;
                int num1 = 0 ;
                int value =  0;

                if(!st.isEmpty()){
                    num2 = Integer.parseInt(st.pop());
                }
                if(!st.isEmpty()){
                    num1 = Integer.parseInt(st.pop());
                }

                switch (s) {
                    case "+" -> value = num1 + num2;
                    case "-" -> value = num1 - num2;
                    case "*" -> value = num1 * num2;
                    case "/" -> value = num1 / num2;
                }

                st.push(String.valueOf(value));
            }else{
                st.push(s);
            }
        }

        return Integer.parseInt(st.peek());
    }
}
