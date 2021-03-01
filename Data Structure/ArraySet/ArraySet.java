import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i = 0; i < size; i++)
            if(items[i].equals(x))
                return true;
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x == null)
            throw new IllegalArgumentException("can't add null");
        if(contains(x))
            return;
        items[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public class ArraySetIterator implements Iterator<T>{
        private int wizPos;

        public ArraySetIterator()
        {
            wizPos = 0;
        }

        public boolean hasNext()
        {
            return wizPos < size;
        }

        public T next()
        {
            T returnItem = items[wizPos];
            wizPos++;
            return returnItem;
        }
    }

    public Iterator<T> iterator()
    {
        return new ArraySetIterator();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(other.getClass() != this.getClass())
            return false;
        ArraySet o = (ArraySet)other;
        if(o.size != size)
            return false;
        for(T item: this)
            if(!o.contains(item))
                return false;
        return true;
    }

    // @Override
    // public String toString()
    // {
    //     StringBuilder returnString = new StringBuilder();
    //     returnString.append("{");
    //     for(int i = 0; i < size - 1; i++)
    //     {
    //         returnString.append(items[i].toString());
    //         returnString.append(",");
    //     }
    //     returnString.append(items[size - 1].toString());
    //     returnString.append("}");
    //     return returnString.toString();
    // }

    @Override
    public String toString()
    {
        List<String> ListOfItems = new ArrayList<>();
        for(T x: this)
            ListOfItems.add(x.toString());
        return "{" + String.join(",", ListOfItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff)
    {
        ArraySet returnArraySet = new ArraySet();
        for(Glerp x: stuff)
            returnArraySet.add(x);
        return returnArraySet;
    }


    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset);

        //equals
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));

        ArraySet<String> aset3 = ArraySet.of("Hi", "I'am", "here!");
        System.out.println(aset3);
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
