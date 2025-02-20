package edu.grinnell.csc207.listlab;

/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {
    
    private static class Node{
        public int value;
        public Node next;
        
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    
    private Node first;
    private int size;
    
    public LinkedList(){
        this.first = null;
    }
    
    
    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        if (first == null){
            first = new Node(value, null);
        } else {
            Node cur = this.first;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(value, null);    
        }
        this.size++;
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
        Node cur = this.first;
        int i = 0;
        while (cur.next != null && i <= index){
            cur = cur.next;
            i++;
        }
        return cur.value;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        if (first == null){
            throw new IndexOutOfBoundsException("the list is empty");
        }
        if (index == 0){
            int value =  first.value;
            first = first.next;
            size--;
            return value;
        } else {
            Node cur = this.first;
            int i = 0;
            while (cur != null && i < index - 1){
                cur = cur.next;
                i++;
            }
                
            if (cur.next == null || cur == null){
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }
                
            int value = cur.next.value;
            cur.next = cur.next.next;
            this.size--;
            return value;
        }
           
    }
}
