public class LongestCommonPrefix {
      public String longestCommonPrefix(String[] strs) {
        
        String smallest  = "" ; 
        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < strs.length ; i++){

            if(min > strs[i].length()){
                smallest = strs[i] ; 
                min = strs[i].length() ;
            }
        }

        for(int i = 0 ; i < smallest.length() ; i++){
            boolean flag = false ;
            for(int j = 0 ; j < strs.length ; j++){

                if(smallest.charAt(i) == strs[j].charAt(i)){
                    flag = true ;
                }else{
                    flag = false ; 
                    break;
                }
            }

            if(flag){
                sb.append(smallest.charAt(i));
            }else{
                break ;
            }
        }

        return sb.toString();
    }
}
