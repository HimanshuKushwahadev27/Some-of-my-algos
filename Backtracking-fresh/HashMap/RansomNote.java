package HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        if(magazine.length() < ransomNote.length())return false;

        int [] fre = new int[26];


        for(int i = 0 ; i < ransomNote.length() ; i++){
            fre[ransomNote.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < magazine.length() ; i++){

            if(fre[magazine.charAt(i) - 'a'] == 0){
                continue;
            }

            fre[magazine.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < ransomNote.length() ; i++){
            if(fre[ransomNote.charAt(i) - 'a'] != 0)return false;
        }

        return true;
    }
}
