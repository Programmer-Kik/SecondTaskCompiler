public class Pair<Key, Value> {
    private final Key key;
    private final Value value;

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public void Print() {
        System.out.println("Ключ: " + key + " Значение: " + value);
    }
}