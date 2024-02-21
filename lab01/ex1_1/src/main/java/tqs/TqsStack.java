package tqs;


import java.util.LinkedList;

public class TqsStack<T> {

    LinkedList<T> collection = null;

    public T pop() {

        if (this.collection == null || this.collection.size() == 0) {
            return null;
        }

        return collection.pop();

    }


    public void add(T element) {


        if (this.collection == null ) {

            this.collection = new LinkedList<T>();

        }

        this.collection.add(element);
    }

    public T peek() {

        if (this.collection == null ) {
            return null;
        }

        return this.collection.peek();


    }


    public int size() {


        if (this.collection == null ) {
            return 0; 
        }

        return this.collection.size();

    }

    public void push(T element) {

        if (this.collection == null ) {

            this.collection = new LinkedList<T>();

        }

        this.collection.push(element);
        
    }


    public boolean isEmpty() {

        if (this.collection == null ) {
            return true; 
        }

        return this.collection.isEmpty();

    }


}
