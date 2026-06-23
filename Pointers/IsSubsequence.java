package Pointers;

public class IsSubsequence {
   public boolean isSubsequence(String s, String t) {
        
        if(s.length() == 0 && t.length() == 0)return true ;
        if(s.length() == 0 && t.length() > 0)return true ;
        if(s.length() > t.length())return false ;

        int low = -1   ;

        for(int i = 0 ; i < t.length() ; i++){

            low++;
            if(t.charAt(i) != s.charAt(low)){
                low-- ;
            }

            if(low==s.length()-1)return true;
        }

        return false;
        

    }
}
