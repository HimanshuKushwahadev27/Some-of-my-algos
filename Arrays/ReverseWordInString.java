public class ReverseWordInString {
    public String reverseWords(String s) {
        
        int high = s.length()-1;

        StringBuilder sb = new StringBuilder();

        for(int i = high ; i >= 0  ; i--){

            StringBuilder helper = new StringBuilder();

            if(s.charAt(i) == ' '){
                continue;
            }

            while( i>=0 && s.charAt(i) != ' '){
                helper.append(s.charAt(i));
                i--;
            }


            helper.reverse();
            sb.append(helper.toString());
            sb.append(' ');
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
