package assignment2;

public class TableEntry<K extends Data<K>, V extends Clonable<V>> implements Data<TableEntry<K ,V>>{

	private K key;
	private V value;
	
	TableEntry(K k, V v){
		this.key = k;
		this.value = v;
	}

	public TableEntry<K, V> clone() {
		TableEntry<K, V> clone = new TableEntry<K, V>(this.key, this.value);
		return clone;
	}

	public K getKey(){
		return this.key;
	}
	
	public V getValue(){
		return this.value;
	}
	
	public int compareTo(TableEntry<K,V> row) {
		int test = key.compareTo(row.getKey());
		return test;
	}

	
}
