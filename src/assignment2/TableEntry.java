package assignment2;

public class TableEntry<K extends Data<K>, V extends Clonable<V>> implements Data<TableEntry<K ,V>>{

	K key;
	V value;
	
	TableEntry(K k, V v){
		this.key = k;
		this.value = v;
	}

	public TableEntry<K, V> clone() {
		TableEntry<K, V> clone = new TableEntry<K, V>(this.key, this.value);
		return clone;
	}

	public int compareTo(TableEntry<K,V> row) {
		return row.toString().compareTo(this.key.toString());
	}

	
}
