package HW9;

import java.lang.reflect.Array;

public class MyArrayList <T> implements MyList<T>{
    private T[] myArray;
    private int arraySize = 0;
    private static final int DEFAULT_SIZE = 16;

    public MyArrayList(){
        myArray = (T[]) Array.newInstance(Object.class,DEFAULT_SIZE);
    }

    @Override
    public void add(T element){
        try {
            myArray[arraySize] = element;
            arraySize++;
        } catch (IndexOutOfBoundsException e){
            T[] newTempArray = (T[]) Array.newInstance(Object.class, arraySize * 2);
            for (int i = 0; i< arraySize; i++){
                newTempArray[i] = myArray[i];
            }
            myArray = newTempArray;
            myArray[arraySize] = element;
            arraySize++;
        }
    }

    @Override
    public void remove(int indexToRemove){
        if (indexToRemove>=0 && indexToRemove< arraySize){
            for(int i = indexToRemove; i< arraySize; i++){
                myArray[i] = myArray[i + 1];
            }
            arraySize--;
        } else {
            System.out.println("Incorrect index to remove. Element wasn't removed.");
        }

    }

    @Override
    public void clear(){
        for (T element: myArray) {
            element = null;
        }
        arraySize = 0;
    }

    @Override
    public int size(){
        return arraySize;
    }

    @Override
    public T get(int getIndex){
        if (getIndex>=0 && getIndex< arraySize){
            return myArray[getIndex];
        } else {
            System.out.println("Incorrect index to get.");
        }
        return null;
    }

    @Override
    public String toString(){
        String print = "[";
        for(int i = 0; i< arraySize; i++){
            print += myArray[i] + " ";
        }
        return print.trim() + "]";
    }

}
