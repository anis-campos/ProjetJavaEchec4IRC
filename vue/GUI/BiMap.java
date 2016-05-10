package vue.GUI;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Anis on 09/05/2016.
 */
public class BiMap<K, V> {

    private HashMap<K, V> map;
    private HashMap<V, K> inverseMap;

    public BiMap() {
        this.map = new HashMap<>();
        this.inverseMap = new HashMap<>();
    }

    public void put(K key, V value) {
        map.put(key, value);
        inverseMap.put(value, key);
    }

    public V getValue(K key) {
        return map.get(key);
    }

    public K getKey(V value) {
        return inverseMap.get(value);
    }

    public Set<K> getKeys() {
        return map.keySet();
    }

    public Set<V> getValues() { return inverseMap.keySet();}
}
