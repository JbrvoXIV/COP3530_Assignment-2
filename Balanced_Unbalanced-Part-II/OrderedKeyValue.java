
public class OrderedKeyValue implements Comparable{
    String key;
    int value;
    
    @Override
    public int compareTo(Object o) {
	    return key.compareTo(((OrderedKeyValue)o).key);
    }

    public OrderedKeyValue(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
	    return "(" + key + ", " + value + ")";
    }
}
