package assignment2;

public class KeyValuePair<K extends Data<K>, V extends Clonable<V>> implements Data<KeyValuePair<K ,V>>{

	K key;
	V value;
	
	KeyValuePair(K k, V v){
		this.key = k;
		this.value = v;
	}

	@Override
	public KeyValuePair<K, V> clone() {
		KeyValuePair<K, V> clone = new KeyValuePair<K, V>(this.key, this.value);
		return clone;
	}

	@Override
	public int compareTo(KeyValuePair o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
