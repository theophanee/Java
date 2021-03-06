package exam;

public class TreeMap<K, V> implements IMAP<K,V>{

	private final K key;
	private V value;
	private IMAP<K,V> left = new EmptyMap<K,V>(), right = new EmptyMap<K,V>();
	private TreeMapStrategy<K,V> strat ;
	public TreeMap(K key,V value,TreeMapStrategy<K,V> s){
		this.key = key;
		this.value = value;
		strat=s;
	}
	
	
	@Override
	public void put(K key, V val) {
		// TODO Auto-generated method stub
		strat.put(this,key,value);
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return strat.get(this,key);
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return get(key)!=null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return left.size()+right.size()+1;
	}

}
