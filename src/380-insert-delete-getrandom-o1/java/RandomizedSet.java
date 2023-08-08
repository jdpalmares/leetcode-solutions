import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    List<Integer> valList; // can change list into an array would be faster but less readable
    Map<Integer, Integer> indexMap;
    Random random;

    public RandomizedSet() {
        valList = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val))
            return false;

        indexMap.put(val, valList.size());
        valList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val))
            return false;

        int currentIndex = indexMap.get(val);
        int lastIndex = valList.size() - 1;
        if (currentIndex != lastIndex) {
            int lastVal = valList.get(lastIndex);
            valList.set(currentIndex, lastVal);
            indexMap.put(lastVal, currentIndex);
        }
        valList.remove(lastIndex);
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return valList.get(random.nextInt(valList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */