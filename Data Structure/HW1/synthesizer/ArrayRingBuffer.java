package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if(isFull())
            throw new RuntimeException("Ring buffer overflow");
        rb[last] = x;
        last = (last + 1) % capacity();
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if(isEmpty())
            throw new RuntimeException("Ring buffer underflow");
        T oldest = rb[first];
        rb[first] = null;
        fillCount--;
        first = (first + 1) % capacity();
        return oldest;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if(isEmpty())
            throw new RuntimeException("Ring buffer underflow");
        return rb[first];
    }

    @Override
    public int capacity()
    {
        return rb.length;
    }

    @Override
    public int fillCount()
    {
        return fillCount;
    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<T> {
        private int ptr;
        private int cnt;
        KeyIterator() {
            ptr = first;
            cnt = 0;
        }
        public boolean hasNext() {
            return cnt != fillCount;
        }
        public T next() {
            T returnItem = rb[ptr];
            ptr = (ptr + 1) % capacity();
            cnt++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> other = (ArrayRingBuffer) o;
        if (other.capacity() != this.capacity()) {
            return false;
        }
        T[] temp = (T[]) new Object[other.capacity()];
        int counter = 0;
        for (T item: other) {
            temp[counter] = item;
            counter += 1;
        }
        counter = 0;
        for (T item: this) {
            if (!item.equals(temp[counter])) {
                return false;
            }
            counter += 1;
        }
        return true;
    }
}