package exam;

public interface IMAP<K, V> {

	void put(K key,V val);
	V get(K key);
	boolean contains(K key);
	int size();
}
