package exam;

public interface TreeMapStrategy<K, V> {

	V get(TreeMap<K,V> m,K key);
	void put(TreeMap<K,V> m,K key,V value);
}
