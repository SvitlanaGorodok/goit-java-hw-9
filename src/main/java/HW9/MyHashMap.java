package HW9;

public class MyHashMap <K,T> {
    private int mapSize = 0;
    private static final int CAPACITY = 10;
    private ListOfNodes[] ArrayOfLists = new ListOfNodes[CAPACITY];
    private int myHashCode;

    public void put(K key, T value) {
        myHashCode = key.hashCode();
        if (ArrayOfLists[myHashCode % CAPACITY] == null) {
            ArrayOfLists[myHashCode % CAPACITY] = new ListOfNodes();
        }
        ArrayOfLists[myHashCode % CAPACITY].putElement(key, value);

    }

    public void remove(K key){
        myHashCode = key.hashCode();
        ArrayOfLists[myHashCode % CAPACITY].removeElement(key);
    }

    public void clear(){
        ArrayOfLists = null;
    }

    public int size(){
        mapSize = 0;
        for (int i = 0; i < CAPACITY; i++){
            if (ArrayOfLists[i] != null){
                mapSize += ArrayOfLists[i].sizeOfList();
            }
        }
        return mapSize;
    }

    public T get(K key){
        myHashCode = key.hashCode();
        try{
            return (T) ArrayOfLists[myHashCode % CAPACITY].getElement(key);
        } catch (NullPointerException e){}
        return null;
    }

    @Override
    public String toString(){
        try {
            String print = "[";
            for (int i = 0; i < 1; i++) {
                print += ArrayOfLists[i] + " ";
            }
            return print.trim() + "]";
        } catch (NullPointerException e){}
        return "HashMap is Empty.";
    }
}
