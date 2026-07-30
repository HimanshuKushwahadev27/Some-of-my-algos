import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {

      class RandomizedSet {

    public HashMap<Integer, Integer> helper;
    public ArrayList<Integer> arr;
    Random rand ; 
    public RandomizedSet() {
        helper = new HashMap<>();
        arr = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        
        Integer num = helper.putIfAbsent(val, arr.size());

        if(num == null){
            arr.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        
        Integer num = helper.get(val);

        if(num==null){
            return false;
        }
        int last = arr.get(arr.size()-1);
        arr.set(num, last); 
        helper.put(last,num); 
        arr.remove(arr.size()-1);

        helper.remove(val);
        return true;
    }
    
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
