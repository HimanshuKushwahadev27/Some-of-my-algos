package Stack;

import java.util.Stack;

public class ValidParan {
      public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for(Character c : s.toCharArray()){

            if(!st.isEmpty() && 
                ((c == ')' && st.peek() == '(') || 
                 (c == '}' && st.peek() == '{') ||
                 (c == ']' && st.peek() == '['))
                ){
                    st.pop();
                }else{
                    st.push(c);
                }
        }

        return st.isEmpty();
    }
}
