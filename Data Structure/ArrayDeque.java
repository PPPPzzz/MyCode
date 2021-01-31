public class ArrayDeque<T> implements Deque<T> {
    public class Array
    {
        public T[] items;

        public Array()
        {
            items = (T[])new Object[8];
        }

        public Array(int capacity)
        {
            items = (T[])new Object[capacity];
        }
    }

    public Array Ahead;
    public int size;
    public int NextLast;
    public int NextFirst;

    public ArrayDeque()
    {
        Ahead = new Array();
        size = 0;
        NextLast = 0;
        NextFirst = 0;
    }

    @Override
    public void addFirst(T item)
    {
        if(size == Ahead.items.length)
        {
            Array temp = new Array(size * 2);
            System.arraycopy(Ahead.items, 0, temp.items, 1, size);
            Ahead = temp;
            Ahead.items[0] = item;
            NextFirst = Ahead.items.length - 1;
            NextLast = size + 1;
        }
        else
        {
            Ahead.items[NextFirst] = item;
            if(NextFirst == 0)
                NextFirst = Ahead.items.length - 1;
            else
                --NextFirst;
        }
        ++size;
    }

    @Override
    public void addLast(T item)
    {
        if(size == Ahead.items.length)
        {
            Array temp = new Array(size * 2);
            System.arraycopy(Ahead.items, 0, temp.items, 0, size);
            Ahead = temp;
            Ahead.items[size] = item;
            NextFirst = Ahead.items.length - 1;
            NextLast = size + 1;
        }
        else
        {
            Ahead.items[NextLast] = item;
            if(NextLast == Ahead.items.length - 1)
                NextLast = 0;
            else
                ++NextFirst;
        }
        ++size;
    }

    @Override
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        else
            return false;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void printDeque()
    {
        int index = NextFirst + 1;
        for(int count = 0; count < size; ++count)
        {
            if(index > Ahead.items.length - 1)
                index -= Ahead.items.length;
            System.out.print(Ahead.items[index] + " ");
            ++index;
        }
        System.out.println();
    }

    public void resize_down()
    {
        Array temp = new Array(size);
        if(NextFirst < NextLast)
            System.arraycopy(Ahead.items, NextFirst + 1, temp, 0, size);
        else
        {
            int segment1 = Ahead.items.length - NextFirst - 1;
            System.arraycopy(Ahead.items, NextFirst + 1, temp, 0, segment1);
            int segment2 = size - segment1;
            System.arraycopy(Ahead.items, 0, temp, segment1 - 1, segment2);
        }
        NextFirst = Ahead.items.length - 1;
        NextLast = 0;
        Ahead = temp;
    }

    @Override
    public T removeFirst()
    {
        T temp;

        if(NextFirst == Ahead.items.length - 1)
            NextFirst = 0;
        else
            ++NextFirst;

        temp = Ahead.items[NextFirst];
        Ahead.items[NextFirst] = null;
        --size;

        if(16 < size && size < Ahead.items.length / 4)
            resize_down();

        return temp;
    }

    @Override
    public T removeLast()
    {
        T temp;

        if(NextLast == 0)
            NextLast = Ahead.items.length - 1;
        else
            --NextLast;
        
        temp = Ahead.items[NextLast];
        Ahead.items[NextLast] = null;
        --size;

        if(16 < size && size < Ahead.items.length / 4)
            resize_down();

        return temp;
    }

    @Override
    public T get(int index)
    {
        int temp = NextFirst;

        if(temp + NextFirst > Ahead.items.length - 1)
        {
            temp += NextFirst;
            temp -= Ahead.items.length;

            return Ahead.items[temp];
        }
        else
            return Ahead.items[temp + index];
    }
}
