package edu.grinnell.csc207.listlab;
import java.util.Arrays;
/**
 * An array-based implementation of the list ADT.
 */
public class ArrayList {
    
    private int size;
    private int[] data;
    
    private static final int INITIAL_SIZE = 8;
    
    public ArrayList(){
        this.data = new int[INITIAL_SIZE];
        this.size = 0;
    }
    
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        grow();
        this.data[size] = value;
        this.size = this.size + 1;   
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        return this.data[index];
    }
    
    public void grow(){
        if (size == data.length){
            Arrays.copyOf(data, data.length *2);
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int val = this.data[index];
       for(int i = index; i < this.size; i++){
           this.data[i] = this.data[i+1];
       }
       this.size--;
       return val;
    }
}
