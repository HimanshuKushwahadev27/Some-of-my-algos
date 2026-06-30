package Stack;

import java.util.Stack;

public class SimplifyPath {
  class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> st = new Stack<>();

        for(int i = 0 ; i < path.length() ; i++){

            StringBuilder sb = new StringBuilder();

            while(i < path.length() && path.charAt(i) != '/'){
                sb.append(path.charAt(i));
                i++ ;
            }

            if(sb.toString().equals("."))continue;
            if(sb.toString().equals("..") && !st.isEmpty()){
                st.pop();
                continue;
            }
            if(sb.toString().equals("..")  && st.isEmpty() )continue;

            if(sb.length() != 0){
                st.add(sb.toString());
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            String s = st.pop();
            sb.insert(0, s);
            sb.insert(0, "/");
        }

        if(sb.length() == 0)return "/";

        return sb.toString();
    }
}}
