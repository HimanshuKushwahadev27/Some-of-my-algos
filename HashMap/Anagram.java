package HashMap;

public class Anagram {
      public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())return false;

        int [] fre = new int[26];

        for(int i = 0 ; i < s.length() ; i++){
            fre[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s.length() ; i++){
            fre[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(fre[i] != 0)return false;
        }

        return true;

    }
}
