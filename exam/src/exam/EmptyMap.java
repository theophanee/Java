package exam;

public class EmptyMap<K, V> implements IMAP<K,V>{

	@Override
	public void put(K key, V val) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
