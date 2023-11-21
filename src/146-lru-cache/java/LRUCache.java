import java.util.LinkedHashMap;

public class LRUCache{
    private LinkedHashMap<Integer, Integer> cacheMap;
    private int CACHE_SIZE;

    public LRUCache(int capacity) {
        cacheMap = new LinkedHashMap<>();
        CACHE_SIZE = capacity;
    }

    public int get(int key) {
        if( cacheMap.containsKey(key) ) {
            int value = cacheMap.remove(key);
            cacheMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if( cacheMap.containsKey(key) ) cacheMap.remove(key);
        else if(cacheMap.size() + 1 > CACHE_SIZE)
            cacheMap.remove(cacheMap.keySet().iterator().next());
        cacheMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */